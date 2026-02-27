package controlador;

import modelo.*;
import vista.VistaConsola;

public class ControladorJuego {

    private Partida partida;
    private VistaConsola vista;

    public ControladorJuego(Partida partida, VistaConsola vista) {
        this.partida = partida;
        this.vista = vista;
    }

    public void iniciarJuego() {

        boolean seguirJugando = true;

        while (seguirJugando && partida.getJugador().getSaldo() > 0) {

            // 🔥 RESET ESTADO DEL JUGADOR
            partida.getJugador().getMano().clear();
            partida.getCrupier().getMano().clear();
            partida.getJugador().setPlantarse(false);

            vista.mostrarMensaje("\n==============================");
            vista.mostrarMensaje("Saldo actual: "
                    + partida.getJugador().getSaldo() + "€");

            // =========================
            // VALIDAR APUESTA
            // =========================
            boolean apuestaValida = false;

            while (!apuestaValida) {
                try {
                    double apuesta = vista.pedirApuesta();

                    if (apuesta <0) {
                        throw new BlackJackException(
                                "La apuesta debe ser mayor que 0.");
                    }

                    if (apuesta > partida.getJugador().getSaldo()) {
                        throw new BlackJackException(
                                "No puedes apostar más dinero del que tienes.");
                    }
                   

                    partida.getJugador().setApuesta(apuesta);
                    apuestaValida = true;

                } catch (BlackJackException e) {
                    vista.mostrarMensaje("Error: " + e.getMessage());
                }
            }

            // =========================
            // INICIAR PARTIDA
            // =========================
            partida.iniciarPartida();

            // =========================
            // TURNO JUGADOR
            // =========================
            while (!partida.getJugador().isPlantarse()
                    && partida.getJugador().calcularPuntos() < 21) {

                vista.mostrarMensaje("\nTus cartas:");
                for (Carta c : partida.getJugador().getMano()) {
                    vista.mostrarMensaje(c.toString());
                }

                vista.mostrarMensaje("Tus puntos: "
                        + partida.getJugador().calcularPuntos());

                // Carta visible del crupier
                vista.mostrarMensaje("\nCarta visible del crupier:");
                Carta visible = partida.getCrupier().getMano().get(0);
                vista.mostrarMensaje(visible.toString());
                vista.mostrarMensaje("[ ? ]");

                int opcion = vista.pedirOpcion();

                if (opcion == 1) {

                    partida.getJugador().pedirCarta(partida.getMazo());

                    Carta ultima =
                            partida.getJugador().getMano().getLast();

                    vista.mostrarMensaje("Tu nueva carta: "
                            + ultima.toString());

                } else {
                    partida.getJugador().plantarse();
                }
            }

            //TURNO CUPRIER
            int puntosJugador =
                    partida.getJugador().calcularPuntos();

            if (puntosJugador <= 21) {

                vista.mostrarMensaje("\nEl crupier revela sus cartas:");

                for (Carta c : partida.getCrupier().getMano()) {
                    vista.mostrarMensaje(c.toString());
                }

                while (partida.getCrupier().calcularPuntos() < 17) {

                    vista.mostrarMensaje("\nEl crupier roba carta...");

                    partida.getCrupier().pedirCarta(partida.getMazo());

                    Carta ultima =
                            partida.getCrupier().getMano().getLast();

                    vista.mostrarMensaje(ultima.toString());
                }
            }

            int puntosCrupier =
                    partida.getCrupier().calcularPuntos();

            String resultado =
                    partida.determinarGanador();

            vista.mostrarMensaje("\nTus puntos finales: "
                    + puntosJugador
                    + "\nPuntos del crupier: "
                    + puntosCrupier
                    + "\nResultado: "
                    + resultado);

          
            // ACTUALIZAR SALDO Y STACK
       
            double apuesta =
                    partida.getJugador().getApuesta();

            if (resultado.equals("Gana el jugador")) {

                partida.getJugador().setSaldo(
                        partida.getJugador().getSaldo()
                                + apuesta);

                partida.registrarResultado(apuesta);

            } else if (resultado.equals("Gana el crupier")) {

                partida.getJugador().setSaldo(
                        partida.getJugador().getSaldo()
                                - apuesta);

                partida.registrarResultado(-apuesta);

            } else {
                partida.registrarResultado(0);
            }

            vista.mostrarMensaje("Saldo actual: "
                    + partida.getJugador().getSaldo()
                    + "€");

            
            // PREGUNTAR SI QUIERE SEGUIR
 
            vista.mostrarMensaje("\n¿Quieres seguir jugando?");
        

            int opcionFinal = vista.pedirContinuar();

            if (opcionFinal != 1) {
                seguirJugando = false;
            }
        }

        
        // RESUMEN FINAL
        
        double balanceTotal =
                partida.calcularBalanceTotal();

        vista.mostrarMensaje("\n========== RESUMEN FINAL ==========");

        if (balanceTotal > 0) {
            vista.mostrarMensaje("Has ganado en total: "
                    + balanceTotal + "€");
        } else if (balanceTotal < 0) {
            vista.mostrarMensaje("Has perdido en total: "
                    + Math.abs(balanceTotal) + "€");
        } else {
            vista.mostrarMensaje(
                    "Has terminado igual que empezaste.");
        }

        vista.mostrarMensaje("Saldo final: "
                + partida.getJugador().getSaldo()
                + "€");
    }
}