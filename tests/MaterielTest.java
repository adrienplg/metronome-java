package tests;

import ihm.Materiel;
import junit.framework.TestCase;

/**
 * Tests sur le Singleton Materiel
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class MaterielTest extends TestCase {
	
	protected Materiel materiel;
	
	public MaterielTest(){
		try {
			this.setUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * M�thode qui cr�e l'instance Materiel
	 */
	public void setUp(){
		materiel = Materiel.getInstance();
	}
	
	/**
	 * M�thode entrainant la fin du test
	 */
	public void tearDown(){
		materiel = null;
	}
	
	/**
	 * V�rifie que toutes les r�f�rences de Materiel sont cr��es
	 */
	public void testReferences(){
		assertNotNull(materiel.getAffichage());
		assertNotNull(materiel.getDecBtn());
		assertNotNull(materiel.getEmetteurSonore());
		assertNotNull(materiel.getIncBtn());
		assertNotNull(materiel.getLedMesure());
		assertNotNull(materiel.getLedTempo());
		assertNotNull(materiel.getMolette());
		assertNotNull(materiel.getStartBtn());
		assertNotNull(materiel.getStopBtn());
	}
}
