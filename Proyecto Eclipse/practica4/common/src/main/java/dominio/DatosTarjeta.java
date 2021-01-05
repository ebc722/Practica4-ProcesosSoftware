package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="DatosTarjetas")
public class DatosTarjeta implements Serializable
{
	@Id
	@GeneratedValue
	private String numTarjeta;
	
	private String cvc;
	private String mesCaducidad;
	private String añoCaducidad;
	
	@Enumerated(value=EnumType.STRING)
	private TipoTarjeta tipo;

	public DatosTarjeta(String numTarjeta, String cvc, String mesCaducidad, String añoCaducidad, TipoTarjeta tipo) 
	{
		this.numTarjeta = numTarjeta;
		this.cvc = cvc;
		this.mesCaducidad = mesCaducidad;
		this.añoCaducidad = añoCaducidad;
		this.tipo = tipo;
	}
	
	public DatosTarjeta() {}

	public String getNumTarjeta() 
	{
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) 
	{
		this.numTarjeta = numTarjeta;
	}

	public String getCvc() 
	{
		return cvc;
	}

	public void setCvc(String cvc) 
	{
		this.cvc = cvc;
	}

	public String getMesCaducidad() 
	{
		return mesCaducidad;
	}

	public void setMesCaducidad(String mesCaducidad) 
	{
		this.mesCaducidad = mesCaducidad;
	}

	public String getAñoCaducidad() 
	{
		return añoCaducidad;
	}

	public void setAñoCaducidad(String añoCaducidad) 
	{
		this.añoCaducidad = añoCaducidad;
	}

	public TipoTarjeta getTipo() 
	{
		return tipo;
	}

	public void setTipo(TipoTarjeta tipo) 
	{		
		this.tipo = tipo;
	}



}
