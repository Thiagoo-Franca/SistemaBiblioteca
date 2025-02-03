import java.time.LocalDate;

public class Emprestimo {
    private final Exemplar exemplar;
    private final Usuario usuario;
    private final String dataEmprestimo;
    private final String dataDevolucao;
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
