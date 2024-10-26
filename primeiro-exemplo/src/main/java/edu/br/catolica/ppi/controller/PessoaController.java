package edu.br.catolica.ppi.controller;

import edu.br.catolica.ppi.domain.Pessoa;
import edu.br.catolica.ppi.dto.PessoaDTO;
import edu.br.catolica.ppi.dto.builder.PessoaBuilder;
import edu.br.catolica.ppi.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa")
@RequiredArgsConstructor
@Tag(name = "PessoaAPI", description = "Api de controle de Usuario")
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping("/save")
    @Operation(summary = "Salva um usuario no banco de dados")
    public ResponseEntity<Pessoa> save(@RequestBody @Valid PessoaDTO pessoaDTO){
         return ResponseEntity.status(HttpStatus.CREATED)
                .body(pessoaService
                        .save(pessoaDTO));
    }

    @PostMapping("/salvar")
    @Operation(summary = "Salva um usuario no banco de dados")
    public ResponseEntity<Pessoa> salvar(@RequestBody @Valid PessoaDTO pessoaDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pessoaService
                        .salvar(pessoaDTO));
    }

    @GetMapping("/cpf/{cpf}")
    @Operation(summary = "Busca usuario pelo cpf")
    public ResponseEntity<Pessoa> findByCpf(@PathVariable("cpf") String cpf){
       return ResponseEntity.status(HttpStatus.OK)
               .body(pessoaService.buscarPorCpf(cpf));
    }
}
