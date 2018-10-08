/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ejb.entidades.QuartoAdicionais;
import ejb.sessionBeans.QuartoAdicionaisSessionBean;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author thiagobrezinski
 */
@Named(value = "quartoAdicionaisJSFManagedBean")
@RequestScoped
public class QuartoAdicionaisJSFManagedBean {

	@EJB
	private QuartoAdicionaisSessionBean quartoAdicionaisSessionBean;

	/**
	 * Creates a new instance of QuartoAdicionaisJSFManagedBean
	 */
	public QuartoAdicionaisJSFManagedBean() {
	}
	
	public List<QuartoAdicionais> getQuartoAdicionais() {
		return quartoAdicionaisSessionBean.getQuartoAdicionais();
	}
	
	public QuartoAdicionais createQuartoAdicional(int idQuarto, String adicional) {
		return quartoAdicionaisSessionBean.createQuartoAdicional(idQuarto, adicional);
	}
}
