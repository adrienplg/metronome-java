package controle.acteurs;

/**
 * Action � r�aliser pour la partie action
 * Pattern Command Action
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class ControleActionImpl implements ControleAction {

	private ActionLed actionLed;
	private ActionEmetteurSonore actionEmetteurSonore;
	
	public ControleActionImpl(){}
	
	/**
	 * R�cup�ration des instances n�cessaires au fonctionnement interne
	 */
	public void initReferences(){
		actionLed = controle.getActionLed();
		actionEmetteurSonore = controle.getActionEmetteurSonore();
	}
	
	public void execute() {
		// C'est le dernier appel qui doit informer le moteur que firstCall est false (si n�cessaire)
		actionEmetteurSonore.execute();
		actionLed.execute();
	}

}
