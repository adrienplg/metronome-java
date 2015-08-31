/**
 * @(#) StartBtn.java
 */

package ihm.elements.boutons;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

/**
 * Bouton qui lance le métronome
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class StartBtn extends JButton implements MouseListener{
	
	private static final long serialVersionUID = 134850577270897508L;
	private boolean pressed;
	
	public StartBtn(String string){
		super();
		this.setText(string);
		pressed = false;
		this.setEnabled(!pressed);
		this.addMouseListener(this);
	}
	
	/**
	 * Etat courant du bouton
	 * @return true si le bouton a été pressé
	 */
	public boolean isPressed(){
		return pressed;
	}
	
	public void setPressed(boolean b){
		pressed = b;
	}

	public void mouseClicked(MouseEvent arg0) {
		pressed = true;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}
}
