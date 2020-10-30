import java.util.Scanner;

public class CostoComputadora {

	public static void main(String[] args) {

		String salir = "";

		while (true) {

			Computadora computadora = new Computadora();

			System.out.println("Ingrese la marca de la computadora:");
			String marcaComputadora = leerCadena();
			System.out.println("Ingrese el modelo de la computadora:");
			String modeloComputadora = leerCadena();
			computadora.setMarca(marcaComputadora);
			computadora.setModelo(modeloComputadora);

			while (true) {

				ComponenteCPU componente = new ComponenteCPU();
				System.out.println("Ingrese tipo de componente:");
				String tipoComponente = leerCadena();
				System.out.println("Ingrese la marca del componente:");
				String marcaComponente = leerCadena();
				System.out.println("Ingrese la cantidad de componentes:");
				int cantidadComponente = (int) leerEntero();
				System.out.println("Ingrese el precio del componente:");
				double precioComponente = leerDecimal();
				componente.setComponente(tipoComponente);
				componente.setMarca(marcaComponente);
				componente.setCantidad(cantidadComponente);
				componente.setPrecio(precioComponente);
				computadora.agregarComponente(componente);

				System.out.println("¿ Desea agregar más componentes ? SI/NO");
				salir = leerCadena();

				if (!salirCarga(salir)) {

					System.out.println("[INFO]: Ha salido del programa.");
					break;

				}

			}
			mostrarDatos(computadora);
			System.out.println("\n¿ Desea cotizar una nueva computadora ? SI/NO");
			salir = leerCadena();

			if (!salirCarga(salir)) {

				System.out.println("[INFO]: Ha salido del programa.");
				break;

			}

		}

	}

	static String leerCadena() {

		String cadena = new Scanner(System.in).nextLine();

		if (cadena.isEmpty()) {

			System.out.println("[ERROR]: La cadena no puede estar vacía, inténtelo nuevamente.");
			leerCadena();

		}

		return cadena;
	}

	static long leerEntero() {

		long numero = new Scanner(System.in).nextLong();

		if (numero <= 0) {

			System.out.println("[ERROR]: El valor debe ser mayor a cero, inténtelo nuevamente.");
			leerEntero();

		}

		return numero;

	}

	static double leerDecimal() {

		double decimal = new Scanner(System.in).nextDouble();

		if (decimal <= 0) {

			System.out.println("[ERROR]: El valor debe ser mayor a cero, inténtelo nuevamente.");
			leerDecimal();
		}

		return decimal;
	}

	static void mostrarDatos(Computadora computadora) {

		System.out.println("=======================");
		System.out.println("COMPUTADORA CARGADA");
		System.out.println("=======================");
		System.out.println("Marca: " + computadora.getMarca());
		System.out.println("Modelo: " + computadora.getModelo());
		System.out.println("COMPONENTES:");
		System.out.println(completarConEspacios("Componente") + "\t" + completarConEspacios("Marca") + "\t"
				+ completarConEspacios("Cantidad") + "\t" + completarConEspacios("Precio Unitario") + "\t\t"
				+ completarConEspacios("SubTotal"));
		for (ComponenteCPU c : computadora.getComponentes()) {

			System.out.println(completarConEspacios(c.getComponente()) + "\t" + completarConEspacios(c.getMarca())
					+ "\t" + completarConEspacios(Integer.toString(c.getCantidad())) + "\t"
					+ completarConEspacios(Double.toString(c.getPrecio())) + "\t\t"
					+ completarConEspacios(Double.toString(c.calculoSubTotal())));

		}
		System.out.printf("%79s", "Costo Total: " + computadora.precioTotal());
		System.out.println("\n" + computadora.precioSugerido());

	}

	static boolean salirCarga(String salir) {

		if (salir.equalsIgnoreCase("NO")) {

			return false;

		} else if (salir.equalsIgnoreCase("SI")) {

			return true;

		} else {

			System.out.println("[ERROR]: La opción ingresada no es correcta, inténtelo nuevamente.");
			leerCadena();

		}

		return true;
	}

	static String completarConEspacios(String cadena) {
		int cantidadEspacios = 15 - cadena.length();
		for (int i = 0; i < cantidadEspacios; i++) {
			cadena += " ";
		}
		return cadena;
	}

}
