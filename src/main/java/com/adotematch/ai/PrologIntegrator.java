package com.adotematch.ai;

import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Variable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrologIntegrator {
    public PrologIntegrator() {
        // Consultar arquivos Prolog com path corrigido
        String dogsPath = getClass().getResource("/prolog/dogs.pl").getFile();
        Query q1 = new Query("consult", new Term[]{new Atom(dogsPath)});
        if (!q1.hasSolution()) {
            throw new RuntimeException("Falha ao consultar dogs.pl: " + dogsPath);
        }

        String vaccinesPath = getClass().getResource("/prolog/vaccines.pl").getFile();
        Query q2 = new Query("consult", new Term[]{new Atom(vaccinesPath)});
        if (!q2.hasSolution()) {
            throw new RuntimeException("Falha ao consultar vaccines.pl: " + vaccinesPath);
        }
    }

    // Query raças por temperamento
    public List<Map<String, String>> queryDogBreedsByTemper(String temper) {
        List<Map<String, String>> results = new ArrayList<>();
        Variable Name = new Variable("Name");
        Variable Temper = new Variable("Temper");
        Variable Char = new Variable("Char");
        Query q = new Query("breed", new Term[]{Name, Temper, Char});
        while (q.hasMoreSolutions()) {
            Map<String, Term> sol = q.nextSolution();
            if (sol.get("Temper").toString().toLowerCase().contains(temper.toLowerCase())) {
                Map<String, String> res = new HashMap<>();
                res.put("name", sol.get("Name").toString());
                res.put("temper", sol.get("Temper").toString());
                res.put("char", sol.get("Char").toString());
                results.add(res);
            }
        }
        return results;
    }

    // Adicione query para vacinas se precisar, ex: queryVaccinesByCategory(String category)
}