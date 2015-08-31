package controle.acteurs;

import controle.Controle;

/**
 * Action � r�aliser pour la partie action
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
	 * Ex�cution de la commande
	 */
	void execute();
	
	/**
	 * Initialisation des r�f�rences permettant l'ex�cution
	 */
	void initReferences();
	
}
