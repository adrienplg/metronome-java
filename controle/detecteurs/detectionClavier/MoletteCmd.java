package controle.detecteurs.detectionClavier;

import controle.Controle;
import controle.detecteurs.DetectionMolette;
import ihm.Materiel;
import ihm.elements.Molette;

/**
 * Action à réaliser pour la commande "Molette" (ConcreteCommand)
 * Pattern Command Detection Clavier
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class MoletteCmd {

	private Controle controle;
	private Materiel materiel;
	private DetectionMolette detectionMolette;
	private Molette molette;
	
	public MoletteCmd(){
		controle = Controle.getInstance();
		materiel = Materiel.getInstance();
	}
	
	public void initReferences(){
		detectionMolette = controle.getDetectionMolette();
		molette = materiel.getMolette();
	}
	
	public void execute() {
		// récupération de la valeur du bouton associé
		detectionMolette.setValeurMolette(molette.getValeurMolette());
	}

}
