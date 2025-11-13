package br.com.fiap.controller;

import br.com.fiap.model.dto.HabilidadeDTO;
import br.com.fiap.service.ProfissaoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HabilidadeController {

    private final ProfissaoService profissaoService;

    public HabilidadeController(ProfissaoService profissaoService) {
        this.profissaoService = profissaoService;
    }

    @GetMapping("/habilidades")
    public String mapaHabilidades(HttpSession session, Model model) {

        String nomeUsuario = (String) session.getAttribute("nomeUsuario");
        model.addAttribute("nomeUsuario", nomeUsuario);

        List<HabilidadeDTO> habilidades = List.of(
                new HabilidadeDTO(
                        "Pensamento Crítico & Dados",
                        "Analisar informações, questionar resultados de IA e tomar decisões embasadas.",
                        "IA/ML, Engenharia de Dados, Sustentabilidade, Gestão."
                ),
                new HabilidadeDTO(
                        "Programação & Lógica",
                        "Criar soluções digitais e automatizar processos.",
                        "Dev, IA/ML, Eng. de Dados, Automação."
                ),
                new HabilidadeDTO(
                        "Cibersegurança & Privacidade",
                        "Proteger sistemas e dados em ambientes conectados.",
                        "Cibersegurança, DevSecOps, Governança Digital."
                ),
                new HabilidadeDTO(
                        "Mecatrônica & Manutenção Avançada",
                        "Integração entre mecânica, elétrica e controle.",
                        "Automação, robótica, manutenção industrial."
                ),
                new HabilidadeDTO(
                        "Empatia & Comunicação",
                        "Conectar pessoas e explicar tecnologia.",
                        "Saúde, Educação, UX, gestão de times."
                ),
                new HabilidadeDTO(
                        "Sustentabilidade & ESG",
                        "Decidir considerando impacto ambiental e social.",
                        "Energias Renováveis, ESG, cidades inteligentes."
                )
        );

        model.addAttribute("habilidades", habilidades);
        model.addAttribute("profissoes", profissaoService.listarOportunidades());

        return "habilidades";
    }
}
