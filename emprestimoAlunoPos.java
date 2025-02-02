public class emprestimoAlunoPos implements EmprestimoBehavior {

    /*
     * A reserva garante a prioridade no empréstimo apenas entre os alunos
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
                            return "Sucesso, Livro " + livro.getTitulo() + " emprestado para " + usuario.getNome()
                                    + ". Devolucao em " + dataDevolucao(usuario) + " dias";
                        }
                        return "Insucesso, usuario já possui um exemplar do livro emprestado";

                    }
                    return "Insucesso, usuario não reservou o livro";
                }
                return "Insucesso, usuario não possui emprestimos disponiveis";
            }
            return "Insucesso, usuario está com pendencias";
        }
        return "Insucesso " + livro.getTitulo() + " não possui exemplares disponiveis";
    }

    @Override
    public int dataDevolucao(Usuario usuario) {
        return usuario.getTempoEmprestimo();
    }

}
