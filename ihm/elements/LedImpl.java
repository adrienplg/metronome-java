package ihm.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * LED version graphique
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class LedImpl extends JPanel implements Led  {
	private static final long serialVersionUID = 7705010019405897359L;
	private Color colorFond;
	private Color colorFlash;
	private Color color;
	
	public LedImpl(Color c){
		setLayout(null);
		this.setOpaque(false);
		Dimension d = new Dimension(20,20);
		setPreferredSize(d);
		colorFond = Color.black;
		colorFlash = c;
		color = colorFond;
	}
	
	/**
	 * Création graphique de la LED
	 */
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(color);
		g.fillOval(0, 0, 20, 20);
	}

	/**
	 * Allumer la LED
	 */
	public void allumer(){
		color = colorFlash;
		repaint();
	}
	
	/**
	 * Eteindre la LED
	 */
	public void eteindre(){
		color = colorFond;
		repaint();
	}
}
