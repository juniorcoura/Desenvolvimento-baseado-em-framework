package br.com.josegeraldo.academico.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cpf;
    private String curso;

    public Aluno(AlunoRequestDTO data){
        this.nome = data.nome();
        this.cpf = data.cpf();
        this.curso = data.curso();

    }

}
