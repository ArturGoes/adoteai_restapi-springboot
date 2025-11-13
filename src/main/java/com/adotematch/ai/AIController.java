package com.adotematch.ai;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class AIController {

    private final RBC rbc = new RBC();
    private final AStar aStar = new AStar();
    private final PrologIntegrator prolog = new PrologIntegrator();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Bem-vindo ao AdoteMatch AI");
        return "index";
    }

    @PostMapping("/rbc")
    public String rbc(@RequestParam double space, @RequestParam double time, @RequestParam int prefTemper, Model model) {
        Case newCase = new Case(space, time, prefTemper, 0, 0, 0, 0);
        Case similar = rbc.retrieveSimilarCase(newCase);
        model.addAttribute("result", "Recomendação RBC: Match = " + similar.getMatch() + " (Pet: tamanho=" + similar.getPetSize() + ", temper=" + similar.getPetTemper() + ", idade=" + similar.getPetAge() + ")");
        return "index";
    }

    @PostMapping("/astar")
    public String astar(@RequestParam double startX, @RequestParam double startY, @RequestParam int goalId, Model model) {
        List<Node> path = aStar.findPath(startX, startY, goalId);
        StringBuilder sb = new StringBuilder("Caminho A*: ");
        for (Node node : path) {
            sb.append("Abrigo ").append(node.getId()).append(" -> ");
        }
        model.addAttribute("result", sb.toString());
        return "index";
    }

    @PostMapping("/prolog")
    public String prolog(@RequestParam String temper, Model model) {
        try {
            List<Map<String, String>> results = prolog.queryDogBreedsByTemper(temper);
            model.addAttribute("result", "Raças Prolog: " + results);
        } catch (Exception e) {
            model.addAttribute("result", "Erro no Prolog: " + e.getMessage());  // Para depurar
        }
        return "index";
    }
}