public class EmprestimoAluno implements EmprestimoStrategy {

    @Override
    public String pedirEmprestimo(Usuario usuario_, Livro livro) {

        IEmprestimoDisponivel usuario = (IEmprestimoDisponivel) usuario_;

        if (livro.getQuantidadeExemplares() > 0) {
            if (!usuario_.verificarDevedor()) {
                if (usuario.getQntdEmprestimosDisponiveis() > 0) {
                    if (usuario_.reservouLivro(livro) == true
                            || livro.getQntExemplaresDisponiveis() > livro.getQntdReservas()) {
                        if (usuario_.verificarLivroEmprestimoEmAndamento(livro) == false) {

                            usuario_.cancelarReserva(livro.getId());

                            String cod = livro.setExemplarEmprestado();

                            usuario_.addLivroEmprestado(livro.buscarExemplar(cod));

                            return "Sucesso, Livro " + livro.getTitulo() + " emprestado para " + usuario_.getNome();
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

}
