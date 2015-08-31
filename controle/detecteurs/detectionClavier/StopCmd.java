package controle.detecteurs.detectionClavier;

import controle.Controle;
import controle.detecteurs.DetectionClavier;
import ihm.Materiel;
import ihm.elements.boutons.StopBtn;

/**
 * Action � r�aliser pour la commande "Stop" (ConcreteCommand)
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
		// r�cup�ration de la valeur du bouton associ�
		detectionClavier.setStopIsPressed(stopBtn.isPressed());
	}


}
