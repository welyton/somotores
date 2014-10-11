package br.com.somotoresentregas.sessionbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import br.com.somotoresentregas.controller.AbstractEJB;
import br.com.somotoresentregas.entities.Entrega;
import br.com.somotoresentregas.entities.Usuario;
import br.com.somotoresentregas.util.Constantes;
import br.com.somotoresentregas.repository.Alertas;
import br.com.somotoresentregas.repository.AlertasDiferenca;

@Stateless
public class AlertaBean extends AbstractEJB<Alertas> {

	@PersistenceContext
	EntityManager entityManager;
	
	public AlertaBean(){
		super(Alertas.class);
	}
	
	@Override
	protected EntityManager getEntityManager(){
		return this.entityManager;
	}
	private Entrega entrega;

	public void desativaAlerta(Alertas pAlerta) {
		try {
			entrega = (Entrega) entityManager.createNamedQuery("Entrega.findById").setParameter("id", pAlerta.getEntregaID()).getSingleResult();
			entrega.setIsAlerta(Constantes.DESATIVA_ALERTA);
			entityManager.merge(entrega);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@PostConstruct
	@Transactional
	@Schedule(hour = "*/1", minute = "0", second = "0")
	public void ativaAlertaAgendamento() {
		try {
			List<AlertasDiferenca> alertas = (List<AlertasDiferenca>) entityManager.createNamedQuery("AlertasDiferenca.findAll").getResultList();
			for (AlertasDiferenca elemento : alertas) {
				if(elemento.getDuracaoentrega().intValue() > elemento.getTempoestimado()){
					entrega = (Entrega) entityManager.createNamedQuery("Entrega.findById").setParameter("id", elemento.getEntregaID()).getSingleResult();
					entrega.setIsAlerta(Constantes.ATIVA_ALERTA);
					entityManager.persist(entrega);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public String verificaPerfilUsuario(){
//		HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
//		return usuario.getPerfil().toUpperCase();
//	}
}
