package controle.detecteurs;

/**
 * Action à réaliser pour la partie détection
 * Pattern Command Detection
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class ControleDetectionImpl implements ControleDetection {

	private DetectionClavier detectionClavier;
	private DetectionMolette detectionMolette;
	
	public ControleDetectionImpl(){}
	
	public void initReferences(){
		detectionClavier = controle.getDetectionClavier();
		detectionMolette = controle.getDetectionMolette();
	}
	
	public void execute() {
		detectionClavier.execute();
		detectionMolette.execute();
	}

}
