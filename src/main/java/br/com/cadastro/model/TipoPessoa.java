package br.com.cadastro.model;

public enum TipoPessoa {
	
	SOLTEIRO("Solteiro(a)"),CASADO("Casado(a)");
	
	private final String tipo;
	
	private TipoPessoa(String tipo){
		
		this.tipo = tipo;
		
		
	}

	public String getTipo() {
		return tipo;
	}
	
	


}
