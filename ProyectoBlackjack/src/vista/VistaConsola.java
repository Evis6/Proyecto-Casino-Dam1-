package vista;
import java.util.Scanner;

public class VistaConsola {

    private Scanner sc = new Scanner(System.in);

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public int pedirOpcion() {
        System.out.println("1. Pedir carta  o 2. Plantarse");
    
        int opcion = sc.nextInt();
        return opcion;
    }
    public int pedirContinuar() {
    	
    	System.out.println("1.Si  o  2.No ");
    	int opcion2=sc.nextInt();
		return opcion2;
    	
    	
    }

    public double pedirApuesta() {
        System.out.println("¿Cuánto deseas apostar? ");
        double apuesta = sc.nextDouble();
        return apuesta;
    }
}