/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

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
@Table(name = "ESTADIA_SERVICOS")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "EstadiaServicos.findAll", query = "SELECT e FROM EstadiaServicos e")
	, @NamedQuery(name = "EstadiaServicos.findByIdEstadia", query = "SELECT e FROM EstadiaServicos e WHERE e.estadiaServicosPK.idEstadia = :idEstadia")
	, @NamedQuery(name = "EstadiaServicos.findByIdServico", query = "SELECT e FROM EstadiaServicos e WHERE e.estadiaServicosPK.idServico = :idServico")})
public class EstadiaServicos implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected EstadiaServicosPK estadiaServicosPK;

	public EstadiaServicos() {
	}

	public EstadiaServicos(EstadiaServicosPK estadiaServicosPK) {
		this.estadiaServicosPK = estadiaServicosPK;
	}

	public EstadiaServicos(int idEstadia, int idServico) {
		this.estadiaServicosPK = new EstadiaServicosPK(idEstadia, idServico);
	}

	public EstadiaServicosPK getEstadiaServicosPK() {
		return estadiaServicosPK;
	}

	public void setEstadiaServicosPK(EstadiaServicosPK estadiaServicosPK) {
		this.estadiaServicosPK = estadiaServicosPK;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (estadiaServicosPK != null ? estadiaServicosPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof EstadiaServicos)) {
			return false;
		}
		EstadiaServicos other = (EstadiaServicos) object;
		if ((this.estadiaServicosPK == null && other.estadiaServicosPK != null) || (this.estadiaServicosPK != null && !this.estadiaServicosPK.equals(other.estadiaServicosPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ejb.EstadiaServicos[ estadiaServicosPK=" + estadiaServicosPK + " ]";
	}
	
}
