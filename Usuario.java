import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    EmprestimoStrategy emprestimoStrategy;
    private String nome;
    private String id;
    private int tempoEmprestimo;
    private boolean devedor = false;
    private final int maxLivroEmprestado = 2;
    private final List<Emprestimo> livrosEmprestados = new ArrayList<>();
    private final List<Reserva> livrosReservados = new ArrayList<>();
    private final int qntReservasMaximas = 3;

    /* Informações do usuário */

    public String getNome() {
        return this.nome;
    };

    public String getId() {
        return this.id;
    };

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean verificarDevedor() {
        return this.devedor;
    }

    public void setDevedor() {
        this.devedor = true;
    }

    public void setNaoDevedor() {
        this.devedor = false;
    }

    public void consultarInformacoes() {
        if (livrosEmprestados == null) {
            System.out.println("Nenhum livro emprestado");
        } else {
            for (Emprestimo emprestimo : livrosEmprestados) {
                System.out.println("Titulo: " + emprestimo.getExemplar().getTitulo());
                System.out.println("Data do emprestimo: " + emprestimo.getDataEmprestimo());
                System.out.println("Status: " + emprestimo.getExemplar().getStatus());
                if (emprestimo.getExemplar().getStatus().equals("Emprestado")) {
                    System.out.println("Data de devolução: " + emprestimo.getDataDevolucao());
                }
            }

        }
        if (livrosReservados == null) {
            System.out.println("Nenhum livro reservado");
        } else {
            for (Reserva livro : livrosReservados) {
                System.out.println("Titulo: " + livro.getTituloLivro());
                System.out.println("Data da reserva: " + livro.getDataReserva());
            }

        }

    };

    /* Funcões sobre Emprestimo */

    public void performEmprestimo(Livro livro) {
        emprestimoStrategy.pedirEmprestimo(this, livro);
    }

    public void addLivroEmprestado(Exemplar livro) {
        livro.setUsuario(this);
        livrosEmprestados.add(new Emprestimo(livro, this));
    }

    public int livrosEmprestados() {
        if (livrosEmprestados == null) {
            return 0;
        }
        return livrosEmprestados.size();
    }

    public int qntEmprestimosDisponiveis() {
        if (livrosEmprestados() > 0) {
            return maxLivroEmprestado - livrosEmprestados.size();
        }
        return 0;
    }

    public boolean verificarLivroEmprestimoEmAndamento(Livro livro) {
        for (Emprestimo l : livrosEmprestados) {
            if (l.getExemplar().getId().equals(livro.getId())) {
                return true;
            }
        }
        return false;
    }

    public int getTempoEmprestimo() {
        return this.tempoEmprestimo;
    };

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

        for (Emprestimo emp : livrosEmprestados) {
            if (emp.getExemplar().getId().equals(exemplar.getId())) {
                livrosEmprestados.remove(emp);
                break;
            }
        }
    }

    /* Funções sobre Reserva */

    public void solicitarReserva(Livro livro) {
        if (livrosEmReserva() < qntReservasMaximas) {
            addReserva((new Reserva(livro.getId(), this.getId())));
            System.out.println(
                    "Usuario: " + this.nome + " Reserva realizada com sucesso para o livro: " + livro.getTitulo());
        } else {
            System.out.println("Limite de reservas atingido!");
        }

    }

    public void cancelarReserva(Livro livro) {
        // falta implementar a funcionalidade de cancelar reserva
    }

    public boolean reservouLivro(Livro livro) {
        for (Reserva l : livrosReservados) {
            if (l.getIdLivro().equals(livro.getId())) {
                return true;
            }
        }
        return false;
    }

    public int livrosEmReserva() {
        if (livrosReservados == null) {
            return 0;
        }
        return livrosReservados.size();
    }

    public void addReserva(Reserva reserva) {
        livrosReservados.add(reserva);
    }

}
