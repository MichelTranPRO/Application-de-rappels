package fr.iutfbleau.papillon;

import java.awt.*;
import javax.swing.*;



public class Rappel extends JComponent{
    private int largeur;
    private int hauteur;
    private int hauteurTexte;
    private String titre;
    private String contexte;
    private int theme;
    private int rang;
    private int id;
    private Color fond;
    private Color texteCouleur;
    private Color[][] tabTheme;
    private FontMetrics mesureTexte;
    private int texteHauteur;
    private int texteLargeur;
    private int xTexte;
    private int yTexte;
    private Color couleurActuelle;
    private Color texteCouleurActuelle;

    public Rappel(String titre, String contexte, int theme, int rang, int id){
        this.titre=titre;
        this.contexte=contexte;
        this.theme=theme;
        this.rang=rang;
        this.id = id;

        this.largeur=375;
        this.hauteur=49;
        this.setPreferredSize(new Dimension(largeur, hauteur));

        this.tabTheme = new Color[][]{
        {new Color(243, 232, 255),new Color(227, 212, 255),new Color(139, 92, 246)}, // violet : Couleur principale, couleur secondaire, couleur texte 
        {new Color(238, 244, 255),new Color(207, 225, 255),new Color(26, 115, 234)}, // bleu
        {new Color(221, 255, 223),new Color(191, 255, 208),new Color(0, 168, 107)}, // vert
        {new Color(255, 237, 235),new Color(255, 207, 203),new Color(255, 59, 48)}, // rouge
        {new Color(255, 231, 207),new Color(255, 209, 164),new Color(255, 127, 0)}  // orange
        };

        this.couleurActuelle =tabTheme[theme][0];
        this.texteCouleurActuelle= tabTheme[theme][2];
    }
    /**
     * Dessine le rappel.
     */
    @Override
    protected void paintComponent(Graphics pinceau) {
        Graphics secondPinceau = pinceau.create();

        if (this.isOpaque()) {

        secondPinceau.setColor(this.getBackground());
        secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
        }

        //Fond
        secondPinceau.setColor(couleurActuelle);
        secondPinceau.fillRoundRect(0, 0, largeur, hauteur, 10, 10);

        mesureTexte = secondPinceau.getFontMetrics();

        //Titre
        secondPinceau.setColor(texteCouleurActuelle);
        secondPinceau.setFont(new Font("Dialog", Font.BOLD, 14));
        texteHauteur = mesureTexte.getAscent();
        xTexte= 10;
        yTexte = (hauteur  + texteHauteur) / 2;
        secondPinceau.drawString(titre, xTexte, yTexte);

    }
    
    // Getters pour pouvoir afficher le contenu du rappel

    public int getId(){
      return id;
    }
    
    public String getTitle(){
      return titre;
    }

    public String getContent(){
      return contexte;
    }

    public int getTheme(){
      return theme;
    }

    public void setColorModify(boolean statut){
        if (statut) {
            this.couleurActuelle = tabTheme[theme][1];
            this.texteCouleurActuelle = tabTheme[theme][2];
        } else {
            this.couleurActuelle = tabTheme[theme][0];
            this.texteCouleurActuelle = tabTheme[theme][2];
        }
        repaint();
    }
}

