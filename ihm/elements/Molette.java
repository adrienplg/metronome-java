package ihm.elements;

import javax.swing.JSlider;


/**
 * Interface de Molette
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public interface Molette {

	int getValeurMolette();
	// R�cup�ration du slider utile pour les tests unitaires
	public JSlider getSlider();
}
