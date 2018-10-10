/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ejb.entidades.Servico;
import ejb.sessionBeans.ServicoSessionBean;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author thiagobrezinski
 */
@Named(value = "servicoJSFManagedBean")
@RequestScoped
public class ServicoJSFManagedBean {

    @EJB
    private ServicoSessionBean servicoSessionBean;

    private String nome;
    private String descricao;
    private BigDecimal valor = new BigDecimal(0);

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    /**
     * Creates a new instance of ServicoJSFManagedBean
     */
    public ServicoJSFManagedBean() {
    }

    public List<Servico> getServicos() {
        return servicoSessionBean.getServicos();
    }

    public Servico findServicoByNome(String nome) {
        return servicoSessionBean.findServicoByNome(nome);
    }

    public Servico findServicoById(int id) {
        return servicoSessionBean.findServicoById(id);
    }

    public Servico createServico() {
        return servicoSessionBean.createServico(this.nome, this.descricao, this.valor);
    }
}
