using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace KingOfTokioCSharp
{
    internal class Monstre
    {
        public int MonstreId { get; set; }
        public string NameMonstre { get; set; }
        public int NumeroVida { get; set; }
        public int NumeroPuntsVictoria { get; set; }
        public int NumeroEnergia { get; set; }
        public bool EstaATokio { get; set; }
        public bool Eliminat { get; set; }
        public virtual Partida Partida { get; set; }
        public virtual Jugador Jugador { get; set; }
        public virtual Monstre monstrei { get; set; }
        public virtual Monstre monstreasociat { get; set; }
        public Monstre(string nameMonstre, int numeroVida, int numeroPuntsVictoria, int numeroEnergia, bool estaATokio, bool eliminat)
        {
            NameMonstre = nameMonstre;
            NumeroVida = numeroVida;
            NumeroPuntsVictoria = numeroPuntsVictoria;
            NumeroEnergia = numeroEnergia;
            EstaATokio = estaATokio;
            Eliminat = eliminat;
        }
        public Monstre() 
        {
            
        }
    }
}
