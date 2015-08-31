package tests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Lanceur de tests unitaires sur l'ensemble des classes de l'application metronome
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Tests du metronome");
		//$JUnit-BEGIN$
		suite.addTestSuite(MetronomeFactoryTest.class);
		suite.addTestSuite(MoteurImplTest.class);
		suite.addTestSuite(HorlogeImplTest.class);
		suite.addTestSuite(ControleTest.class);
		suite.addTestSuite(MaterielTest.class);
		suite.addTestSuite(BoutonsTest.class);
		suite.addTestSuite(MoletteTest.class);
		//$JUnit-END$
		return suite;
	}

}
