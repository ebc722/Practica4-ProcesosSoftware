package dominio;

public class DatosTarjeta 
{
	private String numTarjeta;
	private String cvc;
	private String mesCaducidad;
	private String a�oCaducidad;
	private TipoTarjeta tipo;

	public DatosTarjeta(String numTarjeta, String cvc, String mesCaducidad, String a�oCaducidad, TipoTarjeta tipo) 
	{
		this.numTarjeta = numTarjeta;
		this.cvc = cvc;
		this.mesCaducidad = mesCaducidad;
		this.a�oCaducidad = a�oCaducidad;
		this.tipo = tipo;
	}

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

	public String getA�oCaducidad() 
	{
		return a�oCaducidad;
	}

	public void setA�oCaducidad(String a�oCaducidad) 
	{
		this.a�oCaducidad = a�oCaducidad;
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
