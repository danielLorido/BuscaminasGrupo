package modelo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import modelo.Tablero;
import utiles.Varios;

public class Marcador {

	Coordenada coordenada;
	int numMarcadas;
	public int getNumMarcadas() {
		return numMarcadas;
	}

	public void setNumMarcadas(int numMarcadas) {
		this.numMarcadas = numMarcadas;
	}

	Casilla casillaActual;
	ImageIcon banderita = new ImageIcon(getClass().getResource("/iconos/flagResized.png"));

	/**
	 * Estableve una casilla como marcada, es decir le pone una bandera o se la
	 * quita
	 * 
	 * @param boton
	 * @param tablero
	 * @param desv
	 */
	public void marcarCasilla(JButton boton, Tablero tablero, Desvelador desv) {
		coordenada = new Varios().obtenerCoordenada(boton);
		casillaActual = tablero.getCasilla(coordenada);
		if (casillaActual.isVelada() && !desv.isJuegoTerminado()) {
			casillaActual.setMarcada(!casillaActual.isMarcada());
			if (casillaActual.isMarcada()) {
				boton.setIcon(banderita);
				numMarcadas++;
			} else {
				boton.setIcon(null);
				numMarcadas--;
			}
		}
	}
}
