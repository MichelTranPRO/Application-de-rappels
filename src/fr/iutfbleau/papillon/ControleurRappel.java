package fr.iutfbleau.papillon;

import java.awt.*;
import java.awt.event.*;

public class ControleurRappel implements MouseListener{

    private Rappel rappel;
    private int cpt;
    private PanelRappels panelRappels;
    public ControleurRappel(Rappel rappel, PanelRappels panelRappels){
        this.rappel=rappel;
        this.panelRappels=panelRappels;
	}
    /**
     * Appelle une fonction pour afficher la fenetre ajouter.
     */
	public void mouseClicked(MouseEvent e) {
        if (rappel.getStatutModifier()){
            cpt++;
            if (cpt!=1){ // pas cliqué
                rappel.setStatutModifier(true);
                cpt=0;
            }else if (cpt==1){ // cliqué
                rappel.setHover(true);
                panelRappels.addTabRappelModif(rappel);
            }
        }

        if (!rappel.getStatutModifier()){
            // code pour ouvrir le fenetre rappel contenu blabla
        }
	}

    /**
     * Interraction lorsque la souris sort du bouton.
     * Appelle la fonction qui change les couleurs du bouton.
     * @param evenement géré en dehors du code.
     */
	public void mouseExited(MouseEvent e) {
        if(!rappel.getStatutModifier()){
            rappel.setHover(false);
        }
        if (rappel.getStatutModifier() && cpt == 0){
            rappel.setStatutModifier(true);
        }
        
    }

    /**
     * Interraction lorsque la souris entre du bouton.
     * Appelle la fonction qui change les couleurs du bouton.
     * @param evenement géré en dehors du code.
     */
	public void mouseEntered(MouseEvent e) {
        // if(!rappel.getStatutModifier()){
            rappel.setHover(true);
        // }
        
    }
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
}
