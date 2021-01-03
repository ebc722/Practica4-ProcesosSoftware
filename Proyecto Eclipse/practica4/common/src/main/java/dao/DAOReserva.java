package dao;

import java.util.HashSet;

import dominio.Reserva;

public interface DAOReserva {
	public HashSet<Reserva> obtenerReservas();
	
	public Reserva obtenerReserva(String id);
	
	public Reserva crearReserva(Reserva r);

	public boolean modificarReserva(String idReservaVieja, Reserva reservaNueva);

	public boolean eliminarReserva(String id);
}
