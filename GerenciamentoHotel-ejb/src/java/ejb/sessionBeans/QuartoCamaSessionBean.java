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
import ejb.entidades.QuartoCama;

/**
 *
 * @author thiagobrezinski
 */
@Stateless
@LocalBean
public class QuartoCamaSessionBean {

	@PersistenceContext(unitName = "GerenciamentoHotel-ejbPU")
	private EntityManager em;

	public void persist(Object object) {
		em.persist(object);
	}

	public List<QuartoCama> getQuartoCamas() {
        Query query = em.createNamedQuery("QuartoCama.findAll");
        return query.getResultList();
    }
	
	public QuartoCama createQuartoCama(int idQuarto, int idCama) {
		QuartoCama quartoCama = new QuartoCama(idQuarto, idCama);
		persist(quartoCama);
		
		return quartoCama;
	}
}
