package br.com.somotoresentregas.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class AbstractEJB<T> {

	private Class<T> entidade;
	
	public AbstractEJB(Class<T> pEntidade) {
		this.entidade = pEntidade;
	}
	
	protected abstract EntityManager getEntityManager();
	
	public void insere(T pEntidade){
		getEntityManager().persist(pEntidade);
	}
	
	public void atualiza(T pEntidade){
		getEntityManager().merge(pEntidade);
	}
	
	public void exclui(T pEntidade){
		getEntityManager().remove(getEntityManager().merge(pEntidade));
	}
	
	public T buscaObjeto(Object id){
		return getEntityManager().find(entidade, id);
	}
	
	public List<T> buscaTodos() {
		getEntityManager().getEntityManagerFactory().getCache().evictAll();
		CriteriaQuery criteria = getEntityManager().getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(entidade));
        return getEntityManager().createQuery(criteria).getResultList();
	}
	
	public List<T> buscaRange(int[] range){
		CriteriaQuery criteria = getEntityManager().getCriteriaBuilder().createQuery();
		criteria.select(criteria.from(entidade));
		Query consulta = getEntityManager().createQuery(criteria);
		consulta.setMaxResults(range[1] - range[0] + 1);
		consulta.setFirstResult(range[0]);
		return consulta.getResultList();
	}
	
	public int quantidade(){
		CriteriaQuery criteria = getEntityManager().getCriteriaBuilder().createQuery();
		Root<T> root = criteria.from(entidade);
		criteria.select(getEntityManager().getCriteriaBuilder().count(root));
		Query consulta = getEntityManager().createQuery(criteria);
		return ((Long) consulta.getSingleResult()).intValue();
	}
	
}
