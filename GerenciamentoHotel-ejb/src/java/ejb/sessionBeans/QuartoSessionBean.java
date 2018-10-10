/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.sessionBeans;

import ejb.entidades.Cama;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ejb.entidades.Quarto;
import ejb.entidades.QuartoAdicionais;
import ejb.entidades.QuartoCama;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.ejb.EJB;

/**
 *
 * @author thiagobrezinski
 */
@Stateless
@LocalBean
public class QuartoSessionBean {
	
	@EJB
	private QuartoCamaSessionBean quartoCamaSessionBean;
	
	@EJB
	private QuartoAdicionaisSessionBean quartoAdicionaisSessionBean;

	@EJB
	private CamaSessionBean camaSessionBean;
	
	@PersistenceContext(unitName = "GerenciamentoHotel-ejbPU")
	private EntityManager em;

	public void persist(Object object) {
		em.persist(object);
	}

	public List<Quarto> getQuartos() {
        Query query = em.createNamedQuery("Quarto.findAll");
        return query.getResultList();
    }
	
	public Quarto getQuartoByNumero(int numero) {
        Query query = em.createNamedQuery("Quarto.findByNumero");
		query.setParameter("numero", numero);
        return (Quarto) query.getSingleResult();
	}
	
	public Quarto createQuarto(
			int numero,
			BigDecimal valorDiaria,
			String tipo,
			String ocupado,
			ArrayList<Cama> camas,
			ArrayList<String> adicionais
	) {
		Quarto quarto = new Quarto(numero, valorDiaria, tipo, ocupado);
		persist(quarto);
		
		quarto = getQuartoByNumero(numero);
		
		for(Cama cama : camas) {
			quartoCamaSessionBean.createQuartoCama(quarto.getId(), cama.getId());
		}
		
		for(String adicional : adicionais) {
			quartoAdicionaisSessionBean.createQuartoAdicional(quarto.getId(), adicional);
		}
		
		return quarto;
	}
	
	public void updateQuarto(Quarto quarto) {
		em.merge(quarto);
		em.flush();
	}
}
