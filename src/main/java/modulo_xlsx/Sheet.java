package modulo_xlsx;

import java.io.Serializable;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sheetData")
@XmlAccessorType(XmlAccessType.FIELD)
public class Sheet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "row")
	private List<Linha> linhas;
	
	public Sheet() {}

	public List<Linha> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<Linha> linhas) {
		this.linhas = linhas;
	}

	@Override
	public String toString() {
		return "Sheet [linhas=" + linhas + "]";
	}
	
	

}
