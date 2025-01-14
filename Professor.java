public class Professor implements IUsuario {
    private String Id;
    private String nome;
    private final int tempoEmprestimo = 8;

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public String getId() {
        return this.Id;
    }

    @Override
    public int getTempoEmprestimo() {
        return this.tempoEmprestimo;
    }

}
