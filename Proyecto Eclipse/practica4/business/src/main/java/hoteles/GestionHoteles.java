package hoteles;

import java.util.HashSet;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

import dao.DAOHotelRemoto;
import dominio.Hotel;
import dominio.TipoHabitacion;
import negocio.IAdministracionHotelLocal;
import negocio.IAdministracionHotelRemoto;
import negocio.IConsultaHotelLocal;
import negocio.IConsultaHotelRemoto;

@Stateless
public class GestionHoteles implements IAdministracionHotelLocal, IAdministracionHotelRemoto, IConsultaHotelLocal, IConsultaHotelRemoto {
	
	@EJB
	private DAOHotelRemoto daoHoteles;
	
	public HashSet<Hotel> encuentraHotelesLocalidad(String localidad) {
		
		HashSet<Hotel> hotelesBD = daoHoteles.obtenerHoteles();
		
		HashSet<Hotel> listaHotelesRetornar = new HashSet<Hotel>();
		
		for(Hotel h : hotelesBD)
		{
			System.out.println("La localidad a filtrar es" +localidad);
			System.out.println("La localidad actual es" +h.getLocalidad());
			
			if(h.getLocalidad().equals(localidad))
			{
				System.out.println("He entrado, la localidad a filtrar es" +localidad);
				System.out.println("He entrado, la localidad actual es" +h.getLocalidad());
				listaHotelesRetornar.add(h);
			}
		}
		
		return listaHotelesRetornar;
	}

	public HashSet<Hotel> encuentraHotelesNombre(String nombreHotel) {
		
		HashSet<Hotel> hotelesBD = daoHoteles.obtenerHoteles();
		
		HashSet<Hotel> listaHotelesRetornar = new HashSet<Hotel>();
		
		for(Hotel h : hotelesBD)
		{
			if(h.getNombre().equals(nombreHotel))
			{
				listaHotelesRetornar.add(h);
			}
		}
		
		return listaHotelesRetornar;
	}

	public void modificaPrecioHoteles(Hotel hotel, double precio, HashSet<TipoHabitacion> tipoHabitaciones) {

		HashSet<TipoHabitacion> habitacionesHotel = hotel.getHabitaciones();
		
		for(TipoHabitacion th : habitacionesHotel)
		{
			if(tipoHabitaciones.contains(th))
			{
				th.setPrecioPorNoche(precio);
			}
		}
		
		daoHoteles.modificarHotel(hotel);
	}

	public void anhadeTipoHabitacion(Hotel hotel, TipoHabitacion tipo) {

		HashSet<TipoHabitacion> habitaciones = hotel.getHabitaciones();
		
		habitaciones.add(tipo);
		
		daoHoteles.modificarHotel(hotel);
		
	}

}
