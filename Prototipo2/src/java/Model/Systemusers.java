/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kardiinal
 */
@Entity
@Table(name = "SYSTEMUSERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Systemusers.findAll", query = "SELECT s FROM Systemusers s"),
    @NamedQuery(name = "Systemusers.findById", query = "SELECT s FROM Systemusers s WHERE s.id = :id"),
    @NamedQuery(name = "Systemusers.findByUsername", query = "SELECT s FROM Systemusers s WHERE s.username = :username"),
    @NamedQuery(name = "Systemusers.findByPassword", query = "SELECT s FROM Systemusers s WHERE s.password = :password")})
public class Systemusers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 15)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 15)
    @Column(name = "PASSWORD")
    private String password;

    public Systemusers() {
    }

    public Systemusers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Systemusers)) {
            return false;
        }
        Systemusers other = (Systemusers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Systemusers[ id=" + id + " ]";
    }
    
}
