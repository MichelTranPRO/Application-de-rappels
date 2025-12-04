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
    private BoutonAjouterValider ajouterValiderBtn;

    /**
     * Bouton "⇄", pour échanger des rappels.
     */
    private Bouton modifBtn ;

    /**
     * Bouton "✕", pour supprimer un rappel.
     */
    private Bouton supprBtn;


    /**
     * Controlleur qui permet de gérer le bouton "Ajouter".
     */
    private ControlleurAjouterValiderBtn ctrlAjouterValider;

    /**
     * Controlleur qui permet de gérer le bouton "⇄".
     */
    private ControlleurModifBtn ctrlModif;


    /**
     * Controlleur qui permet de gérer le bouton "✕".
     */
    private ControlleurSupprBtn ctrlSuppr;

    private FenetreRappel fenetreRappel;
    private PanelRappels panelRappels;
    private boolean statutModifBtn;

    /**
     * Le constructeur de la classe <code>PanelHeader</code> initialise tous les composants nécessaire à son affichage 
     */
    public PanelRappelsHeader(FenetreRappel fenetreRappel, PanelRappels panelRappels){
        this.fenetreRappel=fenetreRappel;
        this.panelRappels=panelRappels;
        statutModifBtn=false;

        //JPanel
        panelDroite= new JPanel();
        panelGauche= new JPanel();

        // Boutons
        ajouterValiderBtn = new BoutonAjouterValider(124,33, "Ajouter",Color.WHITE, new Color(255, 184, 0));
        modifBtn = new Bouton(33,33, "⇄",Color.WHITE, new Color(255, 184, 0));
        supprBtn = new Bouton(33,33, "🗑️",Color.WHITE, new Color(255, 184, 0));

        // Controlleurs
        ctrlAjouterValider = new ControlleurAjouterValiderBtn(ajouterValiderBtn,this,panelRappels);
        ctrlModif = new ControlleurModifBtn(modifBtn, this);
        ctrlSuppr = new ControlleurSupprBtn(supprBtn);
        
        // Panels
        panelDroite = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelGauche = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        
        // Affectation des controlleurs
        ajouterValiderBtn.addMouseListener(ctrlAjouterValider);
        modifBtn.addMouseListener(ctrlModif);
        supprBtn.addMouseListener(ctrlSuppr);

        panelDroite.add(modifBtn);
        panelDroite.add(supprBtn);
        panelDroite.setBackground(new Color(255, 235, 153));

        panelGauche.add(ajouterValiderBtn);
        panelGauche.setBackground(new Color(255, 235, 153));

        this.setBackground(new Color(255, 235, 153));
        this.setLayout(new BorderLayout());
        this.add(panelGauche,BorderLayout.WEST);
        this.add(panelDroite,BorderLayout.EAST);
    }

    public void setFenetreAjoutVisible(){
        fenetreRappel.setFenetreAjoutVisible();
    }

    public void setModeModif(Boolean statut){
        this.statutModifBtn=statut;
        if (statut){
            ajouterValiderBtn.setVisibleDessinAjouter(false); // afficher le bouton "valider"
            modifBtn.setHoverColor(true, new Color(255,184,0), new Color(255,255,255));
            panelRappels.setModeModif(true);
        }
        if (!statut){
            ajouterValiderBtn.setVisibleDessinAjouter(true); // afficher le bouton "ajouter"
            modifBtn.setHoverColor(false, new Color(255,184,0), new Color(255,255,255));
            panelRappels.setModeModif(false);
        }
        repaint();
    }

    public boolean getStatutModifBtn(){
        return this.statutModifBtn;
    }
}
