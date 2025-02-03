
public class CarregadorParametros {
    private final String parametroUm;
    private String parametroDois;

    public CarregadorParametros(String parametroUm) {
        this.parametroUm = parametroUm;
    }

    public CarregadorParametros(String parametroUm, String parametroDois) {
        this.parametroUm = parametroUm;
        this.parametroDois = parametroDois;
    }

    public String getParametroUm() {
        return this.parametroUm;
    }

    public String getParametroDois() {
        return this.parametroDois;
    }
}
