package modelo;

import java.util.ArrayList;

import java.util.Collections;


public class Mazo {
	
	//Aqui se guarda todas las cartas del mazo dentro de un ArrayList
	private ArrayList<Carta> mazo = new ArrayList<Carta>();

	/**
	 * Permite accerdera a las cartas desde otras clases
	 * @return mazo
	 */
	public ArrayList<Carta> getCartas() {
		return mazo;
	}
	
    //Proceso en el que se recorren palo y valor y crea carta  y la añade al mazo
	public Mazo() {
		
		for (Palo p : Palo.values()) {
		    for (Valor valor : Valor.values()) {
		        mazo.add(new Carta(valor, p));
		    }
		}
	}
	
	public void barajar() {
		Collections.shuffle(mazo);

	}

	/// roba carta y te la enseña 
	public Carta robarCarta() {
	    return mazo.remove(0);
	}


	@Override
	public String toString() {
		return "Mazo [" + mazo + "]";
	}
}

