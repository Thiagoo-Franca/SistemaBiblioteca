import java.time.LocalDate;

public class Reserva {
    private String idLivro;
    private String idUsuario;
    private String dataReserva;

    public Reserva(String idLivro, String idUsuario) {
        this.idLivro = idLivro;
        this.idUsuario = idUsuario;
        this.dataReserva = LocalDate.now().toString();
    }

    public String getIdLivro() {
        return this.idLivro;
    }

    public String getTituloLivro() {
        Repositorio repositorio = Repositorio.obterIntancia();
        for (Livro livro : repositorio.buscarLivros()) {
            if (livro.getId().equals(this.idLivro)) {
                return livro.getTitulo();
            }
        }
        return null;
    }

    public String getIdUsuario() {
        return this.idUsuario;
    }

    public String getDataReserva() {
        return this.dataReserva;
    }

}
