package dominio;

import java.util.HashSet;

public class Hotel {
	private String id;
	private String nombre;
	private String direccion;
	private String localidad;
	private HashSet<Reserva> reservas;
	private HashSet<TipoHabitacion> habitaciones;
	
	public Hotel(String nombre, String direccion, String localidad, HashSet<TipoHabitacion> habitaciones) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.localidad = localidad;
		this.habitaciones = habitaciones;
		reservas = new HashSet<Reserva>();
		habitaciones = new HashSet<TipoHabitacion>();
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public HashSet<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(HashSet<Reserva> reservas) {
		this.reservas = reservas;
	}

	public HashSet<TipoHabitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(HashSet<TipoHabitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	
}
