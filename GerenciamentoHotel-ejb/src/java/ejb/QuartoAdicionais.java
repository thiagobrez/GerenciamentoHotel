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
@Table(name = "QUARTO_ADICIONAIS")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "QuartoAdicionais.findAll", query = "SELECT q FROM QuartoAdicionais q")
	, @NamedQuery(name = "QuartoAdicionais.findByIdQuarto", query = "SELECT q FROM QuartoAdicionais q WHERE q.quartoAdicionaisPK.idQuarto = :idQuarto")
	, @NamedQuery(name = "QuartoAdicionais.findByAdicional", query = "SELECT q FROM QuartoAdicionais q WHERE q.quartoAdicionaisPK.adicional = :adicional")})
public class QuartoAdicionais implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected QuartoAdicionaisPK quartoAdicionaisPK;

	public QuartoAdicionais() {
	}

	public QuartoAdicionais(QuartoAdicionaisPK quartoAdicionaisPK) {
		this.quartoAdicionaisPK = quartoAdicionaisPK;
	}

	public QuartoAdicionais(int idQuarto, String adicional) {
		this.quartoAdicionaisPK = new QuartoAdicionaisPK(idQuarto, adicional);
	}

	public QuartoAdicionaisPK getQuartoAdicionaisPK() {
		return quartoAdicionaisPK;
	}

	public void setQuartoAdicionaisPK(QuartoAdicionaisPK quartoAdicionaisPK) {
		this.quartoAdicionaisPK = quartoAdicionaisPK;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (quartoAdicionaisPK != null ? quartoAdicionaisPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof QuartoAdicionais)) {
			return false;
		}
		QuartoAdicionais other = (QuartoAdicionais) object;
		if ((this.quartoAdicionaisPK == null && other.quartoAdicionaisPK != null) || (this.quartoAdicionaisPK != null && !this.quartoAdicionaisPK.equals(other.quartoAdicionaisPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ejb.QuartoAdicionais[ quartoAdicionaisPK=" + quartoAdicionaisPK + " ]";
	}
	
}
