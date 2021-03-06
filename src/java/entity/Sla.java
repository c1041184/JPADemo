/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author c1041184
 */
@Entity
@Table(name = "SLA")

public class Sla implements Serializable {

    @OneToMany(mappedBy = "slaid")
    private Collection<Assetgroup> assetgroupCollection;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SLAID")
    @SequenceGenerator(name = "SLA_SEQ",sequenceName = "SLA_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SLA_SEQ")
    private BigDecimal slaid;
    @Size(max = 500)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 250)
    @Column(name = "TITLE")
    private String title;
    @Column(name = "RESPONSETIME")
    private BigInteger responsetime;

    public Sla() {
    }

    public Sla(BigDecimal slaid) {
        this.slaid = slaid;
    }

    public BigDecimal getSlaid() {
        return slaid;
    }

    public void setSlaid(BigDecimal slaid) {
        this.slaid = slaid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigInteger getResponsetime() {
        return responsetime;
    }

    public void setResponsetime(BigInteger responsetime) {
        this.responsetime = responsetime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (slaid != null ? slaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sla)) {
            return false;
        }
        Sla other = (Sla) object;
        if ((this.slaid == null && other.slaid != null) || (this.slaid != null && !this.slaid.equals(other.slaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Sla[ slaid=" + slaid + " ]";
    }

    @XmlTransient
    public Collection<Assetgroup> getAssetgroupCollection() {
        return assetgroupCollection;
    }

    public void setAssetgroupCollection(Collection<Assetgroup> assetgroupCollection) {
        this.assetgroupCollection = assetgroupCollection;
    }
    
}
