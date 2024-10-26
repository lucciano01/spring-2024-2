package edu.br.catolica.ppi.repository;

import edu.br.catolica.ppi.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findByCpf(@Param("cpf") String cpf);

    @Query(value = "select p from Pessoa p where p.nome = :nome")
    Pessoa buscaPeloNome(String nome);
}
