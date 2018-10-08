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
import ejb.entidades.QuartoAdicionais;

/**
 *
 * @author thiagobrezinski
 */
@Stateless
@LocalBean
public class QuartoAdicionaisSessionBean {

	@PersistenceContext(unitName = "GerenciamentoHotel-ejbPU")
	private EntityManager em;

	public void persist(Object object) {
		em.persist(object);
	}

	public List<QuartoAdicionais> getQuartoAdicionais() {
        Query query = em.createNamedQuery("QuartoAdicionais.findAll");
        return query.getResultList();
    }
	
	public QuartoAdicionais createQuartoAdicional(int idQuarto, String adicional) {
		QuartoAdicionais quartoAdicionais = new QuartoAdicionais(idQuarto, adicional);
		persist(quartoAdicionais);
		
		return quartoAdicionais;
	}
}
