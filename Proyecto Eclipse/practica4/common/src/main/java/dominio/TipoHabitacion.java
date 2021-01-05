package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="TipoHabitaciones")
public class TipoHabitacion implements Serializable{
	
	@Id
	@GeneratedValue
	private String id;
	
	private String nombreHabitacion;
	private String descripcion;
	private int disponibles;
	private double precioPorNoche;
	
	public TipoHabitacion(String nombreHabitacion, String descripcion, int disponibles, double precioPorNoche) {
		this.nombreHabitacion = nombreHabitacion;
		this.descripcion = descripcion;
		this.disponibles = disponibles;
		this.precioPorNoche = precioPorNoche;
	}
	
	public TipoHabitacion() {}
	
	public String getId() {
		return id;
	}

	public String getNombreHabitacion() {
		return nombreHabitacion;
	}

	public void setNombreHabitacion(String nombreHabitacion) {
		this.nombreHabitacion = nombreHabitacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDisponibles() {
		return disponibles;
	}

	public void setDisponibles(int disponibles) {
		this.disponibles = disponibles;
	}

	public double getPrecioPorNoche() {
		return precioPorNoche;
	}

	public void setPrecioPorNoche(double precioPorNoche) {
		this.precioPorNoche = precioPorNoche;
	}
	
	@Override
	public boolean equals(Object o)
	{		
		if(this.nombreHabitacion.equals(((TipoHabitacion) o).getNombreHabitacion()))
		{
			return true;
		}
		
		return false;
	}

}
