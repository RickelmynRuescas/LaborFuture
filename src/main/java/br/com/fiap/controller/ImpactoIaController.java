package br.com.fiap.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class ImpactoIaController {

    @GetMapping("/impacto-ia")
    public String impactoIa(HttpSession session, Model model) {

        String nomeUsuario = (String) session.getAttribute("nomeUsuario");
        model.addAttribute("nomeUsuario", nomeUsuario);

        List<Map<String, String>> transicoes = List.of(
                Map.of("atual", "Digitador / Data entry repetitivo",
                        "futuro", "Analista de Dados Júnior / Operador de ETL básico"),
                Map.of("atual", "Telemarketing roteirizado",
                        "futuro", "Atendimento especializado / Suporte técnico"),
                Map.of("atual", "Caixa em funções padronizadas",
                        "futuro", "Atendimento consultivo e operação de autosserviço"),
                Map.of("atual", "Rotinas administrativas repetitivas",
                        "futuro", "Assistente de automação de processos / analista operacional"),
                Map.of("atual", "FAQ simples",
                        "futuro", "Gestor de experiência e supervisão de chatbots")
        );

        List<String> resilientes = List.of(
                "Construção civil qualificada",
                "Manutenção industrial e predial",
                "Instalação de painéis solares",
                "Logística em campo complexa",
                "Profissionais de saúde presenciais",
                "Educadores e mentores de requalificação"
        );

        model.addAttribute("transicoes", transicoes);
        model.addAttribute("resilientes", resilientes);

        return "impacto-ia";
    }
}
