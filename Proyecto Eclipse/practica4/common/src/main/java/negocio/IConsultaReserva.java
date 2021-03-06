package negocio;

import dominio.Hotel;
import dominio.Reserva;

import java.util.Date;
import java.util.HashSet;

public interface IConsultaReserva {
	public HashSet<Reserva> consultarReservasPeriodo(Date fechaComienzo, Date fechaFin, Hotel hotel);
}
