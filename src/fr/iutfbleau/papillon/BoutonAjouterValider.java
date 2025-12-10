package fr.iutfbleau.papillon;

import java.awt.*;



/**
 * La classe <code>BoutonAjouterValider</code> est hérite de la classe <code>Bouton</code>
 * elle permet d'afficher un bouton différent en fonction de son controleur. 
 * 
 * @version 1.0
 * @author Emmanuel Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */

public class BoutonAjouterValider extends Bouton {
    /**
     * Boolean qui permet de savoir quel bouton affciher.
     */
    private boolean dessineAjouter;

    /** Constructeur de la classe <code>BoutonAjouterValider<code>.
     * Defini les paramètres pour créer un objet de la classe.
     * @param l Longeur du bouton.
     * @param h Hauteur du bouton.
     * @param t Texte à afficher.
     * @param f Couleur en en fond du bouton.
     * @param txtCouleur Couleur du texte.
    */
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
    /**
     * Méthode qui permet de d'affichier le bouton "Ajouter" ou non.
     */
    public void setVisibleDessinAjouter(Boolean statut){
        this.dessineAjouter=statut;
    }
}
