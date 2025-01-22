
public class SistemaBiblioteca {

    public static void main(String[] args) {
        Repositorio repositorio = Repositorio.obterIntancia();

        Fabrica fabrica = new Fabrica();

        Usuario alunoGraduacao = fabrica.criarAlunoGraduacao("123", "João da Silva");
        Usuario alunoPosGraduacao = fabrica.criarAlunoPosGraduacao("456", "Luiz Fernando Rodrigues");
        Usuario alunoGraduacao1 = fabrica.criarAlunoGraduacao("789", "Pedro Paulo");
        Usuario professor = fabrica.criarProfessor("100", "Carlos Lucena");

        repositorio.adicionarUsuario(alunoGraduacao);
        repositorio.adicionarUsuario(alunoPosGraduacao);
        repositorio.adicionarUsuario(alunoGraduacao1);
        repositorio.adicionarUsuario(professor);

        // Testes
        System.out.println("Usuários cadastrados:");

        repositorio.getUsuarios();
    }
}
