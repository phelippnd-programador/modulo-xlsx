package modulo_xlsx;

import java.io.Serializable;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "sst")
@XmlAccessorType(XmlAccessType.FIELD)
public class SST implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "si")
	private List<SI> si;
	public SST() {
	}
	public List<SI> getSi() {
		return si;
	}
	public void setSi(List<SI> si) {
		this.si = si;
	}
	
	
}
