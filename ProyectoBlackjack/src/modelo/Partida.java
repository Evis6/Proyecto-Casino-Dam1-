package modelo;

import java.util.Stack;

public class Partida {
	
    private Mazo mazo;
    private Jugador jugador;
    private Crupier crupier;
    private Stack<Double> historial; // Se encarga de guardar el historial de dinero

    public Partida(Jugador jugador, Crupier crupier) {
        this.mazo = new Mazo();
        this.jugador = jugador;
        this.crupier = crupier;
        this.historial = new Stack<>();
    }

   
    
    /**
     * Metodo que inicia la partida 
     */
    public void iniciarPartida() {
    

    	    mazo = new Mazo(); // mazo nuevo cada ronda
    	    mazo.barajar();

    	    // metodo para iniciar partido sin cartas en mano
    	    jugador.getMano().clear();
    	    crupier.getMano().clear();

    	    jugador.setPlantarse(false); 
    	    
        // Reparto inicial
        jugador.pedirCarta(mazo);
        crupier.pedirCarta(mazo); // visible
        jugador.pedirCarta(mazo);

        // Carta oculta del crupier
        Carta cartaOculta = mazo.robarCarta();
        crupier.setCartaOculta(cartaOculta);
    }

    // REGISTRAR RESULTADO ECONÓMICO

    public void registrarResultado(double cantidad) {
        historial.push(cantidad);
    }


    /**
     * Metodo que calcula el balance total
     * @return balance total 
     */
    public double calcularBalanceTotal() {
        double total = 0;

        for (double cantidad : historial) {
            total += cantidad;
        }

        return total;
    }

   /**
    * Metodo que determina el ganador de cada partida dependiendo de los puntos
    * @return el ganador 
    */
    public String determinarGanador() {

        int puntosJugador = jugador.calcularPuntos();
        int puntosCrupier = crupier.calcularPuntos();

        if (puntosJugador > 21) {
            return "Gana el crupier";
        } 
        else if (puntosCrupier > 21) {
            return "Gana el jugador";
        } 
        else if (puntosJugador > puntosCrupier) {
            return "Gana el jugador";
        } 
        else if (puntosCrupier > puntosJugador) {
            return "Gana el crupier";
        } 
        else {
            return "Empate";
        }
    }

  /**
   * 
   * @return jugador
   */
    public Jugador getJugador() {
        return jugador;
    }
/**
 * 
 * @return crupier
 */
    public Crupier getCrupier() {
        return crupier;
    }
    /**
     * 
     * @return mazo
     */
    public Mazo getMazo() {
        return mazo;
    }
    /**
     * 
     * @return historial partida
     */
    public Stack<Double> getHistorial() {
        return historial;
    }
}
