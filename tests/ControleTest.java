package tests;

import junit.framework.TestCase;
import controle.Controle;

/**
 * Test sur le Singleton Controle
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class ControleTest extends TestCase {
	protected Controle controle;
	
	public ControleTest(){
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
		controle = Controle.getInstance();
	}
	
	/**
	 * Méthode entrainant la fin du test
	 */
	public void tearDown(){
		controle = null;
	}
	
	/**
	 * Vérifie que toutes les références de Controle sont créées
	 */
	public void testReferences(){
		assertNotNull(controle.getActionEmetteurSonore());
		assertNotNull(controle.getActionLed());
		assertNotNull(controle.getControleAction());
		assertNotNull(controle.getControleDetection());
		assertNotNull(controle.getDecCmd());
		assertNotNull(controle.getDetectionClavier());
		assertNotNull(controle.getDetectionMolette());
		assertNotNull(controle.getIncCmd());
		assertNotNull(controle.getMoletteCmd());
		assertNotNull(controle.getStartCmd());
		assertNotNull(controle.getStopCmd());
	}
}
