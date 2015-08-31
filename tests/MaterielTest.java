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
	 * Méthode qui crée l'instance Materiel
	 */
	public void setUp(){
		materiel = Materiel.getInstance();
	}
	
	/**
	 * Méthode entrainant la fin du test
	 */
	public void tearDown(){
		materiel = null;
	}
	
	/**
	 * Vérifie que toutes les références de Materiel sont créées
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
