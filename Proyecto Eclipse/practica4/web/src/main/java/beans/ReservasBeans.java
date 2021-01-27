package beans;

import javax.ejb.EJB;
import javax.inject.Named;

import dominio.Reserva;
import negocio.IReservaRemoto;

@Named
public class ReservasBeans 
{
	@EJB
	private IReservaRemoto reservRemo;
	
	private String nombre;
	private String dni;
	private String numeroTarjeta;
	
	private Reserva res;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	
	public String doConfirmarReserva()
	{
		
		return "confirmacionReserva.xhtml";
	}
	
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	
}
