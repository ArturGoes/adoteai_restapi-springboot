package com.adotematch.ai.service;

import com.adotematch.ai.model.Adotante;
import com.adotematch.ai.repository.AdotanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdotanteService {

    @Autowired
    private AdotanteRepository adotanteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Adotante salvar(Adotante adotante) {
        // Hash the password before saving
        adotante.setSenha(passwordEncoder.encode(adotante.getSenha()));
        return adotanteRepository.save(adotante);
    }

    public boolean validarLogin(String email, String senha) {
        Adotante adotante = adotanteRepository.findByEmail(email);
        if (adotante == null || adotante.getSenha() == null) {
            return false;
        }
        // Use BCrypt to verify the password
        return passwordEncoder.matches(senha, adotante.getSenha());
    }
}

//as rotas aqui