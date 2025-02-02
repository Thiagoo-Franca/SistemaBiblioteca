
import java.util.HashMap;

public class InterfaceUsuario {
    private HashMap<String, IComando> comandos = new HashMap<String, IComando>();

    private void inicializarComandos() {
        comandos.put("emp", new EmprestarComando());
        comandos.put("usu", new ConsultarUsuarioComando());
    }

    public void executarComando(String strComando, CarregadorParametros carregadorParametros) {
        IComando comando = comandos.get(strComando);
        comando.executar(carregadorParametros);
    }
}
