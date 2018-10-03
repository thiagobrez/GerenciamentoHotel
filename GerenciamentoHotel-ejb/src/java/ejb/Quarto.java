/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thiagobrezinski
 */
@Entity
@Table(name = "QUARTO")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Quarto.findAll", query = "SELECT q FROM Quarto q")
	, @NamedQuery(name = "Quarto.findById", query = "SELECT q FROM Quarto q WHERE q.id = :id")
	, @NamedQuery(name = "Quarto.findByNumero", query = "SELECT q FROM Quarto q WHERE q.numero = :numero")
	, @NamedQuery(name = "Quarto.findByValordiaria", query = "SELECT q FROM Quarto q WHERE q.valordiaria = :valordiaria")
	, @NamedQuery(name = "Quarto.findByTipo", query = "SELECT q FROM Quarto q WHERE q.tipo = :tipo")
	, @NamedQuery(name = "Quarto.findByOcupado", query = "SELECT q FROM Quarto q WHERE q.ocupado = :ocupado")})
public class Quarto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
	private Integer id;
	@Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO")
	private int numero;
	// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	@Column(name = "VALORDIARIA")
	private BigDecimal valordiaria;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TIPO")
	private String tipo;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "OCUPADO")
	private String ocupado;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "quarto")
	private Collection<Estadia> estadiaCollection;

	public Quarto() {
	}

	public Quarto(Integer id) {
		this.id = id;
	}

	public Quarto(Integer id, int numero, String tipo, String ocupado) {
		this.id = id;
		this.numero = numero;
		this.tipo = tipo;
		this.ocupado = ocupado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public BigDecimal getValordiaria() {
		return valordiaria;
	}

	public void setValordiaria(BigDecimal valordiaria) {
		this.valordiaria = valordiaria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getOcupado() {
		return ocupado;
	}

	public void setOcupado(String ocupado) {
		this.ocupado = ocupado;
	}

	@XmlTransient
	public Collection<Estadia> getEstadiaCollection() {
		return estadiaCollection;
	}

	public void setEstadiaCollection(Collection<Estadia> estadiaCollection) {
		this.estadiaCollection = estadiaCollection;
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
		if (!(object instanceof Quarto)) {
			return false;
		}
		Quarto other = (Quarto) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ejb.Quarto[ id=" + id + " ]";
	}
	
}
