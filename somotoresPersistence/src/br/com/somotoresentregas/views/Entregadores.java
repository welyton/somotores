package br.com.somotoresentregas.views;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the getentregadores database table.
 * 
 */
@Entity
@Table(name="getentregadores")
@NamedQuery(name="Entregadores.findAll", query="SELECT e FROM Entregadores e")
public class Entregadores implements Serializable {
	private static final long serialVersionUID = 1L;

	private int entregador;

	private int isLogado;

	private String matricula;

	private String telefone;

	@Id
	private int usuarioID;

	private String veiculo;

	public Entregadores() {
	}

	public int getEntregador() {
		return this.entregador;
	}

	public void setEntregador(int entregador) {
		this.entregador = entregador;
	}

	public int getIsLogado() {
		return this.isLogado;
	}

	public void setIsLogado(int isLogado) {
		this.isLogado = isLogado;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getUsuarioID() {
		return this.usuarioID;
	}

	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
	}

	public String getVeiculo() {
		return this.veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

}