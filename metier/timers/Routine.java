package metier.timers;

import java.util.TimerTask;

import controle.Controle;
import metier.Moteur;
import metier.MoteurImpl;

/**
 * Routine de d�tection/action
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class Routine extends TimerTask {

	private Controle controle;
	private Moteur moteur;
	
	public Routine(){
		controle = Controle.getInstance();
		moteur = MoteurImpl.getInstance();
	}
	public void run() {
		// D�tection r�guli�re
		controle.getControleDetection().execute();
		if (moteur.isSystemStarted()){
			// Action r�guli�re si le moteur est lanc�
			controle.getControleAction().execute();
		}
//		System.out.println("Dur�e tempo: "+moteur.getDureeTempo());
//		System.out.println("Dur�e mesure: "+moteur.getDureeMesure());
	}
}
