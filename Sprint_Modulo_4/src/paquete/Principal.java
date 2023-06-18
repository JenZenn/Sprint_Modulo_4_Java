package paquete;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {

		Contenedor contenedor = new Contenedor();
		int opcion = 0;
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		do {
			System.out.println(" ================================ ");
			System.out.println("  SISTEMA DE GESTION DE CLIENTES ");
			System.out.println(" ================================ ");
			System.out.println(" -> 1.- Almacenar Cliente        ");
			System.out.println(" -> 2.- Almacenar Profesional    ");
			System.out.println(" -> 3.- Almacenar Administrativo ");
			System.out.println(" -> 4.- Almacenar Capacitación   ");
			System.out.println(" -> 5.- Eliminar Usuario         ");
			System.out.println(" -> 6.- Listar Usuarios          ");
			System.out.println(" -> 7.- Listar Usuarios por Tipo ");
			System.out.println(" -> 8.- Listar Capacitaciones    ");
			System.out.println(" -> 9.- Salir                    ");
			System.out.println(" ================================ ");
			opcion = leer.nextInt();

			leer.nextLine();
			switch (opcion) {
			case 1:
				Menu.agregarCliente(contenedor);
				break;
			case 2:
				Menu.agregarProfesional(contenedor);
				break;
			case 3:
				Menu.agregarAdministrativo(contenedor);
				break;
			case 4:
				if (contenedor.listaAsesorias.size() > 0) {
					Menu.agregarCapacitacion(contenedor);
				} else {
					System.out.println("No existe usuarios para capacitaciones");
				}
				break;
			case 5:
				Menu.eliminarUsuarioFinal(contenedor);
				break;
			case 6:
				Menu.listarUsuarios(contenedor);
				break;
			case 7:
				Menu.listarPorTipo(contenedor);
				break;
			case 8:
				Menu.listarCapacitaciones(contenedor);
				break;
			case 9:
				break;
			default:
				System.out.println("Ingrese opción válida");
				break;
			}
		} while (opcion != 9);
		System.out.println("Saliendo del sistema...");
	}

}