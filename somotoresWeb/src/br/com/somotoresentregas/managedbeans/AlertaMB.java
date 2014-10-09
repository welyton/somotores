package br.com.somotoresentregas.managedbeans;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.somotoresentregas.controller.AbstractManagedBean;
import br.com.somotoresentregas.sessionbeans.AlertaBean;
import br.com.somotoresentregas.views.Alertas;

@Named(value="alertaMB")
@ViewScoped
public class AlertaMB extends AbstractManagedBean<Alertas>{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AlertaBean alertaService;	
	
	public AlertaMB(){
		super(Alertas.class);
	}
	
	public void removeAlerta(ActionEvent evento){
		System.out.println("AlertaMB - removeAlerta");
		alertaService.desativaAlerta(super.getSelecionado());
	}
}
