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
import ejb.entidades.Estadia;
import ejb.entidades.Usuario;
import ejb.entidades.Quarto;
import java.math.BigDecimal;
import javax.ejb.EJB;

/**
 *
 * @author thiagobrezinski
 */
@Stateless
@LocalBean
public class EstadiaSessionBean {

	@EJB
	private UsuarioSessionBean usuarioSessionBean;

	@PersistenceContext(unitName = "GerenciamentoHotel-ejbPU")
	private EntityManager em;

	public void persist(Object object) {
		em.persist(object);
	}

	public List<Estadia> getEstadias() {
        Query query = em.createNamedQuery("Estadia.findAll");
        return query.getResultList();
    }
	
	public void checkIn(
			String nome,
			String cpf,
			String endereco,
			String telefone,
			Quarto quarto,
			int senha,
			int diarias
	) {		
		Usuario usuario = usuarioSessionBean.findUsuarioByCpf(cpf);
		if(usuario == null) {
			usuario = usuarioSessionBean.createUsuario(nome, cpf, endereco, telefone);
		} else {
			usuario = usuarioSessionBean.updateUsuario(nome, cpf, endereco, telefone);
		}
		
		BigDecimal faturaInicial = quarto.getValordiaria().multiply(BigDecimal.valueOf(diarias));
		
		Estadia estadia = new Estadia(
				usuario,
				quarto,
				senha,
				faturaInicial,
				diarias,
				0
		);
		
		persist(estadia);
	}
}
