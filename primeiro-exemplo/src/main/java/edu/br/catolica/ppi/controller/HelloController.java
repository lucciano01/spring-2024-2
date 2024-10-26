package edu.br.catolica.ppi.controller;

import edu.br.catolica.ppi.domain.Pessoa;
import edu.br.catolica.ppi.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/hello")
@RequiredArgsConstructor
public class HelloController {

    private final PessoaService pessoaService;

    @GetMapping("/{name}")
    public String hello(@PathVariable String name){
        return "Olá " +name + "!!" ;
    }


}
