
import java.time.LocalDate;

public class Exemplar {
    private String idLivro;
    private String idExemplar;
    private String status;

    private Usuario usuario;
    // um exemplar pode ter um ou mais emprestimos

    public Exemplar(String livroId, String exemplarId, String status) {
        this.idLivro = livroId;
        this.status = status;
        this.idExemplar = exemplarId;
    }

    public void setExemplarIndispovel() {
        this.status = "Indisponivel";
    }

    public String getStatus() {
        return this.status;
    }

    public void setExemplarDisponivel() {
        this.status = "Disponivel";
    }

    public boolean isDisponivel() {
        return this.status.equals("Disponivel");
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
