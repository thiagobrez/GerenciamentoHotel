/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ejb.entidades.Estadia;
import ejb.entidades.Quarto;
import ejb.entidades.Servico;
import ejb.sessionBeans.EstadiaSessionBean;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author thiagobrezinski
 */
@Named(value = "estadiaJSFManagedBean")
@RequestScoped
public class EstadiaJSFManagedBean {

    @EJB
    private EstadiaSessionBean estadiaSessionBean;

    private int numeroQuarto;
    private int senha;
    private Quarto selectedQuarto;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String fatura;
    private Servico servico;

    /**
     * Creates a new instance of EstadiaJSFManagedBean
     */
    public EstadiaJSFManagedBean() {
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public String getFatura() {
        return fatura;
    }

    public void setFatura(String fatura) {
        this.fatura = fatura;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public Quarto getSelectedQuarto() {
        return selectedQuarto;
    }

    public void setSelectedQuarto(Quarto selectedQuarto) {
        this.selectedQuarto = selectedQuarto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Estadia> getEstadias() {
        return estadiaSessionBean.getEstadias();
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

    public String solicitarServico() {
		return "menuSolicitarServico?faces-redirect=true";
//        estadiaSessionBean.solicitarServico(this.numeroQuarto, this.servico);
    }

    public String login() throws IOException {
        Estadia estadia = estadiaSessionBean.login(this.numeroQuarto, this.senha);
		if(estadia != null) {
			   return "usuarioDashboard?faces-redirect=true";
//			FacesContext.getCurrentInstance().getExternalContext().redirect("usuarioDashboard.xhtml");
		} else {
			
		}
		return "index";
    }

    public void deslogar() {
        this.numeroQuarto = 0;
        this.senha = 0;
        this.selectedQuarto = null;
		this.nome = "";
        this.cpf = "";
        this.endereco = "";
        this.fatura = "";
        this.telefone = "";
    }

    public Estadia getEstadiaById(int id) {
        return estadiaSessionBean.getEstadiaById(id);
    }

}
