package controle.detecteurs.detectionClavier;

import controle.Controle;
import controle.detecteurs.DetectionMolette;
import ihm.Materiel;
import ihm.elements.Molette;

/**
 * Action � r�aliser pour la commande "Molette" (ConcreteCommand)
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
		// r�cup�ration de la valeur du bouton associ�
		detectionMolette.setValeurMolette(molette.getValeurMolette());
	}

}
