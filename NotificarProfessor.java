public class NotificarProfessor implements IObservadorStategy {

    @Override
    public void notificar() {
        System.out.println("Notificando professor");
    }

}
