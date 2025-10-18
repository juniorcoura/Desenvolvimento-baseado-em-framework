package br.com.josegeraldo.academico.repository;

import br.com.josegeraldo.academico.model.Aluno;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
