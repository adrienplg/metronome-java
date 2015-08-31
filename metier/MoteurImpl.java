/**
 * @(#) MoteurImpl.java
 */

package metier;

import controle.Controle;
import controle.detecteurs.DetectionClavier;
import ihm.Materiel;

/**
 * Coeur métier du métronome
 * (pattern Singleton)
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class MoteurImpl implements Moteur{
	
	private static MoteurImpl uniqueInstance;
	private static Materiel materiel;
	private static Controle controle;
	private DetectionClavier detectionClavier;
	// Ces valeurs ne peuvent et ne doivent pas être changées
	private final int delaiDetection = 10; 
	private final int dureeFlash = 60; // en ms
	private final int mesureMin = 2;
	private final int mesureMax = 7;
	private final int minuteEnMs = 60000; // Nombre de ms dans une minute
	
	private int mesure, valeurMolette;
	private int dureeTempo; // Durée en ms d'un battement
	private boolean systemStarted, firstCall; // Renseigne si le système est démarré
	
	public static MoteurImpl getInstance(){
		if (null == uniqueInstance){
			uniqueInstance = new MoteurImpl();
		}
		return uniqueInstance;
	}
	
	private MoteurImpl(){
		// Arrêt du programme: delaiDetection n'est pas un multiple de dureeFlash !
		if (dureeFlash%delaiDetection != 0){
			System.err.println("delaiDetection DOIT être un multiple de dureeFlash ! (MoteurImpl.java)");
			System.exit(1);
		}
		materiel = Materiel.getInstance();
		controle = Controle.getInstance();
		mesure = 4; // Nombre de temps dans une mesure par défaut
		
		systemStarted = false; // Le système est créé à l'état éteint.
		firstCall = true; // Le système est créé sans qu'aucun n'appel n'est été fait au préalable
	}
	
	/**
	 * Récupération des instances nécessaires au fonctionnement interne
	 */
	public void initReferences(){
		detectionClavier = controle.getDetectionClavier();
	}

	/**
	 * Traite les informations recueillies par le controle et modifie les boutons en conséquence
	 */
	public void gestionBoutons() {
		if (detectionClavier.isStartIsPressed()){
			systemStarted = true;
			// Set start value back to unpressed
			materiel.getStartBtn().setPressed(false);
			// Add a mouse listener on the Stop button
			materiel.getStopBtn().addMouseListener(materiel.getStopBtn());
			// Start button is disabled and Stop button is enabled
			materiel.getStartBtn().setEnabled(false);
			materiel.getStopBtn().setEnabled(true);
			// Start button mouse listener is disabled
			materiel.getStartBtn().removeMouseListener(materiel.getStartBtn());
			//System.out.println("System started");
		}
		if (detectionClavier.isStopIsPressed()){
			systemStarted = false;
			// Boolean useful to the control to dim the LEDs and set the counters back to 0
			firstCall=true;
			// Set stop value back to unpressed
			materiel.getStopBtn().setPressed(false);
			// Add a mouse listener on the Start button
			materiel.getStartBtn().addMouseListener(materiel.getStartBtn());
			// Stop button is disabled and Start button is enabled
			materiel.getStopBtn().setEnabled(false);
			materiel.getStartBtn().setEnabled(true);
			// Stop button mouse listener is disabled
			materiel.getStopBtn().removeMouseListener(materiel.getStopBtn());
			//System.out.println("System stopped");
		}
		if (detectionClavier.isIncIsPressed()){
			if (mesure < mesureMax){
				mesure++;
				// Le bouton Inc retourne à l'état non pressé
				materiel.getIncBtn().setPressed(false);
				// Activation du bouton Dec si inactif
				if (!materiel.getDecBtn().isEnabled()){
					materiel.getDecBtn().setEnabled(true);
					materiel.getDecBtn().addMouseListener(materiel.getDecBtn());
				}
				// Désactivation du bouton Inc si valeur minimale atteinte
				if (mesure == mesureMax){
					materiel.getIncBtn().removeMouseListener(materiel.getIncBtn());
					materiel.getIncBtn().setEnabled(false);
				}
			}
			//System.out.println("mesure : "+mesure);
		}
		if (detectionClavier.isDecIsPressed()){
			// Si la mesure actuelle est supérieure à la mesure minimum
			if (mesure > mesureMin){
				mesure--;
				// Le bouton Dec retourne à l'état non pressé
				materiel.getDecBtn().setPressed(false);
				// Activation du bouton Inc si inactif
				if (!materiel.getIncBtn().isEnabled()){
					materiel.getIncBtn().setEnabled(true);
					materiel.getIncBtn().addMouseListener(materiel.getIncBtn());
				}
				// Désactivation du bouton Dec si valeur minimale atteinte
				if (mesure == mesureMin){
					materiel.getDecBtn().removeMouseListener(materiel.getDecBtn());
					materiel.getDecBtn().setEnabled(false);
				}
			}
			//System.out.println("mesure : "+mesure);
		}
	}

	/**
	 * Renseigne la valeur de la molette ainsi que la durée en ms dureeTempo correspondante
	 */
	public void setValeurMolette(int valeurMolette) {
		this.valeurMolette = valeurMolette;
		setDureeTempo(valeurMolette);
	}
	
	/**
	 * Calcule la durée du tempo en ms utile au controle (en fait un multiple de delaiDetection)
	 * @param dureeTempo
	 */
	private void setDureeTempo(int valeurMolette) {
		this.dureeTempo = minuteEnMs/valeurMolette;
	}
	
	public void setFirstCall(boolean firstCall) {
		this.firstCall = firstCall;
	}

	///////////////////////////////////////////////////////////
	// ACCESSEURS
	///////////////////////////////////////////////////////////

	public int getMesure() {
		return mesure;
	}

	public int getMesureMin() {
		return mesureMin;
	}

	public int getMesureMax() {
		return mesureMax;
	}
	
	public int getMinuteEnMs() {
		return minuteEnMs;
	}

	public int getDureeFlash() {
		return dureeFlash;
	}

	public int getDureeTempo() {
		return dureeTempo;
	}
	
	public int getDelaiDetection() {
		return delaiDetection;
	}

	public int getValeurMolette() {
		return valeurMolette;
	}

	public boolean isSystemStarted() {
		return systemStarted;
	}

	public boolean isFirstCall() {
		return firstCall;
	}

}
