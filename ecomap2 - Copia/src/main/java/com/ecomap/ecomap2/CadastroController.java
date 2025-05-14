package com.ecomap.ecomap2;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CadastroController {

    private List<Cadastro> cadastros = new ArrayList<>();

    public CadastroController() {
        // Dois usuários cadastrados por padrão
        cadastros.add(new Cadastro("Ana", "ana@email.com", 123456789, "senha123"));
        cadastros.add(new Cadastro("João", "joao@email.com", 987654321, "1234senha"));
    }

    // Página de cadastro
    @GetMapping("/cadastro")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("cadastro", new Cadastro());
        return "cadastro";
    }

    // Processa o formulário de cadastro
    @PostMapping("/cadastro")
    public String cadastrarUsuario(@ModelAttribute Cadastro cadastro) {
        cadastros.add(cadastro);
        return "redirect:/";
    }

    // Página de login
    @GetMapping("/login")
    public String mostrarLogin(Model model) {
        model.addAttribute("cadastro", new Cadastro());
        return "login";
    }

    // Processa login
    @PostMapping("/login")
    public String processarLogin(@ModelAttribute Cadastro cadastro, HttpSession session, Model model) {
        for (Cadastro c : cadastros) {
            if (c.getEmail().equals(cadastro.getEmail()) && c.getSenha().equals(cadastro.getSenha())) {
                session.setAttribute("usuarioLogado", c.getNome());
                return "redirect:/index";
            }
        }
        model.addAttribute("erro", "Usuário ou senha inválidos.");
        return "login";
    }

    // Página index com verificação de login
    @GetMapping({"/", "/index"})
    public String index(HttpSession session, Model model) {
        String nomeUsuario = (String) session.getAttribute("usuarioLogado");
        model.addAttribute("usuarioLogado", nomeUsuario);
        return "index";
    }

    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    // (Opcional) Expor lista para testes
    @GetMapping("/usuarios")
    @ResponseBody
    public List<Cadastro> listarUsuarios() {
        return cadastros;
    }
}
