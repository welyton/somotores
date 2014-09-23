package br.com.somotoresentregas.views;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the getalertasdiferenca database table.
 * 
 */
@Entity
@Table(name="getalertasdiferenca")
@NamedQuery(name="AlertasDiferenca.findAll", query="SELECT a FROM AlertasDiferenca a")
public class AlertasDiferenca implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigInteger duracaoentrega;

	@Id
	private int entregaID;

	private int tempoestimado;

	public AlertasDiferenca() {
	}

	public BigInteger getDuracaoentrega() {
		return this.duracaoentrega;
	}

	public void setDuracaoentrega(BigInteger duracaoentrega) {
		this.duracaoentrega = duracaoentrega;
	}

	public int getEntregaID() {
		return this.entregaID;
	}

	public void setEntregaID(int entregaID) {
		this.entregaID = entregaID;
	}

	public int getTempoestimado() {
		return this.tempoestimado;
	}

	public void setTempoestimado(int tempoestimado) {
		this.tempoestimado = tempoestimado;
	}

}