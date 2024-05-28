package br.com.fiap.tech_challenge.dto;

import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(
        Long id,
        @NotBlank(message = "Precisa ser apontado se é admin ou não.")
        boolean isAdmin,
        @NotBlank(message = "O nome não pode estar em branco.")
        String nome,
        String email,
        @NotBlank(message = "O time não pode estar em branco.")
        String time
) {
}
