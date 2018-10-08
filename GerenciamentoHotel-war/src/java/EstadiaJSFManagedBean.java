/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ejb.entidades.Estadia;
import ejb.entidades.Quarto;
import ejb.entidades.Servico;
import ejb.sessionBeans.EstadiaSessionBean;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author thiagobrezinski
 */
@Named(value = "estadiaJSFManagedBean")
@RequestScoped
public class EstadiaJSFManagedBean {

	@EJB
	private EstadiaSessionBean estadiaSessionBean;

	/**
	 * Creates a new instance of EstadiaJSFManagedBean
	 */
	public EstadiaJSFManagedBean() {
	}
	
	public Estadia login(int numeroQuarto, int senha) {
		return estadiaSessionBean.login(numeroQuarto, senha);
	}

	public List<Estadia> getEstadias() {
		return estadiaSessionBean.getEstadias();
	}
	
	public Estadia getEstadiaById(int id) {
		return estadiaSessionBean.getEstadiaById(id);
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
		estadiaSessionBean.createEstadia(
				nome, 
				cpf, 
				endereco, 
				telefone, 
				quarto, 
				senha, 
				diarias, 
				status
		);
	}
	
	public void updateEstadia(Estadia estadia) {
		estadiaSessionBean.updateEstadia(estadia);
	}
	
	public void solicitarServico(int idEstadia, Servico servico) {
		estadiaSessionBean.solicitarServico(idEstadia, servico);
	}
}
