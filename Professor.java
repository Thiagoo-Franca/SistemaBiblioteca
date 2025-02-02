public class Professor extends Usuario {
    private final int tempoEmprestimo = 8;
    private IObservadorStategy observador;

    public Professor() {
        emprestimoStrategy = new EmprestimoProfessor();
        observador = new NotificarProfessor();
    }
}
