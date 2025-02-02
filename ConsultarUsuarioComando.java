
public class ConsultarUsuarioComando implements IComando {

    @Override
    public void executar(CarregadorParametros carregadorParametros) {
        Repositorio repositorio = Repositorio.obterIntancia();

        Usuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());
    }

}
