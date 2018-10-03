/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thiagobrezinski
 */
@Entity
@Table(name = "ESTADIA")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Estadia.findAll", query = "SELECT e FROM Estadia e")
	, @NamedQuery(name = "Estadia.findById", query = "SELECT e FROM Estadia e WHERE e.id = :id")
	, @NamedQuery(name = "Estadia.findBySenha", query = "SELECT e FROM Estadia e WHERE e.senha = :senha")
	, @NamedQuery(name = "Estadia.findByDiarias", query = "SELECT e FROM Estadia e WHERE e.diarias = :diarias")
	, @NamedQuery(name = "Estadia.findByCheckout", query = "SELECT e FROM Estadia e WHERE e.checkout = :checkout")
	, @NamedQuery(name = "Estadia.findByFatura", query = "SELECT e FROM Estadia e WHERE e.fatura = :fatura")})
public class Estadia implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
	private Integer id;
	@Basic(optional = false)
    @NotNull
    @Column(name = "SENHA")
	private int senha;
	@Basic(optional = false)
    @NotNull
    @Column(name = "DIARIAS")
	private int diarias;
	@Column(name = "CHECKOUT")
	private Integer checkout;
	// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	@Column(name = "FATURA")
	private BigDecimal fatura;
	@JoinColumn(name = "QUARTO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
	private Quarto quarto;
	@JoinColumn(name = "USUARIO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
	private Usuario usuario;

	public Estadia() {
	}

	public Estadia(Integer id) {
		this.id = id;
	}

	public Estadia(Integer id, int senha, int diarias) {
		this.id = id;
		this.senha = senha;
		this.diarias = diarias;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public int getDiarias() {
		return diarias;
	}

	public void setDiarias(int diarias) {
		this.diarias = diarias;
	}

	public Integer getCheckout() {
		return checkout;
	}

	public void setCheckout(Integer checkout) {
		this.checkout = checkout;
	}

	public BigDecimal getFatura() {
		return fatura;
	}

	public void setFatura(BigDecimal fatura) {
		this.fatura = fatura;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		if (!(object instanceof Estadia)) {
			return false;
		}
		Estadia other = (Estadia) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ejb.Estadia[ id=" + id + " ]";
	}
	
}
