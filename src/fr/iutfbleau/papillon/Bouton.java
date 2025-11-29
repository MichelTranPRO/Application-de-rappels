package fr.iutfbleau.papillon;

import java.awt.*;
import javax.swing.*;

public class Bouton extends JComponent {

    /**
     * Largeur du bouton.
     */
    private int largeur;

    /**
     * Hauteur du bouton.
     */
    private int hauteur;

    /**
     * Position X du texte à afficher.
     */
    private int xTexte;

    /**
     * Postion Y du texte à afficher.
     */
    private int yTexte;

    /** 
     * Dimension, hauteur du texte.
     */
    private int texteHauteur;

    /**
     * Dimension, largeur du texte.
     */
    private int texteLargeur;

    /**
     * Couleur du fond par défaut.
     */
    private Color fond;

    /**
     * Couleur du fond actuel.
     */
    private Color couleurActuelle;

    /**
     * Couleur du texte actuel.
     */
    private Color texteCouleurActuelle;

    /**
     * Couleur du texte par défaut.
     */
    private Color texteCouleur;

    /**
     * Texte à afficher.
     */
    private String texte;

    /**
     * Outil qui permet de pendre les mesures du texte.
     */
    private FontMetrics mesureTexte;

    public Bouton(int l, int h, String t, Color f, Color txtCouleur) {
        this.largeur = l;
        this.hauteur = h;

        this.couleurActuelle = f;
        this.texteCouleurActuelle = txtCouleur;

        this.texte = t;
        this.fond = f;
        this.texteCouleur = txtCouleur;

        this.setPreferredSize(new Dimension(largeur, hauteur));
    }

    public void setHover(boolean statut, Color couleurHover, Color texteHover) {
        if (statut) {
            this.couleurActuelle = couleurHover;
            this.texteCouleurActuelle = texteHover;
        } else {
            this.couleurActuelle = fond;
            this.texteCouleurActuelle = texteCouleur;
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics pinceau) {
        Graphics secondPinceau = pinceau.create();

        secondPinceau.setColor(couleurActuelle);
        secondPinceau.fillRoundRect(0, 0, largeur, hauteur, 10, 10);

        secondPinceau.setColor(texteCouleurActuelle);
        secondPinceau.setFont(new Font("Dialog", Font.BOLD, 18));

        mesureTexte = secondPinceau.getFontMetrics();
        texteLargeur = mesureTexte.stringWidth(texte);
        texteHauteur = mesureTexte.getAscent();

        xTexte = (largeur - texteLargeur) / 2;
        yTexte = (hauteur + texteHauteur) / 2 - 2; // petit ajustement esthetique

        secondPinceau.drawString(texte, xTexte, yTexte);
    }
}
