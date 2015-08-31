package controle.detecteurs.detectionClavier;

import controle.Controle;
import controle.detecteurs.DetectionClavier;
import ihm.Materiel;
import ihm.elements.boutons.DecBtn;

/**
 * Action � r�aliser pour la commande "Dec" (ConcreteCommand)
 * Pattern Command Detection Clavier
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class DecCmd {

	private Controle controle;
	private Materiel materiel;
	private DetectionClavier detectionClavier;
	private DecBtn decBtn;
	
	public DecCmd(){
		controle = Controle.getInstance();
		materiel = Materiel.getInstance();
	}
	
	public void initReferences(){
		detectionClavier = controle.getDetectionClavier();
		decBtn = materiel.getDecBtn();
	}

	public void execute() {
		// r�cup�ration de la valeur du bouton associ�
		detectionClavier.setDecIsPressed(decBtn.isPressed());
	}

}
