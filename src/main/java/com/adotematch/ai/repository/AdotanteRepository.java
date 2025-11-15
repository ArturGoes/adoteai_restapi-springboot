package com.adotematch.ai.repository;

import com.adotematch.ai.model.Adotante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdotanteRepository extends JpaRepository<Adotante, Long> {
    Adotante findByEmail(String email);
<<<<<<< Updated upstream
}
=======
}

//as rotas aqui
//as rotas aqui
>>>>>>> Stashed changes
