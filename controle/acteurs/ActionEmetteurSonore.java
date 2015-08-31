package controle.acteurs;

import metier.Moteur;
import metier.MoteurImpl;
import ihm.Materiel;
import ihm.elements.EmetteurSonore;

/**
 * Action à effectuer vis à vis de l'émetteur sonore (ConcreteCommand)
 * Pattern Command d'Action
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class ActionEmetteurSonore {

	private Moteur moteur;
	private Materiel materiel;
	private EmetteurSonore emetteurSonore;
	private int cptTempo, dureeTempo, delaiDetection;
	
	public ActionEmetteurSonore(){
		moteur = MoteurImpl.getInstance();
		materiel = Materiel.getInstance();
		cptTempo = 0;
	}

	/**
	 * Récupération des instances nécessaires au fonctionnement interne
	 */
	public void initReferences() {
		emetteurSonore = materiel.getEmetteurSonore();
		delaiDetection = moteur.getDelaiDetection();
	}

	public void execute() {
		// Si le système vient d'être relancé, remise à 0 des compteurs
		if (moteur.isFirstCall()){
			cptTempo=0;
		}
		gestionSon();
	}

	/**
	 * Gère les émissions de son à un instant donné.
	 */
	private void gestionSon() {
		// Récupération de la durée du tempo à chaque exécution
		dureeTempo = moteur.getDureeTempo();
		// Lecture du son si le temps vient d'être marqué
		if (cptTempo == 0){
			emetteurSonore.jouerSon();
		}
		// Incrémentation du compteur de tempo avec le délai de détection
		cptTempo += delaiDetection;
		// Remise à zéro si le temps entre chaque pulsation est supérieur ou égal à la durée du tempo
		if (cptTempo >= dureeTempo){
			cptTempo = 0;
		}
	}
}
