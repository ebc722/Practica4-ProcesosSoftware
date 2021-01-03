package negocio;

import java.util.HashSet;
import dominio.Hotel;

public interface IConsultaHotel {
	public HashSet<Hotel> encuentraHotelesLocalidad(String localidad);
	
	public HashSet<Hotel> encuentraHotelesNombre(String nombreHotel);
}
