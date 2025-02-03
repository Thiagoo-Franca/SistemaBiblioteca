public class EmprestimoProfessor implements EmprestimoStrategy {

    @Override
    public String pedirEmprestimo(Usuario usuario_, Livro livro) {

        IEmprestimoDisponivel usuario = (IEmprestimoDisponivel) usuario_;

        if (livro.getQuantidadeExemplares() > 0) {
            if (usuario_.verificarDevedor() == false && usuario.getQntdEmprestimosDisponiveis() > 0) {

                String cod = livro.setExemplarEmprestado();

                usuario_.addLivroEmprestado(livro.buscarExemplar(cod));

                return "Sucesso, Livro " + livro.getTitulo() + " emprestado para " + usuario_.getNome();
            }
            return "Insucesso, " + usuario_.getNome() + " está com pendências";
        }
        return "Insucesso" + livro.getTitulo() + " não possui exemplares disponíveis";
    }

}
