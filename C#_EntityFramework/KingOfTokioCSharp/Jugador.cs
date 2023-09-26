using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace KingOfTokioCSharp
{
    
    internal class Jugador
    {
        public int JugadorID { get; set; }
        public string Nom { get; set; }
        public string Cognom { get; set; }
        public virtual ICollection<Monstre> Monstre { get; set; }

        public Jugador(string nom, string cognom)
        {
            Nom = nom;
            Cognom = cognom;
        }

        public Jugador() 
        {
            this.Monstre = new List<Monstre>();
            /*
            Nom = "";
            Cognom = "";
            */
        }
    }
}
