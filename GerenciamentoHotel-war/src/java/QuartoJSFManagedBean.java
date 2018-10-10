/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ejb.entidades.Cama;
import ejb.entidades.Quarto;
import ejb.sessionBeans.QuartoSessionBean;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author thiagobrezinski
 */
@Named(value = "quartoJSFManagedBean")
@RequestScoped
public class QuartoJSFManagedBean {

    @EJB
    private QuartoSessionBean quartoSessionBean;
	
    private int numero;
    private BigDecimal valorDiaria = new BigDecimal(0);
	

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    /**
     * Creates a new instance of QuartoJSFManagedBean
     */
    public QuartoJSFManagedBean() {
    }

    public List<Quarto> getQuartos() {
        return quartoSessionBean.getQuartos();
    }

    public Quarto getQuartoByNumero(int numero) {
        return quartoSessionBean.getQuartoByNumero(numero);
    }

    public Quarto createQuarto(
            int numero,
            BigDecimal valorDiaria,
            String tipo,
            String ocupado,
            ArrayList<Cama> camas,
            ArrayList<String> adicionais
    ) {
        return quartoSessionBean.createQuarto(
                numero,
                valorDiaria,
                tipo,
                ocupado,
                camas,
                adicionais
        );
    }

    public void updateQuarto(Quarto quarto) {
        quartoSessionBean.updateQuarto(quarto);
    }
}
