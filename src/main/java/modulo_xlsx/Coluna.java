package modulo_xlsx;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Coluna {
	@XmlElement(name = "v")
	private String v;
	@XmlAttribute(name = "t")
	private String tipo;
	private String valor;
	
	public Coluna() {
	}

	public Coluna(String valor) {
		super();
		this.valor = valor;
	}

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Coluna [tipo=" + tipo + ", valor=" + valor + "]";
	}
	
	
}
