/**
 * @(#) Moteur.java
 */

package metier;

/**
 * Coeur métier du métronome
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public interface Moteur{

	void gestionBoutons();
	void setValeurMolette(int valeurMolette);
	void setFirstCall(boolean firstCall);
	
	int getDelaiDetection();
	int getMesure();
	int getDureeFlash();
	int getDureeTempo();
	int getValeurMolette();
	
	boolean isSystemStarted();
	boolean isFirstCall();
	void initReferences();
}
