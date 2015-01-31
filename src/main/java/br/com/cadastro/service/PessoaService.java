package br.com.cadastro.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.cadastro.model.Pessoa;
import br.com.cadastro.repository.PessoaRepository;

public class PessoaService implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private PessoaRepository repository;
	
	
	
	public void addPessoaService(Pessoa pessoa){
		
		repository.addPessoa(pessoa);
		
		
	}

}
