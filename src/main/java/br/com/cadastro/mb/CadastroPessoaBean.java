package br.com.cadastro.mb;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cadastro.model.Endereco;
import br.com.cadastro.model.Pessoa;
import br.com.cadastro.model.TipoPessoa;
import br.com.cadastro.service.PessoaService;

@Named
@RequestScoped
public class CadastroPessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	PessoaService service;
	@Inject
	private Pessoa pessoa;
	@Inject
	private Endereco endereco;
	
	@SuppressWarnings("unused")
	private List<TipoPessoa>tipoPessoas;
	
	

	public CadastroPessoaBean() {

	}
	
	
	public void salvar(){
		
		
		
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public List<TipoPessoa> getTipoPessoas() {
		
		return Arrays.asList(TipoPessoa.values());
	}


	public void setTipoPessoas(List<TipoPessoa> tipoPessoas) {
		this.tipoPessoas = tipoPessoas;
	}




}
