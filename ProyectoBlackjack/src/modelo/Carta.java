package modelo;

public class Carta {

    private Valor valor;
    private Palo palo;

    /**
     * 
     * @param valor de la carta
     * @param palo de la carta
     */
    public Carta(Valor valor, Palo palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public int getValorNumerico() {
        return valor.getPuntos();
    }

    public Valor getValor() {
        return valor;
    }

    public Palo getPalo() {
        return palo;
    }

    @Override
    public String toString() {
        return valor + " de " + palo;
    }
}