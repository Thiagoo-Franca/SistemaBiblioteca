public class notificarProfessor implements ObservadorStategy {

    @Override
    public void notificar() {
        System.out.println("Notificando professor");
    }

}
