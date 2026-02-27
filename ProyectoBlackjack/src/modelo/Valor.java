package modelo;

/**
 * DEFINIR CARTAS (VALOR)
 */
public enum Valor {

    DOS(2),
    TRES(3),
    CUATRO(4),
    CINCO(5),
    SEIS(6),
    SIETE(7),
    OCHO(8),
    NUEVE(9),
    DIEZ(10),
    J(10),
    Q(10),
    K(10),
    AS(11);

	//Cada valor tiene asociado un numero de puntos 
    private final int puntos;
    
    /**
     * 
     * @param puntos
     */
    Valor(int puntos) {
        this.puntos = puntos;
    }
    /**
     * 
     * @return valor numérico de la carta desde otras clases;
     */
    public int getPuntos() {
        return puntos;
    }
}
