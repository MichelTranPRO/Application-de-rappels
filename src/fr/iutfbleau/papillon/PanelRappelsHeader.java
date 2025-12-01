package fr.iutfbleau.papillon;
import java.awt.*;
import javax.swing.*;


/**
 * La classe <code>PanelHeader</code> est utilisée pour gérer le panneau du haut de la fenetre
 * contenant les boutons pour ajouter un rappel, échanger un rappel et supprimer un rappel
 * 
 * @version 1.0
 * @author Emmanuelle Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */

public class PanelRappelsHeader extends JPanel{

    /**
     * Panneau qui contient les éléments à droite.
     */
    private JPanel panelDroite;

    /**
     * Panneau qui contient les éléments à gauche.
     */
    private JPanel panelGauche;

    /**
     * Bouton "Ajouter", pour ajouter un rappel.
     */
    private BoutonAjouterValider ajouterBtn;

    /**
     * Bouton "⇄", pour échanger des rappels.
     */
    private Bouton modifBtn ;

    /**
     * Bouton "✕", pour supprimer un rappel.
     */
    private Bouton supprBtn;

    /**
     * Bouton "✕", pour quitter l'application.
     */
    private Bouton quitterBtn;

    /**
     * Controlleur qui permet de gérer le bouton "Ajouter".
     */
    private ControlleurAjouterValiderBtn ctrl_ajouter;

    /**
     * Controlleur qui permet de gérer le bouton "⇄".
     */
    private ControlleurModifBtn ctrl_modif;

    private ControleurQuitterBtn ctrl_quitter;

    /**
     * Controlleur qui permet de gérer le bouton "✕".
     */
    private ControlleurSupprBtn ctrl_suppr;

    private FenetreRappel fenetreRappel;
    private PanelRappels panelRappels;
    private boolean statutModifBtn;

    /**
     * Le constructeur de la classe <code>PanelHeader</code> initialise tous les composants nécessaire à son affichage 
     */
    public PanelRappelsHeader(FenetreRappel fenetreRappel, PanelRappels panelRappels){
        this.fenetreRappel=fenetreRappel;
        statutModifBtn=false;

        //JPanel
        panelDroite= new JPanel();
        panelGauche= new JPanel();

        // Boutons
        ajouterBtn = new BoutonAjouterValider(124,43, "Ajouter",Color.WHITE, new Color(255, 184, 0));
        modifBtn = new Bouton(43,43, "⇄",Color.WHITE, new Color(255, 184, 0));
        supprBtn = new Bouton(43,43, "🗑️",Color.WHITE, new Color(255, 184, 0));
        quitterBtn = new Bouton(43,43, "✕",Color.WHITE, new Color(255, 184, 0));

        // Controlleurs
        ctrl_ajouter = new ControlleurAjouterValiderBtn(ajouterBtn,this,panelRappels);
        ctrl_modif = new ControlleurModifBtn(modifBtn, panelRappels,this);
        ctrl_suppr = new ControlleurSupprBtn(supprBtn);
        ctrl_quitter = new ControleurQuitterBtn(quitterBtn,this);
        
        // Panels
        panelDroite = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelGauche = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        
        // Affectation des controlleurs
        ajouterBtn.addMouseListener(ctrl_ajouter);
        modifBtn.addMouseListener(ctrl_modif);
        supprBtn.addMouseListener(ctrl_suppr);
        quitterBtn.addMouseListener(ctrl_quitter);

        panelDroite.add(modifBtn);
        panelDroite.add(supprBtn);
        panelDroite.add(quitterBtn);
        panelDroite.setBackground(new Color(255, 235, 153));

        panelGauche.add(ajouterBtn);
        panelGauche.setBackground(new Color(255, 235, 153));

        this.setBackground(new Color(255, 235, 153));
        this.setLayout(new BorderLayout());
        this.add(panelGauche,BorderLayout.WEST);
        this.add(panelDroite,BorderLayout.EAST);
    }

    public void quit(){
        fenetreRappel.quit();
    }

    public void setFenetreAjoutVisible(){
        fenetreRappel.setFenetreAjoutVisible();
    }

    public void setStatutModifBtn(Boolean statut){
        this.statutModifBtn=statut;
        if (statut){
            ajouterBtn.setDessinAjouter(false);
            repaint();
        }
        if (!statut){
            ajouterBtn.setDessinAjouter(true);
            repaint();
        }
    }

    public boolean getStatutModifBtn(){
        return this.statutModifBtn;
    }
}