package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="ReservaHabitaciones")
public class ReservaHabitacion implements Serializable{
	
	@Id
	@GeneratedValue
	private String id;
	
	private int numHabitaciones;
	
	@OneToOne
	@JoinColumn(name="tipoHab_fk")
	private TipoHabitacion tipo;
	
	public ReservaHabitacion(int numHabitaciones, TipoHabitacion tipo) {
		this.numHabitaciones = numHabitaciones;
		this.tipo = tipo;
	}
	
	public ReservaHabitacion() {}
	
	public String getId() {
		return id;
	}

	public int getNumHabitaciones() {
		return numHabitaciones;
	}

	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}

	public TipoHabitacion getTipo() {
		return tipo;
	}

	public void setTipo(TipoHabitacion tipo) {
		this.tipo = tipo;
	}
	
}
