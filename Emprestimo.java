import java.time.LocalDate;

public class Emprestimo {
    private Exemplar exemplar;
    private Usuario usuario;
    private String dataEmprestimo;
    private String dataDevolucao;
    private String dataDevolucaoRealizada;

    public Emprestimo(Exemplar exemplar, Usuario usuario) {
        this.exemplar = exemplar;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now().toString();
        this.dataDevolucao = LocalDate.now().plusDays(usuario.getTempoEmprestimo()).toString();
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public String getDataDevolucaoRealizada() {
        return this.dataDevolucaoRealizada;
    }

    public void setDataLivroDevolvido() {
        this.dataDevolucaoRealizada = LocalDate.now().toString();
    }

}
