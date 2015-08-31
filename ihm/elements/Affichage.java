package ihm.elements;

import java.awt.GridLayout;
import java.awt.Label;
import javax.swing.JPanel;

/**
 * Affiche dans un label le tempo et la mesure
 */
public class Affichage extends JPanel{
	
	private static final long serialVersionUID = -659774298897692018L;
	private Label labelMesure;
	private Label labelTempo;
	private Label tempo;
	private Label mesure;
	
	public Affichage(){
		labelMesure = new Label("Mesure:");
		labelTempo = new Label("Tempo:");
		tempo = new Label("100");
		mesure = new Label("4");
		
		this.setLayout(new GridLayout(2,2));
		
		this.add(labelMesure);
		this.add(mesure);
		this.add(labelTempo);
		this.add(tempo);
	}

	public void setTempo(String tempo) {
		this.tempo.setText(tempo);
	}

	public void setMesure(String mesure) {
		this.mesure.setText(mesure);
	}

	public Label getTempo() {
		return tempo;
	}

	public Label getMesure() {
		return mesure;
	}
	
}

