
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
    private List<Usuario> reservas = new ArrayList();

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

    public void addExemplar(Exemplar exemplar) {
        exemplares.add(exemplar);
    }

    public String setExemplarIndispovel() {
        for (Exemplar exemplar : exemplares) {
            if (exemplar.isDisponivel()) {
                exemplar.setExemplarIndispovel();
                return exemplar.getId();
            }
        }
        return null;
    }

    public void setExemplarDisponivel(String id) {
        for (Exemplar exemplar : exemplares) {
            if (exemplar.getId().equals(id)) {
                exemplar.setExemplarDisponivel();
                break;
            }
        }
    }

    public Exemplar buscarExemplar(String id) {
        for (Exemplar exemplar : exemplares) {
            if (exemplar.getId().equals(id)) {
                return exemplar;
            }
        }
        return null;
    }

    public void addUsuarioReserva(Usuario usuario) {
        reservas.add(usuario);
    }

    /*
     * Dado o código de um livro, o sistema deve apresentar suas informações da
     * seguinte forma:
     * 
     * (i) título,
     * 
     * (ii) quantidade de reservas para aquele livro, e, se diferente de zero, devem
     * ser também apresentados o nome dos usuários que realizaram cada reserva,
     * 
     * (iii) para cada exemplar, deve ser apresentado seu código, seu status
     * (disponível ou emprestado).
     * 
     * Caso o exemplar esteja
     * emprestado deverá ser exibido o nome do usuário que realizou o empréstimo, a
     * data de empréstimo e a data prevista para devolução.
     * Para solicitar tal consulta, o usuário deverá digitar o comando “liv”,
     * seguido do código do livro.
     */
    public void consultarInformacoes() {
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Quantidade de reservas: " + this.qntReservas);
        if (this.qntReservas > 0) {
            System.out.println("Usuarios que realizaram a reserva: ");
            for (Usuario usuario : reservas) {
                System.out.println(usuario.getNome());
            }
        } else {
            System.out.println("Nenhum usuario realizou reserva");
        }
        for (Exemplar exemplar : exemplares) {
            System.out.println("Codigo: " + exemplar.getId() + " | " + "Status: " + exemplar.getStatus());
            // falta implementar caso exemplar esteja emprestado
        }

    }
}
