
import java.util.List;

public abstract class Usuario {
    EmprestimoBehavior emprestimoBehavior;
    private String nome;
    private String id;
    private int tempoEmprestimo;
    private boolean devedor = false;
    private final int maxLivroEmprestado = 2;
    private List<Livro> livrosEmprestados;
    private List<Livro> livrosReservados;

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

    public void performEmprestimo(Livro livro) {
        emprestimoBehavior.pedirEmprestimo(this, livro);
    }

    public void solicitarReserva(Livro livro) {
        // falta implementar a funcionalidade de reserva
    }

    public void cancelarReserva(Livro livro) {
        // falta implementar a funcionalidade de cancelar reserva
    }

    public void addLivroEmprestado(Livro livro) {
        livrosEmprestados.add(livro);
    }

    public int livrosEmprestados() {
        return livrosEmprestados.size();
    }

    public int qntEmprestimosDisponiveis() {
        return maxLivroEmprestado - livrosEmprestados.size();
    }

    public boolean reservouLivro(Livro livro) {
        for (Livro l : livrosReservados) {
            if (l.getId().equals(livro.getId())) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarLivroEmprestimoEmAndamento(Livro livro) {
        for (Livro l : livrosEmprestados) {
            if (l.getId().equals(livro.getId())) {
                return true;
            }
        }
        return false;
    }

}
