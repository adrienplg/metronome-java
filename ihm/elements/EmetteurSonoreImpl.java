package ihm.elements;

/**
 * Emetteur Sonore
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class EmetteurSonoreImpl implements EmetteurSonore {
	
	public EmetteurSonoreImpl(){}
	
	/**
	 * Joue le beep par défaut du système
	 */
	public void jouerSon(){
		java.awt.Toolkit.getDefaultToolkit().beep();
	}
	
}
