package edu.br.catolica.ppi.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PessoaDTO {

    private Long id;

    @NotBlank(message = "O campo não pode ser nulo ou vazio")
    @Min(value = 3, message = "  deve possuir mais de 3 caracteres" )
    private String nome;

    @CPF(message = " invalido")
    private String cpf;

    @Email(message = " inválido")
    private String email;

    private EnderecoDTO enderecoDTO;
}
