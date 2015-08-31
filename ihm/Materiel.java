package ihm;

import ihm.elements.Affichage;
import ihm.elements.EmetteurSonore;
import ihm.elements.EmetteurSonoreImpl;
import ihm.elements.Led;
import ihm.elements.Molette;
import ihm.elements.boutons.DecBtn;
import ihm.elements.boutons.IncBtn;
import ihm.elements.boutons.StartBtn;
import ihm.elements.boutons.StopBtn;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

//import metier.Moteur;
//import metier.MoteurImpl;

/**
 * Classe gérant l'initilisation des composants du package IHM
 * (pattern Singleton)
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class Materiel {
	
	private static Materiel uniqueInstance;
	private JFrame frame;
//	private Moteur moteur;
	private Affichage affichage;
	private Molette molette;
	
	private StartBtn startBtn;
	private StopBtn stopBtn;
	private IncBtn incBtn;
	private DecBtn decBtn;
	
	private Led ledTempo;
	private Led ledMesure;
	
	private EmetteurSonore emetteurSonore;
	
	private Materiel(){}
	
	/**
	 * Récupère l'instance unique du matériel
	 * @return Singleton Materiel
	 */
	public static Materiel getInstance(){
		if (uniqueInstance == null){
			uniqueInstance = new Materiel();
		}
		return uniqueInstance;
	}
	
	/**
	 * Ouvre la fenêtre du programme avec tout les éléments visuels nécessaires
	 */
	public void ouvrirFenetre(){
		frame = new JFrame("Metronome - Caudard Pouligny");
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(startBtn);
		frame.add(stopBtn);
		frame.add(incBtn);
		frame.add(decBtn);
		frame.add((Component) molette);
		frame.add((Component) ledTempo);
		frame.add((Component) ledMesure);
		frame.add(affichage);
		frame.setLocation(200, 200);
		frame.pack();
		frame.setVisible(true);
	}

	// Getters/Setters
//	public void setMoteur(MoteurImpl instance) {
//		this.moteur = instance;
//	}

	public void setStartBtn(StartBtn startBtn) {
		this.startBtn = startBtn;
	}

	public void setStopBtn(StopBtn stopBtn) {
		this.stopBtn = stopBtn;
	}

	public void setIncBtn(IncBtn incBtn) {
		this.incBtn = incBtn;
	}

	public void setDecBtn(DecBtn decBtn) {
		this.decBtn = decBtn;
	}

	public void setAffichage(Affichage affichage) {
		this.affichage = affichage;
	}

	public void setMolette(Molette molette) {
		this.molette = molette;
	}

	public void setLedTempo(Led led) {
		this.ledTempo = led;
	}

	public void setLedMesure(Led led) {
		this.ledMesure = led;
	}
	
	public void setEmetteurSonore(EmetteurSonoreImpl emetteurSonoreImpl) {
		this.emetteurSonore = emetteurSonoreImpl;
	}
	
	/////////////////////////////////////////////////////////////////
	// ACCESSEURS
	/////////////////////////////////////////////////////////////////
//	public Moteur getMoteur() {
//		return moteur;
//	}

	public Affichage getAffichage() {
		return affichage;
	}

	public Molette getMolette() {
		return molette;
	}

	public StartBtn getStartBtn() {
		return startBtn;
	}

	public StopBtn getStopBtn() {
		return stopBtn;
	}

	public IncBtn getIncBtn() {
		return incBtn;
	}

	public DecBtn getDecBtn() {
		return decBtn;
	}

	public Led getLedTempo() {
		return ledTempo;
	}

	public Led getLedMesure() {
		return ledMesure;
	}

	public EmetteurSonore getEmetteurSonore() {
		return emetteurSonore;
	}
	
}
