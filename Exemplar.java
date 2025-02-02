
import java.time.LocalDate;

public class Exemplar {
    private String idLivro;
    private String idExemplar;
    private String Status = "Disponivel";

    private Usuario usuario;
    // um exemplar pode ter um ou mais emprestimos

    public Exemplar(String idLivro, String idExemplar) {
        this.idLivro = idLivro;
        this.idExemplar = idExemplar;
    }

    public void setExemplarIndispovel() {
        this.Status = "Indisponivel";
    }

    public void setExemplarDisponivel() {
        this.Status = "Disponivel";
    }

    public boolean isDisponivel() {
        if (this.Status == "Disponivel") {
            return true;
        }
        return false;
    }

    public String getId() {
        return this.idExemplar;
    }

    public String getLivroId() {
        return this.idLivro;
    }

    public String getTitulo() {
        Repositorio repositorio = Repositorio.obterIntancia();
        for (Livro livro : repositorio.buscarLivros()) {
            if (livro.getId().equals(this.idLivro)) {
                return livro.getTitulo();
            }
        }
        return null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDataEmprestimo() {
        LocalDate data = LocalDate.now();
        return data.toString();
    }

    public String getDataDevolucao() {
        LocalDate data = LocalDate.now().plusDays(usuario.getTempoEmprestimo());
        return data.toString();
    }
}
