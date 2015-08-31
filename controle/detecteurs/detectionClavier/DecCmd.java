package controle.detecteurs.detectionClavier;

import controle.Controle;
import controle.detecteurs.DetectionClavier;
import ihm.Materiel;
import ihm.elements.boutons.DecBtn;

/**
 * Action à réaliser pour la commande "Dec" (ConcreteCommand)
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
		// récupération de la valeur du bouton associé
		detectionClavier.setDecIsPressed(decBtn.isPressed());
	}

}
