/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ejb.entidades.Funcionario;
import ejb.sessionBeans.FuncionarioSessionBean;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author thiagobrezinski
 */
@Named(value = "funcionarioJSFManagedBean")
@RequestScoped
public class FuncionarioJSFManagedBean {
	
	@EJB
	private FuncionarioSessionBean funcionarioSessionBean;

	private String username;
	private String senha;
	
	/**
	 * Creates a new instance of FuncionarioJSFManagedBean
	 */
	public FuncionarioJSFManagedBean() {
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
	
	public Funcionario login(int username, int senha) {
		return funcionarioSessionBean.login(username, senha);
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarioSessionBean.getFuncionarios();
	}
}
