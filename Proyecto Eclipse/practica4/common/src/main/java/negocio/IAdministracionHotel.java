package negocio;

import java.util.HashSet;

import dominio.Hotel;
import dominio.TipoHabitacion;

public interface IAdministracionHotel {	
	public void modificaPrecioHoteles(Hotel hotel, double precio, HashSet<TipoHabitacion> tipoHabitaciones);
	
	public void anhadeTipoHabitacion(String nombreHabitacion, String descripcion, double precioPorNoche, int disponibles, Hotel hotel);
}

