import java.util.List;

public class Fabrica {

    public AlunoGraduacao criarAlunoGraduacao(String id, String nome) {
        AlunoGraduacao aluno = new AlunoGraduacao();
        aluno.setId(id);
        aluno.setNome(nome);
        return aluno;
    }

    public AlunoPosGraduacao criarAlunoPosGraduacao(String id, String nome) {
        AlunoPosGraduacao aluno = new AlunoPosGraduacao();
        aluno.setId(id);
        aluno.setNome(nome);
        return aluno;
    }

    public Professor criarProfessor(String id, String nome) {
        Professor professor = new Professor();
        professor.setId(id);
        professor.setNome(nome);
        return professor;
    }

    public Livro criarLivro(String id, String titulo, String editora, List<String> autores, String edicao,
            String anoPublicacao) {
        Livro livro = new Livro(id, titulo, editora, autores, edicao, anoPublicacao);
        return livro;
    }

    public Exemplar criarExemplar(String livroid, String exemplarId, String status) {
        Exemplar exemplar = new Exemplar(livroid, exemplarId, status);
        return exemplar;
    }
}
