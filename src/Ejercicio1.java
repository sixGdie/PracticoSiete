import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio1 {
	
	private static HashMap<String, Long> agenda = new HashMap<String, Long>();

	public static void main(String[] args) {
	
		menuAgenda();
		
	}
	
	static void menuAgenda() {
		
		System.out.println();
		System.out.println("MEN� AGENDA");
		System.out.println("===================");
		System.out.println("1. Cargar datos contactos");
		System.out.println("2. Buscar tel�fono");
		System.out.println("3. Listar Agenda");
		System.out.println("4. Salir");
		System.out.println("===============================");
		System.out.println("Ingrese la opci�n deseada:");
		int opcion = new Scanner(System.in).nextInt();
		
		switch (opcion) {
		case 1:
			cargarDatos();
			break;
		case 2:
			buscarTelefono();
			break;
		case 3:
			listarAgenda();
			break;
		case 4:
			System.out.println("[INFO]: Ha salido de la agenda.");
			break;
		default:
			System.out.println("[ERROR]: La opci�n ingresada no es v�lida, int�ntelo nuevamente.");
			menuAgenda();
			break;
		}
		
	}
	
	static void cargarDatos() {
		
		while (true) {			
			
			String nombreCompleto = leerNombre();
			
			if (agenda.containsKey(nombreCompleto)) {
				
				System.out.println("[ERROR]: El contacto ya existe, int�ntelo nuevamente.");
				cargarDatos();
				
			}
			Long numeroTelefono = leerTelefono();
			
			System.out.println("� Desea cargar m�s contactos ? SI/NO");
			String salida = new Scanner(System.in).nextLine();
			
			agenda.put(nombreCompleto, numeroTelefono);
			
			if (salida.equalsIgnoreCase("NO")) {
				
				System.out.println("[INFO]: Ha finalizado la carga de datos, volviendo al menu principal...");
				menuAgenda();
				break;
				
			}
			
		}
		
	}
	
	static void buscarTelefono() {
		
		
		if (agenda.isEmpty()) {
			
			System.out.println("[ERROR]: La agenda se encuentra vac�a, primero debe llenarla para buscar en ella.");
			menuAgenda();
		}
		
		System.out.println("Ingrese el nombre de la persona a buscar:");
		String buscarNombre = new Scanner(System.in).nextLine();
		boolean encontrado = false;
		
		for (Map.Entry<String, Long> contacto : agenda.entrySet()) {
			
			if (contacto.getKey().contains(buscarNombre)) {
				
				System.out.println("[INFO]: El contacto ha sido encontrado.");
				System.out.println("Nombre: " + contacto.getKey() + "\nTel�fono: " + contacto.getValue());
				encontrado = true;
				break;
			}
			
		}
		if (!encontrado) {
			
			System.out.println("[INFO]: El contacto no ha sido encontrado, volviendo al men� principal.");
			
		}
		
		menuAgenda();
		
	}
	
	static void listarAgenda() {
		
		if (agenda.isEmpty()) {
			
			System.out.println("[INFO]: La agenda est� vac�a, volviendo al men� principal.");
			menuAgenda();
			
		}
		
		for (Map.Entry<String, Long> contacto : agenda.entrySet()) {
			
			System.out.println("----------------------------");
			System.out.println("Nombre: " + contacto.getKey() + "\nTel�fono: " + contacto.getValue());
			
		}
		System.out.println("----------------------------");
		
		menuAgenda();
		
	}
	
	static Long leerTelefono() {
		
		System.out.println("Ingrese n�mero de tel�fono de la persona:");
		Long numeroTelefono = new Scanner(System.in).nextLong();
		
		if (numeroTelefono.toString().length() <= 2 || numeroTelefono.toString().length() >= 13) {
			
			System.out.println("[ERROR]: El n�mero debe tener entre 3 y 11 d�gitos, int�ntelo nuevamente.");
			leerTelefono();
			
		}
		
		return numeroTelefono;
	}
	
	static String leerNombre() {
		
		System.out.println("Ingrese nombre completo de la persona:");
		String nombreCompleto = new Scanner(System.in).nextLine();
		
		if (nombreCompleto.isEmpty()) {
			
			System.out.println("[ERROR]: El nombre del contacto no puede estar vac�o, int�ntelo nuevamente.");
			cargarDatos();
			
		}
		
		return nombreCompleto;
	}

}
