package br.com.josegeraldo.academico.mapper;

import org.springframework.stereotype.Component;

import br.com.josegeraldo.academico.model.Aluno;
import br.com.josegeraldo.academico.model.AlunoRequestDTO;
import br.com.josegeraldo.academico.model.AlunoResponseDTO;

@Component
public class AlunoMapper {
    
    /**
     * Converte um AlunoRequestDTO (dados de entrada) 
     * para uma entidade Aluno (para salvar no banco).
     */
    public Aluno toEntity(AlunoRequestDTO dto){

        Aluno aluno = new Aluno();
        aluno.setNome(dto.nome());
        aluno.setCpf(dto.cpf());
        aluno.setCurso(dto.curso());
        return aluno;
    }

    /**
     * Converte uma entidade Aluno para um AlunoResponseDTO (dados de saída).
     * Usado em todas as operações que retornam informações do aluno para o cliente.
     */
    public AlunoResponseDTO toResponseDTO(Aluno entity){
        return new AlunoResponseDTO(
            entity.getId(),
            entity.getNome(),
            entity.getCpf(),
            entity.getCurso())
        ;
    }

    public void updateEntityFromDTO(Aluno entity, AlunoRequestDTO dto) {
        entity.setNome(dto.nome());
        entity.setCpf(dto.cpf());
        entity.setCurso(dto.curso());
    }

}
