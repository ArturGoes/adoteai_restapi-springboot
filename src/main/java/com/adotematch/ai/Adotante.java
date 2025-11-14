package com.adotematch.ai;

public class Adotante extends Usuario {
    private String endereco;
    private int espacoEmCasa;
    private int tempoDisponivel;
    private String preferenciasPersonalidade;
    private boolean temCriancas;
    private boolean temOutrosPets;

    public Adotante(String email, String senha, String nome, String endereco, int espacoEmCasa, int tempoDisponivel) {
        super(email, senha, nome, Role.ADOTANTE);
        this.endereco = endereco;
        this.espacoEmCasa = espacoEmCasa;
        this.tempoDisponivel = tempoDisponivel;
    }

    // Getters e Setters completos
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public int getEspacoEmCasa() { return espacoEmCasa; }
    public void setEspacoEmCasa(int espacoEmCasa) { this.espacoEmCasa = espacoEmCasa; }
    public int getTempoDisponivel() { return tempoDisponivel; }
    public void setTempoDisponivel(int tempoDisponivel) { this.tempoDisponivel = tempoDisponivel; }
    public String getPreferenciasPersonalidade() { return preferenciasPersonalidade; }
    public void setPreferenciasPersonalidade(String preferenciasPersonalidade) { this.preferenciasPersonalidade = preferenciasPersonalidade; }
    public boolean isTemCriancas() { return temCriancas; }
    public void setTemCriancas(boolean temCriancas) { this.temCriancas = temCriancas; }
    public boolean isTemOutrosPets() { return temOutrosPets; }
    public void setTemOutrosPets(boolean temOutrosPets) { this.temOutrosPets = temOutrosPets; }

    @Override
    public void atualizarPerfil(String novoNome) {
        this.nome = novoNome;
    }

    // Preencher formulário (RF4) - adicionei param para alergias
    public FormularioAdocao preencherFormulario(String preferencias, boolean temCriancas, boolean temOutrosPets, boolean alergias) {
        this.preferenciasPersonalidade = preferencias;
        this.temCriancas = temCriancas;
        this.temOutrosPets = temOutrosPets;
        return new FormularioAdocao(this, espacoEmCasa, tempoDisponivel, preferencias, temCriancas, temOutrosPets, alergias);
    }
}