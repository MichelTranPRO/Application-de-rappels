package fr.iutfbleau.papillon;

import java.awt.*;
import java.awt.event.*;

public class ControleurRappel implements MouseListener{

    private Rappel rappel;
    public ControleurRappel(Rappel rappel){
        this.rappel=rappel;

	}
    /**
     * Appelle une fonction pour afficher la fenetre ajouter.
     */
	public void mouseClicked(MouseEvent e) {
        if (rappel.getStatutModifier()){
            rappel.setHover(true);
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
        
    }

    /**
     * Interraction lorsque la souris entre du bouton.
     * Appelle la fonction qui change les couleurs du bouton.
     * @param evenement géré en dehors du code.
     */
	public void mouseEntered(MouseEvent e) {
        if(!rappel.getStatutModifier()){
            rappel.setHover(true);
        }
        
    }
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
}
