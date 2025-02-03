public class AlunoGraduacao extends Usuario implements IEmprestimoDisponivel {
    private final int tempoEmprestimoCadaLivro = 4;
    private final int maxEmprestimosLivros = 2;

    public AlunoGraduacao() {
        emprestimoStrategy = new EmprestimoAluno();
    }

    @Override
    public int getTempoEmprestimo() {
        return tempoEmprestimoCadaLivro;
    }

    public int getMaxEmprestimosLivros() {
        return maxEmprestimosLivros;
    }

    @Override
    public int getQntdEmprestimosDisponiveis() {
        return maxEmprestimosLivros - getQntdLivrosPegosEmprestados();
    }

}
