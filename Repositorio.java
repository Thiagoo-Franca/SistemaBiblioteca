
import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    private static Repositorio instancia;

    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private List<Livro> livros = new ArrayList<Livro>();

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

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void getUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.printf(usuario.getNome() + " - " + usuario.getId() + "\n");
        }
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void getLivros() {
        for (Livro livro : livros) {
            System.out.printf(livro.getTitulo() + " - " + livro.getId() + "\n");
        }
    }

}
