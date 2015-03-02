package br.com.cadastro.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.cadastro.model.Filtro;
import br.com.cadastro.model.Pessoa;
import br.com.cadastro.repository.PessoaRepository;

public class PessoaService implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private PessoaRepository repository;
	@Inject
    private Filtro filtro;

	public void addPessoaService(Pessoa pessoa) {

		repository.addPessoa(pessoa);

	}
	
	public List<Pessoa>listPessoaService(){
		return repository.listPessoa();
		
		
	}
	
	public void updatePessoaService(Pessoa pessoa){
		
		repository.updatePessoa(pessoa);
		
	}
	
	public Pessoa findPessoaService(int id){
		return repository.findPessoa(id);
		
		
		
	}
		
		
		
	
	

	public Pessoa validarPessoaService(Pessoa pessoaParam) {

		Pessoa pessoa = null;
		if (pessoaParam.getCpf() != null && !pessoaParam.getCpf().isEmpty()) {

			filtro.setCpf(pessoaParam.getCpf());

		}
		if (pessoaParam.getEmail() != null && !pessoaParam.getEmail().isEmpty()) {

			filtro.setEmail(pessoaParam.getEmail());

		}

		pessoa = repository.validarPessoa(filtro);

		return pessoa;

	}

}
