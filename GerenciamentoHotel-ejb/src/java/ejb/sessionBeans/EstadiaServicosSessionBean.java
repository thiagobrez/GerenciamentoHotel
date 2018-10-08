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
import ejb.entidades.EstadiaServicos;

/**
 *
 * @author thiagobrezinski
 */
@Stateless
@LocalBean
public class EstadiaServicosSessionBean {

	@PersistenceContext(unitName = "GerenciamentoHotel-ejbPU")
	private EntityManager em;

	public void persist(Object object) {
		em.persist(object);
	}

	public List<EstadiaServicos> getEstadiaServicos() {
        Query query = em.createNamedQuery("EstadiaServicos.findAll");
        return query.getResultList();
    }
	
	public void createEstadiaServico(int idEstadia, int idServico) {
		EstadiaServicos estadiaServico = new EstadiaServicos(idEstadia, idServico);
		persist(estadiaServico);
	}
}
