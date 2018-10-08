/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ejb.entidades.QuartoCama;
import ejb.sessionBeans.QuartoCamaSessionBean;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author thiagobrezinski
 */
@Named(value = "quartoCamaJSFManagedBean")
@RequestScoped
public class QuartoCamaJSFManagedBean {

	@EJB
	private QuartoCamaSessionBean quartoCamaSessionBean;

	/**
	 * Creates a new instance of QuartoCamaJSFManagedBean
	 */
	public QuartoCamaJSFManagedBean() {
	}
	
	public List<QuartoCama> getQuartoCamas() {
		return quartoCamaSessionBean.getQuartoCamas();
	}
	
	public QuartoCama createQuartoCama(int idQuarto, int idCama) {
		return quartoCamaSessionBean.createQuartoCama(idQuarto, idCama);
	}
}
