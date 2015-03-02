package br.com.cadastro.repository;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
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
	
	
	public void updatePessoa(Pessoa pessoa){
		
		updateEntity(pessoa);
		
		
	}
	
	public Pessoa findPessoa(int id){
		return entity(id);
		
		
	}
	
	public List<Pessoa>listPessoa(){
		
		return listEntity();
		
		//return manager.createQuery("from Pessoa p join fetch p.endereco", Pessoa.class).getResultList();
		
		
	}

	public Pessoa validarPessoa(Filtro filtro) {

		Pessoa pessoa = null;
		Criteria criteria = createCriteria();
		criteria.setFetchMode("endereco",FetchMode.JOIN);
		if (filtro.getCpf() != null) {
			criteria.add(Restrictions.eq("cpf", filtro.getCpf()));
		}
		else if (filtro.getEmail() != null) {

			criteria.add(Restrictions.eq("email", filtro.getEmail()));

		}

		criteria.setMaxResults(1);
		pessoa = (Pessoa) criteria.uniqueResult();
		return pessoa;

	}

}
