package br.com.somotoresentregas.sessionbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.somotoresentregas.controller.AbstractEJB;
import br.com.somotoresentregas.entities.Categoria;

@Stateless
public class CategoriaBean extends AbstractEJB<Categoria> {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public CategoriaBean(){
		super(Categoria.class);
	}
	
	@Override
	protected EntityManager getEntityManager(){
		return this.entityManager;
	}
	
}
