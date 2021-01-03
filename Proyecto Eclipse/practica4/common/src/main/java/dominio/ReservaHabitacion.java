package dominio;

public class ReservaHabitacion {
	private int numHabitaciones;
	private TipoHabitacion tipo;
	
	public ReservaHabitacion(int numHabitaciones, TipoHabitacion tipo) {
		this.numHabitaciones = numHabitaciones;
		this.tipo = tipo;
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
