
public class ComandoSair implements IComando {

    @Override
    public void executar(CarregadorParametros carregadorParametros) {
        System.exit(0);
    }

}
