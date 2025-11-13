package br.com.fiap.controller;

import br.com.fiap.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UsuarioService usuarioService;

    public AdminController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    private boolean isAdmin(HttpSession session) {
        String nome = (String) session.getAttribute("nomeUsuario");
        return nome != null && nome.equalsIgnoreCase("admin");
    }

    @GetMapping("/usuarios")
    public String listarUsuarios(HttpSession session, Model model) {
        if (!isAdmin(session)) {
            return "redirect:/home";
        }
        model.addAttribute("nomeUsuario", session.getAttribute("nomeUsuario"));
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "admin-usuarios";
    }

    @PostMapping("/usuarios/{id}/delete")
    public String deletarUsuario(@PathVariable Long id, HttpSession session) {
        if (!isAdmin(session)) {
            return "redirect:/home";
        }
        usuarioService.remover(id);
        return "redirect:/admin/usuarios";
    }
}
