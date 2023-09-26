using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace KingOfTokioCSharp
{
    internal class Program
    {
        static void Main(string[] args)
        {
            List<Jugador> listajugadores = new List<Jugador>(); 
            using (var ctx = new Context()) 
            {
                Jugador j1 = new Jugador("Hang","Chen");
                Jugador j2 = new Jugador("Agustin", "Ramos");
                Jugador j3 = new Jugador("Alex", "Castet");

                Partida p1=new Partida(1,3);

                Monstre m1 = new Monstre("King",10,0,0,true,false);
                Monstre m2 = new Monstre("King2", 10, 0, 0, false, false);
                Monstre m3 = new Monstre("King3", 10, 0, 0, false, false);

                listajugadores.Add(j1);
                listajugadores.Add(j2);
                listajugadores.Add(j3);

                m1.Jugador = j1;
                m2.Jugador = j2;
                m3.Jugador = j3;
                m1.Partida = p1;
                m2.Partida = p1;
                m3.Partida = p1;

             
                ctx.Jugadors.Add(j1);
                ctx.Jugadors.Add(j2);
                ctx.Jugadors.Add(j3);

                ctx.Partidas.Add(p1);

                ctx.Monstres.Add(m1);
                ctx.Monstres.Add(m2);
                ctx.Monstres.Add(m3);

                
                ctx.SaveChanges();
                Console.WriteLine("Escrit OK");

                Console.WriteLine("LLista de monstres");
                List<Monstre> llistamonstres = ctx.Monstres.ToList();

                foreach (Monstre monstre in llistamonstres)
                {
                    Console.WriteLine("Nom: " + monstre.NameMonstre );
                }
                
                Console.ReadKey();


                List<Jugador> jugadorsaPartida = AssignarTorns(ctx, p1);
                while (jugadorsaPartida.Count > 1)
                {
                    
                    foreach (Jugador jugador in jugadorsaPartida)
                    {
                        Console.WriteLine();
                        Monstre monstre = jugador.Monstre.ElementAt(0);
                        if (!monstre.Eliminat && monstre.NumeroVida > 0)
                        {
                            Console.WriteLine("Torn de -> "+jugador.Nom+" | Monstre Assignat -> "+monstre.NameMonstre);
                            Console.WriteLine("Vides -> "+monstre.NumeroVida+" Energia -> "+monstre.NumeroEnergia);
                            if (monstre.monstrei != null)
                                Console.WriteLine("Punts de Victoria -> " + monstre.NumeroPuntsVictoria + " Monstre PoderA -> " + monstre.monstrei.NameMonstre);
                            else
                                Console.WriteLine("Punts de Victoria -> " + monstre.NumeroPuntsVictoria + " Monstre PoderA -> CAP");

                            if (monstre.EstaATokio)
                               Console.WriteLine("A Toquio [*]");
                            else
                                Console.WriteLine("A Toquio [ ]");
                            
                            ResoldreTirada(ctx, jugador);
                        }
                        else
                        {
                            Console.WriteLine(" SALTANT EL TORN DE:");
                            Console.WriteLine("Nom Jugador ->" + jugador.Nom + " | Monstre Assignat ->" + monstre.NameMonstre);
                            Console.WriteLine("Vides ->" + monstre.NumeroVida + " Energia->" + monstre.NumeroEnergia);
                           
                        }
                        Console.ReadKey();
                    }
                    jugadorsaPartida = AssignarTorns(ctx, p1);
                    
                }


            }
        }

        public static List<Jugador> AssignarTorns(Context ctx, Partida partida)
        {
            List<Jugador> listaJ = ctx.Jugadors.ToList();
            List<Jugador> jugadors = new List<Jugador>();
            foreach (Jugador jugador in listaJ)
            {
                Monstre monstre = jugador.Monstre.ElementAt(0);
                if (!monstre.Eliminat && monstre.NumeroVida > 0 && monstre.Partida == partida)
                {
                    jugadors.Add(jugador);
                }
            }
            return jugadors;
        }

        public static List<Jugador> RetornarJugadors(Context ctx)
        {
            List<Jugador> listaJ = ctx.Jugadors.ToList();
            List<Jugador> jugadors = new List<Jugador>();
            foreach (Jugador jugador in listaJ)
            {
                Monstre monstre = jugador.Monstre.ElementAt(0);
                if (!monstre.Eliminat && monstre.NumeroVida > 0)
                {
                    jugadors.Add(jugador);
                }
            }
            return jugadors;
        }

        public static List<int> TiradaDaus()
        {
            List<int> tirades = new List<int>();
            Random rand = new Random();

            for (int i = 0; i < 6; i++)
            {
                int a = rand.Next(1, 7);
                Console.WriteLine(a);
                tirades.Add(a);

            }
            return tirades;
        }

        public static void ResoldreTirada(Context ctx, Jugador jugador)
        {
            List<int> tirada = TiradaDaus();
            Monstre monstreJugador = jugador.Monstre.ElementAt(0);
            int cont1 = 0;
            int cont2 = 0;
            int cont3 = 0;
            foreach (int daus in tirada)
            {
                switch (daus)
                {
                    case 1:
                        cont1++;
                        break;
                    case 2:
                        cont2++;
                        break;
                    case 3:
                        cont3++;
                        break;
                    case 4:// 1 punt d’energia.
                        Console.WriteLine(monstreJugador.NameMonstre + " ha obtingut 1 punt d'energia més.");
                        Console.WriteLine("Energia de "+ monstreJugador.NameMonstre+" PREVIA->"+ monstreJugador.NumeroEnergia);
                        monstreJugador.NumeroEnergia++;
                        ctx.SaveChanges();
                        Console.WriteLine("Energia de " + monstreJugador.NameMonstre + " ACTUAL->" + monstreJugador.NumeroEnergia);
                        break;
                    case 5: //Eliminar 1 vida d’un contrincant   
                        if (monstreJugador.EstaATokio)// SOC A TOQUIO RESTO 1 DE VIDA A LA RESTA
                        {
                            List<Jugador> jugadors = RetornarJugadors(ctx);
                            foreach(Jugador j in jugadors)
                            {
                                Monstre monstretmp=j.Monstre.ElementAt(0);
                                if (!monstretmp.EstaATokio)
                                {
                                    Console.WriteLine("El monstre a toquio " + monstreJugador.NameMonstre + " de " + jugador.Nom + " provoca dany al monstre -> " + monstretmp.NameMonstre + " de " + monstretmp.Jugador.Nom);
                                    Console.WriteLine("Vida previa de " + monstretmp.NameMonstre + " era -> " + monstretmp.NumeroVida);
                                    monstretmp.NumeroVida--;
                                    Console.WriteLine("Vida Actual de " + monstretmp.NameMonstre + " es -> " + monstretmp.NumeroVida);
                                    ctx.SaveChanges();
                                }

                            }
                        }
                        else // NO SOC A TOQUIO RESTO 1 DE VIDA AL QUE HI ES A TOQUIO
                        {
                            List<Jugador> jugadors = RetornarJugadors(ctx);
                            foreach (Jugador j in jugadors)
                            {
                                Monstre monstretmp = j.Monstre.ElementAt(0);
                                if (monstretmp.EstaATokio)
                                {
                                    Console.WriteLine("El monstre "+monstreJugador.NameMonstre+" de "+jugador.Nom+" provoca dany al monstre a toquio -> "+monstretmp.NameMonstre+" de "+ monstretmp.Jugador.Nom);
                                    Console.WriteLine("Vida previa de "+monstretmp.NameMonstre+" era -> "+monstretmp.NumeroVida);
                                    monstretmp.NumeroVida--;
                                    ctx.SaveChanges();
                                    Console.WriteLine("Vida Actual de " + monstretmp.NameMonstre + " es -> " + monstretmp.NumeroVida);
                                }
                                    
                            }
                        }
                        break;
                    case 6:// 1 punt de vida.
                        if (monstreJugador.NumeroVida < 10)
                        {
                            Console.WriteLine(monstreJugador.NameMonstre + " ha obtingut 1 vida més.");
                            Console.WriteLine("Vides de " + monstreJugador.NameMonstre + " PREVIES->" + monstreJugador.NumeroVida);
                            monstreJugador.NumeroVida++;
                            ctx.SaveChanges();
                            Console.WriteLine("Vides de " + monstreJugador.NameMonstre + " ACTUALS->" + monstreJugador.NumeroVida);
                        }
                        else
                            Console.WriteLine(monstreJugador.NameMonstre + " ja té 10 vides, no se li afegeix cap.");
                        break;

                }
            }


        }


    }
}
