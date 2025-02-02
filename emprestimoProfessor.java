public class emprestimoProfessor implements EmprestimoBehavior {

    @Override
    public String pedirEmprestimo(Usuario usuario, Livro livro) {
        if (livro.getQuantidadeExemplares() > 0) {
            if (usuario.verificarDevedor() == false) {
                usuario.addLivroEmprestado(livro);
                livro.setExemplarIndispovel();
                return "Sucesso, Livro " + livro.getTitulo() + " emprestado para " + usuario.getNome() +
                        ". Devolucao em " + dataDevolucao(usuario) + " dias";
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
