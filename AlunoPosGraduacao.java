public class AlunoPosGraduacao extends Usuario {
    private final int tempoEmprestimo = 5;
    private final int maxEmprestimoLivros = 3;

    public AlunoPosGraduacao() {
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
