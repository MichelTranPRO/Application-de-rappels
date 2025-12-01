package fr.iutfbleau.papillon;

import java.awt.*;
import java.awt.event.*;

import fr.iutfbleau.papillon.PanelAjoutHeader;

/**
 * La classe <code>ControlleurAjouterBtn</code> est utilisée 
 * pour gérer les interractions entre la souris et l'objet "ajouterBtn" de la classe <code>Bouton</code>." 
 * 
 * @version 1.0
 * @author Emmanuelle Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */

public class ControlleurAjouterValiderBtn implements MouseListener{
	
    /**
     * Bouton ajouter de la classe <code>Panelheader</code>
     */
    private BoutonAjouterValider bouton;

    /**
     * Lien avec la classe <code>PanelRappelsHeader</code>.
     */
    private PanelRappelsHeader panelRappelsHeader;
    private PanelRappels panelRappels;

    /**
     * Le constructeur de la classe <code>ControlleurAjouterBtn</code> 
     * permet de faire le lien avec un objet de la classe <code>Bouton</code>.
     * @param bouton variable nécessaire à la référence de la classe <code>Bouton</code>.
     */
	public ControlleurAjouterValiderBtn(BoutonAjouterValider bouton, PanelRappelsHeader panelRappelsHeader, PanelRappels panelRappels){
        this.bouton=bouton;
        this.panelRappelsHeader = panelRappelsHeader;
        this.panelRappels = panelRappels;
	}
    /**
     * Appelle une fonction pour afficher la fenetre ajouter.
     */
	public void mouseClicked(MouseEvent e) {
        if (!panelRappelsHeader.getStatutModifBtn()){ // si le bouton modif est pas cliqué, le bouton "Ajouter" est visible la
            panelRappelsHeader.setFenetreAjoutVisible();
        }
        if (!panelRappelsHeader.getStatutModifBtn()){ // si le bouton modif est cliqué, le bouton "Valider" est visible la
            // if 
        }
	}

    /**
     * Interraction lorsque la souris sort du bouton.
     * Appelle la fonction qui change les couleurs du bouton.
     * @param evenement géré en dehors du code.
     */
	public void mouseExited(MouseEvent e) {
        bouton.setHoverColor(false, new Color(255,184,0),new Color(255,255,255));
    }

    /**
     * Interraction lorsque la souris entre du bouton.
     * Appelle la fonction qui change les couleurs du bouton.
     * @param evenement géré en dehors du code.
     */
	public void mouseEntered(MouseEvent e) {
        bouton.setHoverColor(true, new Color(255,184,0),new Color(255,255,255));
    }
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
}
