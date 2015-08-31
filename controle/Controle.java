package controle;

import controle.acteurs.ActionEmetteurSonore;
import controle.acteurs.ActionLed;
import controle.acteurs.ControleAction;
import controle.acteurs.ControleActionImpl;
import controle.detecteurs.ControleDetection;
import controle.detecteurs.ControleDetectionImpl;
import controle.detecteurs.DetectionClavier;
import controle.detecteurs.DetectionMolette;
import controle.detecteurs.detectionClavier.DecCmd;
import controle.detecteurs.detectionClavier.IncCmd;
import controle.detecteurs.detectionClavier.MoletteCmd;
import controle.detecteurs.detectionClavier.StartCmd;
import controle.detecteurs.detectionClavier.StopCmd;

/**
 * Classe gérant l'initilisation des composants du package Controle
 * (pattern Singleton)
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class Controle {

	private static Controle uniqueInstance;
	
	private ControleDetection controleDetection;
	private ControleAction controleAction;
	
	private DetectionClavier detectionClavier;
	private DetectionMolette detectionMolette;
	
	private ActionLed actionLed;
	private ActionEmetteurSonore actionEmetteurSonore;
	
	private MoletteCmd moletteCmd;
	private StartCmd startCmd;
	private StopCmd stopCmd;
	private IncCmd incCmd;
	private DecCmd decCmd;
	
	private Controle(){}
	
	/**
	 * Récupère l'instance unique du controle
	 * @return Singleton Controle
	 */
	public static Controle getInstance(){
		if (uniqueInstance == null){
			uniqueInstance = new Controle();
		}
		return uniqueInstance;
	}

	// Getters/Setters	
	public void setControleDetection(ControleDetectionImpl controleDetectionImpl) {
		this.controleDetection = controleDetectionImpl;
	}

	public void setControleAction(ControleActionImpl controleActionImpl) {
		this.controleAction = controleActionImpl;
	}

	public void setDetectionClavier(DetectionClavier detectionClavier) {
		this.detectionClavier = detectionClavier;
	}

	public void setDetectionMolette(DetectionMolette detectionMolette) {
		this.detectionMolette = detectionMolette;
	}
	
	public void setActionLed(ActionLed actionLed) {
		this.actionLed = actionLed;
	}

	public void setActionEmetteurSonore(ActionEmetteurSonore actionEmetteurSonore) {
		this.actionEmetteurSonore = actionEmetteurSonore;
	}
	
	public void setMoletteCmd(MoletteCmd moletteCmd){
		this.moletteCmd = moletteCmd;
	}
	
	public void setStartCmd(StartCmd startCmd) {
		this.startCmd = startCmd;
	}

	public void setStopCmd(StopCmd stopCmd) {
		this.stopCmd = stopCmd;
	}

	public void setIncCmd(IncCmd incCmd) {
		this.incCmd = incCmd;
	}

	public void setDecCmd(DecCmd decCmd) {
		this.decCmd = decCmd;
	}

	/////////////////////////////////////////////////////////////////
	// ACCESSEURS
	/////////////////////////////////////////////////////////////////
	
	public ControleDetection getControleDetection() {
		return controleDetection;
	}

	public ControleAction getControleAction() {
		return controleAction;
	}

	public DetectionClavier getDetectionClavier() {
		return detectionClavier;
	}

	public DetectionMolette getDetectionMolette() {
		return detectionMolette;
	}

	public ActionLed getActionLed() {
		return actionLed;
	}

	public ActionEmetteurSonore getActionEmetteurSonore() {
		return actionEmetteurSonore;
	}

	public MoletteCmd getMoletteCmd() {
		return moletteCmd;
	}

	public StartCmd getStartCmd() {
		return startCmd;
	}

	public StopCmd getStopCmd() {
		return stopCmd;
	}

	public IncCmd getIncCmd() {
		return incCmd;
	}

	public DecCmd getDecCmd() {
		return decCmd;
	}

	

}
