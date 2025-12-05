

import java.awt.*;
import javax.swing.*;

public class Theme extends JComponent{
    private Color couleurTheme;
    private int largeur;
    private int hauteur;
    public int num;
    
    public Theme(Color couleur,int n){
        this.couleurTheme=couleur;
        this.num=n;
        this.largeur=20;
        this.hauteur=largeur;
        this.setPreferredSize(new Dimension(largeur, hauteur));
    }
    @Override
    protected void paintComponent(Graphics pinceau) {
        Graphics secondPinceau = pinceau.create();
        secondPinceau.setColor(couleurTheme);
        secondPinceau.fillOval(0,0,largeur,hauteur);
    }

    public int getNumTheme(){
        return this.num;
    }

    public void setColorTheme(Color nvColor){
        this.couleurTheme=nvColor;
        repaint();
    }
}
