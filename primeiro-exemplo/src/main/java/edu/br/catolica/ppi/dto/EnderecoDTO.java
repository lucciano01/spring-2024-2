package edu.br.catolica.ppi.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoDTO {

    private String uf;

    private String cidade;

    private String bairro;

    private String rua;

    private String numero;
}
