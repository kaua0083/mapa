package com.ecomap.ecomap2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
    @GetMapping("/sobre")
    public String home() {
        
        return "sobre.html";
    }

    @GetMapping("/detalhes")
    public String detalhes() {
        
        return "detalhes.html";
    }

    @GetMapping("/info")
    public String info() {
        
        return "info.html";
    }
      
    @GetMapping("/precos")
    public String precos() {
        
        return "precos.html";
    }
      
}
