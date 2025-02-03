import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    EmprestimoStrategy emprestimoStrategy;
    private String nome;
    private String id;
    private int tempoEmprestimo;
    private boolean devedor = false;
    private int maxEmprestimoLivros;
    private List<Emprestimo> livrosEmprestados = new ArrayList<>();
    private List<Reserva> livrosReservados = new ArrayList<>();
    private final int qntReservasMaximas = 3;
    private List<Reserva> historicoReserva = new ArrayList<>();
    private List<Emprestimo> historicoEmprestimo = new ArrayList<>();

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
        System.out.println("Livros emprestados: " + livrosEmprestados());
        for (Emprestimo emprestimo : livrosEmprestados) {
            System.out.println("Titulo: " + emprestimo.getExemplar().getTitulo());
            System.out.println("Data do emprestimo: " + emprestimo.getDataEmprestimo());
            System.out.println("Status: " + emprestimo.getExemplar().getStatus());
            if (emprestimo.getExemplar().getStatus().equals("Emprestado")) {
                System.out.println("Data de devolução: " + emprestimo.getDataDevolucao());

            }

        }
        System.out.println("\nLivros reservados: " +

                livrosEmReserva());
        for (Reserva livro : livrosReservados) {
            System.out.println("Titulo: " + livro.getTituloLivro());
            System.out.println("Data da reserva: " + livro.getDataReserva());
        }
        System.out.println("\nHistorico de emprestimos: ");
        for (Emprestimo emp : historicoEmprestimo) {
            System.out.println("Titulo: " + emp.getExemplar().getTitulo());
            System.out.println("Data do emprestimo: " + emp.getDataEmprestimo());
            System.out.println("Status: " + emp.getExemplar().getStatus());
            if (emp.getExemplar().getStatus().equals("Emprestado")) {
                System.out.println("Data de entrega: " + emp.getDataDevolucao());
            } else if (emp.getExemplar().getStatus().equals("Devolvido")) {
                System.out.println("Data de devolução: " + emp.getDataDevolucaoRealizada());
            }
        }
        System.out.println("\nHistorico de reservas: ");
        for (Reserva livro : historicoReserva) {
            System.out.println("Titulo: " + livro.getTituloLivro());
            System.out.println("Data da reserva: " + livro.getDataReserva());
        }

    };

    /* Funcões sobre Emprestimo */

    public String performEmprestimo(Livro livro) {
        return emprestimoStrategy.pedirEmprestimo(this, livro);
    }

    public void addLivroEmprestado(Exemplar livro) {
        livro.setUsuario(this);
        livrosEmprestados.add(new Emprestimo(livro, this));
        historicoEmprestimo.add(new Emprestimo(livro, this));
        cancelarReserva(livro.getLivroId());

    }

    public int livrosEmprestados() {
        if (livrosEmprestados == null) {
            return 0;
        }
        return livrosEmprestados.size();
    }

    public int qntEmprestimosDisponiveis() {
        return maxEmprestimoLivros - livrosEmprestados();
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

    public String realizarDevolucao(Livro livro) {
        for (Emprestimo emp : livrosEmprestados) {
            if (emp.getExemplar().getLivroId().equals(livro.getId())) {
                devolucaoLivro(emp.getExemplar());
                return "Devolução realizada com sucesso";
            }
        }
        return "Nao há exemplares deste livro emprestados";
    }

    /* Funções sobre Reserva */

    public void solicitarReserva(Livro livro) {
        if (livrosEmReserva() < qntReservasMaximas) {
            addReserva((new Reserva(livro.getId(), this.getId())));
            historicoReserva.add(new Reserva(livro.getId(), this.getId()));
            livro.adicionarReserva(this);
            System.out.println(
                    "Usuario: " + this.nome + " Reserva realizada com sucesso para o livro: " + livro.getTitulo());
        } else {
            System.out.println("Limite de reservas atingido!");
        }

    }

    public void cancelarReserva(String idLivro) {
        for (Reserva l : livrosReservados) {
            if (l.getIdLivro().equals(idLivro)) {
                livrosReservados.remove(l);
                break;
            }
        }

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

    public void registrarObservador(Livro livro) {
        livro.addUsuarioReserva(this);
    }

    protected abstract void getQntdNotificações();

}
