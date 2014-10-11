package br.com.somotoresentregas.managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;

import br.com.somotoresentregas.controller.AbstractManagedBean;
import br.com.somotoresentregas.repository.Alertas;
import br.com.somotoresentregas.sessionbeans.AlertaBean;

@ManagedBean
@ViewScoped
public class AlertaMB extends AbstractManagedBean<Alertas>{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private AlertaBean alertaService;	
	
	public AlertaMB(){
		super(Alertas.class);
	}
	
	public void removeAlerta(ActionEvent evento){
		System.out.println("AlertaMB - removeAlerta");
		alertaService.desativaAlerta(super.getSelecionado());
	}
}
