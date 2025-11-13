# 🚀 LaborFuture: Plataforma de Orientação do Futuro do Trabalho

Este projeto é uma **Plataforma de Orientação Profissional** que utiliza análise de tendências para guiar usuários na transição para o mercado de trabalho até 2050, focando em **Profissões de Oportunidade** e **Habilidades Chave**.

## 👥 Participantes do Grupo

| Nome | RM |
| :--- | :--- |
| Rickelmyn de Souza Ruescas | 556055 |
| Vitor Couto Victorino | 554965 |
| Fabrini Soares | 557813 |

---

## 💡 Stack Tecnológico e Arquitetura

O projeto foi desenvolvido seguindo o padrão de **Arquitetura em Camadas (MVC)** do Spring Boot para garantir robustez e escalabilidade.

| Categoria | Tecnologia | Detalhes |
| :--- | :--- | :--- |
| **Linguagem** | Java 21 | Linguagem principal do backend. |
| **Framework** | Spring Boot 3 | Utilizado para inicialização rápida e arquitetura MVC/REST. |
| **Persistência** | Spring Data JPA / Hibernate | ORM para mapeamento de entidades. |
| **Banco de Dados** | Oracle Database | Banco de dados relacional para persistência de usuários. |
| **Web / UI** | Thymeleaf | Template Engine para renderização de páginas HTML. |
| **Controle de Sessão** | Autenticação Baseada em Sessão | Módulo completo de Cadastro/Login e validação de acesso. |

---

## 💻 Estrutura de Pacotes (IntelliJ)

A estrutura segue o padrão `Package by Layer` do Spring, garantindo a separação de responsabilidades. Os principais pacotes são:

* **`controller`**: Lida com requisições Web (Thymeleaf).
* **`controller.api`**: Lida com requisições RESTful (JSON).
* **`model.dto`**: Objetos de Transferência de Dados.
* **`model.entity`**: Entidades JPA (`@Entity`).
* **`model.repository`**: Interfaces de acesso a dados (`JpaRepository`).
* **`service`**: Camada de Lógica de Negócio.

---

## 🚢 Deploy em Produção (Docker e Render.com)

O deploy da aplicação foi configurado para ser realizado de forma automatizada e contínua na nuvem.

### 1. Containerização (Dockerfile)

O `Dockerfile` na raiz do projeto define o ambiente de execução, utilizando **Docker** para containerizar a aplicação, garantindo portabilidade. O processo de build utiliza o Maven Wrapper (`mvnw`) para gerar o JAR e o JRE para executar o contêiner.

### 2. Ambiente de Hospedagem (Render.com)

O deploy foi realizado no **Render.com**, que gerencia a imagem Docker e a execução. A segurança das credenciais do banco **Oracle** foi garantida através de **Variáveis de Ambiente** (`DB_URL`, `DB_USER`, `DB_PASSWORD`) no painel do Render, não sendo expostas no código.

O sucesso do deploy demonstra a maturidade técnica do projeto em operar em um ambiente real, com o **Render.com** gerenciando o processo de build e o runtime do contêiner.
