/**
 * @(#) HorlogeImpl.java
 */

package metier;

import java.util.Timer;
import metier.timers.Routine;

/**
 * Classe gérant la minuterie du métronome
 * (pattern Singleton)
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class HorlogeImpl extends Timer implements Horloge{
	
	private static HorlogeImpl uniqueInstance;
	private Moteur moteur;
	private Routine routine;
	
	public static HorlogeImpl getInstance(){
		if (null == uniqueInstance){
			uniqueInstance = new HorlogeImpl();
		}
		return uniqueInstance;
	}
	
	private HorlogeImpl(){
		moteur = MoteurImpl.getInstance();
	}
	
	/**
	 * Démarre l'ensemble du système
	 */
	public void start(){
		this.schedule(routine, 0, moteur.getDelaiDetection());
	}

	public Routine getRoutine() {
		return routine;
	}

	public void setRoutine(Routine routine) {
		this.routine = routine;
	}

}
