public interface EmprestimoBehavior {

    public String pedirEmprestimo(Usuario usuario, Livro livro);

    public int dataDevolucao(Usuario usuario);
}
