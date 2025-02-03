public class EmprestimoAluno implements EmprestimoStrategy {

    @Override
    public String pedirEmprestimo(Usuario usuario, Livro livro) {
        if (livro.getQuantidadeExemplares() > 0) {
            if (usuario.verificarDevedor() == false) {
                if (usuario.qntEmprestimosDisponiveis() > 0) {
                    if (usuario.reservouLivro(livro) == true
                            || livro.getQntExemplaresDisponiveis() > livro.getQntdReservas()) {
                        if (usuario.verificarLivroEmprestimoEmAndamento(livro) == false) {

                            usuario.cancelarReserva(livro.getId());

                            String cod = livro.setExemplarEmprestado();

                            usuario.addLivroEmprestado(livro.buscarExemplar(cod));

                            return "Sucesso, Livro " + livro.getTitulo() + " emprestado para " + usuario.getNome();
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
