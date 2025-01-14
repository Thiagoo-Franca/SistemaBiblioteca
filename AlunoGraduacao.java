public class AlunoGraduacao implements IUsuario {
    private String Id;
    private String nome;
    private final int tempoEmprestimo = 4;

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
