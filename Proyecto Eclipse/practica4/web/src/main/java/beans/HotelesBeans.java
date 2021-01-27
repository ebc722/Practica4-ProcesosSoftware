package beans;

import java.io.Serializable;
import java.util.HashSet;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import negocio.IConsultaHotelLocal;
import negocio.IConsultaHotelRemoto;
import dominio.Hotel;
import dominio.TipoHabitacion;

@Named
@RequestScoped
public class HotelesBeans
{
	@EJB
	private IConsultaHotelRemoto consultaHotel;
	
	private String nombreHotel;
	private String localidadHotel;
	
	private String fechaEntradaHotel;
	private String fechaSalidaHotel;
	
	private HashSet<Hotel> hoteles;
	
	private Hotel hotelAsignado;

	private HashSet<TipoHabitacion> habitacionesHotel;
	
	public HotelesBeans() {}

	public HashSet<Hotel> getHoteles() {
		return hoteles;
	}

	public void setHoteles(HashSet<Hotel> hoteles) {
		this.hoteles = hoteles;
	}
	
	public Hotel getHotelAsignado() {
		return hotelAsignado;
	}

	public String doTipoParaHotel(Hotel hotelAsignado) {
		this.hotelAsignado = hotelAsignado;
		habitacionesHotel = hotelAsignado.getHabitaciones();
		System.out.println("He llegado");
		return "disponibilidadHoteles.xhtml";
	}
	
	public void setHotelAsignado(Hotel hotelAsignado) {
		this.hotelAsignado = hotelAsignado;
	}

	public String getNombreHotel() {
		return nombreHotel;
	}
	
	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}
	
	public String getLocalidadHotel() {
		return localidadHotel;
	}
	
	public void setLocalidadHotel(String localidadHotel) {
		this.localidadHotel = localidadHotel;
	}
	
	public HashSet<TipoHabitacion> getHabitacionesHotel() {
		return habitacionesHotel;
	}
	
	public String doBuscaHotelLocalidad()
	{
		hoteles = consultaHotel.encuentraHotelesLocalidad(localidadHotel);
		/*HashSet<Hotel> hotels = new HashSet<Hotel>();
		HashSet<TipoHabitacion> tipHabs = new HashSet<TipoHabitacion>();
		tipHabs.add(new TipoHabitacion("Individual","Es individual",3,20.0));
		hotels.add(new Hotel("Hotel 1","Los Castros","Santander",tipHabs));
		hoteles = hotels;*/
		return "hoteles.xhtml";
	}
	
	public IConsultaHotelRemoto getConsultaHotel() {
		return consultaHotel;
	}

	public void setConsultaHotel(IConsultaHotelRemoto consultaHotel) {
		this.consultaHotel = consultaHotel;
	}

	public String getFechaEntradaHotel() {
		return fechaEntradaHotel;
	}

	public void setFechaEntradaHotel(String fechaEntradaHotel) {
		this.fechaEntradaHotel = fechaEntradaHotel;
	}

	public String getFechaSalidaHotel() {
		return fechaSalidaHotel;
	}

	public void setFechaSalidaHotel(String fechaSalidaHotel) {
		this.fechaSalidaHotel = fechaSalidaHotel;
	}

	public void setHabitacionesHotel(HashSet<TipoHabitacion> habitacionesHotel) {
		this.habitacionesHotel = habitacionesHotel;
	}

	public String doBuscaHotelNombre()
	{
		hoteles = consultaHotel.encuentraHotelesNombre(nombreHotel);
		return "hoteles.xhtml";
	}
	
	public String doVerDisponibilidad()
	{
		return "";
	}
}
