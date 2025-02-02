
import java.util.List;

public abstract class Usuario {
    EmprestimoBehavior emprestimoBehavior;
    private String nome;
    private String id;
    private int tempoEmprestimo;
    private boolean devedor = false;
    private final int maxLivroEmprestado = 2;
    private List<Exemplar> livrosEmprestados;
    private List<Livro> livrosReservados;
    private final int qntReservasMaximas = 3;

    /* Informações do usuário */

    public String getNome() {
        return this.nome;
    };

    public String getId() {
        return this.id;
    };

    public int getTempoEmprestimo() {
        return this.tempoEmprestimo;
    };

    public boolean verificarDevedor() {
        return this.devedor;
    }

    public void setDevedor() {
        this.devedor = true;
    }

    public void setNaoDevedor() {
        this.devedor = false;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(String id) {
        this.id = id;
    }

    /* Funcões sobre Emprestimo */

    public void performEmprestimo(Livro livro) {
        emprestimoBehavior.pedirEmprestimo(this, livro);
    }

    public void addLivroEmprestado(Exemplar livro) {
        livrosEmprestados.add(livro);
    }

    public int livrosEmprestados() {
        return livrosEmprestados.size();
    }

    public int qntEmprestimosDisponiveis() {
        return maxLivroEmprestado - livrosEmprestados.size();
    }

    public boolean verificarLivroEmprestimoEmAndamento(Livro livro) {
        for (Exemplar l : livrosEmprestados) {
            if (l.getId().equals(livro.getId())) {
                return true;
            }
        }
        return false;
    }

    /* Funções sobre Devolução */

    public void devolucaoLivro(Exemplar exemplar) {
        String livroId = exemplar.getLivroId();

        Repositorio repositorio = Repositorio.obterIntancia();

        for (Livro l : repositorio.buscarLivros()) {
            if (l.getId().equals(livroId)) {
                l.setExemplarDisponivel(exemplar.getId());
                break;
            }
        }
        this.livrosEmprestados.remove(exemplar);

    }

    /* Funções sobre Reserva */

    public String solicitarReserva(Livro livro) {
        if (livrosReservados.size() < qntReservasMaximas) {
            livrosReservados.add(livro);
            return "Usuario: " + this.nome + "Reserva realizada com sucesso para o livro: " + livro.getTitulo();
        }
        return "Limite de reservas atingido!";
    }

    public void cancelarReserva(Livro livro) {
        // falta implementar a funcionalidade de cancelar reserva
    }

    public boolean reservouLivro(Livro livro) {
        for (Livro l : livrosReservados) {
            if (l.getId().equals(livro.getId())) {
                return true;
            }
        }
        return false;
    }
}
