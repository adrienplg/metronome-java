/**
 * @(#) IncBtn.java
 */

package ihm.elements.boutons;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

/**
 * Bouton qui incrémente la mesure
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class IncBtn extends JButton implements MouseListener{
	
	private static final long serialVersionUID = -7898451021060922784L;
	private boolean pressed;
	
	public IncBtn(String string){
		super();
		this.setText(string);
		pressed = false;
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
	
	public void mouseClicked(MouseEvent e) {
		pressed = true;
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}
