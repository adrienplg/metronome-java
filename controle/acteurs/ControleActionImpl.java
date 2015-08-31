package controle.acteurs;

/**
 * Action à réaliser pour la partie action
 * Pattern Command Action
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class ControleActionImpl implements ControleAction {

	private ActionLed actionLed;
	private ActionEmetteurSonore actionEmetteurSonore;
	
	public ControleActionImpl(){}
	
	/**
	 * Récupération des instances nécessaires au fonctionnement interne
	 */
	public void initReferences(){
		actionLed = controle.getActionLed();
		actionEmetteurSonore = controle.getActionEmetteurSonore();
	}
	
	public void execute() {
		// C'est le dernier appel qui doit informer le moteur que firstCall est false (si nécessaire)
		actionEmetteurSonore.execute();
		actionLed.execute();
	}

}
