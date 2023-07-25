package modulo_xlsx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.xml.transform.stream.StreamSource;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class CargaXlsx {
	public final String CAMINHO_WORKSHEET = "xl/worksheets/";
	private String xml;
	private String valores;

	public CargaXlsx(String nomeSheet, String nome) {
		StringBuilder sbValor = new StringBuilder();
		StringBuilder sbSchema = new StringBuilder();
		try (FileInputStream fileInputStream = new FileInputStream(nome)) {
			try (ZipInputStream zis = new ZipInputStream(fileInputStream)) {
				ZipEntry entrada;
				while ((entrada = zis.getNextEntry()) != null) {
					if (entrada.getName().equals("xl/sharedStrings.xml")) {
						byte[] buffer = new byte[1024];
						int byteRead;
						while ((byteRead = zis.read(buffer)) != -1) {
							sbValor.append(new String(buffer, 0, byteRead));
						}
						valores = sbValor.toString();
					}
					if (entrada.getName().startsWith("xl/worksheets/sheet")) {
						byte[] buffer = new byte[1024];
						int byteRead;
						while ((byteRead = zis.read(buffer)) != -1) {
							sbSchema.append(new String(buffer, 0, byteRead));
						}
						xml = sbSchema.toString();
						xml = xml.replaceAll(".*?<sheetData>", "<sheetData>");
						xml = xml.replaceAll("</sheetData>.*", "</sheetData>");
						xml = xml.replaceAll("<row(.*?)>", "<row>");
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Sheet getSheetConverter() throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Sheet.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		StringReader reader = new StringReader(xml);
		JAXBElement<Sheet> unmarshal = unmarshaller.unmarshal(new StreamSource(reader), Sheet.class);
		return unmarshal.getValue();
	}

	private SST getSSTt() throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(SST.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		StringReader reader = new StringReader(valores);
		JAXBElement<SST> unmarshal = unmarshaller.unmarshal(new StreamSource(reader), SST.class);
		return unmarshal.getValue();
	}

	public Sheet getSheet()   {
		Sheet sheet =null;
		try {
			sheet = getSheetConverter();
			List<SI> si = getSSTt().getSi();
			sheet.getLinhas().parallelStream().forEach(linha -> {
				List<Coluna> coluna = linha.getColuna();
				coluna.parallelStream().forEach(c -> {
					if (c.getTipo()!=null && c.getTipo().equals("s")) {
						SI s = si.get(Integer.parseInt(c.getV()));
						c.setValor(s.getValor());
					} else {
						c.setValor(c.getV());
					}
				});
			});
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return sheet;
	}

}
