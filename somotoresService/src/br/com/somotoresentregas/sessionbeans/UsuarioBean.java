package br.com.somotoresentregas.sessionbeans;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

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
	
	private Usuario usuario;

	public boolean logarUsuario(String pLogin, String pSenha) {
		try{
			Usuario usuarioTemp = (Usuario) entityManager.createNamedQuery("Usuario.findByLogin")
					.setParameter("login", pLogin)
					.setParameter("senha", pSenha)
					.getSingleResult();
			
			if (pLogin.equals(usuarioTemp.getLogin()) && pSenha.equals(usuarioTemp.getSenha())) {
				this.usuario = usuarioTemp;
				HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
				sessao.setAttribute("usuario", usuario);
				return true;
			} else {
				entityManager.detach(usuarioTemp);
				return false;
			}
		}catch(NoResultException e){
			return false;
		}
	}
	
	@Remove
	public void removeEjbUsuario(){
		usuario = null;
	}

//	public Usuario getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}
	
	
}