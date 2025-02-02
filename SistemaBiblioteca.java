
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class SistemaBiblioteca {

        public static void main(String[] args) throws IOException {
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

                Livro livro1 = fabrica.criarLivro("100", "Engenharia de Software", "Addison Wesley",
                                List.of("Ian Sommervile"),
                                "6ª", "2000");
                Livro livro2 = fabrica.criarLivro("101", "UML - Guia do Usuário", "Campus",
                                List.of("Grady Booch", "James Rumbaugh", "Ivar Jacobson"),
                                "7ª", "2000");
                Livro livro3 = fabrica.criarLivro("200", "Code Complete", "Microsoft Press", List.of("Steve McConnell"),
                                "2ª",
                                "2014");
                Livro livro4 = fabrica.criarLivro("201",
                                "Agile Software Development, Principles, Patterns and Practices",
                                "Prentice Hall", List.of("Robert Martin"), "1ª", "2002");
                Livro livro5 = fabrica.criarLivro("300", "Refactoring: Improving the Design of Existing Code",
                                "Addison Wesley Professional", List.of("Martin Fowler"), "1ª", "1999");
                Livro livro6 = fabrica.criarLivro("301", "Software Metrics: A rigorous and Practical Approach",
                                "CRC Press",
                                List.of("Norman Fenton", "James Bieman"), "3ª", "2014");

                repositorio.adicionarLivro(livro1);
                repositorio.adicionarLivro(livro2);
                repositorio.adicionarLivro(livro3);
                repositorio.adicionarLivro(livro4);
                repositorio.adicionarLivro(livro5);
                repositorio.adicionarLivro(livro6);

                // Testes
                System.out.println("Usuários cadastrados:");

                repositorio.getUsuarios();

                System.out.println("Livros cadastrados:");

                repositorio.getLivros();

                // Teste de empréstimo

                BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

                while (true) {
                        System.out.println("Digite um comando");

                        String[] entrada = teclado.readLine().split(" ");
                        String comando = entrada[0];

                        // Comando para emprestar um livro
                        if (comando.equals("emp")) {
                                String idUsuario = entrada[1];
                                String idLivro = entrada[2];

                                CarregadorParametros carregador = new CarregadorParametros(idUsuario, idLivro);
                                IComando comandoEmprestimo = new EmprestarComando();
                                comandoEmprestimo.executar(carregador);
                        }
                        // comando para consultar um livro
                        else if (comando.equals("liv")) {
                                String idLivro = entrada[1];

                                CarregadorParametros carregador = new CarregadorParametros(idLivro);
                                IComando comandoConsulta = new ConsultarLivroComando();
                                comandoConsulta.executar(carregador);
                        }

                }

        }

}
