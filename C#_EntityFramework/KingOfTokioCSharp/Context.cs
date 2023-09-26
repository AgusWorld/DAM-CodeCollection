using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace KingOfTokioCSharp
{
    class Context :DbContext
    {
       
        public Context() :base("tokio") 
        {
            Database.SetInitializer<Context>(new DropCreateDatabaseAlways<Context>());

        
        }
        public DbSet<Partida> Partidas { get; set; }
        public DbSet<Jugador> Jugadors { get; set; }
        public DbSet<Monstre> Monstres { get; set; }
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Monstre>()
                .HasRequired<Partida>(p=>p.Partida)
                .WithMany(m => m.Monstre);

            modelBuilder.Entity<Monstre>()
                .HasRequired<Jugador>(j => j.Jugador)
                .WithMany(m => m.Monstre);

            modelBuilder.Entity<Monstre>()
                .HasOptional(p =>p.monstreasociat)
                .WithOptionalDependent(m => m.monstrei);
        }
    }
}
