package br.com.fiap.controller;

import br.com.fiap.model.dto.LoginDTO;
import br.com.fiap.model.dto.UsuarioDTO;
import br.com.fiap.model.entity.Usuario;
import br.com.fiap.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // Tela de login
    @GetMapping("/cadastro")
    public String paginaLogin(@RequestParam(value = "sucesso", required = false) String sucesso,
                              Model model) {

        if (!model.containsAttribute("login")) {
            model.addAttribute("login", new LoginDTO(null, null));
        }

        if (sucesso != null) {
            model.addAttribute("sucessoCadastro",
                    "Conta criada com sucesso! Agora entre com seu usuário e senha.");
        }

        return "cadastro";
    }

    // Tela de criação de conta
    @GetMapping("/criar-conta")
    public String paginaCriarConta(Model model) {
        if (!model.containsAttribute("novoUsuario")) {
            model.addAttribute("novoUsuario", new UsuarioDTO(null, null, null));
        }
        return "criar-conta";
    }

    // POST cadastro
    @PostMapping("/registrar")
    public String registrar(@Valid @ModelAttribute("novoUsuario") UsuarioDTO dto,
                            BindingResult result,
                            RedirectAttributes redirectAttributes,
                            Model model) {

        if (result.hasErrors()) {
            return "criar-conta";
        }

        if (service.buscarPorNome(dto.nome()).isPresent()) {
            model.addAttribute("erroCadastro", "Já existe um usuário com esse nome. Escolha outro.");
            return "criar-conta";
        }

        Usuario salvo = service.criar(dto);

        redirectAttributes.addAttribute("sucesso", "1");
        return "redirect:/cadastro";
    }

    // POST login
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("login") LoginDTO loginDTO,
                        BindingResult result,
                        Model model,
                        HttpSession session) {

        if (result.hasErrors()) {
            return "cadastro";
        }

        return service.autenticar(loginDTO.nome(), loginDTO.senha())
                .map(usuario -> {
                    session.setAttribute("nomeUsuario", usuario.getNome());
                    return "redirect:/home";
                })
                .orElseGet(() -> {
                    model.addAttribute("erroLogin",
                            "Usuário ou senha incorretos, ou usuário não cadastrado.");
                    return "cadastro";
                });
    }
}
