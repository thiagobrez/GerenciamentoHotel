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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thiagobrezinski
 */
@Entity
@Table(name = "FUNCIONARIO")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")
	, @NamedQuery(name = "Funcionario.findById", query = "SELECT f FROM Funcionario f WHERE f.id = :id")
	, @NamedQuery(name = "Funcionario.findByNome", query = "SELECT f FROM Funcionario f WHERE f.nome = :nome")
	, @NamedQuery(name = "Funcionario.findByCpf", query = "SELECT f FROM Funcionario f WHERE f.cpf = :cpf")
	, @NamedQuery(name = "Funcionario.findByEndereco", query = "SELECT f FROM Funcionario f WHERE f.endereco = :endereco")
	, @NamedQuery(name = "Funcionario.findByTelefone", query = "SELECT f FROM Funcionario f WHERE f.telefone = :telefone")
	, @NamedQuery(name = "Funcionario.findByUsername", query = "SELECT f FROM Funcionario f WHERE f.username = :username")
	, @NamedQuery(name = "Funcionario.findBySenha", query = "SELECT f FROM Funcionario f WHERE f.senha = :senha")})
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
	private Integer id;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOME")
	private String nome;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "CPF")
	private String cpf;
	@Size(max = 60)
    @Column(name = "ENDERECO")
	private String endereco;
	@Size(max = 11)
    @Column(name = "TELEFONE")
	private String telefone;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USERNAME")
	private String username;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SENHA")
	private String senha;

	public Funcionario() {
	}

	public Funcionario(Integer id) {
		this.id = id;
	}

	public Funcionario(Integer id, String nome, String cpf, String username, String senha) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.username = username;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
		if (!(object instanceof Funcionario)) {
			return false;
		}
		Funcionario other = (Funcionario) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ejb.Funcionario[ id=" + id + " ]";
	}
	
}
