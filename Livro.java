
import java.util.ArrayList;
import java.util.List;

public class Livro implements ILivro {
    private String titulo;
    private String id;
    private String edicao;
    private String editora;
    private List<String> autores = new ArrayList();
    private String anoPublicacao;
    private List<Exemplar> exemplares = new ArrayList();

    public Livro(String id, String titulo, String editora, List<String> autores, String edicao, String anoPublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.editora = editora;
        this.edicao = edicao;
        this.editora = editora;
        this.autores = autores;
        this.anoPublicacao = anoPublicacao;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public String getEdicao() {
        return this.edicao;
    }

    @Override
    public String getEditora() {
        return this.editora;
    }

    @Override
    public List<String> getAutores() {
        return this.autores;
    }

    @Override
    public String getAnoPublicacao() {
        return this.anoPublicacao;
    }

    @Override
    public int getQuantidadeExemplares() {
        return this.exemplares.size();
    }
}
