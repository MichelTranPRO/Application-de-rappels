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
    private Color fond;
    private Color texteCouleur;
    private Color[][] tabTheme;
    private FontMetrics mesureTexte;
    private int texteHauteur;
    private int texteLargeur;
    private int xTexte;
    private int yTexte;

    public Rappel(String titre, String contexte, int theme, int rang){
        this.titre=titre;
        this.contexte=contexte;
        this.theme=theme;
        this.rang=rang;

        this.largeur=362;
        this.hauteur=49;
        this.setPreferredSize(new Dimension(largeur, hauteur));

        this.tabTheme = new Color[][]{
        {new Color(243, 232, 255),new Color(227, 212, 255),new Color(139, 92, 246)}, // violet : Couleur principale, couleur secondaire, couleur texte 
        {new Color(238, 244, 255),new Color(207, 225, 255),new Color(26, 115, 234)}, // bleu
        {new Color(221, 255, 223),new Color(191, 255, 208),new Color(0, 168, 107)}, // vert
        {new Color(255, 237, 235),new Color(255, 207, 203),new Color(255, 59, 48)}, // rouge
        {new Color(255, 231, 207),new Color(255, 209, 164),new Color(255, 127, 0)}  // orange
        };
    }
    @Override
    protected void paintComponent(Graphics pinceau) {
        Graphics secondPinceau = pinceau.create();

        if (this.isOpaque()) {

        secondPinceau.setColor(this.getBackground());
        secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
        }

        //Fond
        secondPinceau.setColor(tabTheme[theme][0]);
        secondPinceau.fillRoundRect(0, 0, largeur, hauteur, 10, 10);
        
        //Carré texte
        secondPinceau.setColor(tabTheme[theme][1]);
        secondPinceau.fillRoundRect(largeur-(10+24),(hauteur/2)-(24/2),24 ,24 ,10 ,10);

        //Texte dans le carré
        secondPinceau.setColor(tabTheme[theme][2]);
        secondPinceau.setFont(new Font("Serif", Font.BOLD, 16));
        mesureTexte = secondPinceau.getFontMetrics();
        texteLargeur = mesureTexte.stringWidth("⤢");
        texteHauteur = mesureTexte.getAscent();
        xTexte= largeur-(10+26)+(26 - texteLargeur) / 2+1;
        yTexte = (hauteur/2)-(26/2)+(26 + texteHauteur) / 2-1;
        secondPinceau.drawString("⤢", xTexte, yTexte);

        //Titre
        secondPinceau.setColor(tabTheme[theme][2]);
        secondPinceau.setFont(new Font("Dialog", Font.BOLD, 12));
        texteHauteur = mesureTexte.getAscent();
        xTexte= 10;
        yTexte = (hauteur  + texteHauteur) / 2;
        secondPinceau.drawString(titre, xTexte, yTexte);

    }
}

