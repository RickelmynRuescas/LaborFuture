package br.com.fiap.service;

import br.com.fiap.model.entity.ProfissaoOportunidade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissaoService {

    private final List<ProfissaoOportunidade> oportunidades = List.of(
            new ProfissaoOportunidade(
                    "especialistas-ia-ml",
                    "Especialistas em IA e Machine Learning",
                    "Desenvolvem modelos de IA aplicados em recomendação, visão computacional, chatbots e automação inteligente.",
                    "Estudar lógica, Python/Java, estatística, depois Machine Learning, redes neurais e projetos práticos.",
                    "Programação, matemática, estatística, pensamento crítico e ética em IA.",
                    "Até 2050, esses profissionais serão essenciais para criar soluções responsáveis e integrar IA em saúde, indústria e cidades inteligentes."
            ),
            new ProfissaoOportunidade(
                    "engenheiros-dados-bigdata",
                    "Engenheiros de Dados e Big Data",
                    "Criam e mantêm pipelines e estruturas para grandes volumes de dados.",
                    "Dominar SQL, modelagem de dados, ETL, ferramentas como Spark/Kafka e cloud.",
                    "SQL avançado, arquitetura distribuída, programação, governança de dados.",
                    "Com o crescimento de dados em tempo real, serão chave na qualidade e segurança dos dados usados por IA e negócios."
            ),
            new ProfissaoOportunidade(
                    "ciberseguranca",
                    "Profissionais de Cibersegurança",
                    "Protegem sistemas contra ataques, vazamentos e fraudes.",
                    "Aprender redes, sistemas, fundamentos de segurança e buscar certificações.",
                    "Redes, análise de risco, criptografia, resposta a incidentes.",
                    "A expansão de dispositivos conectados e IA maliciosa aumenta muito a demanda."
            ),
            new ProfissaoOportunidade(
                    "energias-renovaveis",
                    "Engenheiros de Energias Renováveis",
                    "Projetam, instalam e otimizam sistemas solares, eólicos e outras fontes limpas.",
                    "Formações técnicas/engenharia, normas, eficiência energética.",
                    "Elétrica, sustentabilidade, análise de viabilidade.",
                    "Lideram a transição energética e geram empregos braçais qualificados em campo."
            ),
            new ProfissaoOportunidade(
                    "sustentabilidade-esg",
                    "Profissionais de Sustentabilidade e ESG",
                    "Conectam impacto ambiental, social e governança às estratégias de negócio.",
                    "Estudar ESG, legislação, indicadores e relatórios.",
                    "Visão sistêmica, análise de dados, comunicação.",
                    "Empresas serão cobradas cada vez mais por impacto real."
            ),
            new ProfissaoOportunidade(
                    "dev-software-plataforma",
                    "Desenvolvedores de Software e Engenheiros de Plataforma",
                    "Criam aplicações, APIs e infraestrutura digital.",
                    "Aprender linguagem, Git, banco, REST e boas práticas.",
                    "Código limpo, testes, versionamento, DevOps.",
                    "Mesmo com IA ajudando no código, seguimos precisando de pessoas que entendem arquitetura e segurança."
            ),
            new ProfissaoOportunidade(
                    "automacao-robotica",
                    "Especialistas em Automação e Robótica",
                    "Desenvolvem soluções automatizadas para indústria, logística e serviços.",
                    "Cursos em mecatrônica/automação, prática com CLP e sensores.",
                    "Mecatrônica, controle, integração de sistemas.",
                    "Robôs exigem gente treinada pra projetar, instalar e manter."
            ),
            new ProfissaoOportunidade(
                    "saude-telemedicina",
                    "Profissionais de Saúde e Telemedicina",
                    "Unem cuidado humano com ferramentas digitais.",
                    "Formação em saúde e domínio de sistemas de telemedicina.",
                    "Empatia, ética, tecnologia em saúde.",
                    "Envelhecimento populacional e medicina preventiva digital aumentam a demanda."
            ),
            new ProfissaoOportunidade(
                    "ux-ui",
                    "Designers de Experiência (UX/UI)",
                    "Criam experiências digitais acessíveis e intuitivas.",
                    "Estudar UX, prototipação, acessibilidade, montar portfólio.",
                    "Empatia, pesquisa com usuários, design visual.",
                    "IA gera telas, mas quem entende pessoas desenha as soluções certas."
            ),
            new ProfissaoOportunidade(
                    "educacao-requalificacao",
                    "Educadores focados em tecnologia e requalificação",
                    "Preparam pessoas para novas carreiras.",
                    "Dominar área técnica e desenvolver didática.",
                    "Comunicação, didática, domínio técnico.",
                    "Requalificação contínua será parte central das políticas de trabalho."
            )
    );

    public List<ProfissaoOportunidade> listarOportunidades() {
        return oportunidades;
    }

    public ProfissaoOportunidade buscarPorSlug(String slug) {
        if (slug == null) return null;
        return oportunidades.stream()
                .filter(p -> p.getSlug().equalsIgnoreCase(slug))
                .findFirst()
                .orElse(null);
    }
}
