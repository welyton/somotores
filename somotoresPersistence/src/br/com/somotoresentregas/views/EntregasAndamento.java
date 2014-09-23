package br.com.somotoresentregas.views;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the getentregasandamento database table.
 * 
 */
@Entity
@Table(name="getentregasandamento")
@NamedQuery(name="EntregasAndamento.findAll", query="SELECT e FROM EntregasAndamento e")
public class EntregasAndamento implements Serializable {
	private static final long serialVersionUID = 1L;

	private Timestamp checkin;

	private Timestamp checkout;

	private String destinatario;

	private int entregador;

	@Id
	private int entregaID;

	@Column(name="status_desc")
	private String statusDesc;

	public EntregasAndamento() {
	}

	public Timestamp getCheckin() {
		return this.checkin;
	}

	public void setCheckin(Timestamp checkin) {
		this.checkin = checkin;
	}

	public Timestamp getCheckout() {
		return this.checkout;
	}

	public void setCheckout(Timestamp checkout) {
		this.checkout = checkout;
	}

	public String getDestinatario() {
		return this.destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public int getEntregador() {
		return this.entregador;
	}

	public void setEntregador(int entregador) {
		this.entregador = entregador;
	}

	public int getEntregaID() {
		return this.entregaID;
	}

	public void setEntregaID(int entregaID) {
		this.entregaID = entregaID;
	}

	public String getStatusDesc() {
		return this.statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

}