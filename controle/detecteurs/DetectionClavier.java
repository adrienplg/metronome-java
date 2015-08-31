package controle.detecteurs;

import controle.Controle;
import controle.detecteurs.detectionClavier.DecCmd;
import controle.detecteurs.detectionClavier.IncCmd;
import controle.detecteurs.detectionClavier.StartCmd;
import controle.detecteurs.detectionClavier.StopCmd;
import metier.Moteur;
import metier.MoteurImpl;
import ihm.Materiel;

/**
 * Action à réaliser pour la partie détection du coté clavier (Concrete Command)
 * Pattern Command Detection Clavier
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class DetectionClavier {

	private Controle controle;
	private Moteur moteur;
	private Materiel materiel;
	private StartCmd startCmd;
	private StopCmd stopCmd;
	private IncCmd incCmd;
	private DecCmd decCmd;
	boolean startIsPressed;
	boolean stopIsPressed;
	boolean incIsPressed;
	boolean decIsPressed;
	
	public DetectionClavier(){
		controle = Controle.getInstance();
		moteur = MoteurImpl.getInstance();
		materiel = Materiel.getInstance();
	}
	
	public void initReferences(){
		startCmd = controle.getStartCmd();
		stopCmd = controle.getStopCmd();
		incCmd = controle.getIncCmd();
		decCmd = controle.getDecCmd();
	}
	
	public void execute() {
		startCmd.execute();
		stopCmd.execute();
		incCmd.execute();
		decCmd.execute();
		// Délègue le traitement des valeurs récupérées au moteur
		moteur.gestionBoutons();
		// Rafraichit l'affichage de la mesure
		materiel.getAffichage().setMesure(String.valueOf(moteur.getMesure()));
	}

	// Getters/Setters
	public boolean isStartIsPressed() {
		return startIsPressed;
	}

	public boolean isStopIsPressed() {
		return stopIsPressed;
	}

	public boolean isIncIsPressed() {
		return incIsPressed;
	}

	public boolean isDecIsPressed() {
		return decIsPressed;
	}

	public void setStartIsPressed(boolean startIsPressed) {
		this.startIsPressed = startIsPressed;
	}

	public void setStopIsPressed(boolean stopIsPressed) {
		this.stopIsPressed = stopIsPressed;
		// Eteind les LED si le système est stoppé
		if(stopIsPressed){
			materiel.getLedMesure().eteindre();
			materiel.getLedTempo().eteindre();
		}
	}

	public void setIncIsPressed(boolean incIsPressed) {
		this.incIsPressed = incIsPressed;
	}

	public void setDecIsPressed(boolean decIsPressed) {
		this.decIsPressed = decIsPressed;
	}

	
}
