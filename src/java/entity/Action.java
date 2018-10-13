/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
 * @author c1041184
 */
@Entity
@Table(name = "ACTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Action.findAll", query = "SELECT a FROM Action a")
    , @NamedQuery(name = "Action.findByActionid", query = "SELECT a FROM Action a WHERE a.actionid = :actionid")
    , @NamedQuery(name = "Action.findByDescription", query = "SELECT a FROM Action a WHERE a.description = :description")
    , @NamedQuery(name = "Action.findByUseraccountid", query = "SELECT a FROM Action a WHERE a.useraccountid = :useraccountid")
    , @NamedQuery(name = "Action.findByCreationdate", query = "SELECT a FROM Action a WHERE a.creationdate = :creationdate")
    , @NamedQuery(name = "Action.findByStartdate", query = "SELECT a FROM Action a WHERE a.startdate = :startdate")
    , @NamedQuery(name = "Action.findByEnddate", query = "SELECT a FROM Action a WHERE a.enddate = :enddate")
    , @NamedQuery(name = "Action.findByTicketid", query = "SELECT a FROM Action a WHERE a.ticketid = :ticketid")})
public class Action implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIONID")
    private BigDecimal actionid;
    @Size(max = 500)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "USERACCOUNTID")
    private BigInteger useraccountid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Column(name = "STARTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Column(name = "ENDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @Column(name = "TICKETID")
    private BigInteger ticketid;

    public Action() {
    }

    public Action(BigDecimal actionid) {
        this.actionid = actionid;
    }

    public Action(BigDecimal actionid, Date creationdate) {
        this.actionid = actionid;
        this.creationdate = creationdate;
    }

    public BigDecimal getActionid() {
        return actionid;
    }

    public void setActionid(BigDecimal actionid) {
        this.actionid = actionid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getUseraccountid() {
        return useraccountid;
    }

    public void setUseraccountid(BigInteger useraccountid) {
        this.useraccountid = useraccountid;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public BigInteger getTicketid() {
        return ticketid;
    }

    public void setTicketid(BigInteger ticketid) {
        this.ticketid = ticketid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actionid != null ? actionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Action)) {
            return false;
        }
        Action other = (Action) object;
        if ((this.actionid == null && other.actionid != null) || (this.actionid != null && !this.actionid.equals(other.actionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Action[ actionid=" + actionid + " ]";
    }
    
}
