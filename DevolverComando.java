
public class DevolverComando implements IComando {

    @Override
    public void executar(CarregadorParametros carregadorParametros) {
        Repositorio repositorio = Repositorio.obterIntancia();

        Usuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());
        Livro livro = repositorio.obterLivroPorCodigo(carregadorParametros.getParametroDois());

        String saida = usuario.realizarDevolucao(livro);
        System.out.println(saida);
    }

}
