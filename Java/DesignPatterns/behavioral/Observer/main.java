package Observer;



public class main {

	public static void main(String[] args) {
		 Partida playstation = new Partida();
		 Videojoc videojoc1 = new Videojoc("Tetris");
		 Videojoc videojoc2 = new Videojoc("Bomberman");
		 Videojoc videojoc3 = new Videojoc("Snake");
		 
		 playstation.addPropertyChangeListener(videojoc1);
		 playstation.addPropertyChangeListener(videojoc2);
		 playstation.addPropertyChangeListener(videojoc3);

		 System.out.println("----------------------------------------------------");
		 System.out.println(videojoc1);
		 System.out.println(videojoc2);
		 System.out.println(videojoc3);
		 
		 playstation.setDades("Tetris", "Raul777", 1000);
		 playstation.setDades("Tetris", "Iker", 1000);
		 playstation.setDades("Tetris", "Ivan", 999);
		 playstation.setDades("Minecraft", "Sergi", 10);
		 playstation.setDades("Bomberman", "Juan", 80);
		 playstation.setDades("Snake", "Hang Chen", 696969696);
		 playstation.setDades("Snake", "Alex de Pablo", 696969696);
		 playstation.setDades("ClubPenguin", "Castet", 30);
		 
		 System.out.println("----------------------------------------------------");
		 System.out.println(videojoc1);
		 System.out.println(videojoc2);
		 System.out.println(videojoc3);
		 

	}

}
