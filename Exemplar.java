public class Exemplar {
    private String idLivro;
    private String idExemplar;
    private String Status = "Disponivel";
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
}
