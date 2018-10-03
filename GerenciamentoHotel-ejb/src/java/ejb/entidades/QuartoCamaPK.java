/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author thiagobrezinski
 */
@Embeddable
public class QuartoCamaPK implements Serializable {

	@Basic(optional = false)
    @NotNull
    @Column(name = "ID_QUARTO")
	private int idQuarto;
	@Basic(optional = false)
    @NotNull
    @Column(name = "ID_CAMA")
	private int idCama;

	public QuartoCamaPK() {
	}

	public QuartoCamaPK(int idQuarto, int idCama) {
		this.idQuarto = idQuarto;
		this.idCama = idCama;
	}

	public int getIdQuarto() {
		return idQuarto;
	}

	public void setIdQuarto(int idQuarto) {
		this.idQuarto = idQuarto;
	}

	public int getIdCama() {
		return idCama;
	}

	public void setIdCama(int idCama) {
		this.idCama = idCama;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (int) idQuarto;
		hash += (int) idCama;
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof QuartoCamaPK)) {
			return false;
		}
		QuartoCamaPK other = (QuartoCamaPK) object;
		if (this.idQuarto != other.idQuarto) {
			return false;
		}
		if (this.idCama != other.idCama) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ejb.QuartoCamaPK[ idQuarto=" + idQuarto + ", idCama=" + idCama + " ]";
	}
	
}
