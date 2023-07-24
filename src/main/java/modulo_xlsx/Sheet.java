package modulo_xlsx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Sheet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final String CAMINHO_WORKSHEET = "xl/worksheets/";
	private String nome;
	private String xml;
	private List<Linha> linhas;
	public Sheet(String nomeSheet) {
		StringBuilder sb = new StringBuilder();
		try (FileInputStream fileInputStream = new FileInputStream(nome)) {
			try (ZipInputStream zis = new ZipInputStream(fileInputStream)) {

				ZipEntry entrada;
				while ((entrada = zis.getNextEntry()) != null) {
					if (entrada.getName().equals(String.format("%s/%s.xml", CAMINHO_WORKSHEET, nomeSheet))) {
						byte[] buffer = new byte[1024];
						int byteRead;
						while ((byteRead = zis.read(buffer)) != -1) {
							sb.append(new String(buffer, 0, byteRead));
						}
						xml =sb.toString();
						return;
					}
				}
				throw new RuntimeException("Sheet não encontrado");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getXml() {
		return xml;
	}
	
	
}
