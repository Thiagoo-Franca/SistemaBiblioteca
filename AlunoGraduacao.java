public class AlunoGraduacao extends Usuario {
    private final int tempoEmprestimo = 4;
    private final int maxEmprestimoLivros = 2;

    public AlunoGraduacao() {
        emprestimoStrategy = new EmprestimoAluno();
    }

    public int getTempoEmprestimo() {
        return tempoEmprestimo;
    }

    public int getmaxEmprestimoLivros() {
        return maxEmprestimoLivros;
    }

    @Override
    protected void getQntdNotificações() {
    }

}
