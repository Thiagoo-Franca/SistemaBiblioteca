public abstract class emprestimoAlunoGraduacao implements EmprestimoBehavior {

    /*
     * A reserva garante a prioridade no empréstimo apenas entre os alunos
     * 
     * Caso o usuário tenha feito uma reserva
     * para o livro em questão, a mesma deve ser cancelada e o empréstimo será
     * efetivado.
     * 
     * 
     * Ao final do processo, o sistema deve emitir uma mensagem de sucesso ou
     * insucesso,
     * mencionando o nome do
     * usuário e o título do livro. Em caso de insucesso, a mensagem também
     * informará o motivo.
     * 
     * 
     * Regra de Empréstimo para Alunos
     * O empréstimo de um livro será realizado para um aluno de graduação ou de
     * pós-graduação apenas se:
     * 1. Houver exemplares disponíveis na biblioteca;
     * 2. O usuário não estiver “devedor” com livros em atraso;
     * 3. O usuário seguir as regras específicas referentes à quantidade máxima de
     * livros que podem ser emprestados (conforme Tabela 2);
     * 4. A quantidade de reservas existentes do livro deve ser menor do que a
     * quantidade de exemplares disponíveis, desde que o usuário não tenha uma
     * reserva para esse livro;
     * 5. Se a quantidade de reservas for igual ou superior à de exemplares
     * disponíveis, o empréstimo será permitido apenas se uma das reservas for do
     * usuário;
     * 6. O usuário não pode ter nenhum empréstimo em andamento de um exemplar desse
     * mesmo livro.
     * Tipo de Usuário Limite de Empréstimos em Aberto
     * Aluno Graduação 2 livros
     * Aluno Pós- Graduação 3 livros
     * Tabela 2. Limites da quantidade de livros para empréstimo
     */

    @Override
    public String pedirEmprestimo(Usuario usuario, Livro livro) {
        if (livro.getQuantidadeExemplares() > 0) {
            if (usuario.verificarDevedor() == false) {
                if (usuario.qntEmprestimosDisponiveis() > 0) {
                    if (usuario.reservouLivro(livro) == true) {
                        if (usuario.verificarLivroEmprestimoEmAndamento(livro) == false) {
                            usuario.cancelarReserva(livro);
                            usuario.addLivroEmprestado(livro);
                            livro.setExemplarIndispovel();
                            dataDevolucao(usuario);
                            return "Sucesso, Livro " + livro.getTitulo() + " emprestado para " + usuario.getNome();
                        } else {
                            return "Insucesso, " + usuario.getNome() + " já possui um exemplar do livro "
                                    + livro.getTitulo() + " emprestado";
                        }
                    }
                }
            }
        }
        return "Insucesso";
    }

    @Override
    public int dataDevolucao(Usuario usuario) {
        return usuario.getTempoEmprestimo();
    }

}
