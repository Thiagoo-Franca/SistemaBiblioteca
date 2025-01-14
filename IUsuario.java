/*
 * Cada usuário, por sua vez, deve ter um código de identificação e um nome. Os três tipos de usuários
(alunos de graduação, alunos de pós-graduação e professores) possuem regras específicas para o
empréstimo de livros, que estão detalhadas na Seção 3 deste documento. Cada tipo de usuário também
tem um período específico, em dias, durante o qual pode manter o livro emprestado, conforme
indicado na Tabela 1. Sempre que o empréstimo de um livro é solicitado, essa operação é registrada
no sistema e é determinada a data de devolução com base no prazo de empréstimo correspondente ao
tipo de usuário
 */

public interface IUsuario {

    String getNome();

    String getId();

    int getTempoEmprestimo();

}
