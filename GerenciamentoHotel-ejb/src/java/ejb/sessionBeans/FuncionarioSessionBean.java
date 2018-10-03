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

/**
 *
 * @author thiagobrezinski
 */
@Stateless
@LocalBean
public class FuncionarioSessionBean {

	@PersistenceContext(unitName = "GerenciamentoHotel-ejbPU")
	private EntityManager em;

	public void persist(Object object) {
		em.persist(object);
	}

	public List<ejb.entidades.Funcionario> getFuncionarios() {
        Query query = em.createNamedQuery("Funcionario.findAll");
        return query.getResultList();
    }
	
	// Add business logic below. (Right-click in editor and choose
	// "Insert Code > Add Business Method")
}
