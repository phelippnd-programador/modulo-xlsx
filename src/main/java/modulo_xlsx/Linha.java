package modulo_xlsx;

import java.util.List;

public class Linha {
	private List<Coluna> coluna;
	public void carrega(Sheet sheet) {
		sheet.getXml();
	}
}
