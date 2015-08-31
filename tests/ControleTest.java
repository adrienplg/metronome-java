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
	 * M�thode qui cr�e l'instance Horloge
	 */
	public void setUp(){
		controle = Controle.getInstance();
	}
	
	/**
	 * M�thode entrainant la fin du test
	 */
	public void tearDown(){
		controle = null;
	}
	
	/**
	 * V�rifie que toutes les r�f�rences de Controle sont cr��es
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
