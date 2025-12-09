package fr.iutfbleau.papillon;

import java.awt.*;
import javax.swing.*;

public class BoutonSuppr extends JComponent{
    private int largeur;
    private int hauteur;
    private Image imageJaune;
    private Image imageBlanche;
    private Image imageActuelle;
    private ClassLoader loader;
    private Color fond;

    public BoutonSuppr(int l, int h, Color f) {
        this.largeur = l;
        this.hauteur = h;
        loader = Thread.currentThread().getContextClassLoader();

        this.imageJaune = new ImageIcon(loader.getResource("res/icons8-trash-yellow.png")).getImage();
        this.imageBlanche = new ImageIcon(loader.getResource("res/icons8-trash-white.png")).getImage();

        imageActuelle = imageJaune;
        this.fond = f;

        this.setPreferredSize(new Dimension(largeur, hauteur));
    }
    @Override
    protected void paintComponent(Graphics pinceau) {
        Graphics g = pinceau.create();

        g.setColor(fond);
        g.fillRoundRect(0, 0, largeur, hauteur, 10, 10);
        g.drawImage(imageActuelle, (largeur - 24) / 2, (hauteur - 24) / 2, this);
    
    }

    public void setHoverColor(boolean statut) {
        if (statut) {
            this.fond = new Color(255, 184, 0);
            this.imageActuelle = imageBlanche;
        } else {
            this.fond = new Color(255, 255, 255);
            this.imageActuelle= imageJaune;
        }
        repaint();
    }
}
