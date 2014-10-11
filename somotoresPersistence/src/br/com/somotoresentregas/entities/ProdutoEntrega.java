/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.somotoresentregas.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "produto_entrega", catalog = "somotore_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProdutoEntrega.findAll", query = "SELECT p FROM ProdutoEntrega p"),
    @NamedQuery(name = "ProdutoEntrega.findByProdutoentregaID", query = "SELECT p FROM ProdutoEntrega p WHERE p.produtoentregaID = :produtoentregaID"),
    @NamedQuery(name = "ProdutoEntrega.findByProdutoQtde", query = "SELECT p FROM ProdutoEntrega p WHERE p.produtoQtde = :produtoQtde")})
public class ProdutoEntrega implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "produto_entregaID", nullable = false)
    private Integer produtoentregaID;
    private Short produtoQtde;
    @JoinColumn(name = "entregaID", referencedColumnName = "entregaID", nullable = false)
    @ManyToOne(optional = false)
    private Entrega entregaID;
    @JoinColumn(name = "produtoID", referencedColumnName = "produtoID", nullable = false)
    @ManyToOne(optional = false)
    private Produto produtoID;

    public ProdutoEntrega() {
    }

    public ProdutoEntrega(Integer produtoentregaID) {
        this.produtoentregaID = produtoentregaID;
    }

    public Integer getProdutoentregaID() {
        return produtoentregaID;
    }

    public void setProdutoentregaID(Integer produtoentregaID) {
        this.produtoentregaID = produtoentregaID;
    }

    public Short getProdutoQtde() {
        return produtoQtde;
    }

    public void setProdutoQtde(Short produtoQtde) {
        this.produtoQtde = produtoQtde;
    }

    public Entrega getEntregaID() {
        return entregaID;
    }

    public void setEntregaID(Entrega entregaID) {
        this.entregaID = entregaID;
    }

    public Produto getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(Produto produtoID) {
        this.produtoID = produtoID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produtoentregaID != null ? produtoentregaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdutoEntrega)) {
            return false;
        }
        ProdutoEntrega other = (ProdutoEntrega) object;
        if ((this.produtoentregaID == null && other.produtoentregaID != null) || (this.produtoentregaID != null && !this.produtoentregaID.equals(other.produtoentregaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.somotoresentregas.model.ProdutoEntrega[ produtoentregaID=" + produtoentregaID + " ]";
    }
    
}
