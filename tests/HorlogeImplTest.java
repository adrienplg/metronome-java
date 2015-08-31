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
	 * M�thode qui cr�e l'instance Horloge
	 */
	public void setUp(){
		horloge = HorlogeImpl.getInstance();
	}
	
	/**
	 * M�thode entrainant la fin du test
	 */
	public void tearDown(){
		horloge = null;
	}
	
	/**
	 * V�rifie que la routine de d�tection est cr�� et que le moteur renvoi bien un d�lai de d�tection positif
	 */
	public void testRoutine(){
		assertNotNull(MoteurImpl.getInstance().getDelaiDetection());
		assertTrue(MoteurImpl.getInstance().getDelaiDetection()>0);
		assertNotNull(horloge.getRoutine());
	}
}
