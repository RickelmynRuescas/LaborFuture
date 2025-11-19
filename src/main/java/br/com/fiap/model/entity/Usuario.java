package br.com.fiap.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "TB_FL_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Informe seu nome")
    @Column(name = "nome", nullable = false, length = 80, unique = true)
    private String nome;

    @NotBlank(message = "Informe uma senha")
    @Column(name = "senha", nullable = false, length = 120)
    private String senha;

    @NotBlank(message = "Informe o nome do primeiro animal de estimação")
    @Column(name = "primeiro_animal", nullable = false, length = 80)
    private String primeiroAnimal;

    @NotBlank(message = "Informe a cidade onde nasceu")
    @Column(name = "cidade_nascimento", nullable = false, length = 80)
    private String cidadeNascimento;

    @NotBlank(message = "Informe o apelido que tinha quando criança")
    @Column(name = "apelido_infancia", nullable = false, length = 80)
    private String apelidoInfancia;

    public Usuario() {}

    public Usuario(Long id, String nome, String senha, String primeiroAnimal,
                   String cidadeNascimento, String apelidoInfancia) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.primeiroAnimal = primeiroAnimal;
        this.cidadeNascimento = cidadeNascimento;
        this.apelidoInfancia = apelidoInfancia;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getPrimeiroAnimal() { return primeiroAnimal; }
    public void setPrimeiroAnimal(String primeiroAnimal) { this.primeiroAnimal = primeiroAnimal; }

    public String getCidadeNascimento() { return cidadeNascimento; }
    public void setCidadeNascimento(String cidadeNascimento) { this.cidadeNascimento = cidadeNascimento; }

    public String getApelidoInfancia() { return apelidoInfancia; }
    public void setApelidoInfancia(String apelidoInfancia) { this.apelidoInfancia = apelidoInfancia; }
}
