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

import br.com.somotoresentregas.entities.Entrega;
import br.com.somotoresentregas.entities.Usuario;
import br.com.somotoresentregas.util.Constantes;
import br.com.somotoresentregas.views.Alertas;
import br.com.somotoresentregas.views.AlertasDiferenca;

@Stateless
public class AlertaBean {

	@PersistenceContext
	EntityManager entityManager;

	private List<Alertas> alertas;
	private Entrega entrega;

	@SuppressWarnings("unchecked") 
	public List<Alertas> getAlertas() {
		alertas = (List<Alertas>) entityManager.createNamedQuery("Alertas.findAll").getResultList();
		return alertas;
	}

	public void desativaAlerta(Alertas pAlerta) {
		try {
			entrega = (Entrega) entityManager.createNamedQuery("Entrega.findById").setParameter("id", pAlerta.getEntregaID()).getSingleResult();
			System.out.println(entrega.getDestinatario());
			entrega.setIsAlerta(Constantes.DESATIVA_ALERTA);
			entityManager.persist(entrega);
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
	
	public String verificaPerfilUsuario(){
		HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		return usuario.getPerfil().toUpperCase();
	}
}
