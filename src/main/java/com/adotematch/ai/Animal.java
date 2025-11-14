package com.adotematch.ai;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Animal {
    private final String id;
    private String raca;
    private int idade;
    private String sexo;
    private String tamanho;
    private Temperamento temperamento;
    private String cor;
    private List<Vacina> vacinasTomadas;
    private List<Vacina> vacinasPendentes;
    private List<String> fotos;
    private Date dataEntrada;
    private Date dataSaida;
    private Status status;

    public enum Temperamento {
        CALMO, ATIVO, TIMIDO, SOCIÁVEL
    }

    public enum Status {
        DISPONIVEL, ADOTADO, TRANSFERIDO
    }

    public Animal(String raca, int idade, String sexo, String tamanho, Temperamento temperamento, String cor) {
        this.id = UUID.randomUUID().toString();
        this.raca = raca;
        this.idade = idade;
        this.sexo = sexo;
        this.tamanho = tamanho;
        this.temperamento = temperamento;
        this.cor = cor;
        this.vacinasTomadas = new ArrayList<>();
        this.vacinasPendentes = new ArrayList<>();
        this.fotos = new ArrayList<>();
        this.dataEntrada = new Date();
        this.status = Status.DISPONIVEL;
    }

    // Getters e Setters completos
    public String getId() { return id; }
    public String getRaca() { return raca; }
    public void setRaca(String raca) { this.raca = raca; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }
    public String getTamanho() { return tamanho; }
    public void setTamanho(String tamanho) { this.tamanho = tamanho; }
    public Temperamento getTemperamento() { return temperamento; }
    public void setTemperamento(Temperamento temperamento) { this.temperamento = temperamento; }
    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }
    public List<Vacina> getVacinasTomadas() { return vacinasTomadas; }
    public void setVacinasTomadas(List<Vacina> vacinasTomadas) { this.vacinasTomadas = vacinasTomadas; }
    public List<Vacina> getVacinasPendentes() { return vacinasPendentes; }
    public void setVacinasPendentes(List<Vacina> vacinasPendentes) { this.vacinasPendentes = vacinasPendentes; }
    public List<String> getFotos() { return fotos; }
    public void setFotos(List<String> fotos) { this.fotos = fotos; }
    public Date getDataEntrada() { return dataEntrada; }
    public void setDataEntrada(Date dataEntrada) { this.dataEntrada = dataEntrada; }
    public Date getDataSaida() { return dataSaida; }
    public void setDataSaida(Date dataSaida) { this.dataSaida = dataSaida; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public void adicionarVacinaTomada(Vacina vacina) {
        vacinasTomadas.add(vacina);
    }

    public void adicionarVacinaPendente(Vacina vacina) {
        vacinasPendentes.add(vacina);
    }

    public void adicionarFoto(String fotoUrl) {
        fotos.add(fotoUrl);
    }

    public void registrarSaida(Date dataSaida, Status novoStatus) {
        this.dataSaida = dataSaida;
        this.status = novoStatus;
    }

    public boolean isDuplicado(Animal outro) {
        return this.raca.equals(outro.raca) && this.idade == outro.idade && this.cor.equals(outro.cor);
    }
}