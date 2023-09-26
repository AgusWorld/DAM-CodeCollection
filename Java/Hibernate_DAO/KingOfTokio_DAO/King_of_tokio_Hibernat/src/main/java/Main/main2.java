package Main;
import java.util.Collections;
import java.util.HashSet;

import java.util.Scanner;

import DAO.JugadorDAO;
import DAO.MonstreDAO;
import DAO.PartidaDAO;
import Funcions.Funcions;
import HibernateDB.Jugador;
import HibernateDB.Monstre;
import HibernateDB.Partida;

public class main2 {

	/*
	 * 4
Nom1 Cog1
Mon1
Nom2 Cog2
Mon2
Nom3 Cog3
Mon3
Nom4 Cog4
Mon4
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		JugadorDAO jd=new JugadorDAO();
		PartidaDAO pd=new PartidaDAO();
		MonstreDAO md=new MonstreDAO();
		
		Funcions f=new Funcions(jd, pd, md);
		
		System.out.println("Numero de jugadors");
		int njugadors=sc.nextInt();
		String nom;
		String Cognom;
		String NomMonstre;
		Partida p=new Partida(1,njugadors);
		pd.Insert(p);
		
		Monstre mp=new Monstre("Aliento Flamigero");
        Monstre mp2=new Monstre("Mimetismo");
        Monstre mp3=new Monstre("Monstruo con Rayo Reductor");
        Monstre mp4=new Monstre("Monstruo Escupidor de Veneno");
        md.Insert(mp);
        md.Insert(mp2);
        md.Insert(mp3);
        md.Insert(mp4);
		//List<Jugador> jugadores=new ArrayList<Jugador>();
		for (int i = 1; i <= njugadors; i++) {
			System.out.println("Nom i cognom del jugador"+i);
			nom=sc.next();
			Cognom=sc.next();
			Jugador j=new Jugador(nom,Cognom);
			f.jugadores.add(j);
			jd.Insert(j);
			
			
			
			System.out.println("nom Monstres jugador "+i);
			NomMonstre=sc.next();
			Monstre m=new Monstre(NomMonstre, 10, 0, 0, false, false, null);
			md.Insert(m);
			
			j.setMonstre(new HashSet<Monstre>());
			j.getMonstre().add(m);
			m.setIdJugador(j);
			m.setIdPartida(p);
			jd.Update(j);
			md.Update(m);
			pd.Update(p);
		}
		
		
			
		
		
	        
		Boolean acabar=false;
		Collections.shuffle(f.jugadores);
		while (!acabar) {
			f.SetMonstreTokioAleatori();
			f.menu();
			System.out.println("Torn del jugador:"+f.jugadores.get(0).getNom()+" "+f.jugadores.get(0).getCognom());
			int num=(int) (Math.random()*3+1);
			//int num = sc.nextInt();
			switch (num) {
			case 1:
				f.SolveRoll(f.jugadores.get(0));
				acabar=f.AcabaPartida();
				f.PassarTorn();
				break;
			case 2:
				f.SolvePowerCarts(md.get(f.jugadores.get(0).getId_Jugador()+4));
//				System.out.println(md.get(f.jugadores.get(0).getId_Jugador()+4).getNom());
				
				break;
			case 3:
				f.ListMonstresVius();
				break;
			default:
				break;
			}
			f.ActualitzarMonstresVius();
		}
		
		System.out.println("Final del joc");
		
		sc.close();
	}
	
}
