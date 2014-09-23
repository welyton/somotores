package br.com.somotoresentregas.managedbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.com.somotoresentregas.sessionbeans.AlertaBean;
import br.com.somotoresentregas.views.Alertas;

@ManagedBean
@ViewScoped
public class AlertaMB {
	
	@EJB
	private AlertaBean alertaService;

	private List<Alertas> alertas;
	private Alertas alertaSelected;

	public List<Alertas> getAlertas() {
		if (alertas == null) {
			alertas = alertaService.getAlertas();
		}
		return alertas;
	}

	public void setAlertas(List<Alertas> alertas) {
		this.alertas = alertas;
	}
	
	public void removeAlerta(){
		alertaService.desativaAlerta(alertaSelected);
	}
	
	public boolean isUsuarioAdmin(){
		return "A".equals(alertaService.verificaPerfilUsuario());
	}

	public Alertas getAlertaSelected() {
		return alertaSelected;
	}

	public void setAlertaSelected(Alertas alertaSelected) {
		this.alertaSelected = alertaSelected;
	}
	
	
	
}
