package fr.iutfbleau.papillon;

import java.awt.*;
import java.awt.event.*;

/**
 * La classe <code>ControleurSupprBtn</code> est utilisée 
 * pour gérer les interractions entre la souris et l'objet "supprBtn" de la classe <code>Bouton</code>." 
 * 
 * @version 1.0
 * @author Emmanuelle Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */

public class ControleurSupprBtn implements MouseListener{

    /**
     * Bouton ajouter de la classe <code>Panelheader</code>
     */
	private BoutonSuppr bouton;
    private PanelAccueilHeader panelAccueilHeader;

    /**
     * Le constructeur de la classe <code>ControleurSupprBtn</code> 
     * permet de faire le lien avec un objet de la classe <code>Bouton</code>.
     * @param bouton variable nécessaire à la référence de la classe <code>Bouton</code>.
     */
	public ControleurSupprBtn(BoutonSuppr bouton, PanelAccueilHeader panelAccueilHeader){
        this.bouton = bouton;
        this.panelAccueilHeader = panelAccueilHeader;
	}

    
	public void mouseClicked(MouseEvent e) {
        boolean nouveauStatut = !panelAccueilHeader.getStatutSupprBtn();
        if(panelAccueilHeader.getStatutModifBtn()){
            panelAccueilHeader.setModeModif(!nouveauStatut);
        }
        panelAccueilHeader.setModeSuppr(nouveauStatut);
	}

    /**
     * Interraction lorsque la souris sort du bouton.
     * Appelle la fonction qui change les couleurs du bouton.
     * @param evenement géré en dehors du code.
     */
	public void mouseExited(MouseEvent e) {
        // hover uniquement si pas en mode modif
        if (!panelAccueilHeader.getStatutSupprBtn()) {
            bouton.setHoverColor(false);
        }
    }
    
    /**
     * Interraction lorsque la souris sort du bouton.
     * Appelle la fonction qui change les couleurs du bouton.
     * @param evenement géré en dehors du code.
     */
	public void mouseEntered(MouseEvent e) {
        // hover uniquement si pas en mode modif
        if (!panelAccueilHeader.getStatutSupprBtn()) {
            bouton.setHoverColor(true);
        }
    }
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
}
