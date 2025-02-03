public class Professor extends Usuario implements IObservador {
    private final int tempoEmprestimo = 8;
    private final int maxEmprestimoLivros = Integer.MAX_VALUE;
    private int qntdNotificações = 0;

    public Professor() {
        emprestimoStrategy = new EmprestimoProfessor();
    }

    public int getTempoEmprestimo() {
        return tempoEmprestimo;
    }

    public int qntEmprestimosDisponiveis() {
        return Integer.MAX_VALUE;
    }

    public void registrarObservador(Livro livro) {
        livro.adicionarObservador(this);

    }

    @Override
    public void notificar(String mensagem) {
        this.qntdNotificações++;
    }

    public void getQntdNotificações() {
        System.out.println("Foram recebidas: " + qntdNotificações + " notificações");
    }

}
