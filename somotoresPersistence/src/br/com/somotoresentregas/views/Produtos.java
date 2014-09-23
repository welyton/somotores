package br.com.somotoresentregas.views;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the getprodutos database table.
 * 
 */
@Entity
@Table(name="getprodutos")
@NamedQuery(name="Produtos.findAll", query="SELECT p FROM Produtos p")
public class Produtos implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal precoUnitario;

	private String produto;

	@Id
	private int produtoID;

	private short sku;

	public Produtos() {
	}

	public BigDecimal getPrecoUnitario() {
		return this.precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public String getProduto() {
		return this.produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public int getProdutoID() {
		return this.produtoID;
	}

	public void setProdutoID(int produtoID) {
		this.produtoID = produtoID;
	}

	public short getSku() {
		return this.sku;
	}

	public void setSku(short sku) {
		this.sku = sku;
	}

}