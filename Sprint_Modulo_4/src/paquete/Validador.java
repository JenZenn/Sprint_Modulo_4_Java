package paquete;

import java.util.Arrays;
import java.util.Scanner;

public class Validador {
	public static String obtenerDatoValido(Scanner leer, String mensaje, int longitudMinima, int longitudMaxima) {
		String dato;
		do {
			System.out.println(mensaje);
			dato = leer.nextLine().trim();
			if (dato.length() < longitudMinima || dato.length() > longitudMaxima) {
				System.out.println(
						"El dato debe tener entre " + longitudMinima + " y " + longitudMaxima + " caracteres.");
			}
		} while (dato.length() < longitudMinima || dato.length() > longitudMaxima);
		return dato;
	}

	public static String obtenerFechaNacimeinto(Scanner leer, String mensaje, String exRegular) {
		String dato = "";
		do {
			System.out.println(mensaje);
			dato = leer.nextLine().trim();
			if (!dato.matches(exRegular)) {
				System.out.println("Ingrese un dato válido.");
			}
		} while (!dato.matches(exRegular));
		return dato;
	}

	public static int obtenerRutValido(Scanner leer, String mensaje) {
		int rut = 0;
		do {
			System.out.println(mensaje);
			String rutString = leer.nextLine().trim();
			try {
				rut = Integer.parseInt(rutString);
			} catch (NumberFormatException excepcionDeFN) {
				rut = 0;
			} finally {
				if (rut == 0) {
					System.out.println("Ingrese un rut válido");
				} else if (rut > 99999999) {
					System.out.println("El rut máximo es 99.999.999 sin puntos");
				}
			}
		} while (rut > 99999999 || rut <= 0);
		return rut;
	}

	public static String validarEntrada(Scanner leer, int minLength, int maxLength, String mensajeError) {
		String entrada = "";
		do {
			entrada = leer.nextLine().trim();
			if (entrada.length() < minLength || entrada.length() > maxLength) {
				System.out.println(mensajeError);
			}
		} while (entrada.length() < minLength || entrada.length() > maxLength);
		return entrada;
	}

	public static String validarEntrada(Scanner leer, int minLength, int maxLength, String mensajeErrorMin,
			String mensajeErrorMax) {
		String entrada = "";
		do {
			entrada = leer.nextLine().trim();
			if (entrada.length() < minLength) {
				System.out.println(mensajeErrorMin);
			} else if (entrada.length() > maxLength) {
				System.out.println(mensajeErrorMax);
			}
		} while (entrada.length() < minLength || entrada.length() > maxLength);
		return entrada;
	}

	public static String validarFormatoFecha(Scanner leer, String exRegular, String mensajeError) {
		String fecha = "";
		do {
			fecha = leer.nextLine().trim();
			if (!fecha.matches(exRegular)) {
				System.out.println(mensajeError);
			}
		} while (!fecha.matches(exRegular));
		return fecha;
	}

	public static String validarTelefono(Scanner leer) {
		String telefono = "";
		boolean valido = false;
		do {
			valido = false;
			telefono = leer.nextLine().trim();
			try {
				Integer.parseInt(telefono);
				valido = true;
			} catch (NumberFormatException excepcionDeFN) {
				System.out.println("Ingrese solo números para el teléfono");
			}
		} while (telefono.length() < 1 || !valido);
		return telefono;
	}

	public static int validarSistemaSalud(Scanner leer) {
		int sisSalud = 0;
		String sistemaSaludString = "";
		do {
			sistemaSaludString = leer.nextLine();
			try {
				sisSalud = Integer.parseInt(sistemaSaludString);
				if (sisSalud <= 0 || sisSalud > 2) {
					System.out.println("Ingrese valor válido (1 o 2)");
				}
			} catch (NumberFormatException excepcionDeFN) {
				sisSalud = 0;
				System.out.println("Ingrese solo números para el sistema de salud");
			}
		} while (sisSalud <= 0 || sisSalud > 2);
		return sisSalud;
	}

	public static String validarLongitud(Scanner leer, int maxLength, String mensajeError) {
		String entrada = "";
		do {
			entrada = leer.nextLine().trim();
			if (entrada.length() > maxLength) {
				System.out.println(mensajeError);
			}
		} while (entrada.length() > maxLength);
		return entrada;
	}

	public static int validarEdad(Scanner leer) {
		int edad = -1;
		String edadString = "";
		do {
			edadString = leer.nextLine();
			try {
				edad = Integer.parseInt(edadString);
				if (edad < 0 || edad >= 150) {
					System.out.println("Ingrese valor válido! (0 o 149)");
				}
			} catch (NumberFormatException excepcionDeFN) {
				System.out.println("Ingrese solo números para la edad");
			}
		} while (edad < 0 || edad >= 150);
		return edad;
	}

	public static String obtenerEntradaValida1(String mensaje, int minCaracteres, int maxCaracteres, Scanner leer) {
		String entrada;
		do {
			System.out.println(mensaje);
			entrada = leer.nextLine().trim();
			if (entrada.length() < minCaracteres || entrada.length() > maxCaracteres) {
				System.out.println(
						"La entrada debe tener entre " + minCaracteres + " y " + maxCaracteres + " caracteres.");
			}
		} while (entrada.length() < minCaracteres || entrada.length() > maxCaracteres);
		return entrada;
	}

	public static String obtenerEntradaValida(String mensaje, String exRegular, Scanner leer) {
		String entrada;
		do {
			System.out.println(mensaje);
			entrada = leer.nextLine().trim();
			if (!entrada.matches(exRegular)) {
				System.out.println("Ingrese una entrada válida.");
			}
		} while (!entrada.matches(exRegular));
		return entrada;
	}

	public static int obtenerRutValido(String mensaje, Scanner leer) {
		int rut = 0;
		String rutString;
		do {
			System.out.println(mensaje);
			rutString = leer.nextLine().trim();
			try {
				rut = Integer.parseInt(rutString);
			} catch (NumberFormatException excepcionDeFN) {
				rut = 0;
			} finally {
				if (rut == 0) {
					System.out.println("Ingrese un rut válido.");
				} else if (rut > 99999999) {
					System.out.println("El rut máximo es 99999999 sin puntos.");
				}
			}
		} while (rut > 99999999 || rut <= 0);
		return rut;
	}
	
	
	
	
	
	
	public static int obtenerRutValido(Scanner leer, Contenedor contenedor) {
		int rut = 0;
		System.out.println("Ingrese rut del cliente:");
		do {
			String rutString = leer.nextLine().trim();
			try {
				rut = Integer.parseInt(rutString);
			} catch (NumberFormatException excepcionDeFN) {
				rut = 0;
			} finally {
				if (rut == 0) {
					System.out.println("Ingrese rut válido");
				} else if (rut > 99999999) {
					System.out.println("El rut máximo es 99.999.999 sin puntos!");
				}
			}
		} while (rut > 99999999 || rut <= 0);
		Usuario usuario = contenedor.ExisteUsuario(rut);
		return (usuario != null) ? rut : 0;
	}

	public static String obtenerDiaValido(Scanner leer) {
		String[] diasSemana = { "lúnes","lunes", "martes", "miercoles", "jueves", "viernes", "sábado", "domingo" };
		String dia = "";
		System.out.println("Ingrese día de la capacitación. (Ejemplo: Martes)");
		do {
			dia = leer.nextLine().trim();
			if (!Arrays.asList(diasSemana).contains(dia.toLowerCase())) {
				System.out.println("Ingrese día válido. (Ejemplo: Domingo)");
			}
		} while (!Arrays.asList(diasSemana).contains(dia.toLowerCase()));
		return dia;
	}

	public static String obtenerHoraValida(Scanner leer) {
		String horaRegular = "^(?:\\d|[01]\\d|2[0-3]):[0-5]\\d$";
		String hora = "";
		System.out.println("Ingrese hora de la capacitación. Formato (HH:MM)");
		do {
			hora = leer.nextLine().trim();
			if (!hora.matches(horaRegular)) {
				System.out.println("Ingrese una hora válida!");
			}
		} while (!hora.matches(horaRegular));
		return hora;
	}

	public static String obtenerLugarValido(Scanner leer) {
		String lugar = "";
		System.out.println("Ingrese lugar de la capacitación:");
		do {
			lugar = leer.nextLine().trim();
			if (lugar.length() < 10) {
				System.out.println("Nombre del lugar corto");
			} else if (lugar.length() > 50) {
				System.out.println("Nombre del lugar largo");
			}
		} while (lugar.length() < 10 || lugar.length() > 50);
		return lugar;
	}

	public static double obtenerDuracionValida(Scanner leer) {
		double duracion = 0;
		System.out.println("Ingrese duración de la capacitación. (Ejemplo: 1.5)");
		do {
			String duracionString = leer.nextLine().trim();
			try {
				duracion = Double.parseDouble(duracionString);
			} catch (NumberFormatException excepcionDeFN) {
				duracion = 0;
			} finally {
				if (duracion == 0) {
					System.out.println("Ingrese una duración válida");
				}
			}
		} while (duracion <= 0);
		return duracion;
	}

	public static int obtenerCantidadAsistentesValida(Scanner leer) {
		int cantidadAsistentes = 0;
		System.out.println("Ingrese cantidad de asistentes a la capacitación:");
		do {
			String cantidadAsistentesString = leer.nextLine().trim();
			try {
				cantidadAsistentes = Integer.parseInt(cantidadAsistentesString);
			} catch (NumberFormatException excepcionDeFN) {
				cantidadAsistentes = 0;
			} finally {
				if (cantidadAsistentes == 0) {
					System.out.println("Debe tener al menos 1 asistente");
				} else if (cantidadAsistentes >= 1000) {
					System.out.println("Máxima cantidad de asistentes debe ser 999");
				}
			}
		} while (cantidadAsistentes >= 1000 || cantidadAsistentes < 1);
		return cantidadAsistentes;
	}

}
