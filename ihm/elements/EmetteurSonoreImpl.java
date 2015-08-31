package ihm.elements;

/**
 * Emetteur Sonore
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class EmetteurSonoreImpl implements EmetteurSonore {
	
	public EmetteurSonoreImpl(){}
	
	/**
	 * Joue le beep par d�faut du syst�me
	 */
	public void jouerSon(){
		java.awt.Toolkit.getDefaultToolkit().beep();
	}
	
}
