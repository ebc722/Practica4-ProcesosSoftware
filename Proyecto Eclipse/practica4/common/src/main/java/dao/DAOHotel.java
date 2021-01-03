package dao;

import java.util.HashSet;
import dominio.Hotel;

public interface DAOHotel {
	public HashSet<Hotel> obtenerHoteles();
	
	public Hotel obtenerHotel(String id);
	
	public Hotel crearHotel(Hotel h);

	public boolean modificarHotel(Hotel h);

	public boolean eliminarHotel(String id);
}
