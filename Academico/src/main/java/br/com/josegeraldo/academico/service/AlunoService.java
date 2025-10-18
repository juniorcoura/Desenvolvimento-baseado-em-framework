package br.com.josegeraldo.academico.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.josegeraldo.academico.mapper.AlunoMapper;
import br.com.josegeraldo.academico.model.Aluno;
import br.com.josegeraldo.academico.model.AlunoRequestDTO;
import br.com.josegeraldo.academico.model.AlunoResponseDTO;
import br.com.josegeraldo.academico.repository.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlunoService {
    
    private final AlunoRepository alunoRepository;

    private final AlunoMapper alunoMapper;

    public AlunoResponseDTO saveAluno(AlunoRequestDTO alunoDTO){
        Aluno novoAluno =  alunoMapper.toEntity(alunoDTO);
        alunoRepository.save(novoAluno);
        return alunoMapper.toResponseDTO(novoAluno);
    }

    public List<AlunoResponseDTO> getAll(){
        List<AlunoResponseDTO> alunoList = alunoRepository.findAll().
                                                            stream().                                                   map(AlunoResponseDTO::new).
                                                            toList();
        return alunoList;
    }

    public AlunoResponseDTO getAluno(long id){
        Aluno aluno = alunoRepository.findById(id).get();
        return new AlunoResponseDTO(aluno);
    }

    public AlunoResponseDTO deleteAluno(long id){

        Aluno aluno = alunoRepository.findById(id).get();

        if(aluno == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado");
        }

        alunoRepository.deleteById(id);

        return new AlunoResponseDTO(aluno);
    }

     public AlunoResponseDTO updateAluno(Long id, AlunoRequestDTO alunoDTO) {
        Aluno aluno = alunoRepository.findById(id).get();
        if(aluno == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado");
        }        
        alunoMapper.updateEntityFromDTO(aluno, alunoDTO);

        alunoRepository.save(aluno);
        
        return alunoMapper.toResponseDTO(aluno);
    }


}
