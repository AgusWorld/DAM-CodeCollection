package Main;

import java.util.List;
import java.util.Set;

import DAO.JugadorDAO;
import DAO.VideoJocDAO;
import Model.Jugador;
import Model.VideoJoc;

public class MainHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JugadorDAO jDAO = new JugadorDAO();
		VideoJocDAO vDAO = new VideoJocDAO();
		
		
		Jugador jug1 = new Jugador("Adria","Girones",2000);
		Jugador jug2 = new Jugador("Alberto","Rivera",1000);
		Jugador jug3 = new Jugador("Profe","Eloi en bancarrota",50);
		Jugador jug4 = new Jugador("Sara","Con Pasta",10000);
		
		
		VideoJoc j1 = new VideoJoc("Las monas chinas",0, 50) ;
		VideoJoc j2 = new VideoJoc("Among us", 0, 25);
		VideoJoc j3 = new VideoJoc("Outer wilds", 0, 39) ;
		
		jDAO.Insert(jug1);
		jDAO.Insert(jug2);
		jDAO.Insert(jug3);
		jDAO.Insert(jug4);
		
		vDAO.Insert(j1);
		vDAO.Insert(j2);
		vDAO.Insert(j3);
		
		jug1.getVideojoc().add(j1);
		jug1.getVideojoc().add(j2);
		jug2.getVideojoc().add(j1);
		jug3.getVideojoc().add(j3);
		jug3.getVideojoc().add(j2);
		jug4.getVideojoc().add(j3);
		jug4.getVideojoc().add(j2);
		jug4.getVideojoc().add(j1);
		
		jDAO.Update(jug1);
		jDAO.Update(jug2);
		jDAO.Update(jug3);
		jDAO.Update(jug4);
		
		
		List<Jugador>jList = jDAO.listar();
		
        for (Object o : jList) {
        	Jugador jug = (Jugador)o;
        	System.out.println("Jugador:");
        	System.out.println("Nombre: " + jug.getNombre() + ", Apellidos:" + jug.getApellidos() );
        	System.out.println("Juegos:");
        	Set<VideoJoc> juegos =  jug.getVideojoc() ;
        	for (VideoJoc j : juegos) 
        		System.out.println("Nombre juego: " + j.getNombre());
        		
        	
        }
        
        System.out.println("Ver m�todo creado en el DAO");
        List<Jugador>jgenteConPasta = jDAO.ObtenerJugadoresConPasta();
		
        for (Object o : jList) {
        	Jugador jug = (Jugador)o;
        	System.out.println("Jugador:");
        	System.out.println("Nombre: " + jug.getNombre() + ", Apellidos:" + jug.getApellidos() );
        	System.out.println("Juegos:");
        	Set<VideoJoc> juegos =  jug.getVideojoc();
        	for (VideoJoc j : juegos) 
        		System.out.println("Nombre juego: " + j.getNombre());
        		
        	
        }
	}

}
