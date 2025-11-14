package com.adotematch.ai;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    /**
     * Rota para a página inicial de login/cadastro.
     * Mapeia para /index/ (ou apenas /) e retorna o template index.html.
     */
    @GetMapping({"/", "/index", "/index/"})
    public String index() {
        return "index"; // Assume que index.html está em src/main/resources/templates/
    }

    /**
     * Rota para a tela principal após o login.
     * Mapeia para /tela_principal/ e retorna o template tela_principal.html.
     */
    @GetMapping("/tela_principal/")
    public String telaPrincipal() {
        return "tela_principal"; // Assume que tela_principal.html está em src/main/resources/templates/
    }

    /**
     * Rota para a tela da funcionalidade de Match da AI.
     * Mapeia para /adoteMatchAi/ e retorna o template adoteMatchAi.html.
     */
    @GetMapping("/adoteMatchAi/")
    public String adoteMatchAi() {
        return "adoteMatchAi"; // Assume que adoteMatchAi.html está em src/main/resources/templates/
    }
}