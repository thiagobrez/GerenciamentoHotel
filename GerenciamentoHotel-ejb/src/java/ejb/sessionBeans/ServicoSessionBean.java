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
import ejb.entidades.Servico;
import java.math.BigDecimal;

/**
 *
 * @author thiagobrezinski
 */
@Stateless
@LocalBean
public class ServicoSessionBean {

	@PersistenceContext(unitName = "GerenciamentoHotel-ejbPU")
	private EntityManager em;

	public void persist(Object object) {
		em.persist(object);
	}

	public List<Servico> getServicos() {
        Query query = em.createNamedQuery("Servico.findAll");
        return query.getResultList();
    }

	public Servico findServicoByNome(String nome) {
		for(Servico servico : getServicos()) {
			if(servico.getNome().equals(nome)) return servico;
		}
		
		return null;
	}
	
	public Servico findServicoById(int id) {
		for(Servico servico : getServicos()) {
			if(servico.getId().equals(id)) return servico;
		}
		
		return null;
	}
	
	public Servico createServico(String nome, String descricao, BigDecimal valor) {
		Servico servico = new Servico(nome, descricao, valor);
		persist(servico);
		
		return findServicoByNome(nome);
	}
}
