

package punto1;

import java.util.ArrayList;

public class Catedra extends Profesor {

	// Se declara un atributo propio de esta clase
	protected int horasSemanales;

	// Se declara el constructor que hereda los atributos del padre
	Catedra(String nombre, String apellido, String estudio, String tipo, int horasSemanales) {
		super(nombre, apellido, estudio, tipo);
		this.horasSemanales = horasSemanales;
	}

	// M�todo que retorna el salario del profesor dependiendoel nivel de estudio
	public int salario() {
		switch (estudio) {
		case "Doctorado":
			return (700000 / 30) * horasSemanales * 4;
		case "Maestr�a":
			return (500000 / 30) * horasSemanales * 4;
		case "Especializaci�n":
			return (400000 / 30) * horasSemanales * 4;
		case "Sin postgrado":
			return (300000 / 30) * horasSemanales * 4;
		default:
			return 0;
		}

	}

	// Se muestra cada profesor y se calcula el salario total
	public long mostrar(ArrayList<Catedra> catedras, long salarioTotal, int indice) {
		for (int i = 0; i < catedras.size(); i++) {
			System.out.printf("\t|%3d.|%-15.14s|%-15.14s|%-18.15s|%-18s|%-15d|$ %-10d|%n", i + indice,
					catedras.get(i).nombre, catedras.get(i).apellido, catedras.get(i).estudio, catedras.get(i).tipo,
					catedras.get(i).horasSemanales, catedras.get(i).salario());
			salarioTotal += catedras.get(i).salario();
		}
		return salarioTotal;
	}

}