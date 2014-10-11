/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.somotoresentregas.repository;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LOGIC
 */
@Entity
@Table(name = "getalertas", catalog = "somotore_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alertas.findAll", query = "SELECT a FROM Alertas a"),
    @NamedQuery(name = "Alertas.findByEntregaID", query = "SELECT a FROM Alertas a WHERE a.entregaID = :entregaID"),
    @NamedQuery(name = "Alertas.findByDestinatario", query = "SELECT a FROM Alertas a WHERE a.destinatario = :destinatario"),
    @NamedQuery(name = "Alertas.findByEndereco", query = "SELECT a FROM Alertas a WHERE a.endereco = :endereco"),
    @NamedQuery(name = "Alertas.findByEntregador", query = "SELECT a FROM Alertas a WHERE a.entregador = :entregador"),
    @NamedQuery(name = "Alertas.findByStatusDesc", query = "SELECT a FROM Alertas a WHERE a.statusDesc = :statusDesc"),
    @NamedQuery(name = "Alertas.findByCheckin", query = "SELECT a FROM Alertas a WHERE a.checkin = :checkin"),
    @NamedQuery(name = "Alertas.findByCheckout", query = "SELECT a FROM Alertas a WHERE a.checkout = :checkout")})
public class Alertas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Id
    private int entregaID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(nullable = false, length = 80)
    private String destinatario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String endereco;
    @Size(max = 200)
    @Column(length = 200)
    private String entregador;
    @Size(max = 15)
    @Column(name = "status_desc", length = 15)
    private String statusDesc;
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkin;
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkout;

    public Alertas() {
    }

    public int getEntregaID() {
        return entregaID;
    }

    public void setEntregaID(int entregaID) {
        this.entregaID = entregaID;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEntregador() {
        return entregador;
    }

    public void setEntregador(String entregador) {
        this.entregador = entregador;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }
    
}
