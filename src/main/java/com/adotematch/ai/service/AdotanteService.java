package com.adotematch.ai.service;

import com.adotematch.ai.model.Adotante;
import com.adotematch.ai.repository.AdotanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdotanteService {

    @Autowired
    private AdotanteRepository adotanteRepository;

    public Adotante salvar(Adotante adotante) {
        return adotanteRepository.save(adotante);
    }

    public boolean validarLogin(String email, String senha) {
        Adotante adotante = adotanteRepository.findByEmail(email);
        return adotante != null && adotante.getSenha().equals(senha); // Simplificado, use hash em produção
    }
}
