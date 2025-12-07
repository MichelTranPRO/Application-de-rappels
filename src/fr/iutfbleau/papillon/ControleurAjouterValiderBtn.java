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

public class ControleurAjouterValiderBtn implements MouseListener{
	
    /**
     * Bouton ajouter de la classe <code>Panelheader</code>
     */
    private BoutonAjouterValider bouton;

    /**
     * Lien avec la classe <code>PanelAccueilHeader</code>.
     */
    private PanelAccueilHeader PanelAccueilHeader;
    private PanelAccueil PanelAccueil;

    /**
     * Le constructeur de la classe <code>ControlleurAjouterBtn</code> 
     * permet de faire le lien avec un objet de la classe <code>Bouton</code>.
     * @param bouton variable nécessaire à la référence de la classe <code>Bouton</code>.
     */
	public ControleurAjouterValiderBtn(BoutonAjouterValider bouton, PanelAccueilHeader PanelAccueilHeader, PanelAccueil PanelAccueil){
        this.bouton=bouton;
        this.PanelAccueilHeader = PanelAccueilHeader;
        this.PanelAccueil = PanelAccueil;
	}
    /**
     * Appelle une fonction pour afficher la fenetre ajouter.
     */
	public void mouseClicked(MouseEvent e) {
        if (PanelAccueilHeader.getStatutModifBtn()){ // actions effectuées quand le on clique sur le bouton "valider"
            PanelAccueil.updateTabRappelModif();
            PanelAccueilHeader.setModeModif(false);
        }
        else{ // actions effectuées quand le on clique sur le bouton "ajouter"
            PanelAccueilHeader.setFenetreAjoutVisible();
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
