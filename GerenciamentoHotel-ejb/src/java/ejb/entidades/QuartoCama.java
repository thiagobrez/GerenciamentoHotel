/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thiagobrezinski
 */
@Entity
@Table(name = "QUARTO_CAMA")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "QuartoCama.findAll", query = "SELECT q FROM QuartoCama q")
	, @NamedQuery(name = "QuartoCama.findByIdQuarto", query = "SELECT q FROM QuartoCama q WHERE q.quartoCamaPK.idQuarto = :idQuarto")
	, @NamedQuery(name = "QuartoCama.findByIdCama", query = "SELECT q FROM QuartoCama q WHERE q.quartoCamaPK.idCama = :idCama")})
public class QuartoCama implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected QuartoCamaPK quartoCamaPK;

	public QuartoCama() {
	}

	public QuartoCama(QuartoCamaPK quartoCamaPK) {
		this.quartoCamaPK = quartoCamaPK;
	}

	public QuartoCama(int idQuarto, int idCama) {
		this.quartoCamaPK = new QuartoCamaPK(idQuarto, idCama);
	}

	public QuartoCamaPK getQuartoCamaPK() {
		return quartoCamaPK;
	}

	public void setQuartoCamaPK(QuartoCamaPK quartoCamaPK) {
		this.quartoCamaPK = quartoCamaPK;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (quartoCamaPK != null ? quartoCamaPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof QuartoCama)) {
			return false;
		}
		QuartoCama other = (QuartoCama) object;
		if ((this.quartoCamaPK == null && other.quartoCamaPK != null) || (this.quartoCamaPK != null && !this.quartoCamaPK.equals(other.quartoCamaPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ejb.QuartoCama[ quartoCamaPK=" + quartoCamaPK + " ]";
	}
	
}
