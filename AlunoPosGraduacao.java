public class AlunoPosGraduacao extends Usuario implements IEmprestimoDisponivel {
    private final int tempoEmprestimoCadaLivro = 5;
    private final int maxEmprestimosLivros = 3;

    public AlunoPosGraduacao() {
        emprestimoStrategy = new EmprestimoAluno();
    }

    @Override
    public int getTempoEmprestimo() {
        return tempoEmprestimoCadaLivro;
    }

    public int getmaxEmprestimoLivros() {
        return maxEmprestimosLivros;
    }

    @Override
    public int getQntdEmprestimosDisponiveis() {
        return maxEmprestimosLivros - getQntdLivrosPegosEmprestados();
    }
}
