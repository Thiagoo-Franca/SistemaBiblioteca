public class emprestimoProfessor implements EmprestimoStrategy {

    @Override
    public String pedirEmprestimo(Usuario usuario, Livro livro) {
        if (livro.getQuantidadeExemplares() > 0) {
            if (usuario.verificarDevedor() == false && usuario.qntEmprestimosDisponiveis() > 0) {

                String cod = livro.setExemplarEmprestado();

                usuario.addLivroEmprestado(livro.buscarExemplar(cod));

                return "Sucesso, Livro " + livro.getTitulo() + " emprestado para " + usuario.getNome()
                        + ". Devolução em "
                        + dataDevolucao(usuario) + " dias";
            }
            return "Insucesso, " + usuario.getNome() + " está com pendências";
        }
        return "Insucesso" + livro.getTitulo() + " não possui exemplares disponíveis";
    }

    // falta implementar o metodo dataDevolucao
    @Override
    public int dataDevolucao(Usuario usuario) {
        return 0;
    }

}
