/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.sessionBeans;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ejb.entidades.Usuario;

/**
 *
 * @author thiagobrezinski
 */
@Stateless
@LocalBean
public class UsuarioSessionBean {

	@PersistenceContext(unitName = "GerenciamentoHotel-ejbPU")
	private EntityManager em;
	
	public UsuarioSessionBean() {}
	
	public void persist(Object object) {
		em.persist(object);
	}
	
	public List<Usuario> getUsuarios() {
        Query query = em.createNamedQuery("Usuario.findAll");
        return query.getResultList();
    }
	
	public Usuario findUsuarioByCpf(String cpf) {
        Query query = em.createNamedQuery("Usuario.findByCpf");
		query.setParameter("cpf", cpf);
        return ((Usuario) query.getResultList().get(0));
	}
	
	public Usuario createUsuario(
			String nome,
			String cpf,
			String endereco,
			String telefone
	) {
		Usuario usuario = new Usuario(nome, cpf, endereco, telefone);
		em.persist(usuario);
		
		return findUsuarioByCpf(cpf);
	}
	
	public Usuario updateUsuario(
			String nome,
			String cpf,
			String endereco,
			String telefone
	) {
		Usuario usuario = new Usuario(nome, cpf, endereco, telefone);
		em.merge(usuario);
		em.flush();
		
		return findUsuarioByCpf(cpf);
	}	
}
