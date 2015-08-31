package controle.detecteurs.detectionClavier;

import controle.Controle;
import controle.detecteurs.DetectionClavier;
import ihm.Materiel;
import ihm.elements.boutons.IncBtn;

/**
 * Action à réaliser pour la commande "Inc" (ConcreteCommand)
 * Pattern Command Detection Clavier
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class IncCmd {

	private Controle controle;
	private Materiel materiel;
	private DetectionClavier detectionClavier;
	private IncBtn incBtn;
	
	public IncCmd(){
		controle = Controle.getInstance();
		materiel = Materiel.getInstance();
	}
	
	public void initReferences(){
		detectionClavier = controle.getDetectionClavier();
		incBtn = materiel.getIncBtn();
	}

	public void execute() {
		// récupération de la valeur du bouton associé
		detectionClavier.setIncIsPressed(incBtn.isPressed());
	}

}
