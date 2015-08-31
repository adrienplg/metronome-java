package controle.acteurs;

import metier.Moteur;
import metier.MoteurImpl;
import ihm.Materiel;
import ihm.elements.Led;

/**
 * Action à effectuer vis à vis de la LED (ConcreteCommand)
 * Pattern Command Action
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class ActionLed {

	private Materiel materiel;
	private Moteur moteur;
	private Led ledTempo, ledMesure;
	private int dureeFlash, dureeTempo, delaiDetection;
	private int cptTempo, cptMesure, mesure;
	
	public ActionLed(){
		materiel = Materiel.getInstance();
		moteur = MoteurImpl.getInstance();
		cptTempo = 0;
		cptMesure = 0;
	}

	/**
	 * Récupération des instances nécessaires au fonctionnement interne
	 */
	public void initReferences() {
		ledTempo = materiel.getLedTempo();
		ledMesure = materiel.getLedMesure();
		dureeFlash = moteur.getDureeFlash();
		dureeTempo = moteur.getDureeTempo();
		delaiDetection = moteur.getDelaiDetection();
	}

	public void execute() {
		// Si le système vient d'être relancé, remise à 0 des compteurs
		if (moteur.isFirstCall()){
			cptTempo=0;
			cptMesure=0;
			moteur.setFirstCall(false);
		}
		gestionFlash();
	}
	
	/**
	 * Gère l'allumage et l'extinction des LED en fonction des valeurs tempo et mesure du moteur
	 */
	private void gestionFlash(){
		// Récupération de la durée du tempo et de la mesure à chaque exécution
		dureeTempo = moteur.getDureeTempo();
		mesure=moteur.getMesure();
		// La LED de tempo s'allume si le temps vient d'être marqué
		if (cptTempo == 0){
			ledTempo.allumer();
			// La LED de mesure s'allume toutes les dureeTempo * mesure (nombre de temps dans une mesure)
			if(cptMesure == 0){
				ledMesure.allumer();
			}
		}
		// Les LED s'éteignent une fois que le temps de durée de flash est atteint
		if (cptTempo == dureeFlash){
			ledTempo.eteindre();
			ledMesure.eteindre();
		}
		// Incrémentation du compteur de tempo avec le délai de détection
		cptTempo += delaiDetection;
		// Le temps entre chaque pulsation est supérieur ou égal à la durée du tempo, remise à zéro
		if (cptTempo >= dureeTempo){
			cptTempo = 0;
			cptMesure++;
			if (cptMesure >= mesure){
				cptMesure = 0;
			}
		}
	}
}
