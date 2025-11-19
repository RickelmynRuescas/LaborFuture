package br.com.fiap.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioDTO(
        Long id,

        @NotBlank(message = "Informe seu nome")
        @Size(min = 3, max = 80, message = "O nome deve ter entre 3 e 80 caracteres")
        String nome,

        @NotBlank(message = "Informe uma senha")
        @Size(min = 4, max = 60, message = "A senha deve ter entre 4 e 60 caracteres")
        String senha,

        @NotBlank(message = "Informe o nome do primeiro animal de estimação")
        String primeiroAnimal,

        @NotBlank(message = "Informe a cidade onde nasceu")
        String cidadeNascimento,

        @NotBlank(message = "Informe o apelido da infância")
        String apelidoInfancia
) {}
