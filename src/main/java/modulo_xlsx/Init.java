package modulo_xlsx;

public class Init {
	public static void main(String[] args) {
		CargaXlsx cSheet = new CargaXlsx("sheet1","teste_01.xlsx");
//		String xml = cSheet.getXml();
//		xml = xml.replaceAll(".*?<sheetData>", "<sheetData>");
//		xml = xml.replaceAll("</sheetData>.*", "</sheetData>");
		cSheet.getSheet();
		System.out.println(cSheet.getSheet());
		
	}
}
