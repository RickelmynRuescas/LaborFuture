package br.com.fiap.controller;

import br.com.fiap.model.entity.ProfissaoOportunidade;
import br.com.fiap.service.ProfissaoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProfissaoController {

    private final ProfissaoService profissaoService;

    public ProfissaoController(ProfissaoService profissaoService) {
        this.profissaoService = profissaoService;
    }

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {

        String nome = (String) session.getAttribute("nomeUsuario");
        model.addAttribute("nomeUsuario", nome);

        var oportunidades = profissaoService.listarOportunidades();

        List<String> futureGrowthJobs = oportunidades.stream()
                .map(ProfissaoOportunidade::getNome)
                .toList();

        List<String> atRiskJobs = List.of(
                "Digitadores / Data Entry",
                "Telemarketing e suporte básico",
                "Caixas em funções padronizadas",
                "Rotinas administrativas repetitivas",
                "Operadores de linhas de produção padronizadas",
                "Triagem simples de currículos e documentos",
                "Atendimento de FAQ substituído por chatbots"
        );

        List<String> resilientManualJobs = List.of(
                "Pedreiros, carpinteiros, armadores, mestres de obras",
                "Eletricistas, encanadores e técnicos de manutenção",
                "Montadores de estruturas e instaladores de painéis solares",
                "Profissionais de infraestrutura",
                "Técnicos de manutenção industrial e de campo",
                "Logística física complexa",
                "Serviços com forte contato humano em campo"
        );

        model.addAttribute("futureGrowthJobs", futureGrowthJobs);
        model.addAttribute("atRiskJobs", atRiskJobs);
        model.addAttribute("resilientManualJobs", resilientManualJobs);

        return "index";
    }

    @GetMapping("/profissoes")
    public String profissoes(HttpSession session, Model model) {
        String nome = (String) session.getAttribute("nomeUsuario");
        model.addAttribute("nomeUsuario", nome);

        model.addAttribute("oportunidades", profissaoService.listarOportunidades());
        return "profissoes";
    }

    @GetMapping("/profissoes/{slug}")
    public String detalheProfissao(@PathVariable String slug,
                                   HttpSession session,
                                   Model model) {

        String nome = (String) session.getAttribute("nomeUsuario");
        model.addAttribute("nomeUsuario", nome);

        ProfissaoOportunidade profissao = profissaoService.buscarPorSlug(slug);
        if (profissao == null) {
            return "redirect:/profissoes";
        }

        model.addAttribute("profissao", profissao);
        return "profissao-detalhe";
    }
}
