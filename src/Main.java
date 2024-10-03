public class Main {
    public static void main(String[] args) {

        Thread hilos = new Thread(new Hilos(1,5));
        hilos.start();


    }
}