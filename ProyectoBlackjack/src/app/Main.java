package app;

import modelo.*;
import vista.VistaConsola;
import controlador.ControladorJuego;

public class Main {

    public static void main(String[] args) {

        Jugador jugador = new Jugador(500, "Jugador_1");
        Crupier crupier = new Crupier("Dealer");

        Partida partida = new Partida(jugador, crupier);
        VistaConsola vista = new VistaConsola();

        ControladorJuego controlador =
                new ControladorJuego(partida, vista);

        controlador.iniciarJuego();
    }
}