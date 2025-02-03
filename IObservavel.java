public interface IObservavel {
    public void adicionarObservador(IObservador observador);

    public void removerObservador(IObservador observador);

    public void notificarObservadores();
}
