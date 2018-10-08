/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ejb.entidades.EstadiaServicos;
import ejb.sessionBeans.EstadiaServicosSessionBean;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author thiagobrezinski
 */
@Named(value = "estadiaServicosJSFManagedBean")
@RequestScoped
public class EstadiaServicosJSFManagedBean {

	@EJB
	private EstadiaServicosSessionBean estadiaServicosSessionBean;

	/**
	 * Creates a new instance of EstadiaServicosJSFManagedBean
	 */
	public EstadiaServicosJSFManagedBean() {
	}
	
	public List<EstadiaServicos> getEstadiaServicos() {
		return estadiaServicosSessionBean.getEstadiaServicos();
	}
	
	public void createEstadiaServico(int idEstadia, int idServico) {
		estadiaServicosSessionBean.createEstadiaServico(idEstadia, idServico);
	}
	
}
