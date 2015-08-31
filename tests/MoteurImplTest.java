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
	 * M�thode qui cr�e l'instance MoteurImpl
	 */
	public void setUp(){
		MetronomeFactory.creationMetronome();
		moteur = MoteurImpl.getInstance();
		materiel = Materiel.getInstance();
		controle = Controle.getInstance();
	}
	
	/**
	 * M�thode entrainant la fin du test
	 */
	public void tearDown(){
		moteur = null;
		materiel = null;
		controle = null;
	}
	
	/**
	 * Test si :
	 * delaiDetection est un multiple de dureeFlash
	 * le boolean SystemStarted est initialis� � false
	 * la mesure minimale est �gale � 2
	 * la mesure maximale est �gale � 7
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
	 * Test sur le bon fonctionnement du bool�en firstCall servant dans le controle pour la remise � z�ro
	 * des compteurs d'action
	 * On ajoute des temps de latence pour laisser le temps de remonter aux informations 
	 */
	public void testFirstCall(){
		// Le syst�me est d�marr� comme non encore appel�
		assertTrue(moteur.isFirstCall());
		
		// Pression de Start
		materiel.getStartBtn().setPressed(true);
		// Envoi de l'information
		controle.getControleDetection().execute();
		try {Thread.sleep(30);
		} catch (InterruptedException e) {}
		// firstCall passe � faux
		assertFalse(moteur.isFirstCall());
		
		// Pression de Stop
		materiel.getStopBtn().setPressed(true);
		// Envoi de l'information
		controle.getControleDetection().execute();
		try {Thread.sleep(30);
		} catch (InterruptedException e) {}
		// firstCall passe � vrai
		assertTrue(moteur.isFirstCall());
	}
	
}
