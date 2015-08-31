package controle.detecteurs;

import controle.Controle;

/**
 * Action � r�aliser pour la partie d�tection
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
	 * Ex�cution de la commande
	 */
	void execute();

	/**
	 * Initialisation des r�f�rences permettant l'ex�cution
	 */
	void initReferences();
}
