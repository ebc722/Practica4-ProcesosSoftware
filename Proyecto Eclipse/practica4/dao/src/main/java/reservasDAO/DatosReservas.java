package reservasDAO;

import dao.DAOReservaRemoto;
import dominio.Reserva;

import java.util.HashSet;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.DAOReservaLocal;

@Stateless
public class DatosReservas implements DAOReservaLocal, DAOReservaRemoto {

	@PersistenceContext(unitName="hotelesPU")
	private EntityManager em;
	
	public HashSet<Reserva> obtenerReservas() {
		HashSet<Reserva> prov = new HashSet<Reserva>();
		
		Query q = em.createNamedQuery("SELECT h FROM Hotel h");
		List<Reserva> reservas = q.getResultList();
		
		for(Reserva r : reservas)
		{
			prov.add(r);
		}
		
		return prov;

	}

	public Reserva obtenerReserva(String id) {
		return em.find(Reserva.class, id);
	}

	public Reserva crearReserva(Reserva r) {
		
		em.persist(r);
		return r;
	}

	public boolean modificarReserva(Reserva reserva) {

		if(em.merge(reserva) != null)
		{
			return true;
		}
		
		return false;
	}

	public boolean eliminarReserva(String id) {
		Reserva prov = obtenerReserva(id);
		
		if(prov != null)
		{
			em.remove(prov);
			return true;
		}
		
		return false;
	}

}
