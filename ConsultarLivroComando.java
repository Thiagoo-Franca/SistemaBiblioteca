
public class ConsultarLivroComando implements IComando {

    @Override
    public void executar(CarregadorParametros carregadorParametros) {
        Repositorio repositorio = Repositorio.obterIntancia();

        Livro livro = repositorio.obterLivroPorCodigo(carregadorParametros.getParametroUm());

        livro.consultarInformacoes();
    }

}
