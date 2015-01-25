package br.com.cadastro.repository;

import br.com.cadastro.model.Pessoa;

public class PessoaRepository extends BasicRepository<Pessoa> {

	private static final long serialVersionUID = 1L;

	public PessoaRepository() {

		super(Pessoa.class);

	}
	
	public void addPessoa(Pessoa pessoa){
		
		addEntity(pessoa);
		
	}
	
	
	
	

}
