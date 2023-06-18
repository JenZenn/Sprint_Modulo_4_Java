package paquete;

import java.util.ArrayList;
import java.util.List;

public class Contenedor {
	public List<Asesoria> listaAsesorias = new ArrayList<>();
	public List<Capacitacion> listaCapacitacion = new ArrayList<>();
	public int idCapacitacion = 1;

	public Contenedor() {
	}

	public void almacenarCliente(Usuario cliente) {
		listaAsesorias.add(cliente);
	}

	public void almacenarProfesional(Usuario profesional) {
		listaAsesorias.add(profesional);
	}

	public void almacenarAdministrativo(Usuario administrativo) {
		listaAsesorias.add(administrativo);
	}

	public void eliminarUsuario(String rut) {
		try {
			Usuario usuarioBorrar = null;
			int rutNumero = Integer.parseInt(rut);
			for (int i = 0; i < listaAsesorias.size(); i++) {
				Usuario usuario = (Usuario) listaAsesorias.get(i);
				if (usuario.getRun() == rutNumero) {
					usuarioBorrar = usuario;
				}
			}
			if (usuarioBorrar != null) {
				listaAsesorias.remove(usuarioBorrar);
			}
		} catch (Exception excepcion) {
			System.out.println("Error convirtiendo el rut a número");
		}
	}

	public void listarUsuario(int rut) {
		for (int i = 0; i < listaAsesorias.size(); i++) {
			Usuario usuario = (Usuario) listaAsesorias.get(i);
			if (usuario.getRun() == rut) {
				System.out.println(usuario.toString());
			}
		}
	}

	public void listarUsuarios() {
		if (listaAsesorias.size() == 0) {
			System.out.println("No hay usuarios a listar.");
		} else {
			System.out.println("LISTA DE USUARIOS:");
			System.out.print(" | ");
			System.out.printf("%-3s", "ID");
			System.out.printf("%-50s", "NOMBRE");
			System.out.printf("%-13s", "FECHA NAC.");
			System.out.printf("%-11s", "RUT");
			System.out.printf("%-2s", "|");
			System.out.println();

			for (int i = 0; i < listaAsesorias.size(); i++) {
				Usuario user = (Usuario) listaAsesorias.get(i);
				System.out.print(" | ");
				System.out.printf("%-3s", i + 1);
				System.out.printf("%-50s", user.getNombre());
				System.out.printf("%-13s", user.getFechaNacimiento());
				System.out.printf("%-11s", user.getRun());
				System.out.printf("%-2s", "|");
				System.out.println();
			}
		}
	}

	public void listaTipoUsuario(Class<?> clase) {
		int contador = 0;
		for (Asesoria iAsesoria : listaAsesorias) {
			if (iAsesoria.getClass().equals(clase)) {
				System.out.println(iAsesoria.toString());
				contador++;
			}
		}
		if (contador == 0) {
			System.out.println("No hay usuarios del tipo " + clase.getSimpleName());
		}
	}

	public void listarCapacitaciones() {
		if (listaCapacitacion.size() == 0) {
			System.out.println("No hay capacitaciones a listar.");
		} else {
			for (Capacitacion capacitacion : listaCapacitacion) {
				System.out.println(capacitacion.mostrarDetalle());
				listarUsuario(capacitacion.getRutCliente());
				System.out.println();
			}
		}
	}

	public Usuario ExisteUsuario(int rut) {
		for (int i = 0; i < listaAsesorias.size(); i++) {
			Usuario usuario = (Usuario) listaAsesorias.get(i);
			if (usuario.getRun() == rut) {
				return usuario;
			}
		}
		return null;
	}

}
