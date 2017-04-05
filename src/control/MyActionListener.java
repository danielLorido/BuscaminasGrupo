package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class MyActionListener implements ActionListener {

	// TODO: Intentar usar esta clase para los eventos
	@Override
	public void actionPerformed(ActionEvent e) {
		Object fuente = e.getSource();
		if (fuente.getClass() == JButton.class) {
			reconoceBoton(e);
		} else {
			comenzarJuego();
		}
	}

	/**
	 * Reconoce la coordenada del boton que he pulsado
	 * 
	 * @param e
	 *            El evento que ha desatado la acción
	 */
	public void reconoceBoton(ActionEvent e) {
		// TODO:
		System.out.println("Boton");
	}

	/**
	 * Debe comenzar un juego desde cero
	 */
	public void comenzarJuego() {
		// TODO:
		System.out.println("Juego");

	}

}
