
package punto1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {

	public static void main(String arg[]) throws IOException {

		System.out.print("\n\n\tESTE PROGRAMA ADMINISTRA EL PAGO DE TRES TIPOS DE PROFESORES");

		// Se declara un objeto que realiza la lectura de datos
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// Se introduce en ciclo para que el usuario elija si quiere volver a usar el
		// programa
		int repetir = 1;

		do {
			// Se declaran las variables a usar
			ArrayList<Fijo> contratacionFija = new ArrayList<Fijo>();
			ArrayList<VinculacionEspecial> vinculacionEspecial = new ArrayList<VinculacionEspecial>();
			ArrayList<Catedra> catedras = new ArrayList<Catedra>();
			int nDeprofes, nivelEstudio = 1, tipoProfe = 1, horasSemanales = 8;
			String nombre = "", apellido = "", estudio = "", tipo = "";
			long salarioTotal = 0;

			// Se le pregunta al usuario cuantos profesores va a escribir
			System.out.print("\n\n\tIngresa el n�mero de profesores que quieres escribir: ");
			nDeprofes = Integer.parseInt(in.readLine());

			if (nDeprofes <= 0) {
				while (nDeprofes <= 0) {
					System.out.print("\n\tEscribe un n�mero que sea mayor o igual que cero: ");
					nDeprofes = Integer.parseInt(in.readLine());
				}
			}

			// Se introduce en un ciclo donde va introciendo los profeosres
			for (int i = 0; i < nDeprofes; i++) {

				System.out.print("\n\n\tIngresa la informaci�n del profesor N�" + (i + 1));

				System.out.print("\n\n\tNombre: ");
				nombre = in.readLine();

				System.out.print("\tApellido: ");
				apellido = in.readLine();

				do {
					System.out.print((nivelEstudio >= 1 && nivelEstudio <= 4)
							? "\tNivel de estudio: 1. Doctorado    2. Maestr�a    3. Especializaci�n     4. Sin postgrado\n\tDecisi�n: "
							: "\n\tIngresa un n�mero valido: ");
					nivelEstudio = Integer.parseInt(in.readLine());

				} while (nivelEstudio < 1 || nivelEstudio > 4);
				switch (nivelEstudio) {
				case 1:
					estudio = "Doctorado";
					break;
				case 2:
					estudio = "Maestr�a";
					break;
				case 3:
					estudio = "Especializaci�n";
					break;
				case 4:
					estudio = "Sin postgrado";
					break;
				}
				do {
					System.out.print((tipoProfe >= 1 && tipoProfe <= 3)
							? "\tTipo de profesor: 1. Contrataci�n fija     2. Vinculaci�n especial    3. Catedr�\n\tDecisi�n: "
							: "\n\tIngresa un n�mero valido: ");
					tipoProfe = Integer.parseInt(in.readLine());

				} while (tipoProfe < 1 || tipoProfe > 3);
				switch (tipoProfe) {
				case 1:
					tipo = "Contrataci�n fija";
					break;
				case 2:
					tipo = "Vinculaci�n especial";
					break;
				case 3:
					tipo = "Catedr�";
					break;
				}

				// Dependiendo del tipo de profesor se declara un objeto y se introduce en un
				// arrayList
				switch (tipoProfe) {
				case 1:
					Fijo contratoFijo = new Fijo(nombre, apellido, estudio, tipo);
					contratacionFija.add(contratoFijo);
					break;
				case 2:
					VinculacionEspecial especial = new VinculacionEspecial(nombre, apellido, estudio, tipo);
					vinculacionEspecial.add(especial);
					break;
				case 3:

					// Sis on de catedr� se pregunta la cantidad de horas que trabaja en la semana
					do {
						System.out.print((horasSemanales >= 8 && horasSemanales <= 19) ? "\tHoras de clase semanales: "
								: "\n\tIngresa un n�mero valido: ");
						horasSemanales = Integer.parseInt(in.readLine());

					} while (horasSemanales < 8 || horasSemanales > 19);

					Catedra catedratico = new Catedra(nombre, apellido, estudio, tipo, horasSemanales);
					catedras.add(catedratico);
					break;
				}

			}

			Fijo contratoFij = new Fijo(nombre, apellido, estudio, tipo);
			VinculacionEspecial especia = new VinculacionEspecial(nombre, apellido, estudio, tipo);
			Catedra catedratic = new Catedra(nombre, apellido, estudio, tipo, horasSemanales);

			// Salida por pantalla de cada array
			System.out.print(
					"\n\n\t________________________________________________________________________________________________________\n");
			System.out.printf("\t|%-3s|%-15s|%-15s|%-18s|%-18s|%-15s|%-12s|", "    ", "Nombres", "Apellidos",
					"Nivel de estudio", "Tipo", "Horas semanales", "Salario");
			System.out.print(
					"\n\t|____|_______________|_______________|__________________|__________________|_______________|____________|\n");

			salarioTotal = contratoFij.mostrar(contratacionFija, salarioTotal, 1);
			salarioTotal = especia.mostrar(vinculacionEspecial, salarioTotal, contratacionFija.size() + 1);
			salarioTotal = catedratic.mostrar(catedras, salarioTotal,
					contratacionFija.size() + vinculacionEspecial.size() + 1);

			System.out.print(
					"\t|_______________________________________________________________________________________________________|\n");
			System.out.printf("\t|%88s$ %-13d|", "El total a pagar es: ", salarioTotal);
			System.out.print(
					"\n\t|_______________________________________________________________________________________________________|\n");
			do {
				System.out.print((repetir >= 1 && repetir <= 2)
						? "\n\n\t�Quieres volver a usar el programa? \n\n\t1. Si\n\t2. No\n\n\tDecisi�n: "
						: "\n\n\tIngresa un n�mero valido: ");
				repetir = Integer.parseInt(in.readLine());

			} while (repetir < 1 || repetir > 2);
		} while (repetir == 1);
		System.out.println("\n\n\t\tGRACIAS POR USAR ESTE PROGRAMA\n");

	}
}
