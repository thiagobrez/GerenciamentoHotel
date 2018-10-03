/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thiagobrezinski
 */
@Entity
@Table(name = "CAMA")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Cama.findAll", query = "SELECT c FROM Cama c")
	, @NamedQuery(name = "Cama.findById", query = "SELECT c FROM Cama c WHERE c.id = :id")
	, @NamedQuery(name = "Cama.findByTipo", query = "SELECT c FROM Cama c WHERE c.tipo = :tipo")})
public class Cama implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
	private Integer id;
	@Size(max = 30)
    @Column(name = "TIPO")
	private String tipo;

	public Cama() {
	}

	public Cama(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
		if (!(object instanceof Cama)) {
			return false;
		}
		Cama other = (Cama) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ejb.Cama[ id=" + id + " ]";
	}
	
}
