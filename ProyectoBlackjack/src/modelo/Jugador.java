package modelo;



public class Jugador extends AgenteJuego implements Accionable{
	private double saldo;
	private double apuesta;
	private boolean plantarse=false;
	private String nombre;
	
/**
 * 
 * @param saldo jugador
 * @param nombre jugador
 */
	public Jugador(double saldo, String nombre) {
		super();
		this.nombre=nombre;
		this.saldo = saldo;
		this.apuesta=0;
		this.plantarse = false;
	}
	/**
	 * 
	 * @return nombre del jugador
	 */
	public String getNombre() {
		return nombre;
	}
	
	//Metodo para reiniciar el turno del jugador 
	public void reiniciarTurno() {
	    this.plantarse = false;
	    this.apuesta = 0;
	    this.getMano().clear(); 
	}
	
	/**
	 * 
	 * @return Saldo del jugador
	 */
	public double getSaldo() {
		return saldo;
	}
	
	/**
	 * 
	 * @return apuesta del jugador
	 */
	public double getApuesta() {
		return apuesta;
	}
	
	/**
	 * 
	 * @return si el jugador esta plantado o no
	 */
	public boolean isPlantarse() {
		return plantarse;
	}

	@Override
	public void plantarse() {
		this.plantarse=true;
		
	}
	//Metodo que usa el jugador para pedir carta
	@Override
	public void pedirCarta(Mazo mazo) {
		
		Carta cartaRobada= mazo.robarCarta();
		añadirCarta(cartaRobada);
	}
	/**
	 * 
	 * @param saldo
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	/**
	 * 
	 * @param apuesta
	 */
	public void setApuesta(double apuesta) {
		this.apuesta = apuesta;
	}
	/**
	 * 
	 * 
	 * @param plantarse
	 */
	public void setPlantarse(boolean plantarse) {
		this.plantarse = plantarse;
	}
	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

}
