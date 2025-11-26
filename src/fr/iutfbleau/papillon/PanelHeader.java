import java.awt.*;
import javax.swing.*;

/**
 * La classe <code>PanelHeader</code> est utilisée pour gérer le panneau du haut de la fenetre
 * contenant les boutons pour ajouter un rappel, échanger un rappel et supprimer un rappel
 * 
 * @version 1.0
 * @author Emmanuelle Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */

public class PanelHeader extends JPanel{

    /**
     * Panneau qui contient les éléments à droite.
     */
    private JPanel panelDroite = new JPanel();

    /**
     * Panneau qui contient les éléments à gauche.
     */
    private JPanel panelGauche = new JPanel();

    /**
     * Bouton "Ajouter", pour ajouter un rappel.
     */
    private Bouton ajouterBtn = new Bouton(124,43, "Ajouter",Color.WHITE, new Color(255, 184, 0));

    /**
     * Bouton "⇄", pour échanger des rappels.
     */
    private Bouton modifBtn = new Bouton(43,43, "⇄",Color.WHITE, new Color(255, 184, 0));

    /**
     * Bouton "✕", pour supprimer un rappel.
     */
    private Bouton supprBtn = new Bouton(43,43, "✕",Color.WHITE, new Color(255, 184, 0));

    /**
     * Controlleur qui permet de gérer le bouton "Ajouter".
     */
    private Controlleur_ajouterBtn ctrl_ajouter = new Controlleur_ajouterBtn(ajouterBtn);

    /**
     * Controlleur qui permet de gérer le bouton "⇄".
     */
    private Controlleur_modifBtn ctrl_modif = new Controlleur_modifBtn(modifBtn);

    /**
     * Controlleur qui permet de gérer le bouton "✕".
     */
    private Controlleur_supprBtn ctrl_suppr = new Controlleur_supprBtn(supprBtn);

    /**
     * Le constructeur de la classe <code>PanelHeader</code> initialise tous les composants nécessaire à son affichage 
     */
    public PanelHeader(){
        panelDroite = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelGauche = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        ajouterBtn.addMouseListener(ctrl_ajouter);
        modifBtn.addMouseListener(ctrl_modif);
        supprBtn.addMouseListener(ctrl_suppr);

        panelDroite.add(modifBtn);
        panelDroite.add(supprBtn);
        panelDroite.setBackground(new Color(255, 235, 153));

        panelGauche.add(ajouterBtn);
        panelGauche.setBackground(new Color(255, 235, 153));

        this.setBackground(new Color(255, 235, 153));
        this.setLayout(new BorderLayout());
        this.add(panelGauche,BorderLayout.WEST);
        this.add(panelDroite,BorderLayout.EAST);
    }
}