/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "MESSAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m")
    , @NamedQuery(name = "Message.findByMessageid", query = "SELECT m FROM Message m WHERE m.messageid = :messageid")
    , @NamedQuery(name = "Message.findByMessagedate", query = "SELECT m FROM Message m WHERE m.messagedate = :messagedate")
    , @NamedQuery(name = "Message.findByMessagecontent", query = "SELECT m FROM Message m WHERE m.messagecontent = :messagecontent")
    , @NamedQuery(name = "Message.findByIspublished", query = "SELECT m FROM Message m WHERE m.ispublished = :ispublished")})
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MESSAGEID")
    private BigDecimal messageid;
    @Column(name = "MESSAGEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date messagedate;
    @Size(max = 1000)
    @Column(name = "MESSAGECONTENT")
    private String messagecontent;
    @Column(name = "ISPUBLISHED")
    private Short ispublished;
    @JoinColumn(name = "TICKETID", referencedColumnName = "TICKETID")
    @ManyToOne
    private Ticket ticketid;
    @JoinColumn(name = "SENDERID", referencedColumnName = "USERACCOUNTID")
    @ManyToOne
    private Useraccount senderid;

    public Message() {
    }

    public Message(BigDecimal messageid) {
        this.messageid = messageid;
    }

    public BigDecimal getMessageid() {
        return messageid;
    }

    public void setMessageid(BigDecimal messageid) {
        this.messageid = messageid;
    }

    public Date getMessagedate() {
        return messagedate;
    }

    public void setMessagedate(Date messagedate) {
        this.messagedate = messagedate;
    }

    public String getMessagecontent() {
        return messagecontent;
    }

    public void setMessagecontent(String messagecontent) {
        this.messagecontent = messagecontent;
    }

    public Short getIspublished() {
        return ispublished;
    }

    public void setIspublished(Short ispublished) {
        this.ispublished = ispublished;
    }

    public Ticket getTicketid() {
        return ticketid;
    }

    public void setTicketid(Ticket ticketid) {
        this.ticketid = ticketid;
    }

    public Useraccount getSenderid() {
        return senderid;
    }

    public void setSenderid(Useraccount senderid) {
        this.senderid = senderid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (messageid != null ? messageid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.messageid == null && other.messageid != null) || (this.messageid != null && !this.messageid.equals(other.messageid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Message[ messageid=" + messageid + " ]";
    }
    
}
