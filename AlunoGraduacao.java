public class AlunoGraduacao extends Usuario {
    private final int tempoEmprestimo = 4;

    public AlunoGraduacao() {
        emprestimoBehavior = new emprestimoAlunoGraduacao();
    }

}
