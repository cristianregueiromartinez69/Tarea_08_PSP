import java.util.Random;

public class Hilos implements Runnable{


    private int numero_hilo = 1;
    private int max_hilos_crear = 5;
    Random random = new Random();


    public Hilos(int numero_hilo, int max_hilos_crear){

        this.numero_hilo = numero_hilo;
        this.max_hilos_crear = max_hilos_crear;
    }


    @Override
    public void run() {

        try{

            if(numero_hilo < max_hilos_crear){

                Thread hiloHijo = new Thread(new Hilos(numero_hilo + 1, max_hilos_crear));
                hiloHijo.start();
                hiloHijo.join();

            }



            for(int i = 0; i < 10; i++){

                System.out.println("El hilo " + numero_hilo + " está procesando la instruccion(" + (i + 1) + "/10).");
                Thread.sleep(random.nextInt(500) + 100);


            }

            System.out.println("Hilo: " + numero_hilo + " ha finalizado");


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
