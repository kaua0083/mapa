package com.ecomap.ecomap2;

import java.util.*;
import java.util.stream.Collectors;


import org.springframework.web.bind.annotation.*;

@RestController
public class LocaisController {

    // Lista em memória (simula banco de dados)
    private List<Ponto> pontos = new ArrayList<>();

    public LocaisController() {
        // Ponto inicial
        Ponto ponto1 = new Ponto(
            "Macefer Reciclagem",
            Arrays.asList("Macefer Reciclagem", "Chapada Grande"),
            Arrays.asList(-23.593883, -47.987828),
            "<b>• Macefer Reciclagem - Chapada Grande</b><br><img src='img/macefer.jpg' class='popup-img'><br><a href='/detalhes'> Mais detalhes </a>"
        );
        pontos.add(ponto1);
    }

    @GetMapping("/pontos")
    public List<Ponto> getPontos() {
        return pontos;
    }

    

    @PostMapping("/addPonto")
    public String addPonto( @RequestParam String nome,@RequestParam String aliases,@RequestParam String coordenadas, @RequestParam String popup) {
        // Converte aliases: "alias1, alias2" -> List<String>
        List<String> aliasList = Arrays.stream(aliases.split(","))
                                       .map(String::trim)
                                       .collect(Collectors.toList());

        // Converte coordenadas: "lat, lon" -> List<Double>
        List<Double> coordenadasList = Arrays.stream(coordenadas.split(","))
                                             .map(String::trim)
                                             .map(Double::parseDouble)
                                             .collect(Collectors.toList());

        // Cria novo ponto
        Ponto novoPonto = new Ponto(nome, aliasList, coordenadasList, popup);

        // Adiciona à lista
        pontos.add(novoPonto);

        return "redirect:/";
    }
}
