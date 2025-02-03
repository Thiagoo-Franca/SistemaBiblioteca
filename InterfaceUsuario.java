
import java.util.HashMap;

public class InterfaceUsuario {
    private final HashMap<String, IComando> comandos = new HashMap<>();

    public void executarComando(String strComando, CarregadorParametros carregadorParametros) {
        IComando comando = comandos.get(strComando);
        comando.executar(carregadorParametros);
    }

    public HashMap<String, IComando> getComandos() {
        return comandos;
    }
}
