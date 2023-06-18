package paquete;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class Usuario implements Asesoria {

	private String nombre;
	private String fechaNacimiento;
	private int run;

	public Usuario() {
	}

	public Usuario(String nombre, String fechaNacimiento, int run) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.run = run;
	}

	public String getNombre() {
		return nombre;
	}

	public final void setNombre(String nombre) {
		if (nombre.length() >= 10 && nombre.length() <= 50) {
			this.nombre = nombre;
		}
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public final void setFechaNacimiento(String fechaNacimiento) throws ParseException {
		this.fechaNacimiento = new SimpleDateFormat("DD/MM/YYYY").parse(fechaNacimiento).toString();
	}

	public int getRun() {
		return run;
	}

	public final void setRun(int run) {
		if (run < 99999999) {
			this.run = run;
		}
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", run=" + run + "]";
	}

	public String mostrarEdad() {
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("DD/MM/YYYY");
		LocalDate fechaActual = LocalDate.now();
		LocalDate fecha = LocalDate.parse(fechaNacimiento, formateador);
		Period periodo = Period.between(fecha, fechaActual);
		return "El usuario tiene " + periodo.getYears() + " años";
	}

	public String analizarUsuario() {
		return this.nombre + ", " + this.run;
	}
}
