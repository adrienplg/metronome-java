package tests;

import controle.Controle;
import ihm.Materiel;
import metier.MetronomeFactory;
import metier.MoteurImpl;
import junit.framework.TestCase;

public class BoutonsTest extends TestCase {
	
	private Materiel materiel;
	private MoteurImpl moteur;
	private Controle controle;
	private int mesureInit;
	
	public BoutonsTest(){
		try {
			this.setUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * M�thode qui cr�e l'instance Horloge
	 */
	public void setUp(){
		MetronomeFactory.creationMetronome();
		materiel = Materiel.getInstance();
		moteur = MoteurImpl.getInstance();
		controle = Controle.getInstance();
	}
	
	/**
	 * M�thode entrainant la fin du test
	 */
	public void tearDown(){
		materiel = null;
		moteur = null;
		controle = null;
	}
	
	/**
	 * Test si le moteur est bien d�marr�/arr�t� une fois le bouton Start/Stop press�
	 */
	public void testStartStop(){
		// Le syst�me est �teind � la cr�ation du moteur
		assertFalse(moteur.isSystemStarted());
		
		// Modification de l'�tat du bouton Start
		materiel.getStartBtn().setPressed(true);
		// Envoi de l'information
		controle.getControleDetection().execute();
		// Test si le bouton Stop est bien relach�
		assertFalse(materiel.getStopBtn().isPressed());
		// Test si le syst�me est d�marr�
		assertTrue(moteur.isSystemStarted());
		
		// Modification de l'�tat du bouton Stop
		materiel.getStopBtn().setPressed(true);
		// Envoi de l'information
		controle.getControleDetection().execute();
		// Test si le bouton Start est bien relach�
		assertFalse(materiel.getStartBtn().isPressed());
		// Test si le syst�me est arr�t�
		assertFalse(moteur.isSystemStarted());
	}
	
	/**
	 * Test de la bonne prise en compte de la pression du bouton Inc
	 */
	public void testPressionInc(){
		// Valeur initiale de la mesure
		mesureInit = moteur.getMesure();
		// Le bouton Inc n'est pas press� au d�marrage
		assertFalse(materiel.getIncBtn().isPressed());
		// Pression du bouton Inc
		materiel.getIncBtn().setPressed(true);
		// Envoi de l'information
		controle.getControleDetection().execute();
		// Test : retour automatique au statut de non press�
		assertFalse(materiel.getIncBtn().isPressed());
		// Test sur la nouvelle mesure: elle est augment�e de 1 c�t� moteur et affichage
		assertTrue(moteur.getMesure() == mesureInit+1);
		assertTrue(Integer.parseInt(materiel.getAffichage().getMesure().getText()) == mesureInit+1);
	}
	
	/**
	 * Test sur la d�sactivation du bouton Inc une fois la mesure maximale atteinte
	 * puis sa r�activation
	 */
	public void testMaxInc(){
		while (materiel.getIncBtn().isEnabled()){
			// Pression du bouton Inc
			materiel.getIncBtn().setPressed(true);
			// Envoi de l'information
			controle.getControleDetection().execute();
		}
		// Le bouton n'est plus disponible si la mesure atteint la valeur maximale
		assertFalse(materiel.getIncBtn().isEnabled());
		// La valeur de la mesure est maximale
		assertTrue(moteur.getMesure() == moteur.getMesureMax());
		
		// Pression du bouton Dec
		materiel.getDecBtn().setPressed(true);
		// Envoi de l'information
		controle.getControleDetection().execute();
		// Le bouton Inc est r�activ�
		assertTrue(materiel.getIncBtn().isEnabled());
	}
	
	/**
	 * Test de la bonne prise en compte de la pression du bouton Dec
	 */
	public void testPressionDec(){
		// Valeur initiale de la mesure
		mesureInit = moteur.getMesure();
		// Le bouton Dec n'est pas press� au d�marrage
		assertFalse(materiel.getDecBtn().isPressed());
		// Pression du bouton Dec
		materiel.getDecBtn().setPressed(true);
		// Envoi de l'information
		controle.getControleDetection().execute();
		// Test : retour automatique au statut de non press�
		assertFalse(materiel.getDecBtn().isPressed());
		// Test sur la nouvelle mesure: elle est diminu�e de 1 c�t� moteur et affichage
		assertTrue(moteur.getMesure() == mesureInit-1);
		assertTrue(Integer.parseInt(materiel.getAffichage().getMesure().getText()) == mesureInit-1);
	}
	
	/**
	 * Test sur la d�sactivation du bouton Dec une fois la mesure minimale atteinte
	 * puis sa r�activation
	 */
	public void testMinDec(){
		while (materiel.getDecBtn().isEnabled()){
			// Pression du bouton Dec
			materiel.getDecBtn().setPressed(true);
			// Envoi de l'information
			controle.getControleDetection().execute();
		}
		// Le bouton n'est plus disponible si la mesure atteint la valeur minimale
		assertFalse(materiel.getDecBtn().isEnabled());
		// La valeur de la mesure est minimale
		assertTrue(moteur.getMesure() == moteur.getMesureMin());
		
		// Pression du bouton Inc
		materiel.getIncBtn().setPressed(true);
		// Envoi de l'information
		controle.getControleDetection().execute();
		// Le bouton Dec est r�activ�
		assertTrue(materiel.getDecBtn().isEnabled());
	}
	
}
