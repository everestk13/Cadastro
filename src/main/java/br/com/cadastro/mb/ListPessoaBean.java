package br.com.cadastro.mb;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cadastro.model.EstadoCivil;
import br.com.cadastro.model.Pessoa;
import br.com.cadastro.model.TipoSexo;
import br.com.cadastro.model.Uf;
import br.com.cadastro.service.PessoaService;

@Named
@ConversationScoped
public class ListPessoaBean extends BasicBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Pessoa> pessoas;
	@Inject
	private PessoaService service;
	@Inject
	private Pessoa pessoaSelect;
	private Pessoa pessoaAlterar;
	@SuppressWarnings("unused")
	private List<EstadoCivil> estadoCivil;
	@SuppressWarnings("unused")
	private List<TipoSexo> tipoSexo;
	@SuppressWarnings("unused")
	private List<Uf> Ufs;
	@Inject
	private Conversation conversation;
	
	

	public ListPessoaBean() {

	}

	@PostConstruct
	public void init() {
		
		openConversation();
		
		if (pessoas == null) {

			this.pessoas = service.listPessoaService();

		}

	}
	
	public String selecionar(){
		System.out.println("---Selecionar Pessoa---");
		this.pessoaAlterar = this.pessoaSelect;
		
		return "EditarContribuinte";
		
	}
	
	public void update() throws IOException{
		
		service.updatePessoaService(pessoaAlterar);
		closeConversation();
		FacesContext.getCurrentInstance().getExternalContext().redirect("ListContribuintes.xhtml"); 
		
	}
	
	private void openConversation(){
		
		if(this.conversation.isTransient()){
			
			conversation.begin();
			
		}
		
	}
	
	private void closeConversation(){
		
		if(!this.conversation.isTransient()){
			
			conversation.end();
			
		}
		
	}
	
	
	
	
	

	public PessoaService getService() {
		return service;
	}

	public void setService(PessoaService service) {
		this.service = service;
	}

	public List<EstadoCivil> getEstadoCivil() {
		return Arrays.asList(EstadoCivil.values());
	}

	public void setEstadoCivil(List<EstadoCivil> estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public List<TipoSexo> getTipoSexo() {
		return Arrays.asList(TipoSexo.values());
	}

	public void setTipoSexo(List<TipoSexo> tipoSexo) {
		this.tipoSexo = tipoSexo;
	}

	public List<Uf> getUfs() {
		return Arrays.asList(Uf.values());
	}

	public void setUfs(List<Uf> ufs) {
		Ufs = ufs;
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

	public Pessoa getPessoaAlterar() {
		return pessoaAlterar;
	}

	public void setPessoaAlterar(Pessoa pessoaAlterar) {
		this.pessoaAlterar = pessoaAlterar;
	}



	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

	

}
