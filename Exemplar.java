import java.time.LocalDate;

public class Exemplar {
    private String idLivro;
    private String idExemplar;
    private String status;
    private Usuario usuario;
    private String dataEmprestimo;
    private String dataDevolucao;

    public Exemplar(String livroId, String exemplarId, String status) {
        this.idLivro = livroId;
        this.status = status;
        this.idExemplar = exemplarId;
    }

    public void setExemplarEsprestado() {
        this.status = "Emprestado";
    }

    public String getStatus() {
        return this.status;
    }

    public void setExemplarDisponivel() {
        this.status = "Disponivel";
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

    public void setDataEmprestimo() {
        LocalDate dataEmprestimo = LocalDate.now();
        setDataDevolucao(dataEmprestimo.plusDays(usuario.getTempoEmprestimo()));
        this.dataEmprestimo = dataEmprestimo.toString();
    }

    public String getDataEmprestimo() {
        return this.dataEmprestimo;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao.toString();
    }
}
