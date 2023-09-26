/**
 * 
 */
package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import Model.Jugador;

/**
 * @author IES SABADELL
 *
 */
public class JugadorDAO extends GenericDAO<Jugador, Integer> implements IJugadorDAO {

	public List<Jugador> ObtenerJugadoresConPasta() {
		List <Jugador> entities =this.listar();
		
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			
			List <Jugador> genteConPasta = new ArrayList<Jugador>();
			
			 for (Jugador j : entities) {
		        	if(j.getSaldo() > 500) {
		        		genteConPasta.add(j);
		        	}
		        }
		        session.getTransaction().commit();
			

			return genteConPasta;
		}catch (HibernateException e) {
			e.printStackTrace();
			if (session != null && session.getTransaction() != null) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				session.getTransaction().rollback();
			}
			e.printStackTrace();

		}
		return null;
	}

}
