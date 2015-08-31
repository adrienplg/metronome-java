package controle.detecteurs.detectionClavier;

import controle.Controle;
import controle.detecteurs.DetectionClavier;
import ihm.Materiel;
import ihm.elements.boutons.StopBtn;

/**
 * Action à réaliser pour la commande "Stop" (ConcreteCommand)
 * Pattern Command Detection Clavier
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class StopCmd {

	private Controle controle;
	private Materiel materiel;
	private DetectionClavier detectionClavier;
	private StopBtn stopBtn;
	
	public StopCmd(){
		controle = Controle.getInstance();
		materiel = Materiel.getInstance();
	}
	
	public void initReferences(){
		detectionClavier = controle.getDetectionClavier();
		stopBtn = materiel.getStopBtn();
	}

	public void execute() {
		// récupération de la valeur du bouton associé
		detectionClavier.setStopIsPressed(stopBtn.isPressed());
	}


}
