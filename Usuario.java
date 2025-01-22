
public abstract class Usuario {
    EmprestimoBehavior emprestimoBehavior;
    private String nome;
    private String id;
    private int tempoEmprestimo;
    private boolean devedor = false;

    public void performEmprestimo() {
        if (!devedor) {
            emprestimoBehavior.pedirEmprestimo(null);
        }
    }

    public String getNome() {
        return this.nome;
    };

    public String getId() {
        return this.id;
    };

    public int getTempoEmprestimo() {
        return this.tempoEmprestimo;
    };

    public boolean verificarDevedor() {
        return this.devedor;
    }

    public void setDevedor() {
        this.devedor = true;
    }

    public void setNaoDevedor() {
        this.devedor = false;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(String id) {
        this.id = id;
    }

}
