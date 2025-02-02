
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
    private int qntReservas = 0;

    public Livro(String id, String titulo, String editora, List<String> autores, String edicao, String anoPublicacao) {
        this.id = id;
        this.titulo = titulo;
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

    public int qntReservas() {
        return qntReservas;
    }

    public int adicionarReserva() {
        return qntReservas++;
    }

    public int removerReserva() {
        return qntReservas--;
    }

    public int getQntExemplaresDisponiveis() {
        int qnt = 0;
        for (Exemplar exemplar : exemplares) {
            if (exemplar.isDisponivel()) {
                qnt++;
            }
        }
        return qnt;
    }

    public void setExemplarIndispovel() {
        for (Exemplar exemplar : exemplares) {
            if (exemplar.isDisponivel()) {
                exemplar.setExemplarIndispovel();
                break;
            }
        }
    }

    public void setExemplarDisponivel(String id) {
        for (Exemplar exemplar : exemplares) {
            if (exemplar.getId().equals(id)) {
                exemplar.setExemplarDisponivel();
                break;
            }
        }
    }
}
