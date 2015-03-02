package br.com.cadastro.model;

public enum EstadoCivil {
	
	
	SOLTEIRO("Solteiro(a)"),CASADO("Casado(a)");
	
	private final String valor;
	
	private EstadoCivil(String valor) {
		
		this.valor = valor;
		
	
	}

	public String getValor() {
		return valor;
	}
	

}
