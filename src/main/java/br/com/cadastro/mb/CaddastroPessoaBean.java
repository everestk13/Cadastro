package br.com.cadastro.mb;

import java.io.Serializable;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cadastro.model.Endereco;
import br.com.cadastro.model.Pessoa;
import br.com.cadastro.service.PessoaService;

@Named
@RequestScoped
public class CaddastroPessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	PessoaService service;
	@Inject
	Pessoa pessoa;
	@Inject
	Endereco endereco;

	public CaddastroPessoaBean() {

	}
	
	
	public void salvar(){
		
		
		
	}
	

}
