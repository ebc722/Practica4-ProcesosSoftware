package dominio;

import java.io.Serializable;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="Hoteles")
public class Hotel implements Serializable{
	
	@Id
	@GeneratedValue
	private String id;
	
	private String nombre;
	private String direccion;
	private String localidad;
	
	@OneToMany
	@JoinColumn(name="reserva_fk")
	private HashSet<Reserva> reservas;
	
	@OneToMany
	@JoinColumn(name="habitacion_fk")
	private HashSet<TipoHabitacion> habitaciones;
	
	public Hotel(String nombre, String direccion, String localidad, HashSet<TipoHabitacion> habitaciones) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.localidad = localidad;
		this.habitaciones = habitaciones;
		reservas = new HashSet<Reserva>();
		habitaciones = new HashSet<TipoHabitacion>();
	}
	
	public Hotel() {}

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
