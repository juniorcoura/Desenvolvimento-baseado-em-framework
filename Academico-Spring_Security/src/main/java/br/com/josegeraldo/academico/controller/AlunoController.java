package br.com.josegeraldo.academico.controller;

import br.com.josegeraldo.academico.model.Aluno;
import br.com.josegeraldo.academico.model.AlunoRequestDTO;
import br.com.josegeraldo.academico.model.AlunoResponseDTO;
import br.com.josegeraldo.academico.repository.AlunoRepository;
import br.com.josegeraldo.academico.service.AlunoService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public AlunoResponseDTO saveAluno(@RequestBody AlunoRequestDTO data){

        AlunoResponseDTO aluno = alunoService.saveAluno(data);
        return aluno;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> getAll(){
        List<AlunoResponseDTO> alunosList = alunoService.getAll();
        return ResponseEntity.ok(alunosList) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> getAluno(@PathVariable long id){
        return ResponseEntity.ok(alunoService.getAluno(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> deleteAluno(@PathVariable long id){
        return ResponseEntity.ok(alunoService.deleteAluno(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> updateAluno(@PathVariable Long id, @RequestBody AlunoRequestDTO data) {
        
        AlunoResponseDTO alunoAtualizadoDTO = alunoService.updateAluno(id, data);
    
        return ResponseEntity.ok(alunoAtualizadoDTO);
    }
    
    
}
