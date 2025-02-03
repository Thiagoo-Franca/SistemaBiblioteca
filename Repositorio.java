
import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    private static Repositorio instancia;

    private final List<Usuario> usuarios = new ArrayList<>();
    private final List<Livro> livros = new ArrayList<>();

    private Repositorio() {
    }

    public static Repositorio obterIntancia() {
        if (instancia == null) {
            instancia = new Repositorio();
        }
        return instancia;
    }

    public Usuario obterUsuarioPorCodigo(String codigo) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(codigo)) {
                return usuario;
            }
        }
        return null;
    }

    public Livro obterLivroPorCodigo(String codigo) {
        for (Livro livro : livros) {
            if (livro.getId().equals(codigo)) {
                return livro;
            }
        }
        return null;
    }

    public List<Livro> buscarLivros() {
        return livros;
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void getUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.printf(usuario.getNome() + " - " + usuario.getId() + "\n");
        }
    }

    public void getLivros() {
        for (Livro livro : livros) {
            System.out.printf(livro.getTitulo() + " - " + livro.getId() + "\n");
        }
    }

}
