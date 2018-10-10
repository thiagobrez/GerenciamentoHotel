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

    private String username;
    private String senha;
    private Quarto selectedQuarto;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String fatura;

    public String getFatura() {
        return fatura;
    }

    public void setFatura(String fatura) {
        this.fatura = fatura;
    }
    private String senhaCheckin;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Estadia login() {
        return estadiaSessionBean.login(this.username, this.senha);
    }

    public void realizarCheckin() {
        return estadiaSessionBean.realizarCheckin(this.nome, this.cpf, this.endereco, this.telefone, this.selectedQuarto);
    }

    public void realizarCheckout() {
        return estadiaSessionBean.realizarCheckout(this.selectedQuarto);
    }
}
