package lanceur;

import metier.MetronomeFactory;

/**
 * Lancement de l'application Metronome
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class Metronome {

	public Metronome(){
		MetronomeFactory.creationMetronome();
	}
	
	/**
	 * Lanceur
	 * @param args
	 */
	public static void main(String[] args) {
		new Metronome();
	}

}
