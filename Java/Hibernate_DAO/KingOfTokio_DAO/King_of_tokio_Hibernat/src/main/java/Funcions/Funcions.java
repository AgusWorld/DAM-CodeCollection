package Funcions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


import DAO.JugadorDAO;
import DAO.MonstreDAO;
import DAO.PartidaDAO;
import HibernateDB.Jugador;
import HibernateDB.Monstre;

public class Funcions {
	
	JugadorDAO jd;
	PartidaDAO pd;
	MonstreDAO md;
	
	public List<Jugador> jugadores=new ArrayList<Jugador>();
	public Funcions(JugadorDAO jd,PartidaDAO pd,MonstreDAO md) 
	{
		this.jd=jd;
		this.pd=pd;
		this.md=md;
	}
	public Boolean AcabaPartida() 
	{
		//Boolean acabarPartida=false;
		List<Monstre> entities =md.listar();
		
			if (EncaraVius()==1) {
				for (Monstre monstre : entities) {
					if (monstre.getVides() > 0 
		                    && monstre.getIdJugador() != null 
		                    && !monstre.isEliminat()) {
						System.out.println("Monstre gunayador "+ monstre.getNom());
					}
				
			}
				return true;
				
			}
			if(MonstreMaxPunts()>=20) {
				
					for (Monstre monstre : entities) {
						if (monstre.getVictories()==20) {
							System.out.println("Monstre gunayador "+ monstre.getNom());
						}
					
					}
				return true;
				
			}
			else {
				
				return false;
			
		}

	}
	
	public void PassarTorn() 
	{
		jugadores.add(jugadores.size(), jugadores.get(0));
		jugadores.remove(0);
	}
	public int MonstreMaxPunts() 
	{
		List<Monstre> entities =md.listar();
		int maxpunts=0;
		for (Monstre monstre : entities) {
			
			if (monstre.getVictories()>=maxpunts) {
				maxpunts=monstre.getVictories();
			}
		}
		
		for (Monstre monstre : entities) {
			if (maxpunts==monstre.getVictories()) {
				System.out.println("Monstre amb mes Punts "+ monstre.getNom());
			}
		}
		return maxpunts;
	}
	public void menu() 
	{
		System.out.println("\n\n\n-------------------------------------------------------");
		System.out.println("Menu King of Tokio");
		System.out.println("1.Tirada i resoldre la tirada");
		System.out.println("2.Comprar Cartas");
		System.out.println("3.Entrar a Tokio");
		System.out.println("4.Listar Monstres Vius");
	}
	public Boolean HihaMonstreTokio() 
	{
		List<Monstre> entities =md.listar();
		//List<Monstre> monstre=new ArrayList<Monstre>();
		
		Boolean tokio=false;
		
	for(Monstre m :entities) 
	{
		if (m.isEstaATokio() && m.getVides()>0) {
			//monstre.add(m);
			tokio=true;
			
		}else if(m.isEstaATokio() && m.getVides()==0) {
			m.setEstaATokio(false);
			tokio=false;
			
		}
//		else if (m.isEstaATokio()==false) {
//			tokio=false;
//		}
		md.Update(m);
	}
	System.out.println("Monstre viu a Tokio: "+tokio);
	return tokio;	
	}
	public List<Integer> Roll() 
	{
		
		List<Integer> LDaus=new ArrayList<Integer>();
		Random rd=new Random();
		
		for (int i = 0; i < 6; i++) {
			int nrandom=rd.nextInt(6)+1;
			LDaus.add(nrandom);
			System.out.println("Dau numero "+nrandom);
		}
		return LDaus;
		
	}
	public void SolvePowerCarts(Monstre m) 
	{
		List<Monstre> entities =md.listar();
		
		System.out.println("Energia actual de "+m.getNom()+" -> "+m.getEnergia());
		
		if (m.getMonstre_de_poder()==null) {
			ComprarCartes(m);
		}else if (m.getMonstre_de_poder()!=null) {
			
			if (m.getMonstre_de_poder().getIdMonstre()==1) {
				for (Monstre monstre : entities) {
					if(monstre.getIdJugador()!=null) {
					if (monstre.getIdJugador()!=m.getIdJugador()) {
						monstre.setVides(monstre.getVides()-1);
						monstre.setMonstre_de_poder(null);
						md.Update(monstre);
					}}
					
				}
				PassarTorn();
				System.out.println("Esta usant la carta Aliento Flamigero");
				System.out.println("Provoques dany a tothom");
			}
			else if (m.getMonstre_de_poder().getIdMonstre()==2) {
				
				int puntvictoriespropi=m.getVictories();
				int puntvidespropi=m.getVides();
				int puntsvictoriesrival;
				int puntsvidesrival;
				int rivalrandom=(int)Math.random()*2+1;
				System.out.println(" esta usant la carta Mimetismo");
				for (Monstre monstre : entities) {
					if (monstre.getIdJugador()!=null) {
						
					
					if (jugadores.get(rivalrandom).getId_Jugador()==monstre.getIdJugador().getId_Jugador()) {
						puntsvictoriesrival=monstre.getVictories();
						puntsvidesrival=monstre.getVides();
						
						monstre.setVictories(puntvictoriespropi);
						monstre.setVides(puntvidespropi);
						m.setVictories(puntsvictoriesrival);
						m.setVides(puntsvidesrival);
						
						monstre.setMonstre_de_poder(null);
						md.Update(monstre);
						
						System.out.println("Has cambiat Victories-Vides amb el rival -> "+monstre.getNom());
						System.out.println(m.getNom()+": Punts de vida Actuals->"+m.getVides());
						System.out.println(m.getNom()+": Punts de victoria Actuals->"+m.getVictories());
						System.out.println(monstre.getNom()+": Punts de vida Actuals->"+monstre.getVides());
						System.out.println(monstre.getNom()+":Punts de victoria Actuals->"+monstre.getVictories());
					}
				}
				PassarTorn();
				
			}}
			else if (m.getMonstre_de_poder().getIdMonstre()==3) {
				int rivalrandom=(int)Math.random()*2+1;
				System.out.println(" esta usant la carta Monstruo con Rayo Reductor");
				for (Monstre monstre : entities) {
					if(monstre.getIdJugador()!=null) {
					if (jugadores.get(rivalrandom).getId_Jugador()==monstre.getIdJugador().getId_Jugador()) {
						monstre.setVides(monstre.getVides()-1);
						m.setMonstre_de_poder(null);
						md.Update(monstre);
						md.Update(m);
						System.out.println(m.getNom()+" ha tret 1 de vida a "+monstre.getNom());
					}}
				}
				PassarTorn();
				
			}
			else if (m.getMonstre_de_poder().getIdMonstre()==4) {
				int rivalrandom=(int)Math.random()*2+1;
				System.out.println(" esta usant la carta Monstruo Escupidor de Veneno");
				for (Monstre monstre : entities) {
					if(monstre.getIdJugador()!=null) {
					if (jugadores.get(rivalrandom).getId_Jugador()==monstre.getIdJugador().getId_Jugador()) {
						monstre.setVictories(monstre.getVictories()-1);
						monstre.setMonstre_de_poder(null);
						md.Update(monstre);
						System.out.println(m.getNom()+" ha tret 1 punt de vicoria a "+monstre.getNom());
						System.out.println("Punts de victoria de "+monstre.getNom()+" -> "+monstre.getVictories());
					}}
				}
				PassarTorn();
				
			}
			
		}
		
		//md.Update(m);
	}
public List<Monstre> ListMonstrePoderLliures(){
		
		List<Monstre> entities = md.listar();
		ArrayList<Integer> idsAssociats = new ArrayList<Integer>();
		
		//Añado a una array los IDs de monsturo associado de los monstruos con jugador
		for (Monstre monstre : entities) {
			if(monstre.getIdJugador()!=null && monstre.getMonstre_de_poder()!=null) {
				idsAssociats.add(monstre.getMonstre_de_poder().getIdMonstre());
			}
		}
		
		List<Monstre> lliures = new ArrayList<Monstre>();
		
		for (Monstre monstre : entities) {
			if(monstre.getIdJugador()==null //Si no tiene jugador asociado
					&& monstre.getMonstre_de_poder()==null //Si no tiene monsturo de poder associado
					&& !idsAssociats.contains(monstre.getIdMonstre())) {//Si su id no esta en la array de ya asociados
				lliures.add(monstre);
			}
		}
		
		
		return lliures;
	}
	
	public int MonstreLliureMesEconomic() {
		List<Monstre> lliures = ListMonstrePoderLliures();
		int i=10000;
		for (Monstre monstre : lliures) {
			if(i>=PreuMonstre(monstre.getNom()))
				i=PreuMonstre(monstre.getNom());
		}
		
		return i;
	}
	
	public int PreuMonstre(String nom) {
		if(nom.equals("Aliento Flamigero"))
			return 3;
		else if(nom.equals("Mimetismo"))
			return 8;
		else if(nom.equals("Monstruo con Rayo Reductor"))
			return 6;
		else if(nom.equals("Monstruo Escupidor de Veneno"))
			return 4;
		return 1000;
			
	}
		
	public void ComprarCartes(Monstre monstre) {

		List<Monstre> lliures = ListMonstrePoderLliures();
		if(lliures.size()>=1 && MonstreLliureMesEconomic()<=monstre.getEnergia()) 
		{
			int numeroAleatorio = (int) (Math.random() * lliures.size());
			if(PreuMonstre(lliures.get(numeroAleatorio).getNom())<=monstre.getEnergia()) {
				monstre.setMonstre_de_poder(lliures.get(numeroAleatorio));
				monstre.setEnergia(monstre.getEnergia()-PreuMonstre(lliures.get(numeroAleatorio).getNom()));
				System.out.println("COMPRAT-> "+lliures.get(numeroAleatorio).getNom());
				System.out.println(monstre.getNom()+" ara te assignat com a monstre d'energia a "+lliures.get(numeroAleatorio).getNom());
				System.out.println("Energia actual de "+monstre.getNom()+" -> "+monstre.getEnergia());
				md.Update(monstre);
			}else 
				ComprarCartes(monstre);
			
		}
		else if(MonstreLliureMesEconomic()>monstre.getEnergia())
			System.out.println("NO HI TENS SUFICIENT ENERGIA PER COMPRAR EL MES ECONOMIC");
		else 
			System.out.println("NO HI HA MONSTRES DE PODER LLIURES");

	}
	public void ListMostresViusContrincants(int idMonstre)
	{
		List<Monstre> entities =md.listar();
		
		for(Monstre m :entities) 
		{
			if (m.getIdMonstre()== idMonstre ) {
					if(m.getVides()>0) {
						System.out.println("nom del Monstre viu:"+m.getNom());
						
					}else {
						System.out.println("No te cap monstre viu");
					}

			}
			
		}
		
	}
	
	public List<Monstre> ListMostresViusContrincants2(Monstre mon)
	{
		List<Monstre> entities = ListMonstresVius();
		for(Monstre m :entities) {
			if (m == mon ) 
				entities.remove(m);
			else
				System.out.println("Nom del Monstre viu:"+m.getNom());
		}
		return entities;
	}
	
	
	
	
	public void SolveRoll(Jugador j) {
		List<Integer> LDaus = Roll();
		int cont1=0;
		int cont2=0;
		int cont3=0;
		for (int Dau : LDaus) {
			switch (Dau) {
			case 1:
				cont1++;
				break;
			case 2:
				cont2++;
				break;
			case 3:
				cont3++;
				break;
			case 4:
				SumarPuntsEnergia(j);
				System.out.println("Se li ha sumat 1 punt d'energia al monstre del jugador ->"+j.getNom());	
				break;
			case 5:
				System.out.println("Se li ha restat una vida al monstre del jugador ->"+j.getNom());	
				
				EliminarVida(j);
				break;
			case 6:
				System.out.println("Se li ha sumat una vida al monstre del jugador ->"+j.getNom());	
				
				
				SumarVida(j,1);
				break;

			default:
				break;
			}
			if (cont1==3) {
				SumarVictories(j,1);
				System.out.println("Se li ha sumat 1 victoria al monstre del jugador ->"+j.getNom());	
			
			}
			if (cont2==3) {
				SumarVictories(j,2);
				System.out.println("Se li han sumat 2 victories al monstre del jugador ->"+j.getNom());	
				
			}
			if (cont3==3) {
				SumarVictories(j,3);
				System.out.println("Se li han sumat 3 victories al monstre del jugador ->"+j.getNom());	
				
			}
			
		}
		
		
	}
	
	private void SumarPuntsEnergia(Jugador j) {
		List<Monstre> entities =md.listar();
		
		for (Monstre monstre : entities) {
			if(monstre.getIdJugador()!=null) {
			if (j.getId_Jugador()==monstre.getIdJugador().getId_Jugador()) {
				monstre.setEnergia(monstre.getEnergia() + 1);
			}}
			
			md.Update(monstre);
		}
		
	}
	private void EliminarVida(Jugador j) 
	{
		List<Monstre> entities =md.listar();
		boolean jugadorTOkio=false;
		for (Monstre monstre : entities) {
			if(monstre.getIdJugador()!=null) {
				
			if (j.getId_Jugador()==monstre.getIdJugador().getId_Jugador() && monstre.isEstaATokio()) {
				jugadorTOkio=true;
			}
			
			}
			
			
		}
		for (Monstre monstre : entities) {
			if(monstre.getIdJugador()!=null) {
				
			if (jugadorTOkio) {
				if ( !monstre.isEstaATokio() && j.getId_Jugador()!=monstre.getIdJugador().getId_Jugador() && monstre.getVides()>0) {
					monstre.setVides(monstre.getVides()-1);
				}
			}else if(!jugadorTOkio){
				if (monstre.isEstaATokio() && j.getId_Jugador()!=monstre.getIdJugador().getId_Jugador()&& monstre.getVides()>0) {
					monstre.setVides(monstre.getVides()-1);
				}
			}
			
			}
			md.Update(monstre);
			
		}
		
	}
	public int EncaraVius() {
        List<Monstre> entities = md.listar();
        int cont = 0;
        for (Monstre m : entities) {
            if (m.getVides() > 0 
                    && m.getIdJugador() != null 
                    && !m.isEliminat())
                cont++;
        }
        System.out.println(cont);
        return cont;
    }
	public void SetMonstreTokioAleatori() {
        List<Monstre> entitats = md.listar();
        List<Integer> idmonstresvius=new ArrayList<Integer>();
//        Random r = new Random();
//        int MonstreRandom = r.nextInt(EncaraVius())+1;
//        if(!HihaMonstreTokio()) {
//        entitats.get(MonstreRandom).setEstaATokio(true);
//        md.Update(entitats.get(MonstreRandom));
        
        for (Monstre monstre : entitats) {
			if (monstre.getVides() > 0 
                    && monstre.getIdJugador() != null 
                    && !monstre.isEliminat()) {
				idmonstresvius.add(monstre.getIdMonstre());
			}
		}
        Collections.shuffle(idmonstresvius);
        Boolean tokio=HihaMonstreTokio();
        if (!tokio) {
        	for (Monstre monstre : entitats) {
    			if (monstre.getIdMonstre()==idmonstresvius.get(0)) {
    				monstre.setEstaATokio(true);
    				md.Update(monstre);
    			}
    		}
		}
         else {
            System.out.println("Ya hi ha un monstre a Tokio");
        }
        
    }
	private void SumarVictories(Jugador j,int victories) 
	{
		List<Monstre> entities =md.listar();
		for (Monstre monstre : entities) {
			if(monstre.getIdJugador()!=null) {
			if (j.getId_Jugador()==monstre.getIdJugador().getId_Jugador()) {
				monstre.setVictories(monstre.getVictories()+victories);
			}}
			
			md.Update(monstre);
		}
	}
	private void SumarVida(Jugador j,int vides) 
	{
		List<Monstre> entities =md.listar();
		for (Monstre monstre : entities) {
			if(monstre.getIdJugador()!=null) {
			if (j.getId_Jugador()==monstre.getIdJugador().getId_Jugador() && monstre.getVides()<10 && monstre.isEstaATokio()==false) {
				monstre.setVides(monstre.getVides()+vides);
			}}
			
			md.Update(monstre);
		}
	}
	public List<Monstre> ListMonstresVius() {
        List<Monstre> entities = md.listar();
        List<Monstre> MonstresVius = new ArrayList<Monstre>();
        for (Monstre m : entities) {
            if (m.getVides() > 0 && !m.isEliminat()) {
                System.out.println(m.getNom() + " es un monstre viu");
                MonstresVius.add(m);
            }
        }
        return MonstresVius;
    }

    public void ActualitzarMonstresVius() {
        List<Monstre> entities = md.listar();
        for (Monstre m : entities) {
        	if(m.getIdJugador()!=null) {
            if (m.getVides() <= 0) {
                m.setEliminat(true);
                m.setVides(0);
                for (int i = 0; i < jugadores.size(); i++) {
					if (m.getIdJugador().getId_Jugador()==jugadores.get(i).getId_Jugador()) {
						jugadores.remove(i);
					}
				}
               
                md.Update(m);
               
            }}
        }
        for (Monstre monstre : entities) {
			if (monstre.getIdJugador()==null) {
				monstre.setVides(0);
			md.Update(monstre);
			}
			
		}
    }
}

	