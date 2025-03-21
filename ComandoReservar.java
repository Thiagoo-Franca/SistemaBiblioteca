
public class ComandoReservar implements IComando {

    @Override
    public void executar(CarregadorParametros carregadorParametros) {
        Repositorio repositorio = Repositorio.obterIntancia();

        Usuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());
        Livro livro = repositorio.obterLivroPorCodigo(carregadorParametros.getParametroDois());

        usuario.solicitarReserva(livro);

    }

}
