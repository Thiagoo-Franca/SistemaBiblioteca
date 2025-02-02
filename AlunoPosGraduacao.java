public class AlunoPosGraduacao extends Usuario {
    private final int tempoEmprestimo = 5;

    public AlunoPosGraduacao() {
        emprestimoStrategy = new EmprestimoAlunoPos();
    }
}
