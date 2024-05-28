package br.com.fiap.tech_challenge.dto;

import jakarta.validation.constraints.NotBlank;

public record AparelhoDTO(
        Long id,
        boolean estaReservado,
        @NotBlank(message = "O nome não pode estar em branco")
        String nomeAparelho,
        @NotBlank(message = "O modelo não pode estar em branco")
        String modelo,
        String observacao,
        @NotBlank(message = "O time responsável não pode estar em branco")
        String timeResponsavel,
        String quemReservou
) {
}
