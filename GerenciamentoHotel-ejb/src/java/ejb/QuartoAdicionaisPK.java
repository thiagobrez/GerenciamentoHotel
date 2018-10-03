/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author thiagobrezinski
 */
@Embeddable
public class QuartoAdicionaisPK implements Serializable {

	@Basic(optional = false)
    @NotNull
    @Column(name = "ID_QUARTO")
	private int idQuarto;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ADICIONAL")
	private String adicional;

	public QuartoAdicionaisPK() {
	}

	public QuartoAdicionaisPK(int idQuarto, String adicional) {
		this.idQuarto = idQuarto;
		this.adicional = adicional;
	}

	public int getIdQuarto() {
		return idQuarto;
	}

	public void setIdQuarto(int idQuarto) {
		this.idQuarto = idQuarto;
	}

	public String getAdicional() {
		return adicional;
	}

	public void setAdicional(String adicional) {
		this.adicional = adicional;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (int) idQuarto;
		hash += (adicional != null ? adicional.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof QuartoAdicionaisPK)) {
			return false;
		}
		QuartoAdicionaisPK other = (QuartoAdicionaisPK) object;
		if (this.idQuarto != other.idQuarto) {
			return false;
		}
		if ((this.adicional == null && other.adicional != null) || (this.adicional != null && !this.adicional.equals(other.adicional))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ejb.QuartoAdicionaisPK[ idQuarto=" + idQuarto + ", adicional=" + adicional + " ]";
	}
	
}
