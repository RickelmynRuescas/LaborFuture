package br.com.fiap.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginDTO(

        @NotBlank(message = "Informe seu nome")
        @Size(min = 3, max = 80, message = "O nome deve ter entre 3 e 80 caracteres")
        String nome,

        @NotBlank(message = "Informe sua senha")
        @Size(min = 4, max = 60, message = "A senha deve ter entre 4 e 60 caracteres")
        String senha

) { }
