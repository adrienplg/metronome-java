package tests;

import controle.Controle;
import ihm.Materiel;
import junit.framework.TestCase;
import metier.HorlogeImpl;
import metier.MetronomeFactory;
import metier.MoteurImpl;

/**
 * Tests sur la factory
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
//TODO cette classe de test est-elle vraiment nécessaire ?
public class MetronomeFactoryTest extends TestCase{

	protected MetronomeFactory mFactory;
	
	public MetronomeFactoryTest(){
		try {
			this.setUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setUp(){
		MetronomeFactory.creationMetronome();
	}
	
	/**
	 * Tests sur la création des Singleton
	 */
	public void testSingleton(){
		assertNotNull(MoteurImpl.getInstance());
		assertNotNull(HorlogeImpl.getInstance());
		assertNotNull(Controle.getInstance());
		assertNotNull(Materiel.getInstance());
	}
}
