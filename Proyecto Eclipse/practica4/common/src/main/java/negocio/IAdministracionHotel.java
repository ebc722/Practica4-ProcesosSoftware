package negocio;

import java.util.HashSet;
import dominio.Hotel;

public interface IAdministracionHotel {	
	public void modificaPrecioHoteles(HashSet<Hotel> hoteles, double precio);
	
	public void anhadeTipoHabitacion(String nombreHabitacion, String descripcion, double precioPorNoche, int disponibles);
}

