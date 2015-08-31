package tests;

import controle.Controle;
import ihm.Materiel;
import metier.MetronomeFactory;
import metier.MoteurImpl;
import junit.framework.TestCase;

/**
 * Test sur le Singleton MoteurImpl
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class MoteurImplTest extends TestCase{

	protected MoteurImpl moteur;
	private Materiel materiel;
	private Controle controle;
	
	public MoteurImplTest(){
		try {
			this.setUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Méthode qui crée l'instance MoteurImpl
	 */
	public void setUp(){
		MetronomeFactory.creationMetronome();
		moteur = MoteurImpl.getInstance();
		materiel = Materiel.getInstance();
		controle = Controle.getInstance();
	}
	
	/**
	 * Méthode entrainant la fin du test
	 */
	public void tearDown(){
		moteur = null;
		materiel = null;
		controle = null;
	}
	
	/**
	 * Test si :
	 * delaiDetection est un multiple de dureeFlash
	 * le boolean SystemStarted est initialisé à false
	 * la mesure minimale est égale à 2
	 * la mesure maximale est égale à 7
	 * le nombre de ms dans une sec est 60000
	 */
	public void testConstructeur(){
		assertTrue((moteur.getDureeFlash()%moteur.getDelaiDetection()) == 0);
		assertFalse(moteur.isSystemStarted());
		assertEquals(2, moteur.getMesureMin());
		assertEquals(7, moteur.getMesureMax());
		assertEquals(60000, moteur.getMinuteEnMs());
	}
	
	/**
	 * Test sur le bon fonctionnement du booléen firstCall servant dans le controle pour la remise à zéro
	 * des compteurs d'action
	 * On ajoute des temps de latence pour laisser le temps de remonter aux informations 
	 */
	public void testFirstCall(){
		// Le système est démarré comme non encore appelé
		assertTrue(moteur.isFirstCall());
		
		// Pression de Start
		materiel.getStartBtn().setPressed(true);
		// Envoi de l'information
		controle.getControleDetection().execute();
		try {Thread.sleep(30);
		} catch (InterruptedException e) {}
		// firstCall passe à faux
		assertFalse(moteur.isFirstCall());
		
		// Pression de Stop
		materiel.getStopBtn().setPressed(true);
		// Envoi de l'information
		controle.getControleDetection().execute();
		try {Thread.sleep(30);
		} catch (InterruptedException e) {}
		// firstCall passe à vrai
		assertTrue(moteur.isFirstCall());
	}
	
}
