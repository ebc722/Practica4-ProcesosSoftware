package negocio;

import java.util.HashSet;

import dominio.Hotel;
import dominio.TipoHabitacion;

public interface IAdministracionHotel {	
	public void modificaPrecioHoteles(Hotel hotel, double precio, HashSet<TipoHabitacion> tipoHabitaciones);
	
	public void anhadeTipoHabitacion(Hotel hotel, TipoHabitacion tipo);
}

