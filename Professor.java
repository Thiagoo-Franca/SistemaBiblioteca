public class Professor extends Usuario implements IObservador, IEmprestimoDisponivel {
    private final int tempoEmprestimo = 8;
    private final int maxEmprestimoLivros = Integer.MAX_VALUE;
    private int qntdNotificacoesRecebidas = 0;

    public Professor() {
        emprestimoStrategy = new EmprestimoProfessor();
    }

    @Override
    public int getTempoEmprestimo() {
        return tempoEmprestimo;
    }

    public int qntEmprestimosDisponiveis() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void registrarObservador(Livro livro) {
        livro.adicionarObservador(this);

    }

    @Override
    public void setQuantidadeNotificacoes() {
        this.qntdNotificacoesRecebidas++;
    }

    @Override
    public void getQuantidadeNotificacoes() {
        System.out.println("Foram recebidas: " + qntdNotificacoesRecebidas + " notificações");
    }

    @Override
    public int getQntdEmprestimosDisponiveis() {
        return maxEmprestimoLivros;
    }

}
