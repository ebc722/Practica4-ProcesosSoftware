package reservas;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import javax.ejb.EJB;

import dao.DAOReservaRemoto;
import dominio.DatosCliente;
import dominio.DatosTarjeta;
import dominio.Hotel;
import dominio.Reserva;
import dominio.ReservaHabitacion;
import dominio.TipoHabitacion;
import negocio.IConsultaReservaLocal;
import negocio.IConsultaReservaRemoto;
import negocio.IReservaLocal;
import negocio.IReservaRemoto;

public class GestionReservas implements IReservaLocal, IReservaRemoto, IConsultaReservaLocal, IConsultaReservaRemoto{

	@EJB
	DAOReservaRemoto daoReservas;
	
	public boolean habitacionesSuficientes(int habitaciones, Hotel hotel, TipoHabitacion tipoHab) {

		HashSet<TipoHabitacion> habitacionesRecorrer = hotel.getHabitaciones();
		
		for(TipoHabitacion th : habitacionesRecorrer)
		{
			if(th.equals(tipoHab))
			{
				if(th.getDisponibles() >= habitaciones)
				{
					return true;
				}
			}
		}
		
		return false;
	}

	public void confirmarReserva(String id, DatosCliente cliente, DatosTarjeta tarjeta, Hotel hotel, Date entrada, Date salida,
			HashSet<ReservaHabitacion> habitacionesReserva) {
		
		//Cálculo del importe
		
		double precioNoches = 0;
		
		long diferencia = salida.getTime() - entrada.getTime();
		
	    long nochesTranscurridas = TimeUnit.DAYS.convert(diferencia, TimeUnit.MILLISECONDS) + 1;
		
	    for(ReservaHabitacion rh : habitacionesReserva)
	    {
	    	precioNoches += rh.getTipo().getPrecioPorNoche() * rh.getNumHabitaciones();
	    }
	    
	    precioNoches = precioNoches * nochesTranscurridas;

		Reserva res = new Reserva(id, entrada, salida, precioNoches, cliente, tarjeta);
		
		daoReservas.crearReserva(res);
		
	}

	//PENDIENTE
	public Reserva consultaReserva(String id, Hotel hotel) {

		return null;
	}

	public boolean cancelaReserva(String id, Hotel hotel) {
		
		Reserva resComp = daoReservas.obtenerReserva(id);
		
		Date today = Calendar.getInstance().getTime();
		
		if(hotel.getReservas().contains(resComp))
		{
			long diferencia = today.getTime() - resComp.getFechaEntrada().getTime();
			
			long transcurridos = TimeUnit.DAYS.convert(diferencia, TimeUnit.MILLISECONDS);
			
			if(transcurridos < 2)
			{
				return false;
			}
			else
			{
				daoReservas.eliminarReserva(id);
			}
		}
		
		return true;
	}

	public boolean modificarNumeroHabitacionesReserva(String id, TipoHabitacion tipo, int num, Hotel hotel) {

		Reserva reserv = daoReservas.obtenerReserva(id);
		
		HashSet<ReservaHabitacion> habs = reserv.getHabitacionesReservadas();
		
		for(ReservaHabitacion rh : habs)
		{
			if(rh.getTipo().equals(tipo) && num < rh.getTipo().getDisponibles() + rh.getNumHabitaciones())
			{
				int dif = num - rh.getNumHabitaciones();
						
				rh.setNumHabitaciones(num);
				
				rh.getTipo().setDisponibles(rh.getTipo().getDisponibles() - dif);
				
				return true;
			}
		}
		
		daoReservas.modificarReserva(id, reserv);
		
		return false;
	}

	public boolean modificarFechaReserva(String id, Date fechaEntrada, Date fechaSalida, Hotel hotel) {

		Reserva reserv = daoReservas.obtenerReserva(id);
		
		reserv.setFechaEntrada(fechaEntrada);
		reserv.setFechaSalida(fechaSalida);
		
		daoReservas.modificarReserva(id, reserv);
				
		return false;
	}

	public HashSet<Reserva> consultarReservasPeriodo(Date fechaComienzo, Date fechaFin) {

		HashSet<Reserva> reservasActuales = daoReservas.obtenerReservas();
		
		HashSet<Reserva> reservasRango = new HashSet<Reserva>();
		
		for(Reserva r : reservasActuales)
		{
			if(r.getFechaEntrada().compareTo(fechaComienzo) > 0 && fechaFin.compareTo(r.getFechaEntrada()) > 0)
			{
				reservasRango.add(r);
			}
		}
		
		return reservasRango;
	}

}
