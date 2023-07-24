package modulo_xlsx;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class CargaXlsx {
	public final String CAMINHO_WORKSHEET ="xl/worksheets/";
	public String carga(String nome,String nomeSheet) throws IOException {
		StringBuilder sb = new StringBuilder();
		FileInputStream fileInputStream = new FileInputStream(nome);
		ZipInputStream zis = new ZipInputStream(fileInputStream);
		ZipEntry entrada;
		while ((entrada =  zis.getNextEntry()) != null) {
			if(entrada.getName().equals(String.format("%s/%s.xml",CAMINHO_WORKSHEET, nomeSheet))) {
				byte[] buffer = new byte[1024];
				int byteRead;
				while((byteRead = zis.read(buffer))!=-1) {
					sb.append(new String(buffer,0,byteRead));
				}
				return sb.toString();
			}
			
		}
		zis.close();
		fileInputStream.close();
		return sb.toString();
	}
}
