package br.com.cadastro.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cadastro.model.Pessoa;
import br.com.cadastro.service.PessoaService;

@Named
@ViewScoped
public class ListPessoaBean extends BasicBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Pessoa> pessoas;
	@Inject
	private PessoaService service;
	@Inject
	private Pessoa pessoaSelect;
	
	

	public ListPessoaBean() {

	}

	@PostConstruct
	public void init() {
		
		if (pessoas == null) {

			this.pessoas = service.listPessoaService();

		}

	}
	
	
	
	
	

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Pessoa getPessoaSelect() {
		return pessoaSelect;
	}

	public void setPessoaSelect(Pessoa pessoaSelect) {
		this.pessoaSelect = pessoaSelect;
	}

	

}
