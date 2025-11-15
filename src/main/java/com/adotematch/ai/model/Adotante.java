package com.adotematch.ai.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "adotante", schema = "adocao_animais")
@Data
@Builder
public class Adotante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adotante")
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String residencia;

    private String telefone;

    private String email;

    @Column(nullable = false)
    private String endereco;

    @Column(name = "experiencia_pets")
    private String experienciaPets;

    @Column(name = "espaco_em_casa")
    private int espacoEmCasa;

    @Column(name = "tempo_disponivel")
    private int tempoDisponivel;

    private String senha;
}
// test