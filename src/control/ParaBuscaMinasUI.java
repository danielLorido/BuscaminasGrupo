package control;

import vista.BuscaMinasUI;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import modelo.Casilla;
import modelo.Coordenada;
import modelo.Desvelador;
import modelo.Marcador;
import modelo.Tablero;
import utiles.Varios;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ParaBuscaMinasUI extends BuscaMinasUI {
	private static final long serialVersionUID = 1L;

	private int tamano = 40;
	// Para la version 2 poner el numero de minas al crear el tablero

	Tablero tablero = new Tablero(tamano);
	Desvelador desvelador = new Desvelador();
	Marcador marcador = new Marcador();
	Casilla casilla = new Casilla();

	public ParaBuscaMinasUI() {
		mntmNuevoJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		crearBotonera(tamano);
		Component[] componentes = pnlBotonera.getComponents();

		for (Component component : componentes) {
			component.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (SwingUtilities.isRightMouseButton(e)) {
						marcador.marcarCasilla((JButton) e.getSource(), tablero, desvelador);
					}
				}
			});

			((JButton) component).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Coordenada coordenada = new Varios().obtenerCoordenada((JButton) component);
					casilla = tablero.getCasilla(coordenada);
					if (!casilla.isMarcada() && !casilla.isMina()) {
						desvelador.desvelarCasillas((JButton) e.getSource(), tablero);
					}
					actualizarBotonera(tamano);
					// System.out.println((component).getName());
					desvelador.explotarMinas((JButton) e.getSource(), tablero, pnlBotonera, componentes);
				}
			});
		}
	}

	/**
	 * Crea el panel y le pone un GridLayout con un tamaño cuadrado, luego crea
	 * un boton con un nombre para cada posicion
	 * 
	 * @param tamano
	 *            El numero de casillas que tendrá el tablero
	 */
	private void crearBotonera(int tamano) {
		pnlBotonera.setLayout(new GridLayout(tamano, tamano));
		botonera = new JButton[tamano][tamano];
		for (int fila = 0; fila < botonera.length; fila++) {
			for (int columna = 0; columna < botonera[fila].length; columna++) {
				Coordenada coordenada = new Coordenada(fila, columna);
				// "btn" + String.valueOf(coordenada.establecerCoordenadas())
				botonera[fila][columna] = new JButton();
				botonera[fila][columna].setName(coordenada.establecerCoordenadas());
				// Borrar despues
//				if (tablero.getCasillas()[fila][columna].isMina()) {
//					botonera[fila][columna].setText("Mina");
//				}
				pnlBotonera.add(botonera[fila][columna]);
			}
		}
	}

	private void actualizarBotonera(int tamano) {
		for (int fila = 0; fila < botonera.length; fila++) {
			for (int columna = 0; columna < botonera[fila].length; columna++) {
				Coordenada coordenada = new Coordenada(fila, columna);
				Casilla casillita = tablero.getCasilla(coordenada);
				if (!casillita.isVelada() && !casillita.isMina() && !casillita.isMarcada()
						&& casillita.getminasAlrededor() > 0) {
					botonera[fila][columna].setText(String.valueOf(casillita.getminasAlrededor()));
				}
				desvelador.darColor(botonera[fila][columna], casillita);
			}
		}
	}
}
