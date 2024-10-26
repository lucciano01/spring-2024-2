package edu.br.catolica.ppi.service;

import edu.br.catolica.ppi.domain.Pessoa;
import edu.br.catolica.ppi.dto.PessoaDTO;
import edu.br.catolica.ppi.dto.builder.PessoaBuilder;
import edu.br.catolica.ppi.execption.DataNotFoundException;
import edu.br.catolica.ppi.execption.InvalidMessageException;
import edu.br.catolica.ppi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final PessoaBuilder pessoaBuilder;

    public Pessoa save(PessoaDTO pessoaDTO){
        Optional.ofNullable(pessoaDTO.getId())
                .ifPresent(ex -> {
                    throw new InvalidMessageException("O id deve ser nulo");
                });
        return pessoaRepository
                .save(pessoaBuilder.dtoToEntity(pessoaDTO));
    }

    public Pessoa salvar(PessoaDTO pessoaDTO){
         return pessoaRepository
                .save(pessoaBuilder.dtoToEntity(pessoaDTO));
    }

    public Pessoa buscarPorCpf(String cpf){
        return pessoaRepository.findByCpf(cpf).orElseThrow(()
                -> new DataNotFoundException("Usuário do não encontrado para o cpf: " + cpf));
    }
}
