package paquete;

import java.util.Arrays;

public class Capacitacion {
    
    private int id;
    private int rutCliente;
    private String dia;
    private String hora;
    private String lugar;
    private double duracion;
    private int cantAsistentes;

    public Capacitacion() {

    }

    public Capacitacion(int id, int rutCliente, String dia, String hora, String lugar, double duracion, int cantAsistentes) {
        setId(id);
        setRutCliente(rutCliente);
        setDia(dia);
        setHora(hora);
        setLugar(lugar);
        setDuracion(duracion);
        setCantAsistentes(cantAsistentes);
    }

    public int getId() {
        return id;
    }

    public final void setId(int id) {
        if(id > 0){
            this.id = id;
        }
    }

    public int getRutCliente() {
        return rutCliente;
    }

    public final void setRutCliente(int rutCliente) {
        if(rutCliente > 0){
            this.rutCliente = rutCliente;
        }
    }

    public String getDia() {
        return dia;
    }

    public final void setDia(String dia) {
        String[] diasDeSemana = {"lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo"};
        if(Arrays.asList(diasDeSemana).contains(dia.toLowerCase())){
            this.dia= dia;
        }
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        if(hora.matches("^(?:\\d|[01]\\d|2[0-3]):[0-5]\\d$")){
            this.hora = hora;
        }
    }

    public String getLugar() {
        return lugar;
    }

    public final void setLugar(String lugar) {
        if(lugar.length() >= 10 && lugar.length() <= 50){
            this.lugar = lugar;
        }
    }

    public double getDuracion() {
        return duracion;
    }

    public final void setDuracion(double duracion) {
        if(duracion > 0){
            this.duracion = duracion;
        }
    }

    public int getCantAsistentes() {
        return cantAsistentes;
    }

    public final void setCantAsistentes(int cantAsistentes) {
        if(cantAsistentes > 0 && cantAsistentes < 1000){
            this.cantAsistentes = cantAsistentes;
        }
    }

    

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Capacitacion [id=");
		builder.append(id);
		builder.append(", rutCliente=");
		builder.append(rutCliente);
		builder.append(", dia=");
		builder.append(dia);
		builder.append(", hora=");
		builder.append(hora);
		builder.append(", lugar=");
		builder.append(lugar);
		builder.append(", duración=");
		builder.append(duracion);
		builder.append(", cantAsistentes=");
		builder.append(cantAsistentes);
		builder.append("]");
		return builder.toString();
	}

	public String mostrarDetalle(){
        return "La capacitación será en " + this.lugar + " a las " + this.hora + " del día " + this.dia
                + " y durará " + this.duracion * 60 + " minutos";
    }
}
