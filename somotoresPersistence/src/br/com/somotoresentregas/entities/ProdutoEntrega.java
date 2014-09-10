package br.com.somotoresentregas.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the produto_entrega database table.
 * 
 */
@Entity
@Table(name="produto_entrega")
@NamedQuery(name="ProdutoEntrega.findAll", query="SELECT p FROM ProdutoEntrega p")
public class ProdutoEntrega implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int produto_entregaID;

	private short produtoQtde;

	//bi-directional many-to-one association to Entrega
	@ManyToOne
	@JoinColumn(name="entregaID")
	private Entrega entrega;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name="produtoID")
	private Produto produto;

	public ProdutoEntrega() {
	}

	public int getProduto_entregaID() {
		return this.produto_entregaID;
	}

	public void setProduto_entregaID(int produto_entregaID) {
		this.produto_entregaID = produto_entregaID;
	}

	public short getProdutoQtde() {
		return this.produtoQtde;
	}

	public void setProdutoQtde(short produtoQtde) {
		this.produtoQtde = produtoQtde;
	}

	public Entrega getEntrega() {
		return this.entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}