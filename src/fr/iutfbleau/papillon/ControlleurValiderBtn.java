import java.awt.*;
import java.awt.event.*;

/**
 * La classe <code>ControlleurValiderBtn</code> est utilisée 
 * pour gérer les interractions entre la souris et l'objet "ajouterBtn" de la classe <code>Bouton</code>." 
 * 
 * @version 1.0
 * @author Emmanuelle Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */

public class ControlleurValiderBtn implements MouseListener{
	
    /**
     * Bouton ajouter de la classe <code>Panelheader</code>
     */
    private Bouton bouton;

    /**
     * Le constructeur de la classe <code>ControlleurValiderBtn</code> 
     * permet de faire le lien avec un objet de la classe <code>Bouton</code>.
     * @param bouton variable nécessaire à la référence de la classe <code>Bouton</code>.
     */
	public ControlleurValiderBtn(Bouton bouton){
        this.bouton=bouton;
	}

	public void mouseClicked(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
        bouton.setHover(false, new Color(0,161,67),new Color(255,255,255));
    }
	public void mouseEntered(MouseEvent e) {
        bouton.setHover(true, new Color(0,161,67),new Color(255,255,255));
    }
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
}