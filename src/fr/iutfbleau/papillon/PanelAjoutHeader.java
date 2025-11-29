package fr.iutfbleau.papillon;

import java.awt.*;
import javax.swing.*;

/**
 * La classe <code>PanelHeader</code> est utilisée pour gérer le panneau du haut de la fenetre
 * contenant les boutons pour ajouter un rappel, échanger un rappel et supprimer un rappel
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */

public class PanelAjoutHeader extends JPanel{

    /**
     * Bouton "Retour", pour ajouter un rappel.
     */
    private Bouton retourBtn;

    /**
     * Le constructeur de la classe <code>PanelAjoutHeader</code> initialise tous les composants nécessaire à son affichage 
     */
    public PanelAjoutHeader(){

        retourBtn = new Bouton(400, 43, "Retour", Color.WHITE, new Color(255, 184, 0));

        retourBtn.addMouseListener(new ControlleurRetourBtn(retourBtn));

        this.add(retourBtn);
        this.setBackground(new Color(255, 235, 153));
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
    }

    /**
     * getter de type Bouton pour le bouton Retour et obtenir ses parametres
     * 
     * @return le bouton de retour
     */
    public Bouton getBtnRetour() {
    	return this.retourBtn;
    }
}
