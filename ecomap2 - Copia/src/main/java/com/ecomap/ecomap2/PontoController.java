package com.ecomap.ecomap2;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PontoController {

    @GetMapping("/ponto")
    public String pontoview(Model conteiner){
        return"ponto.html";
    }

    
    
}
