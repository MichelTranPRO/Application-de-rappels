package fr.iutfbleau.papillon;

import java.awt.*;
import java.awt.event.*;

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
    private PanelAccueilHeader panelAccueilHeader;
    private PanelAccueil panelAccueil;

    /**
     * Le constructeur de la classe <code>ControlleurAjouterBtn</code> 
     * permet de faire le lien avec un objet de la classe <code>Bouton</code>.
     * @param bouton variable nécessaire à la référence de la classe <code>Bouton</code>.
     */
	public ControleurAjouterValiderBtn(BoutonAjouterValider bouton, PanelAccueilHeader panelAccueilHeader, PanelAccueil panelAccueil){
        this.bouton=bouton;
        this.panelAccueilHeader = panelAccueilHeader;
        this.panelAccueil = panelAccueil;
	}
    /**
     * Appelle une fonction pour afficher la fenetre ajouter.
     */
	public void mouseClicked(MouseEvent e) {
        if (panelAccueilHeader.getStatutModifBtn()){ // actions effectuées quand le on clique sur le bouton "valider"
            panelAccueil.updateTabRappelModifSQL();
            panelAccueilHeader.setModeModif(false);
        }
        else if(panelAccueilHeader.getStatutSupprBtn()){
            panelAccueil.deleteTabRappelSupprSQL();
            panelAccueilHeader.setModeSuppr(false);
        }
        else{ // actions effectuées quand le on clique sur le bouton "ajouter"
            panelAccueilHeader.setFenetreAjoutVisible();
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
