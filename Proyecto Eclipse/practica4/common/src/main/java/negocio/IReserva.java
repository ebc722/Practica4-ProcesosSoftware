package negocio;

import java.util.Date;
import java.util.HashSet;

import dominio.*;

public interface IReserva {
	public boolean habitacionesSuficientes(int habitaciones, Hotel hotel, TipoHabitacion tipoHab);
	
	public void confirmarReserva(String id, DatosCliente cliente, DatosTarjeta tarjeta, Hotel hotel, Date entrada, Date salida, HashSet<ReservaHabitacion> habitacionesReserva);

	public Reserva consultaReserva(String id, Hotel hotel);
	
	public boolean cancelaReserva(String id, Hotel hotel);
	
	public boolean modificarNumeroHabitacionesReserva(String id, TipoHabitacion tipo, int num, Hotel hotel);

	public boolean modificarFechaReserva(String id, Date fechaEntrada, Date fechaSalida, Hotel hotel);
}
