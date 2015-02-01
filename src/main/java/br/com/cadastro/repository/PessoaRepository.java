package br.com.cadastro.repository;

import java.io.Serializable;

import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.cadastro.model.Filtro;
import br.com.cadastro.model.Pessoa;

@Stateless
public class PessoaRepository extends BasicRepository<Pessoa> implements
		Serializable {

	private static final long serialVersionUID = 1L;

	public PessoaRepository() {

		super(Pessoa.class);

	}

	public void addPessoa(Pessoa pessoa) {

		addEntity(pessoa);

	}

	public Pessoa consultaPessoa(Filtro filtro) {

		Pessoa pessoa = null;
		Criteria criteria = createCriteria();
		if (filtro.getCpf() != null) {
			criteria.add(Restrictions.eq("cpf", filtro.getCpf()));
		}
		if (filtro.getEmail() != null) {

			criteria.add(Restrictions.eq("email", filtro.getEmail()));

		}

		criteria.setMaxResults(1);
		pessoa = (Pessoa) criteria.uniqueResult();
		return pessoa;

	}

}
