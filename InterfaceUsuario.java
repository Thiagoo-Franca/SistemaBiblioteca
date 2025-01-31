
import java.util.HashMap;

public class InterfaceUsuario {
    private HashMap<String, Comando> comandos = new HashMap<String, Comando>();

    private void inicializarComandos() {
        comandos.put("emp", new EmprestarComando());
        comandos.put("usu", new ConsultarUsuarioComando());
    }

    public void executarComando (String strComando, carregadorParametros) {
        Comando comando = comandos.get(strComando);
        Comando.executar(carregadorParametros); 
    }
}
