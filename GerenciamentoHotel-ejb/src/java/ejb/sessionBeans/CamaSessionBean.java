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
import ejb.entidades.Cama;

/**
 *
 * @author thiagobrezinski
 */
@Stateless
@LocalBean
public class CamaSessionBean {

	@PersistenceContext(unitName = "GerenciamentoHotel-ejbPU")
	private EntityManager em;

	public void persist(Object object) {
		em.persist(object);
	}

	public List<Cama> getCamas() {
        Query query = em.createNamedQuery("Cama.findAll");
        return query.getResultList();
    }

	public Cama getCamaById(int id) {
        Query query = em.createNamedQuery("Cama.findById");
		query.setParameter("id", id);
        return ((Cama) query.getResultList().get(0));
	}
}
