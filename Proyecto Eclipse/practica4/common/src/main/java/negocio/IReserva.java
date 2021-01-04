package negocio;

import java.util.Date;

import dominio.*;

public interface IReserva {
	public boolean habitacionesSuficientes(int habitaciones, Hotel hotel, TipoHabitacion tipoHab);
	
	public void confirmarReserva(Hotel hotel, Reserva reserva);

	public Reserva consultaReserva(Reserva res, Hotel hotel);
	
	public boolean cancelaReserva(Reserva res, Hotel hotel);
	
	public boolean modificarNumeroHabitacionesReserva(Reserva res, TipoHabitacion tipo, int num, Hotel hotel);

	public boolean modificarFechaReserva(Reserva res, Date fechaEntrada, Date fechaSalida, Hotel hotel);
}
