package modelo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import utiles.Varios;

public class Desvelador {
	JButton botonera[][];
	private int numVeladas;
	private boolean juegoTerminado;
	ImageIcon minita = new ImageIcon(getClass().getResource("/iconos/minaNormalResized.png"));

	/**
	 * 
	 * @param boton
	 * @param tablero
	 */
	public void desvelarCasillas(JButton boton, Tablero tablero) {
		Coordenada coordenada = new Varios().obtenerCoordenada(boton);
		Casilla casilla = tablero.getCasilla(coordenada);
		if (casilla.isMina()) {
			boton.setIcon(minita);
			// Tendría que explotar todas, desactivar el tablero y acabar el
			// juego y darlo como perdido
		} else if (casilla.isVelada() && !casilla.isMarcada()) {
			if (casilla.getminasAlrededor() == 0 && !casilla.isMina()) {
				desvelarContiguas(casilla, tablero, coordenada.getX(), coordenada.getY());
			} else {
				boton.setText(String.valueOf(casilla.getminasAlrededor()));
			}
			casilla.setVelada(false);
			numVeladas--;
			darColor(boton, casilla);
		}
	}

	/**
	 * Le asigna un color y una fuente al boton que hemos pulsado
	 * 
	 * @param boton
	 *            El boton al que le vamos a dar el estilo
	 * @param casilla
	 *            Para obtener el numero de minas adyacentes
	 */
	public void darColor(JButton boton, Casilla casilla) {
		if (!casilla.isVelada()) {
			boton.setFont(new Font("Comic Sans MS", Font.CENTER_BASELINE, 10));
			boton.setHorizontalAlignment(SwingConstants.CENTER);
			boton.setBackground(Color.LIGHT_GRAY);
			switch (casilla.getminasAlrededor()) {
			case 1:
				boton.setForeground(Color.BLUE);
				break;
			case 2:
				boton.setForeground(Color.YELLOW);
				break;
			case 3:
				boton.setForeground(Color.RED);
				break;
			case 4:
				boton.setForeground(Color.PINK);
				break;
			case 5:
				boton.setForeground(Color.ORANGE);
				break;
			case 6:
				boton.setForeground(Color.BLACK);
				break;
			case 7:
				boton.setForeground(Color.GREEN);
				break;
			default:
				boton.setBackground(Color.CYAN);
				break;
			}
		}

	}

	/**
	 * Explotar todas las minas cuando pulsas en una mina
	 * 
	 * @param boton
	 * @param tablero
	 * @param panel
	 * @param componente
	 */
	public void explotarMinas(JButton boton, Tablero tablero, JPanel panel, Component[] componente) {
		Coordenada coordenada = new Varios().obtenerCoordenada(boton);
		Casilla casilla = tablero.getCasilla(coordenada);

		if (casilla.isMina()) {
			componente = panel.getComponents();
			for (int i = 0; i < componente.length; i++) {
				// if (new){
				// utiles.Varios().obtenerCoordenada(((JButton)componente))) {
				//
				// }
				componente[i].setEnabled(false);
			}
			juegoTerminado = true;
		}
	}

	/**
	 * Debe desvelar las casillas de alrededor de la casilla indicada, en caso
	 * de que sea agua deberá hacer la recursividad
	 * 
	 * @param tablero
	 * @param casilla
	 * @param columna
	 * @param fila
	 */
	public void desvelarContiguas(Casilla casilla, Tablero tablero, int fila, int columna) {
		if (casilla.getminasAlrededor() > 0 && !casilla.isMina()) {
			casilla.setVelada(false);
			numVeladas--;
		} else {
			int[][] adyacentes = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, /* Mina */ { 0, 1 }, { 1, -1 },
					{ 1, 0 }, { 1, 1 } };
			// System.out.println("Col: " + columna);
			// System.out.println("Fil: " + fila);
			// System.out.println("-------Adyacentes------");
			for (int i = 0; i < adyacentes.length; i++) {
				int filaNueva = fila + adyacentes[i][0];
				int columnaNueva = columna + adyacentes[i][1];
				if (validarCordenada(columnaNueva, filaNueva, tablero)) {
					// System.out.print(columnaNueva + " - " + filaNueva);
					// System.out.println();
					Coordenada coordenadaNueva = new Coordenada(filaNueva, columnaNueva);
					Casilla casillaNueva = tablero.getCasilla(coordenadaNueva);
					if (casillaNueva.isVelada() && !casillaNueva.isMarcada()) {
						casillaNueva.setVelada(false);
						numVeladas--;
						if (casillaNueva.getminasAlrededor() == 0) {
							desvelarContiguas(casillaNueva, tablero, filaNueva, columnaNueva);
						}

					}

				}

			}

		}
	}

	/**
	 * Comprueba que una casilla en una fila y una columna especifica existe en
	 * el tablero
	 * 
	 * @param columna
	 * @param fila
	 * @param tablero
	 * @return true si existe o false en caso contrario
	 */
	private boolean validarCordenada(int columna, int fila, Tablero tablero) {
		if (columna >= 0 && columna < tablero.getTamano() && fila >= 0 && fila < tablero.getTamano()) {
			return true;
		}
		return false;
	}

	/**
	 * Comprueba si el numero de minas en el tablero corresponde a las casillas
	 * tapadas con una mina
	 * 
	 * @return true si has ganado el juego o false en caso contrario
	 */
	public boolean comprobarGanador(Tablero tablero, Marcador marcador) {

		if (numVeladas == tablero.getNumMinasTotales() || marcador.getNumMarcadas() == tablero.getNumMinasTotales()) {
			System.out.println("has ganado");
			return true;
		}
		return false;
	}

	public boolean isJuegoTerminado() {
		return juegoTerminado;
	}

	public void setJuegoTerminado(boolean juegoTerminado) {
		this.juegoTerminado = juegoTerminado;
	}

	public int getNumVeladas() {
		return numVeladas;
	}

	public void setNumVeladas(int numVeladas) {
		this.numVeladas = numVeladas;
	}
}
