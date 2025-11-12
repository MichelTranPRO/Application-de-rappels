import javax.swing.*;
import java.awt.*;

public class Bouton extends JComponent{
    private int largeur;
    private int hauteur;
    private int xTexte;
    private int yTexte;
    private int texteHauteur;
    private int texteLargeur;
    private Color fond;
    private Color texteCouleur;
    private String texte;
    private FontMetrics mesureTexte;

    public Bouton(int l, int h, String t, Color f, Color txtCouleur){
        this.largeur=l;
        this.hauteur=h;
        this.texte=t;
        this.fond=f;
        this.texteCouleur=txtCouleur;
        this.setPreferredSize(new Dimension(largeur, hauteur));
    }
    @Override
    protected void paintComponent(Graphics pinceau) {
        Graphics secondPinceau = pinceau.create();

        if (this.isOpaque()) {

        secondPinceau.setColor(this.getBackground());
        secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
        }
        secondPinceau.setColor(fond);
        secondPinceau.fillRoundRect(0, 0, largeur, hauteur, 10, 10);

        secondPinceau.setColor(texteCouleur);
        secondPinceau.setFont(new Font("Inter", Font.BOLD, 18));
        mesureTexte = secondPinceau.getFontMetrics();
        texteLargeur = mesureTexte.stringWidth(texte);
        texteHauteur = mesureTexte.getAscent();
        xTexte=(largeur - texteLargeur) / 2;
        yTexte = (hauteur + texteHauteur) / 2;
        secondPinceau.drawString(texte, xTexte, yTexte);
    }
}

