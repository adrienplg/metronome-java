package controle.detecteurs.detectionClavier;

import controle.Controle;
import controle.detecteurs.DetectionClavier;
import ihm.Materiel;
import ihm.elements.boutons.StartBtn;

/**
 * Action � r�aliser pour la commande "Start" (ConcreteCommand)
 * Pattern Command Detection Clavier
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class StartCmd {

	private Controle controle;
	private Materiel materiel;
	private DetectionClavier detectionClavier;
	private StartBtn startBtn;
	
	public StartCmd(){
		controle = Controle.getInstance();
		materiel = Materiel.getInstance();
	}
	
	public void initReferences(){
		detectionClavier = controle.getDetectionClavier();
		startBtn = materiel.getStartBtn();
	}
	
	public void execute() {
		// r�cup�ration de la valeur du bouton associ�
		detectionClavier.setStartIsPressed(startBtn.isPressed());
	}


}
