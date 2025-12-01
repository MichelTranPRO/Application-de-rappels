package fr.iutfbleau.papillon;
import fr.iutfbleau.papillon.PanelAjoutHeader;
import java.awt.*;
import java.awt.event.*;

/**
 * La classe <code>ControlleurValiderBtn</code> est utilisée 
 * pour gérer les interractions entre la souris et l'objet "ajouterBtn" de la classe <code>Bouton</code>." 
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */

public class ControlleurValiderBtn implements MouseListener{
	
    /**
     * Bouton ajouter de la classe <code>Panelheader</code>
     */
    private Bouton bouton;

    /**
     * Lien avec la classe <code>panelAjoutHeader</code>.S
     */
    private PanelAjout panelAjout;

    /**
     * Le constructeur de la classe <code>ControlleurValiderBtn</code> 
     * permet de faire le lien avec un objet de la classe <code>Bouton</code>.
     * @param bouton variable nécessaire à la référence de la classe <code>Bouton</code>.
     */
	public ControlleurValiderBtn(Bouton bouton, PanelAjout panelAjout){
        this.bouton=bouton;
        this.panelAjout=panelAjout;
	}

    @Override
	public void mouseClicked(MouseEvent e) {
        // je mets juste le code pour retourner a la fenetre rappel faudra mettre les verifs avant
        panelAjout.setFenetreRappelVisible();
	}

    /**
     * Interraction lorsque la souris entre du bouton.
     * Appelle la fonction qui change les couleurs du bouton.
     * @param evenement géré en dehors du code.
     */
    @Override
	public void mouseExited(MouseEvent e) {
        bouton.setHoverColor(false, new Color(0,161,67),new Color(255,255,255));
    }

    /**
     * Interraction lorsque la souris entre du bouton.
     * Appelle la fonction qui change les couleurs du bouton.
     * @param evenement géré en dehors du code.
     */
    @Override
	public void mouseEntered(MouseEvent e) {
        bouton.setHoverColor(true, new Color(0,161,67),new Color(255,255,255));
    }

    @Override
	public void mousePressed(MouseEvent e) {
	}

    @Override
	public void mouseReleased(MouseEvent e) {
	}
}