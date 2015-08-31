package controle.detecteurs;

import controle.Controle;
import controle.detecteurs.detectionClavier.MoletteCmd;
import metier.Moteur;
import metier.MoteurImpl;
import ihm.Materiel;

/**
 * Action à réaliser pour la partie détection du coté molette (Concrete Command)
 * Pattern Command Detection Molette
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class DetectionMolette {

	private Controle controle;
	private Moteur moteur;
	private Materiel materiel;
	private MoletteCmd moletteCmd;
	private int valeurMolette;
	
	public DetectionMolette(){
		controle = Controle.getInstance();
		moteur = MoteurImpl.getInstance();
		materiel = Materiel.getInstance();
	}
	
	public void initReferences(){
		moletteCmd = controle.getMoletteCmd();
	}
	
	public void execute() {
		moletteCmd.execute();
		// Informe le moteur de l'information
		moteur.setValeurMolette(valeurMolette);
		// Rafraichit l'affichage du tempo
		materiel.getAffichage().setTempo(String.valueOf(valeurMolette));
	}

	public void setValeurMolette(int valeurMolette) {
		this.valeurMolette = valeurMolette;
	}
	

}
