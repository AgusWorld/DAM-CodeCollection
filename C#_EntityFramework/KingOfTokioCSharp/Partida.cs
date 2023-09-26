using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace KingOfTokioCSharp
{
    internal class Partida
    {
        public int PartidaId { get; set; }
        public int Torn { get; set; }
        public int N_Jugadors { get; set; }
        public virtual ICollection<Monstre> Monstre { get; set; }
        public Partida(int torn, int n_Jugadors)
        {
            Torn = torn;
            N_Jugadors = n_Jugadors;
        }
        public Partida() 
        {
            this.Monstre= new List<Monstre>();
            /*
            Torn= 0;
            N_Jugadors = 0;
            */
        }
    }
}
