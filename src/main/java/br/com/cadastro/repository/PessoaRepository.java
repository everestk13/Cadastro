package br.com.cadastro.repository;

import java.io.Serializable;

import javax.ejb.Stateless;

import br.com.cadastro.model.Pessoa;

@Stateless
public class PessoaRepository extends BasicRepository<Pessoa> implements Serializable {

	private static final long serialVersionUID = 1L;

	public PessoaRepository() {

		super(Pessoa.class);

	}
	
	public void addPessoa(Pessoa pessoa){
		
		addEntity(pessoa);
		
	}
	
	
	
	

}
