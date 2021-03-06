/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ejb.entidades.Cama;
import ejb.sessionBeans.CamaSessionBean;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author thiagobrezinski
 */
@Named(value = "camaJSFManagedBean")
@RequestScoped
public class CamaJSFManagedBean {

	@EJB
	private CamaSessionBean camaSessionBean;

	/**
	 * Creates a new instance of CamaJSFManagedBean
	 */
	public CamaJSFManagedBean() {
	}
	
	public List<Cama> getCamas() {
		return camaSessionBean.getCamas();
	}

	public Cama getCamaById(int id) {
		return camaSessionBean.getCamaById(id);
	}
	
}
