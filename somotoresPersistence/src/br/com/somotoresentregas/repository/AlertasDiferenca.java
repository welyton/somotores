/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.somotoresentregas.repository;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LOGIC
 */
@Entity
@Table(name = "getalertasdiferenca", catalog = "somotore_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlertasDiferenca.findAll", query = "SELECT a FROM AlertasDiferenca a"),
    @NamedQuery(name = "AlertasDiferenca.findByEntregaID", query = "SELECT a FROM AlertasDiferenca a WHERE a.entregaID = :entregaID"),
    @NamedQuery(name = "AlertasDiferenca.findByDuracaoentrega", query = "SELECT a FROM AlertasDiferenca a WHERE a.duracaoentrega = :duracaoentrega"),
    @NamedQuery(name = "AlertasDiferenca.findByTempoestimado", query = "SELECT a FROM AlertasDiferenca a WHERE a.tempoestimado = :tempoestimado")})
public class AlertasDiferenca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Id
    private int entregaID;
    private BigInteger duracaoentrega;
    private Integer tempoestimado;

    public AlertasDiferenca() {
    }

    public int getEntregaID() {
        return entregaID;
    }

    public void setEntregaID(int entregaID) {
        this.entregaID = entregaID;
    }

    public BigInteger getDuracaoentrega() {
        return duracaoentrega;
    }

    public void setDuracaoentrega(BigInteger duracaoentrega) {
        this.duracaoentrega = duracaoentrega;
    }

    public Integer getTempoestimado() {
        return tempoestimado;
    }

    public void setTempoestimado(Integer tempoestimado) {
        this.tempoestimado = tempoestimado;
    }
    
}
