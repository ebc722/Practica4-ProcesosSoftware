package hotelesDAO;

import java.util.HashSet;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.DAOHotelLocal;
import dao.DAOHotelRemoto;
import dominio.Hotel;

@Stateless
public class DatosHoteles implements DAOHotelLocal, DAOHotelRemoto{

	@PersistenceContext(unitName="hotelesPU")
	private EntityManager em;
	
	public HashSet<Hotel> obtenerHoteles() {
		HashSet<Hotel> prov = new HashSet<Hotel>();
		
		Query q = em.createNamedQuery("SELECT h FROM Hotel h");
		List<Hotel> hoteles = q.getResultList();
		
		for(Hotel h : hoteles)
		{
			prov.add(h);
		}
		
		return prov;
	}

	public Hotel obtenerHotel(String id) {
		return em.find(Hotel.class, id);
	}

	public Hotel crearHotel(Hotel h) {
		em.persist(h);
		return h;
	}

	public boolean modificarHotel(Hotel hotel) {
		
		if(em.merge(hotel) != null)
		{
			return true;
		}
		
		return false;
	}

	public boolean eliminarHotel(String id) {
		Hotel prov = obtenerHotel(id);
		
		if(prov != null)
		{
			em.remove(prov);
			return true;
		}
		
		return false;
	}

}
