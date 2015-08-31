package ihm.elements;

import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Molette version graphique
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class MoletteImpl extends JPanel implements Molette, ChangeListener{

	private static final long serialVersionUID = -836721994000111428L;
	private JSlider slider;
	private int valeurMolette;
	private int mini, maxi, init, tickSpacing;

	public MoletteImpl(){
		mini = 40;
		maxi = 200;
		init = 100;
		tickSpacing = 20;
		
		// Utilisation d'un JSlider pour la molette
		slider = new JSlider(JSlider.HORIZONTAL, mini, maxi, init);
		slider.setMajorTickSpacing(tickSpacing);
		slider.setPaintTicks(true);
		creerLabels();
		
		slider.addChangeListener(this);
		valeurMolette = slider.getValue();
		this.add(slider);
	}

	@SuppressWarnings("unchecked")
	/**
	 * Création de l'échelle de tempo
	 */
	private void creerLabels(){
		// Création de la table des labels
		Hashtable labelTable = new Hashtable();
		labelTable.put( new Integer( mini ), new JLabel(String.valueOf(mini)));
		labelTable.put( new Integer( mini + 1*2*tickSpacing ), new JLabel(String.valueOf( mini + 1*2*tickSpacing )));
		labelTable.put( new Integer( mini + 2*2*tickSpacing ), new JLabel(String.valueOf( mini + 2*2*tickSpacing )));
		labelTable.put( new Integer( mini + 3*2*tickSpacing ), new JLabel(String.valueOf( mini + 3*2*tickSpacing )));
		labelTable.put( new Integer( mini + 4*2*tickSpacing ), new JLabel(String.valueOf( mini + 4*2*tickSpacing )));
		slider.setLabelTable( labelTable );
		slider.setPaintLabels(true);
	}
	
	/**
	 * Changement de valeur du JSlider
	 */
	public void stateChanged(ChangeEvent arg0) {
		valeurMolette = slider.getValue();
	}

	public int getValeurMolette() {
		return valeurMolette;
	}

	public JSlider getSlider() {
		return slider;
	}
	
}
