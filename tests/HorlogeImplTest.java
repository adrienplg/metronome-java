package tests;

import junit.framework.TestCase;
import metier.HorlogeImpl;
import metier.MoteurImpl;

/**
 * Test sur le Singleton HorlogeImpl
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class HorlogeImplTest extends TestCase{
	protected HorlogeImpl horloge;
	
	public HorlogeImplTest(){
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
		horloge = HorlogeImpl.getInstance();
	}
	
	/**
	 * Méthode entrainant la fin du test
	 */
	public void tearDown(){
		horloge = null;
	}
	
	/**
	 * Vérifie que la routine de détection est créé et que le moteur renvoi bien un délai de détection positif
	 */
	public void testRoutine(){
		assertNotNull(MoteurImpl.getInstance().getDelaiDetection());
		assertTrue(MoteurImpl.getInstance().getDelaiDetection()>0);
		assertNotNull(horloge.getRoutine());
	}
}
