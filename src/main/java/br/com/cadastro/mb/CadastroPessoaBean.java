package br.com.cadastro.mb;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cadastro.model.Endereco;
import br.com.cadastro.model.EstadoCivil;
import br.com.cadastro.model.Pessoa;
import br.com.cadastro.model.TipoSexo;
import br.com.cadastro.model.Uf;
import br.com.cadastro.service.PessoaService;

@Named
@RequestScoped
public class CadastroPessoaBean extends BasicBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	PessoaService service;
	@Inject
	private Pessoa pessoa;
	@Inject
	private Endereco endereco;
	@SuppressWarnings("unused")
	private List<EstadoCivil> estadoCivil;
	@SuppressWarnings("unused")
	private List<TipoSexo> tipoSexo;
	@SuppressWarnings("unused")
	private List<Uf> Ufs;

	public void salvar() {

		this.pessoa.setEndereco(endereco);
		this.endereco.setPessoa(pessoa);
		if (validarPessoaMb() == null) {

			service.addPessoaService(pessoa);
			limparCampos();
			info("Contribuinte cadastrado com sucesso.");
		} else {

			error("CPF ou EMAIL já cadastrados no sistema.");
		}

	}

	public void limparCampos() {

		this.pessoa = new Pessoa();
		this.endereco = new Endereco();

	}

	public boolean validarCpf() {

		Pessoa pessoa = validarPessoaMb();
		if (pessoa != null) {

			error("CPF já cadastrado no sistema.");
			return false;

		}

		return true;

	}

	public boolean validarEmail() {

		Pessoa pessoa = validarPessoaMb();
		if (pessoa != null) {

			error("Email já cadastrado no sistema.");
			return false;

		}

		return true;

	}

	protected Pessoa validarPessoaMb() {

		Pessoa pessoa = service.validarPessoaService(this.pessoa);

		return pessoa;

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

}
