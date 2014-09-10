package br.com.somotoresentregas.sessionbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.somotoresentregas.entities.Categoria;

@Stateless
public class LogarBean {
	
	@PersistenceContext
	EntityManager entityManager;

	public boolean logar(String pLogin, String pSenha) {
		Categoria cat = entityManager.find(Categoria.class,1);
		System.out.println(cat.getNome());
		return "admin".equals(pLogin) && "admin".equals(pSenha);
	}
	
}