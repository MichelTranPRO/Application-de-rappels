package fr.iutfbleau.papillon;

import java.awt.*;
import javax.swing.*;

/**
 * La classe <code>Rappel</code> représente un rappel avec ses attributs et méthodes pour la gestion de son affichage.
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */
public class Rappel extends JComponent{

    /**
     * Largeur du rappel.
     */
    private int largeur;

    /**
     * Hauteur du rappel.
     */
    private int hauteur;

    /**
     * Titre du rappel.
     */
    private String titre;

    /**
     * Contenu du rappel.
     */
    private String contexte;

    /**
     * Thème du rappel.
     */
    private int theme;

    /**
     * Rang du rappel.
     */
    private int rang;

    /**
     * Identifiant unique du rappel.
     */
    private int id;

    /**
     * Tableau des thèmes avec leurs couleurs associées.
     */
    private Color[][] tabTheme;

    /**
     * Mesure du texte pour le dessin.
     */
    private FontMetrics mesureTexte;

    /**
     * Hauteur du texte.
     */
    private int texteHauteur;

    /**
     * Position X du texte.
     */
    private int xTexte;

    /**
     * Position Y du texte.
     */
    private int yTexte;

    /**
     * Couleur actuelle du rappel.
     */
    private Color couleurActuelle;

    /**
     * Couleur actuelle du texte du rappel.
     */
    private Color texteCouleurActuelle;

    /**
     * Statut du mode modification.
     */
    private boolean statutModeModif;

    /**
     * Statut du mode modification.
     */
    private boolean selectedModif;

    /**
     * Statut du mode suppression.
     */
    private boolean selectedSuppr;

    /**
     * Statut du mode suppression.
     */
    private boolean statutModeSuppr;

    public Rappel(String titre, String contexte, int theme, int rang, int id){
        this.titre=titre;
        this.contexte=contexte;
        this.theme=theme;
        this.rang=rang;
        this.id = id;

        this.largeur=355;
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

        this.statutModeModif=false;
        this.selectedModif=false;
        this.statutModeSuppr=false;
        this.selectedSuppr=false;
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
    public int getRank(){
      return rang;
    }

    public void setRank(int num){
      this.rang=num;
    }

    public void setHoverColor(Boolean statutHover){
      if (statutHover) {
            this.couleurActuelle = tabTheme[theme][2];
            this.texteCouleurActuelle = tabTheme[theme][1];
        } else {
            this.couleurActuelle = tabTheme[theme][0];
            this.texteCouleurActuelle = tabTheme[theme][2];
        }
        repaint();
    }

    // ======== METHODES POUR LE MODE MODIF ========
    public void setColorModif(boolean statutColorModif){
      if (statutColorModif){
        this.couleurActuelle = tabTheme[theme][1];
        this.texteCouleurActuelle = tabTheme[theme][2];
      }
      if (!statutColorModif){
        this.couleurActuelle = tabTheme[theme][0];
        this.texteCouleurActuelle = tabTheme[theme][2];
      }
      repaint();
    }

    public void setColorModifHover(boolean statutColorModifHover){
      if (statutColorModifHover){
        this.couleurActuelle = tabTheme[theme][2];
        this.texteCouleurActuelle = tabTheme[theme][1];
      }
      if (!statutColorModifHover){
        this.couleurActuelle = tabTheme[theme][1];
        this.texteCouleurActuelle = tabTheme[theme][2];
      }
      repaint();
    }

    public void setModeModif(boolean statut){
      this.statutModeModif=statut;
    }

    public Boolean getModeModif(){
      return statutModeModif;
    }

    public boolean isSelectedModif() {
        return selectedModif;
    }

    public void setSelectedModif(boolean b) {
        this.selectedModif = b;
    }
    // =================================================
    
    // ======== METHODES POUR LE MODE SUPPRIMER ========
    public void setColorSuppr(boolean statutColorSuppr){
      if (statutColorSuppr){
        this.couleurActuelle = tabTheme[theme][1];
        this.texteCouleurActuelle = tabTheme[theme][2];
      }
      if (!statutColorSuppr){
        this.couleurActuelle = tabTheme[theme][0];
        this.texteCouleurActuelle = tabTheme[theme][2];
      }
      repaint();
    }

    public void setColorSupprHover(boolean statutColorSupprHover){
      if (statutColorSupprHover){
        this.couleurActuelle = tabTheme[theme][2];
        this.texteCouleurActuelle = tabTheme[theme][1];
      }
      if (!statutColorSupprHover){
        this.couleurActuelle = tabTheme[theme][1];
        this.texteCouleurActuelle = tabTheme[theme][2];
      }
      repaint();
    }

    public void setModeSuppr(boolean statut){
      this.statutModeSuppr=statut;
    }

    public Boolean getModeSuppr(){
      return statutModeSuppr;
    }

    public boolean isSelectedSuppr() {
        return selectedSuppr;
    }

    public void setSelectedSuppr(boolean b) {
        this.selectedSuppr = b;
    }
    // =================================================
}

