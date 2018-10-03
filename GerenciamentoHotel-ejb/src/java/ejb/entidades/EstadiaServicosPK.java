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
public class EstadiaServicosPK implements Serializable {

	@Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTADIA")
	private int idEstadia;
	@Basic(optional = false)
    @NotNull
    @Column(name = "ID_SERVICO")
	private int idServico;

	public EstadiaServicosPK() {
	}

	public EstadiaServicosPK(int idEstadia, int idServico) {
		this.idEstadia = idEstadia;
		this.idServico = idServico;
	}

	public int getIdEstadia() {
		return idEstadia;
	}

	public void setIdEstadia(int idEstadia) {
		this.idEstadia = idEstadia;
	}

	public int getIdServico() {
		return idServico;
	}

	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (int) idEstadia;
		hash += (int) idServico;
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof EstadiaServicosPK)) {
			return false;
		}
		EstadiaServicosPK other = (EstadiaServicosPK) object;
		if (this.idEstadia != other.idEstadia) {
			return false;
		}
		if (this.idServico != other.idServico) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ejb.EstadiaServicosPK[ idEstadia=" + idEstadia + ", idServico=" + idServico + " ]";
	}
	
}
