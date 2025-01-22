
public class ConsultarUsuarioComando implements Comando {

    @Override
    public void executar(CarregadorParamentros carregadorParametros) {
        Repositorio repositorio = Repositorio.obterIntancia();

        Usuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());
    }

}
