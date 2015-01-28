package br.com.cadastro.mb;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.cadastro.model.Pessoa;
import br.com.cadastro.model.Sexo;
import br.com.cadastro.model.TipoPessoa;
import br.com.cadastro.service.PessoaService;

@Named
@RequestScoped
public class CadastroPessoaBean extends BasicBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	PessoaService service;
	@Inject
	private Pessoa pessoa;

	
	@SuppressWarnings("unused")
	private List<TipoPessoa>tipoPessoas;
	@SuppressWarnings("unused")
	private List<Sexo> sexo;

	
	

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



	public List<TipoPessoa> getTipoPessoas() {
		
		return Arrays.asList(TipoPessoa.values());
	}


	public void setTipoPessoas(List<TipoPessoa> tipoPessoas) {
		this.tipoPessoas = tipoPessoas;
	}


	public List<Sexo> getSexo() {
		return Arrays.asList(Sexo.values());
	}

	public void setSexo(List<Sexo> sexo) {
		this.sexo = sexo;
	}







}
