package test;

import static org.junit.Assert.*;

import java.sql.DatabaseMetaData;

import org.junit.Before;
import org.junit.Test;

import modelo.Casilla;
import modelo.Coordenada;
import modelo.Tablero;

public class TableroTest {
	// int cuadrada;
	// Tablero tablero;
	private Casilla getCasilla(Coordenada coordenada, Casilla[][] casillas) {
		return casillas[coordenada.getX()][coordenada.getY()];
	}

	@Before
	public void setUp() throws Exception {
		// cuadrada = 6;
		// tablero = new Tablero(cuadrada);
	}

	@Test
	public void testGenerarTablero() {
		fail("Not yet implemented");
	}

	@Test
	public void testRellenarNumeros() {
		fail("Not yet implemented");
	}

	@Test
	public void testEnumerarMina() {
		Casilla[][] casillas;
		// Inicializo la matriz
		casillas = new Casilla[3][3];
		// Lo relleno de Casillas
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				casillas[i][j] = new Casilla();
			}
		}
		//Pongo la mina en el medio
		casillas[1][1].setMina(true);

		int[][] adyacentes = { 
				{ 0, 0 }, { 0, 1 }, { 0, 2 },

				{ 1, 0 }, /* MINA */ { 1, 2 },

				{ 2, 0 }, { 2, 1 }, { 2, 2 } };
		
		for (int i = 0; i < adyacentes.length; i++) {
			Coordenada nuevaCoordenada = new Coordenada(adyacentes[i][0], adyacentes[i][1]);
			Casilla nuevaCasilla = getCasilla(nuevaCoordenada, casillas);
			assertTrue(nuevaCasilla.getminasAlrededor() == 1);
		}

	}

	@Test
	public void testValidarCordenada() {
		fail("Not yet implemented");
	}

	@Test
	public void testColocarMinas() {
		fail("Not yet implemented");
	}

}
