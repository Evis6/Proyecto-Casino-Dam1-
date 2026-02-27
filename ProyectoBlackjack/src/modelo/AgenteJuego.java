package modelo;

import java.util.LinkedList;


public abstract class AgenteJuego {

	private LinkedList<Carta> mano;
	protected int total ;
	protected int ases;

	 
	public AgenteJuego() {
		super();
		this.mano = new LinkedList<Carta>();
		this.total=0;
		this.ases=0;
	}



	protected void añadirCarta(Carta carta) {
		mano.add(carta);
	}

	public int calcularPuntos() {


		total =0;
		ases=0;

		for (Carta carta : mano) {
			total += carta.getValorNumerico();

			if (carta.getValor() == Valor.AS) {
				ases++;
			}
		}


		//PARA AJUSTAR EL AS EN CASO DE QUE TE PASES DE 21
		while(total > 21 && ases >0) {
			total-=10;
			ases--;

		}
		return total;
	}







	public LinkedList<Carta> getMano() {
		return mano;
	}

	protected boolean estaPasado() {
		return calcularPuntos() > 21;
	}


	public int getTotal() {
		return total;
	}



}


