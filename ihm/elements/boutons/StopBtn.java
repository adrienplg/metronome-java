/**
 * @(#) StopBtn.java
 */

package ihm.elements.boutons;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

/**
 * Bouton qui stoppe le métronome
 * @author Nicolas Caudard, Adrien Pouligny
 *
 */
public class StopBtn extends JButton implements MouseListener{
	
	private static final long serialVersionUID = -6458250283931403013L;
	private boolean pressed;
	
	public StopBtn(String string){
		super();
		this.setText(string);
		pressed = false;
		this.setEnabled(pressed);
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
