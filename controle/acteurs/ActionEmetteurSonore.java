package controle.acteurs;

import metier.Moteur;
import metier.MoteurImpl;
import ihm.Materiel;
import ihm.elements.EmetteurSonore;

/**
 * Action � effectuer vis � vis de l'�metteur sonore (ConcreteCommand)
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
	 * R�cup�ration des instances n�cessaires au fonctionnement interne
	 */
	public void initReferences() {
		emetteurSonore = materiel.getEmetteurSonore();
		delaiDetection = moteur.getDelaiDetection();
	}

	public void execute() {
		// Si le syst�me vient d'�tre relanc�, remise � 0 des compteurs
		if (moteur.isFirstCall()){
			cptTempo=0;
		}
		gestionSon();
	}

	/**
	 * G�re les �missions de son � un instant donn�.
	 */
	private void gestionSon() {
		// R�cup�ration de la dur�e du tempo � chaque ex�cution
		dureeTempo = moteur.getDureeTempo();
		// Lecture du son si le temps vient d'�tre marqu�
		if (cptTempo == 0){
			emetteurSonore.jouerSon();
		}
		// Incr�mentation du compteur de tempo avec le d�lai de d�tection
		cptTempo += delaiDetection;
		// Remise � z�ro si le temps entre chaque pulsation est sup�rieur ou �gal � la dur�e du tempo
		if (cptTempo >= dureeTempo){
			cptTempo = 0;
		}
	}
}
