package metier;

import ihm.Materiel;
import ihm.elements.Affichage;
import ihm.elements.EmetteurSonoreImpl;
import ihm.elements.LedImpl;
import ihm.elements.MoletteImpl;
import ihm.elements.boutons.DecBtn;
import ihm.elements.boutons.IncBtn;
import ihm.elements.boutons.StartBtn;
import ihm.elements.boutons.StopBtn;

import java.awt.Color;

import metier.timers.Routine;

import controle.Controle;
import controle.acteurs.ActionEmetteurSonore;
import controle.acteurs.ActionLed;
import controle.acteurs.ControleActionImpl;
import controle.detecteurs.ControleDetectionImpl;
import controle.detecteurs.DetectionClavier;
import controle.detecteurs.DetectionMolette;
import controle.detecteurs.detectionClavier.DecCmd;
import controle.detecteurs.detectionClavier.IncCmd;
import controle.detecteurs.detectionClavier.MoletteCmd;
import controle.detecteurs.detectionClavier.StartCmd;
import controle.detecteurs.detectionClavier.StopCmd;

/**
 * Initialisation des composants et de leur lancement
 * (pattern Factory)
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class MetronomeFactory {
	
	private static Materiel materiel;
	private static Controle controle;
	private static MoteurImpl moteur;
	private static HorlogeImpl horloge;
	
	private MetronomeFactory(){}
	
	/**
	 * Cr�ation du M�tronome
	 */
	public static void creationMetronome(){
		// R�cup�ration/cr�ation des instances de Singleton
		materiel = Materiel.getInstance();
		controle = Controle.getInstance();
		moteur = MoteurImpl.getInstance();
		horloge = HorlogeImpl.getInstance();
		creerRoutine();
		creerInterface();
		creerControles();
		initReferences();
		// Ouverture de la fen�tre une fois que tous les �l�ments ont �t� cr��s
		materiel.ouvrirFenetre();
		// D�marrage de l'horloge
		horloge.start();
	}
	
	/**
	 * Cr�ation de la routine d'ex�cution employ�e par l'horloge
	 */
	private static void creerRoutine(){
		horloge.setRoutine(new Routine());
	}
	
	/**
	 * Cr�ation de l'ensemble des �l�ments graphiques et sonores du programme
	 */
	private static void creerInterface() {
		creerBoutons();
		creerAffichage();
		creerMolette();
		creerLeds();
		creerEmetteurSonore();
	}
	
	/**
	 * Cr�ation des instances de contr�le
	 */
	private static void creerControles() {
		creerControleDetection();
		creerControleAction();
		creerMoletteCmd();
		creerBoutonsCmd();
		creerDetectionClavier();
		creerDetectionMolette();
		creerActionLed();
		creerActionEmetteurSonore();
	}
	
	/**
	 * Initialisation des r�f�rences d'instances au sein des classes de controle et du moteur
	 */
	private static void initReferences(){
		moteur.initReferences();
		controle.getControleDetection().initReferences();
		controle.getControleAction().initReferences();
		controle.getStartCmd().initReferences();
		controle.getStopCmd().initReferences();
		controle.getIncCmd().initReferences();
		controle.getDecCmd().initReferences();
		controle.getMoletteCmd().initReferences();
		controle.getDetectionClavier().initReferences();
		controle.getDetectionMolette().initReferences();
		controle.getActionLed().initReferences();
		controle.getActionEmetteurSonore().initReferences();
	}

	///////////////////////////////////////////////////////////
	// Fonctions relatives � la cr�ation de l'interface
    ///////////////////////////////////////////////////////////
	
	private static void creerBoutons() {
		materiel.setStartBtn(new StartBtn("Start"));
		materiel.setStopBtn(new StopBtn("Stop"));
		materiel.setIncBtn(new IncBtn("Inc"));
		materiel.setDecBtn(new DecBtn("Dec"));
	}
	private static void creerAffichage() {
		materiel.setAffichage(new Affichage());
	}
	private static void creerMolette() {
		materiel.setMolette(new MoletteImpl());
	}
	private static void creerLeds() {
		materiel.setLedTempo(new LedImpl(Color.green));
		materiel.setLedMesure(new LedImpl(Color.orange));
	}
	
	private static void creerEmetteurSonore() {
		materiel.setEmetteurSonore(new EmetteurSonoreImpl());
	}
	
	///////////////////////////////////////////////////////////
	// Fonctions relatives � la cr�ation de la partie Contr�le
    ///////////////////////////////////////////////////////////

	private static void creerControleDetection() {
		controle.setControleDetection(new ControleDetectionImpl());
	}

	private static void creerControleAction() {
		controle.setControleAction(new ControleActionImpl());
	}

	private static void creerMoletteCmd() {
		controle.setMoletteCmd(new MoletteCmd());
	}
	
	private static void creerBoutonsCmd() {
		controle.setStartCmd(new StartCmd());
		controle.setStopCmd(new StopCmd());
		controle.setIncCmd(new IncCmd());
		controle.setDecCmd(new DecCmd());
	}

	private static void creerDetectionClavier() {
		controle.setDetectionClavier(new DetectionClavier());
	}

	private static void creerDetectionMolette() {
		controle.setDetectionMolette(new DetectionMolette());
	}
	
	private static void creerActionLed() {
		controle.setActionLed(new ActionLed());
	}

	private static void creerActionEmetteurSonore() {
		controle.setActionEmetteurSonore(new ActionEmetteurSonore());
	}
}
