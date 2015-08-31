package controle.detecteurs;

import controle.Controle;

/**
 * Action à réaliser pour la partie détection
 * Pattern Command Detection
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public interface ControleDetection {
	
	/**
	 * Instance du Singleton Controle
	 */
	Controle controle = Controle.getInstance();
	
	/**
	 * Exécution de la commande
	 */
	void execute();

	/**
	 * Initialisation des références permettant l'exécution
	 */
	void initReferences();
}
