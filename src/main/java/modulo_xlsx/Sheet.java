package modulo_xlsx;

import java.io.Serializable;
import java.util.List;

public class Sheet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private List<Linha> linhas;
}
