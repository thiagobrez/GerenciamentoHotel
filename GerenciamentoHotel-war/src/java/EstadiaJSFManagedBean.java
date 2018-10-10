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
@Named(value = "estadiaJSFManagedBean")
@RequestScoped
public class EstadiaJSFManagedBean {
    @EJB
    private EstadiaSessionBean estadiaSessionBean;

    private int numeroQuarto;
    private int senha;
    private Estadia estadia;
    private Quarto selectedQuarto;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private BigDecimal fatura = new BigDecimal(0);
    private Servico servico;

    private String novoNome;
    private String novoCpf;
    private String novoEndereco;
    private String novoTelefone;
    private int novaDiarias;
    private int novaSenha;
    private String novoStatus;
    private int novoQuarto;
	
	private ArrayList<String> listaStatus;

	public ArrayList<String> getListaStatus() {
		return listaStatus;
	}
	
    public int getNovoQuarto() {
        return novoQuarto;
    }

    public void setNovoQuarto(int novoQuarto) {
        this.novoQuarto = novoQuarto;
    }

    public String getNovoNome() {
        return novoNome;
    }

    public void setNovoNome(String novoNome) {
        this.novoNome = novoNome;
    }

    public String getNovoCpf() {
        return novoCpf;
    }

    public void setNovoCpf(String novoCpf) {
        this.novoCpf = novoCpf;
    }

    public String getNovoEndereco() {
        return novoEndereco;
    }

    public void setNovoEndereco(String novoEndereco) {
        this.novoEndereco = novoEndereco;
    }

    public String getNovoTelefone() {
        return novoTelefone;
    }

    public void setNovoTelefone(String novoTelefone) {
        this.novoTelefone = novoTelefone;
    }

    public int getNovaDiarias() {
        return novaDiarias;
    }

    public void setNovaDiarias(int novaDiarias) {
        this.novaDiarias = novaDiarias;
    }

    public int getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(int novaSenha) {
        this.novaSenha = novaSenha;
    }

    public String getNovoStatus() {
        return novoStatus;
    }

    public void setNovoStatus(String novoStatus) {
        this.novoStatus = novoStatus;
    }

    /**
     * Creates a new instance of EstadiaJSFManagedBean
     */
    public EstadiaJSFManagedBean() {
		this.listaStatus = new ArrayList<>();
		this.listaStatus.add("reservado");
		this.listaStatus.add("ocupado");
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public BigDecimal getFatura() {
        return fatura;
    }

    public void setFatura(BigDecimal fatura) {
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

    public void createEstadia() {
        estadiaSessionBean.createEstadia(
                this.novoNome,
                this.novoCpf,
                this.novoEndereco,
                this.novoTelefone,
                this.novoQuarto,
                this.novaSenha,
                this.novaDiarias,
                this.novoStatus
        );
        this.novoNome = "";
        this.novoCpf = "";
        this.novoEndereco = "";
        this.novaSenha = 0;
        this.novoStatus = "";
        this.novoTelefone = "";
        this.novoQuarto = 0;
        this.novaDiarias = 0;
    }

    public void updateEstadia(Estadia estadia) {
        estadiaSessionBean.updateEstadia(estadia);
    }

    public void solicitarServico() {
        estadiaSessionBean.solicitarServico(this.estadia.getId(), this.servico);
    }

    public String login() throws IOException {
        this.estadia = estadiaSessionBean.login(this.numeroQuarto, this.senha);
        if (estadia != null) {
            this.nome = this.estadia.getUsuario().getNome();
            this.cpf = this.estadia.getUsuario().getCpf();
            this.endereco = this.estadia.getUsuario().getEndereco();
            this.fatura = this.estadia.getFatura();

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
        this.fatura = new BigDecimal(0);
        this.telefone = "";
    }

    public Estadia getEstadiaById(int id) {
        return estadiaSessionBean.getEstadiaById(id);
    }

}
