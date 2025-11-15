package com.adotematch.ai;

import com.adotematch.ai.model.Adotante;
import com.adotematch.ai.service.AdotanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @Autowired
    private AdotanteService adotanteService;

    // Rota para a página inicial (login/cadastro)
   @GetMapping({"/", "/index", "/index/"})
    public String index(Model model) {
        Adotante adotante = Adotante.builder()
                .nome("")
                .residencia("")
                .telefone("")
                .endereco("")
                .espacoEmCasa(0)
                .tempoDisponivel(0)
                .build();
        model.addAttribute("adotante", adotante);
        return "index";
    }

    // Processar cadastro de adotante
    @PostMapping("/cadastro")
    public String cadastrarAdotante(@ModelAttribute Adotante adotante) {
        adotanteService.salvar(adotante);
        return "redirect:/tela_principal/";
    }

    // Processar login (simplificado, sem Spring Security completo)
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String senha) {
        if (adotanteService.validarLogin(email, senha)) {
            return "redirect:/tela_principal/";
        }
        return "redirect:/index?error=true";
    }

    // Tela principal após login
    @GetMapping("/tela_principal/")
    public String telaPrincipal(Model model) {
        // Adicionar dados do usuário logado (mock por enquanto)
        model.addAttribute("userName", "Adotante");
        return "tela_principal";
    }

    // Tela da funcionalidade de Match AI
    @GetMapping("/adoteMatchAi/")
    public String adoteMatchAi(Model model) {
        model.addAttribute("formularioAdocao", new com.adotematch.ai.FormularioAdocao(null, 0, 0, "", false, false, false));
        return "adoteMatchAi";
    }

    // Processar formulário de match AI
    @PostMapping("/adoteMatchAi/")
    public String processarMatch(@ModelAttribute com.adotematch.ai.FormularioAdocao formulario, Model model) {
        // Simulação de lógica da IA (mock)
        model.addAttribute("resultadoMatch", "Animal recomendado: Cachorro, raça: Golden Retriever, temperamento: Amigável");
        return "adoteMatchAi";
    }
}

//as rotas aqui