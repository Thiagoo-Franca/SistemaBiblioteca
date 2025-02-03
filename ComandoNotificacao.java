
public class ComandoNotificacao implements IComando {

    @Override
    public void executar(CarregadorParametros carregadorParametros) {
        Repositorio repositorio = Repositorio.obterIntancia();

        Usuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());

        IObservador observador = (IObservador) usuario;

        observador.getQuantidadeNotificacoes();

    }

}
