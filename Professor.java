public class Professor extends Usuario {
    private final int tempoEmprestimo = 8;
    private ObservadorStategy observador;

    public Professor() {
        emprestimoStrategy = new emprestimoProfessor();
        observador = new notificarProfessor();
    }
}
