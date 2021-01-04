package dominio;

import java.util.Date;
import java.util.HashSet;

public class Reserva {
	private String id;
	private Date fechaEntrada;
	private Date fechaSalida;
	private double importe;
	private DatosCliente cliente;
	private DatosTarjeta tarjeta;
	private HashSet<ReservaHabitacion> habitacionesReservadas;
	
	public Reserva(Date fechaEntrada, Date fechaSalida, double importe, DatosCliente cliente,
			DatosTarjeta tarjeta) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.importe = importe;
		this.cliente = cliente;
		this.tarjeta = tarjeta;
		habitacionesReservadas = new HashSet<ReservaHabitacion>();
	} 
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public DatosCliente getCliente() {
		return cliente;
	}

	public void setCliente(DatosCliente cliente) {
		this.cliente = cliente;
	}

	public DatosTarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(DatosTarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public HashSet<ReservaHabitacion> getHabitacionesReservadas() {
		return habitacionesReservadas;
	}

	public void setHabitacionesReservadas(HashSet<ReservaHabitacion> habitacionesReservadas) {
		this.habitacionesReservadas = habitacionesReservadas;
	}
	
}
