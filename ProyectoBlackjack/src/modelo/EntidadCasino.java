package modelo;
/**
 * Clase que representa la entidad general del casino
 */
public abstract class EntidadCasino {
	
	private String id;
	private String nombre;
	
	public String getId() {
		return id;
	}
	public EntidadCasino(String id, String nombre) {

		this.id = id;
		this.nombre= nombre;
	}
	public String getNombre() {
		return nombre;
	}
	@Override
	public String toString() {
		return "EntidadCasino id=" + id + ", Nombre=" + nombre;
	}
	
}
