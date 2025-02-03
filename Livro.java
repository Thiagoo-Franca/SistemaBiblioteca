import java.util.ArrayList;
import java.util.List;

public class Livro implements ILivro, IObservavel {
    private final String titulo;
    private final String id;
    private final String edicao;
    private final String editora;
    private List<String> autores = new ArrayList();
    private final String anoPublicacao;
    private final List<Exemplar> exemplares = new ArrayList();
    private final List<Usuario> reservas = new ArrayList();
    private final List<IObservador> observadores = new ArrayList();

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

    public void setAutores(List<String> autores) {
        this.autores = autores;
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

    public int getQntdReservas() {
        return this.reservas.size();
    }

    public void adicionarReserva(Usuario usuario) {
        reservas.add(usuario);
        this.notificarObservadores();
    }

    public void removerReserva(Usuario usuario) {
        for (Usuario user : reservas) {
            if (user.getNome().equals(usuario.getNome())) {
                reservas.remove(user);
                break;
            }
        }
    }

    public int getQntExemplaresDisponiveis() {
        int qnt = 0;
        for (Exemplar exemplar : exemplares) {
            if (exemplar.getStatus().equals("Disponivel")) {
                qnt++;
            }
        }
        return qnt;
    }

    public void addExemplar(Exemplar exemplar) {
        exemplares.add(exemplar);
    }

    public String setExemplarEmprestado() {
        for (Exemplar exemplar : exemplares) {
            if (exemplar.getStatus().equals("Disponivel")) {
                exemplar.setExemplarEsprestado();
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

    public void consultarInformacoes() {
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Quantidade de reservas: " + this.getQntdReservas());

        if (this.getQntdReservas() > 0) {
            System.out.println("Usuarios que realizaram a reserva: ");
            for (Usuario usuario : reservas) {
                System.out.println(usuario.getNome());
            }
        } else {
            System.out.println("Nenhum usuario realizou reserva");
        }
        for (Exemplar exemplar : exemplares) {
            System.out.println("Codigo: " + exemplar.getId() + " | " + "Status: " + exemplar.getStatus());
            if (exemplar.getStatus().equals("Emprestado")) {
                System.out.println("Usuario: " + exemplar.getUsuario().getNome());
            }
        }

    }

    @Override
    public void adicionarObservador(IObservador observador) {
        observadores.add(observador);
        System.out.println("Observador adicionado");
    }

    @Override
    public void removerObservador(IObservador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        if (this.getQntdReservas() > 2) {
            for (IObservador observador : observadores) {
                observador.setQuantidadeNotificacoes();
            }
        }
    }

}
