
package punto1;

public class Profesor {

	// Se declaran los atributos de la clase
	protected String nombre;
	protected String apellido;
	protected String estudio;
	protected String tipo;

	// Se declara el m�todo constructor por defecto
	public Profesor() {

	}

	// Se declara el m�todo constructor con par�metros
	Profesor(String nombre, String apellido, String estudio, String tipo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.estudio = estudio;
		this.tipo = tipo;
	}
}