package paquete;

import java.util.Scanner;

public class Menu {

	public static void agregarAdministrativo(Contenedor contenedor) {
		Scanner leer = new Scanner(System.in);
		String exRegular = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

		String nombreUsuario = Validador.obtenerDatoValido(leer, "Ingrese el nombre de usuario del administrativo:", 10,
				50);
		String fechaNacimiento = Validador.obtenerFechaNacimeinto(leer, "Ingrese fecha de nacimiento del administrativo:",
				exRegular);
		int rut = Validador.obtenerRutValido(leer, "Ingrese rut del administrativo:");
		String area = Validador.obtenerDatoValido(leer, "Ingrese área del administrativo:", 5, 20);
		String experiencia = Validador.obtenerDatoValido(leer, "Ingrese la experiencia previa del administrativo:", 0,
				100);

		Usuario administrativo = new Administrativo(nombreUsuario, fechaNacimiento, rut, area, experiencia);
		contenedor.almacenarAdministrativo(administrativo);
	}

	public static void agregarCliente(Contenedor contenedor) {
		Scanner leer = new Scanner(System.in);
		String nombreUsuario = "";
		String fechaNacimiento = "";
		String nombres = "";
		String apellidos = "";
		String telefono = "";
		String afp = "";
		String direccion = "";
		String comuna = "";
		String rutString = "";
		String sistemaSaludString = "";
		String edadString = "";
		boolean valido = false;
		String exRegular = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
		int rut = 0;
		int sisSalud = 0;
		int edad = -1;

		System.out.println("Ingrese el nombre de usuario del cliente (10 - 50 caracteres)");
		nombreUsuario = Validador.validarEntrada(leer, 10, 50,
				"El nombre del usuario debe tener entre 10 - 50 caracteres");

		System.out.println("Ingrese fecha de nacimiento del cliente (Formato DD/MM/YYYY)");
		fechaNacimiento = Validador.validarFormatoFecha(leer, exRegular, "Ingrese fecha válida");

		System.out.println("Ingrese rut del cliente sin dígito verificador:");
		rut = Validador.obtenerRutValido(leer, rutString);

		System.out.println("Ingrese nombres de los clientes (5-30 caracteres):");
		nombres = Validador.validarEntrada(leer, 5, 30, "Nombres del cliente cortos", "Nombres del cliente largos");

		System.out.println("Ingrese los apellidos del cliente:");
		apellidos = Validador.validarEntrada(leer, 5, 30, "Apellidos del cliente cortos",
				"Apellidos del cliente largos");

		System.out.println("Ingrese teléfono del cliente:");
		telefono = Validador.validarTelefono(leer);

		System.out.println("Ingrese AFP del cliente (4 - 30 caracteres)");
		afp = Validador.validarEntrada(leer, 4, 30, "Nombre de AFP muy corto", "Nombre de AFP muy largo");

		System.out.println("Ingrese el sistema de salud del cliente. Use 1 para FONASA y 2 para ISAPRE:");
		sisSalud = Validador.validarSistemaSalud(leer);

		System.out.println("Ingrese dirección del cliente:");
		direccion = Validador.validarLongitud(leer, 70, "Dirección muy larga");

		System.out.println("Ingrese comuna del cliente:");
		comuna = Validador.validarLongitud(leer, 50, "Comuna muy larga");

		System.out.println("Ingrese edad del cliente (Máximo 149 años):");
		edad = Validador.validarEdad(leer);

		Usuario cliente = new Cliente(nombreUsuario, fechaNacimiento, rut, nombres, apellidos, telefono, afp, sisSalud,
				direccion, comuna, edad);
		contenedor.almacenarCliente(cliente);
	}

	public static void agregarProfesional(Contenedor contenedor) {
		Scanner leer = new Scanner(System.in);
		String exRegular = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
		
		String nombreUsuario = Validador.obtenerDatoValido(leer, "Ingrese nombre de usuario del profesional:", 10, 50);
		String fechaNacimiento = Validador.obtenerFechaNacimeinto(leer,
				"Ingrese fecha de nacimiento del profesional (Formato DD/MM/YYYY):",exRegular);
		int rut = Validador.obtenerRutValido("Ingrese rut del profesional:", leer);
		String titulo = Validador.obtenerDatoValido(leer,  "Ingrese título del profesional (10 - 50 caracteres):",10, 50);
		String fechaIngreso = Validador.obtenerFechaNacimeinto(leer,
				"Ingrese fecha de ingreso del profesional (Formato DD/MM/YYYY):",exRegular);

		Usuario profesional = new Profesional(nombreUsuario, fechaNacimiento, rut, titulo, fechaIngreso);
		contenedor.almacenarProfesional(profesional);
	}
	
	
	public static void agregarCapacitacion(Contenedor contenedor) {
		Scanner leer = new Scanner(System.in);

		int rut = Validador.obtenerRutValido(leer, contenedor);
		if (rut == 0) {
			System.out.println("Usuario no registrado con dicho rut");
			return;
		}

		String dia = Validador.obtenerDiaValido(leer);
		String hora = Validador.obtenerHoraValida(leer);
		String lugar = Validador.obtenerLugarValido(leer);
		double duracion = Validador.obtenerDuracionValida(leer);
		int cantidadAsistentes = Validador.obtenerCantidadAsistentesValida(leer);

		int id = contenedor.idCapacitacion;
		contenedor.idCapacitacion++;
		Capacitacion capacitacion = new Capacitacion(id, rut, dia, hora, lugar, duracion, cantidadAsistentes);
		contenedor.listaCapacitacion.add(capacitacion);
	}
	
	
	public static void eliminarUsuarioFinal(Contenedor contenedor) {
		String rutString = "";
		int rut = 0;
		
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese rut del usuario a borrar:");
		do {
			rutString = leer.nextLine().trim();
			try {
				rut = Integer.parseInt(rutString);
			} catch (NumberFormatException excepcionDeFN) {
				rut = 0;
			} finally {
				if (rut == 0) {
					System.out.println("Ingrese un rut válido");
				} else if (rut > 99999999) {
					System.out.println("El rut máximo es 99999999 sin puntos");
				}
			}
		} while (rut > 99999999 || rut <= 0);
		
		Usuario usuario = contenedor.ExisteUsuario(rut);
		if (usuario != null) {
			contenedor.eliminarUsuario(rutString);
			System.out.println("Usuario Eliminado... ");
		} else {
			System.out.println("No existe usuario con ese rut en los registros.");
		}
	}
	
	
	
	
	public static void listarUsuarios(Contenedor contenedor) {
		contenedor.listarUsuarios();
	}

	public static void listarPorTipo(Contenedor contenedor) {
		String tipoString = "";
		int tipo = 0;
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese el tipo de usuario a listar.");
		System.out.println("1.- Clientes");
		System.out.println("2.- Profesionales");
		System.out.println("3.- Administrativos");
		do {
			tipoString = leer.nextLine().trim();
			try {
				tipo = Integer.parseInt(tipoString);
			} catch (NumberFormatException excepcionDeFN) {
				tipo = 0;
			} finally {
				if (tipo == 0) {
					System.out.println("Ingrese número válido");
				} else if (tipo < 1 || tipo > 3) {
					System.out.println("Ingrese valores de 1 - 3");
				}
			}
		} while (tipo < 1 || tipo > 3);
		
		switch (tipo) {
		case 1:
			contenedor.listaTipoUsuario(Cliente.class);
			break;
		case 2:
			contenedor.listaTipoUsuario(Profesional.class);
			break;
		case 3:
			contenedor.listaTipoUsuario(Administrativo.class);
			break;
		}
	}

	public static void listarCapacitaciones(Contenedor contenedor) {
		contenedor.listarCapacitaciones();
	}

}
