package fr.iutfbleau.papillon;

import java.awt.*;
import java.awt.event.*;

/**
 * La classe <code>ControleurAjouterValiderBtn</code> est utilisée 
 * pour gérer les interractions entre la souris et l'objet "ajouterValiderBtn" de la classe <code>Bouton</code>." 
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

    /**
     * Lien avec la classe <code>PanelAccueil</code>.
     */
    private PanelAccueil panelAccueil;

    /**
     * Les constructeurs de la classe <code>ControlleurAjouterBtn</code> 
     * permettent de faire le lien avec différentes classes.
     * @param BoutonAjouterValider variable nécessaire à la référence de la classe <code>BoutonAjouterValider</code>.
     * @param PanelAccueilHeader variable nécessaire à la référence de la classe <code>PanelAccueilHeader</code>.
     * @param PanelAccueil variable nécessaire à la référence de la classe <code>PanelAccueil</code>.
     */
	public ControleurAjouterValiderBtn(BoutonAjouterValider bouton, PanelAccueilHeader panelAccueilHeader, PanelAccueil panelAccueil){
        this.bouton=bouton;
        this.panelAccueilHeader = panelAccueilHeader;
        this.panelAccueil = panelAccueil;
	}
    /**
     * Méthode appelée lorsque l'utilisateur clique sur le composant.
     * Elle permet de valider l'échange ou suppresion des rappels.
     * Mais aussi d'afficher la fenetre ajouter.
     */
	public void mouseClicked(MouseEvent e) {
        if (panelAccueilHeader.getStatutModifBtn()){ // actions effectuées quand on clique sur le bouton "valider" en mode "modif".
            panelAccueil.updateTabRappelModifSQL();
            panelAccueilHeader.setModeModif(false);
        }
        else if(panelAccueilHeader.getStatutSupprBtn()){ // actions effectuées quand on clique sur le bouton "valide" en mode "suppr".
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
