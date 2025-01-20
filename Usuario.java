public abstract class Usuario {
    EmprestimoBehavior emprestimoBehavior;

    public void performEmprestimo() {
        emprestimoBehavior.pedirEmprestimo();
    }
}
