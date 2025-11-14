package com.adotematch.ai;

public class Veterinario extends Usuario {

    public Veterinario(String email, String senha, String nome) {
        super(email, senha, nome, Role.VETERINARIO);
    }

    @Override
    public void atualizarPerfil(String novoNome) {
        this.nome = novoNome;
    }

    // RF10: Atualizar vacinas
    public void atualizarVacina(Animal animal, Vacina vacina, boolean tomada) {
        if (tomada) {
            animal.adicionarVacinaTomada(vacina);
        } else {
            animal.adicionarVacinaPendente(vacina);
        }
    }
}