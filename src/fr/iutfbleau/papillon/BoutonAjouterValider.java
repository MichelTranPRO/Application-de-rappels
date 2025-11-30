package fr.iutfbleau.papillon;
import fr.iutfbleau.papillon.Bouton;
import java.awt.*;
import javax.swing.*;



/**
 * La classe <code>Bouton</code> est utilisée 
 * pour créer un bouton personnalisable. 
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */

public class BoutonAjouterValider extends Bouton {

    private boolean dessineAjouter;
    public BoutonAjouterValider(int l, int h, String t, Color f, Color txtCouleur){
        super(l, h, t, f, txtCouleur);
        dessineAjouter=true;
    }
    /**
     * Dessine le composant.
     */
    @Override
    protected void paintComponent(Graphics pinceau) {
        
        Graphics secondPinceau = pinceau.create();
        if (dessineAjouter){
            secondPinceau.setColor(couleurActuelle);
            secondPinceau.fillRoundRect(0, 0, largeur, hauteur, 10, 10);

            secondPinceau.setColor(texteCouleurActuelle);
            secondPinceau.setFont(new Font("Dialog", Font.BOLD, 18));

            mesureTexte = secondPinceau.getFontMetrics();
            texteLargeur = mesureTexte.stringWidth("Ajouter");
            texteHauteur = mesureTexte.getAscent();

            xTexte = (largeur - texteLargeur) / 2;
            yTexte = (hauteur + texteHauteur) / 2 - 2; // petit ajustement esthetique

            secondPinceau.drawString("Ajouter", xTexte, yTexte);
        }
        if (!dessineAjouter){
            secondPinceau.setColor(couleurActuelle);
            secondPinceau.fillRoundRect(0, 0, largeur, hauteur, 10, 10);

            secondPinceau.setColor(texteCouleurActuelle);
            secondPinceau.setFont(new Font("Dialog", Font.BOLD, 18));

            mesureTexte = secondPinceau.getFontMetrics();
            texteLargeur = mesureTexte.stringWidth("Valider");
            texteHauteur = mesureTexte.getAscent();

            xTexte = (largeur - texteLargeur) / 2;
            yTexte = (hauteur + texteHauteur) / 2 - 2; // petit ajustement esthetique

            secondPinceau.drawString("Valider", xTexte, yTexte);
        }
    }

    public void setDessinAjouter(Boolean statut){
        this.dessineAjouter=statut;
    }
}
