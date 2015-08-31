package metier.timers;

import java.util.TimerTask;

import controle.Controle;
import metier.Moteur;
import metier.MoteurImpl;

/**
 * Routine de détection/action
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
		// Détection régulière
		controle.getControleDetection().execute();
		if (moteur.isSystemStarted()){
			// Action régulière si le moteur est lancé
			controle.getControleAction().execute();
		}
//		System.out.println("Durée tempo: "+moteur.getDureeTempo());
//		System.out.println("Durée mesure: "+moteur.getDureeMesure());
	}
}
