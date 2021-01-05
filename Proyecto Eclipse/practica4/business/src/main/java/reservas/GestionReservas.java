package reservas;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import javax.ejb.EJB;
import javax.ejb.Stateless;

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

@Stateless
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

	public void confirmarReserva(Hotel hotel, Reserva reserva) {
		
		//Cálculo del importe
		
		double precioNoches = 0;
		
		long diferencia = reserva.getFechaSalida().getTime() - reserva.getFechaEntrada().getTime();
		
	    long nochesTranscurridas = TimeUnit.DAYS.convert(diferencia, TimeUnit.MILLISECONDS) + 1;
		
	    for(ReservaHabitacion rh : reserva.getHabitacionesReservadas())
	    {
	    	precioNoches += rh.getTipo().getPrecioPorNoche() * rh.getNumHabitaciones();
	    }
	    
	    precioNoches = precioNoches * nochesTranscurridas;
	
		daoReservas.crearReserva(reserva);
		
	}

	public Reserva consultaReserva(Reserva res, Hotel hotel) {

		if(hotel.getReservas().contains(res))
		{
			return res;
		}
		
		return null;
	}

	public boolean cancelaReserva(Reserva res, Hotel hotel) {
		
		Date today = Calendar.getInstance().getTime();
		
		if(hotel.getReservas().contains(res))
		{
			long diferencia = today.getTime() - res.getFechaEntrada().getTime();
			
			long transcurridos = TimeUnit.DAYS.convert(diferencia, TimeUnit.MILLISECONDS);
			
			if(transcurridos < 2)
			{
				return false;
			}
			else
			{
				daoReservas.eliminarReserva(res.getId());
			}
		}
		
		return true;
	}

	public boolean modificarNumeroHabitacionesReserva(Reserva res, TipoHabitacion tipo, int num, Hotel hotel) {
	
		if(hotel.getReservas().contains(res))
		{
			HashSet<ReservaHabitacion> habs = res.getHabitacionesReservadas();
			
			for(ReservaHabitacion rh : habs)
			{
				if(rh.getTipo().equals(tipo) && num < rh.getTipo().getDisponibles() + rh.getNumHabitaciones())
				{
					int dif = num - rh.getNumHabitaciones();
							
					rh.setNumHabitaciones(num);
					
					rh.getTipo().setDisponibles(rh.getTipo().getDisponibles() - dif);
					
					daoReservas.modificarReserva(res);
					
					return true;
				}
			}
		
		}
		
		return false;
	}

	public boolean modificarFechaReserva(Reserva res, Date fechaEntrada, Date fechaSalida, Hotel hotel) {

		if(hotel.getReservas().contains(res))
		{
			res.setFechaEntrada(fechaEntrada);
			res.setFechaSalida(fechaSalida);
			
			daoReservas.modificarReserva(res);
			
			return true;
		}
		
		return false;
		
	}

	public HashSet<Reserva> consultarReservasPeriodo(Date fechaComienzo, Date fechaFin, Hotel hotel) {

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
