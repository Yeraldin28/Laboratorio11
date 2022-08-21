

package punto1;

import java.util.ArrayList;

public class Fijo extends Profesor {

	// Se declara el constructor que hereda los atributos del padre
	Fijo(String nombre, String apellido, String estudio, String tipo) {
		super(nombre, apellido, estudio, tipo);
	}

	// M�todo que retorna el salario del profesor dependiendoel nivel de estudio
	public int salario() {
		switch (estudio) {
		case "Doctorado":
			return 7000000;
		case "Maestr�a":
			return 5000000;
		case "Especializaci�n":
			return 4000000;
		case "Sin postgrado":
			return 3000000;
		default:
			return 0;
		}

	}

	// Se muestra cada profesor y se calcula el salario total
	public long mostrar(ArrayList<Fijo> array, long salarioTotal, int indice) {
		for (int i = 0; i < array.size(); i++) {
			System.out.printf("\t|%3d.|%-15.14s|%-15.14s|%-18.15s|%-18s|%-15.3s|$ %-10d|%n", i + indice,
					array.get(i).nombre, array.get(i).apellido, array.get(i).estudio, array.get(i).tipo, "N/A",
					array.get(i).salario());
			salarioTotal += array.get(i).salario();
		}
		return salarioTotal;
	}
}