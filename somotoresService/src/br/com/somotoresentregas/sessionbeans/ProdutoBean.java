package br.com.somotoresentregas.sessionbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.somotoresentregas.controller.AbstractEJB;
import br.com.somotoresentregas.entities.Produto;

@Stateless
public class ProdutoBean extends AbstractEJB<Produto>{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public ProdutoBean(){
		super(Produto.class);
	}
	
	@Override
	protected EntityManager getEntityManager(){
		return this.entityManager;
	}
	
}