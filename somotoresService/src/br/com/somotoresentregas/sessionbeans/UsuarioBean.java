package br.com.somotoresentregas.sessionbeans;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.com.somotoresentregas.controller.AbstractEJB;
import br.com.somotoresentregas.entities.Usuario;

@Stateful
public class UsuarioBean extends AbstractEJB<Usuario> {

	@PersistenceContext
	private EntityManager entityManager;
	
	public UsuarioBean(){
		super(Usuario.class);
	}
	
	@Override
	protected EntityManager getEntityManager(){
		return this.entityManager;
	}	
	

	public Usuario logarUsuario(Usuario pUsuario) {
		try{
			Usuario usuarioDB = (Usuario) entityManager.createNamedQuery("Usuario.findByLogin")
					.setParameter("login", pUsuario.getLogin())
					.setParameter("senha", pUsuario.getSenha())
					.getSingleResult();
			
			System.out.println("usuarioTemp Login: " + usuarioDB.getLogin());
			System.out.println("usuarioTemp Senha: " + usuarioDB.getSenha());
			
			if (pUsuario.getLogin().equals(usuarioDB.getLogin()) && pUsuario.getSenha().equals(usuarioDB.getSenha())) {
				System.out.println("vai retornar true");
				return usuarioDB;
			} else {
				entityManager.detach(usuarioDB);
				usuarioDB = null;
				System.out.println("vai retornar false");
				return null;
			}
		}catch(NoResultException e){
			return null;
		}
	}
}