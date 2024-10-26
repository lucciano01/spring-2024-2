package edu.br.catolica.ppi.dto.builder;

import edu.br.catolica.ppi.domain.Endereco;
import edu.br.catolica.ppi.domain.Pessoa;
import edu.br.catolica.ppi.dto.PessoaDTO;
import org.springframework.stereotype.Component;

@Component
public class PessoaBuilder {

    public Pessoa dtoToEntity(PessoaDTO pessoaDTO){
      return Pessoa.builder()
              .nome(pessoaDTO.getNome())
              .cpf(pessoaDTO.getCpf())
              .email(pessoaDTO.getEmail())
              .endereco(Endereco.builder()
                      .bairro(pessoaDTO.getEnderecoDTO().getBairro())
                      .cidade(pessoaDTO.getEnderecoDTO().getCidade())
                      .numero(pessoaDTO.getEnderecoDTO().getNumero())
                      .uf(pessoaDTO.getEnderecoDTO().getUf())
                      .rua(pessoaDTO.getEnderecoDTO().getRua())
                      .build())
              .build();
    }
}
