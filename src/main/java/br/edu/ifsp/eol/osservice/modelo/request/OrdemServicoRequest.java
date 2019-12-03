package br.edu.ifsp.eol.osservice.modelo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class OrdemServicoRequest {

    @NotBlank
    private Long id;

    @NotBlank
    private Long instalador;

}
