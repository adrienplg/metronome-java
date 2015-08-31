package tests;

import ihm.Materiel;
import metier.MetronomeFactory;
import metier.MoteurImpl;
import controle.Controle;
import junit.framework.TestCase;

public class MoletteTest extends TestCase {
	private Materiel materiel;
	private MoteurImpl moteur;
	private Controle controle;
	private int tempoMin;
	private int tempoMax;
	private int valeurTempo;
	private int valeurRandom;
	
	public MoletteTest(){
		try {
			this.setUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Méthode qui crée l'instance Horloge
	 */
	public void setUp(){
		MetronomeFactory.creationMetronome();
		materiel = Materiel.getInstance();
		moteur = MoteurImpl.getInstance();
		controle = Controle.getInstance();
		tempoMin = 40;
		tempoMax = 200;
	}
	
	/**
	 * Méthode entrainant la fin du test
	 */
	public void tearDown(){
		materiel = null;
		moteur = null;
		controle = null;
	}
	
	/**
	 * Test la bonne prise en compte des changements de position de la molette
	 */
	public void testValeurMolette(){
		// Valeur initiale de la molette
		valeurTempo = moteur.getValeurMolette();
		valeurRandom = valeurTempo;
		// Création d'une valeur de tempo aléatoire différente de la valeur initiale
		while (valeurTempo == valeurRandom){
			valeurRandom = (int)(Math.random() * (tempoMax-tempoMin)) + tempoMin;
		}
		// Modification de la valeur de la molette
		materiel.getMolette().getSlider().setValue(valeurRandom);
		// Envoi de l'information
		controle.getControleDetection().execute();
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		controle.getControleAction().execute();
		// Test : prise en compte du changement côté moteur et affichage
		assertTrue(moteur.getValeurMolette() == valeurRandom);
		assertTrue(Integer.parseInt(materiel.getAffichage().getTempo().getText()) == (valeurRandom));
	}
}
