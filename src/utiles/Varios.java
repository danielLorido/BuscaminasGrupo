package utiles;

import javax.swing.JButton;

import modelo.Coordenada;

public class Varios {
	/**
	 * Obtengo las coordenadas de un boton a traves de su nombre
	 * 
	 * @param boton
	 *            La coordena que queremos obtener
	 * @return Un objeto Coordenada con sus valores en x e y
	 */
	public Coordenada obtenerCoordenada(JButton boton) {
		String valores = boton.getName();
		Coordenada coordenada = new Coordenada(0, 0);
		coordenada.setX(Integer.valueOf(valores.substring(0, 2)));
		coordenada.setY(Integer.valueOf(valores.substring(2, 4)));
		return coordenada;
	}


}
