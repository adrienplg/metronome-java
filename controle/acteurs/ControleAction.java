package controle.acteurs;

import controle.Controle;

/**
 * Action à réaliser pour la partie action
 * Pattern Command Action
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public interface ControleAction {
	
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
