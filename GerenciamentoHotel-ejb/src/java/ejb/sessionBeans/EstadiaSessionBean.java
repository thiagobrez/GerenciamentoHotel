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
import ejb.entidades.EstadiaServicos;
import ejb.entidades.Usuario;
import ejb.entidades.Quarto;
import ejb.entidades.Servico;
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
	
	@EJB
	private QuartoSessionBean quartoSessionBean;

	@EJB
	private EstadiaServicosSessionBean estadiaServicosSessionBean;

	@EJB
	private ServicoSessionBean servicoSessionBean;
	
	@PersistenceContext(unitName = "GerenciamentoHotel-ejbPU")
	private EntityManager em;

	public void persist(Object object) {
		em.persist(object);
	}

	public Estadia login(int numeroQuarto, int senha) {
		List<Estadia> estadias = getEstadias();
		for(Estadia estadia : estadias) {
			if(estadia.getQuarto().getNumero() == numeroQuarto &&
					estadia.getSenha() == senha) {
				return estadia;
			}
		}
		
		return null;
	}
	
	public List<Estadia> getEstadias() {
        Query query = em.createNamedQuery("Estadia.findAll");
		return query.getResultList();
    }
	
	public Estadia getEstadiaById(int id) {
        Query query = em.createNamedQuery("Estadia.findById");
		query.setParameter("id", id);
        return (Estadia) query.getSingleResult();
	}
	
	public void createEstadia(
			String nome,
			String cpf,
			String endereco,
			String telefone,
			Quarto quarto,
			int senha,
			int diarias,
			String status
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
		
		quarto.setOcupado(status);
		quartoSessionBean.updateQuarto(quarto);
		
		persist(estadia);
	}
	
	public void updateEstadia(Estadia estadia) {
		em.merge(estadia);
		em.flush();
	}
	
	public void solicitarServico(int idEstadia, Servico servico) {
		Estadia estadia = getEstadiaById(idEstadia);
		estadia.setFatura(estadia.getFatura().add(servico.getValor()));
		updateEstadia(estadia);
		
		estadiaServicosSessionBean.createEstadiaServico(idEstadia, servico.getId());
	}
}
