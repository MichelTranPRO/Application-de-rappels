package fr.iutfbleau.papillon;

import java.awt.*;
import java.awt.event.*;

/**
 * La classe <code>ControlleurModifBtn</code> est utilisée 
 * pour gérer les interractions entre la souris et l'objet "modifBtn" de la classe <code>Bouton</code>." 
 * 
 * @version 1.0
 * @author Emmanuelle Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */

public class ControlleurModifBtn implements MouseListener{
	
    /**
     * Bouton ajouter de la classe <code>Panelheader</code>
     */
    private Bouton bouton;

    private PanelRappels panelRappels;
    private int cpt;

    /**
     * Le constructeur de la classe <code>ControlleurModifBtn</code> 
     * permet de faire le lien avec un objet de la classe <code>Bouton</code>.
     * @param bouton variable nécessaire à la référence de la classe <code>Bouton</code>.
     */
	public ControlleurModifBtn(Bouton bouton, PanelRappels panelRappels){
        this.bouton=bouton;
        this.panelRappels=panelRappels;
	}

	public void mouseClicked(MouseEvent e) {
        cpt++;
        bouton.setHover(true, new Color(255,184,0),new Color(255,255,255));
        if (cpt!=1){
            cpt=0;
            bouton.setHover(false, new Color(255,184,0),new Color(255,255,255));
            panelRappels.changeColorAllRappels(false);
        }else{
            bouton.setHover(true, new Color(255,184,0),new Color(255,255,255));
            panelRappels.changeColorAllRappels(true);
        }
	}

    /**
     * Interraction lorsque la souris sort du bouton.
     * Appelle la fonction qui change les couleurs du bouton.
     * @param evenement géré en dehors du code.
     */
	public void mouseExited(MouseEvent e) {
        bouton.setHover(false, new Color(255,184,0),new Color(255,255,255));
    }

    /**
     * Interraction lorsque la souris sort du bouton.
     * Appelle la fonction qui change les couleurs du bouton.
     * @param evenement géré en dehors du code.
     */
	public void mouseEntered(MouseEvent e) {
        bouton.setHover(true, new Color(255,184,0),new Color(255,255,255));
    }
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
}
