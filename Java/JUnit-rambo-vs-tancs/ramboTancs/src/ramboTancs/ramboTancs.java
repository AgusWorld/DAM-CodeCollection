package ramboTancs;

import java.util.Scanner;
/**
 * @author AgustinRamos
 * @version 1.0
 */
public class ramboTancs {

	/**
	 * Funcion main que lee las lineas de cada fila de la matriz para después usar
	 * la funcion principal del programa y imprimir por pantalla el resultado
	 */
	public static void main(String[] args) {
		Scanner src = new Scanner(System.in);
		String linea1 = src.nextLine();
		String linea2 = src.nextLine();
		String linea3 = src.nextLine();
		String linea4 = src.nextLine();
		String linea5 = src.nextLine();
		src.close();
		System.out.println(elprograma(linea1, linea2, linea3, linea4, linea5));
	}

	/**
	 * Funcion que añade a cada casilla de la matriz el caracter correspondiente
	 * previamente leido
	 */
	public static String elprograma(String linea1, String linea2, String linea3, String linea4, String linea5) {

		char[][] campo = new char[5][5];

		for (int col = 0; col < 5; col++) {
			campo[0][col] = linea1.charAt(col);
		}
		for (int col = 0; col < 5; col++) {
			campo[1][col] = linea2.charAt(col);
		}
		for (int col = 0; col < 5; col++) {
			campo[2][col] = linea3.charAt(col);
		}
		for (int col = 0; col < 5; col++) {
			campo[3][col] = linea4.charAt(col);
		}
		for (int col = 0; col < 5; col++) {
			campo[4][col] = linea5.charAt(col);
		}

		int impactats = 0;
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 5; col++) {
				if (campo[row][col] == 'X') {
					impactats = comprobar(row, col, campo);
				}
			}
		}
		String tancsimpactats = "Tancs impactats: " + impactats;
		return tancsimpactats;
	}

	/**
	 * Funcion que comprueba si una casilla esta fuera del campo
	 * 
	 * @param row La fila que se está comprobando
	 * @param col La columna que se está comprobando
	 * @return Devuelve true si esta fuera y false si no.
	 */
	static public boolean fuera(int row, int col) {
		boolean fuera = false;
		if ((row >= 5 || row < 0) || (col >= 5 || col < 0)) {
			fuera = true;
		}
		return fuera;
	}

	/**
	 * Funcion que cuenta las 'O' alrededor de la casilla.
	 * 
	 * @param posrow Fila donde está la X.
	 * @param poscol Columna donde está la X.
	 * @param mat    Matriz del campo.
	 * @return
	 */
	static public int comprobar(int posrow, int poscol, char[][] mat) {
		int impactats = 0;
		// ARRIBA-IZQQUIERDA
		if (!fuera(posrow - 1, poscol - 1) && mat[posrow - 1][poscol - 1] == 'O') {
			impactats++;
		}
		// ARRIBA-CENTRO
		if (!fuera(posrow - 1, poscol) && mat[posrow - 1][poscol] == 'O') {
			impactats++;
		}
		// ARRIBA-DERECHA
		if (!fuera(posrow - 1, poscol + 1) && mat[posrow - 1][poscol + 1] == 'O') {
			impactats++;
		}

		// MEDIO-IZQUIERDA
		if (!fuera(posrow, poscol - 1) && mat[posrow][poscol - 1] == 'O') {
			impactats++;
		}
		// MEDIO-DERECHA
		if (!fuera(posrow, poscol + 1) && mat[posrow][poscol + 1] == 'O') {
			impactats++;
		}

		// ABAJO-IZQUIERDA
		if (!fuera(posrow + 1, poscol - 1) && mat[posrow + 1][poscol - 1] == 'O') {
			impactats++;
		}
		// ABAJO-CENTRO
		if (!fuera(posrow + 1, poscol) && mat[posrow + 1][poscol] == 'O') {
			impactats++;
		}
		// ABAJO-DERECHA
		if (!fuera(posrow + 1, poscol + 1) && mat[posrow + 1][poscol + 1] == 'O') {
			impactats++;
		}

		return impactats;
	}

}
