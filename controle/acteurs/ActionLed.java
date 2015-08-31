package controle.acteurs;

import metier.Moteur;
import metier.MoteurImpl;
import ihm.Materiel;
import ihm.elements.Led;

/**
 * Action � effectuer vis � vis de la LED (ConcreteCommand)
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
	 * R�cup�ration des instances n�cessaires au fonctionnement interne
	 */
	public void initReferences() {
		ledTempo = materiel.getLedTempo();
		ledMesure = materiel.getLedMesure();
		dureeFlash = moteur.getDureeFlash();
		dureeTempo = moteur.getDureeTempo();
		delaiDetection = moteur.getDelaiDetection();
	}

	public void execute() {
		// Si le syst�me vient d'�tre relanc�, remise � 0 des compteurs
		if (moteur.isFirstCall()){
			cptTempo=0;
			cptMesure=0;
			moteur.setFirstCall(false);
		}
		gestionFlash();
	}
	
	/**
	 * G�re l'allumage et l'extinction des LED en fonction des valeurs tempo et mesure du moteur
	 */
	private void gestionFlash(){
		// R�cup�ration de la dur�e du tempo et de la mesure � chaque ex�cution
		dureeTempo = moteur.getDureeTempo();
		mesure=moteur.getMesure();
		// La LED de tempo s'allume si le temps vient d'�tre marqu�
		if (cptTempo == 0){
			ledTempo.allumer();
			// La LED de mesure s'allume toutes les dureeTempo * mesure (nombre de temps dans une mesure)
			if(cptMesure == 0){
				ledMesure.allumer();
			}
		}
		// Les LED s'�teignent une fois que le temps de dur�e de flash est atteint
		if (cptTempo == dureeFlash){
			ledTempo.eteindre();
			ledMesure.eteindre();
		}
		// Incr�mentation du compteur de tempo avec le d�lai de d�tection
		cptTempo += delaiDetection;
		// Le temps entre chaque pulsation est sup�rieur ou �gal � la dur�e du tempo, remise � z�ro
		if (cptTempo >= dureeTempo){
			cptTempo = 0;
			cptMesure++;
			if (cptMesure >= mesure){
				cptMesure = 0;
			}
		}
	}
}
