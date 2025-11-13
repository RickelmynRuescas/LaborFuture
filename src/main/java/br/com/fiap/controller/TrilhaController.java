package br.com.fiap.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrilhaController {

    @GetMapping("/trilhas")
    public String trilhas(HttpSession session, Model model) {
        String nomeUsuario = (String) session.getAttribute("nomeUsuario");
        model.addAttribute("nomeUsuario", nomeUsuario);
        return "trilhas";
    }
}
