package dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="Reservas")
public class Reserva implements Serializable{
	
	@Id
	@GeneratedValue
	private String id;

	private Date fechaEntrada;
	private Date fechaSalida;
	private double importe;
	
	@OneToOne
	@JoinColumn(name="cliente_fk")
	private DatosCliente cliente;

	@OneToOne
	@JoinColumn(name="tarjeta_fk")
	private DatosTarjeta tarjeta;
	
	@OneToMany
	@JoinColumn(name="habitacionesReservadas_fk")
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
	
	public Reserva() {}
	
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
