package br.com.josegeraldo.academico.model;

public record AlunoResponseDTO(Long id, String nome, String cpf, String curso) {

    public AlunoResponseDTO(Aluno aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getCpf(), aluno.getCurso());
    }

}
