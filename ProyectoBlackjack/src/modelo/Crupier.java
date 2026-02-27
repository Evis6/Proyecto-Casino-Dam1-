package modelo;

public class Crupier extends AgenteJuego implements Accionable {


	private String nombre;
	private boolean plantarse; 
	private Carta cartaOculta;
	
	public String getNombre() {
		return nombre;
	}


	public boolean isPlantarse() {
		return plantarse;
	}


	public Crupier(String nombre) {
		super();
		this.nombre=nombre;
	}



    @Override
    public void pedirCarta(Mazo mazo) {

        // Revela carta oculta si existe
        if (cartaOculta != null) {
            añadirCarta(cartaOculta);
            cartaOculta = null;
        }

        // Lógica automática hasta 17
        while (calcularPuntos() < 17) {
            Carta carta = mazo.robarCarta();
            añadirCarta(carta);
        }

        plantarse = true;
    }
    public void setCartaOculta(Carta carta) {
        this.cartaOculta = carta;
    }
	@Override
	public void plantarse() {	
		plantarse=true;
	}

	
}
