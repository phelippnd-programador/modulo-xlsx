package modulo_xlsx;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
@XmlAccessorType(XmlAccessType.FIELD)
public class Linha {
	@XmlElement(name = "c")
	private List<Coluna> coluna;

	
	public Linha() {
	}

	public List<Coluna> getColuna() {
		return coluna;
	}

	public void setColuna(List<Coluna> coluna) {
		this.coluna = coluna;
	}

	@Override
	public String toString() {
		return "Linha [coluna=" + coluna + "]";
	}
	
	
	
}
