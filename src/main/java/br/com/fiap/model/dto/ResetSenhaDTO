package br.com.fiap.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ResetSenhaDTO(
        @NotBlank(message = "Informe seu nome")
        String nome,

        @NotBlank(message = "Informe o nome do primeiro animal de estimação")
        String primeiroAnimal,

        @NotBlank(message = "Informe a cidade onde nasceu")
        String cidadeNascimento,

        @NotBlank(message = "Informe o apelido da infância")
        String apelidoInfancia,

        @NotBlank(message = "Informe a nova senha")
        @Size(min = 4, max = 60, message = "A senha deve ter entre 4 e 60 caracteres")
        String novaSenha
) {}
