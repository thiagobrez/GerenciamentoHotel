/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ejb.entidades.Usuario;
import ejb.sessionBeans.UsuarioSessionBean;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author thiagobrezinski
 */
@Named(value = "usuarioJSFManagedBean")
@RequestScoped
public class UsuarioJSFManagedBean {

	@EJB
	private UsuarioSessionBean usuarioSessionBean;

	/**
	 * Creates a new instance of UsuarioJSFManagedBean
	 */
	public UsuarioJSFManagedBean() {
	}
	
	public List<Usuario> getUsuarios() {
		return usuarioSessionBean.getUsuarios();
	}
	
	public Usuario findUsuarioByCpf(String cpf) {
		return usuarioSessionBean.findUsuarioByCpf(cpf);
	}
	
	public Usuario createUsuario(
			String nome,
			String cpf,
			String endereco,
			String telefone
	) {
		return usuarioSessionBean.createUsuario(nome, cpf, endereco, telefone);
	}
	
	public Usuario updateUsuario(
			String nome,
			String cpf,
			String endereco,
			String telefone
	) {
		return usuarioSessionBean.updateUsuario(nome, cpf, endereco, telefone);
	}
}
