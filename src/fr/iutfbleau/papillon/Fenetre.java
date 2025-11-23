import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame{
    private int largeur;
    private int hauteur;
    private Bouton ajouterBtn;
    private Bouton modifBtn;
    private Bouton supprBtn;
    private JPanel panelHaut;
    private JPanel hautDroite;
    private JPanel hautGauche;
    private PanelRappels rappels;
    private JScrollPane scrollPanel;
    
    public Fenetre(){
        largeur = 461;
        hauteur = 367;
        panelHaut = new JPanel();
        hautDroite = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        hautGauche = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        ajouterBtn = new Bouton(124,43, "Ajouter",Color.WHITE, new Color(255, 184, 0));
        modifBtn = new Bouton(43,43, "⇄",Color.WHITE, new Color(255, 184, 0));
        supprBtn = new Bouton(43,43, "✕",Color.WHITE, new Color(255, 184, 0));
        rappels = new PanelRappels();
        scrollPanel = new JScrollPane(rappels);

        this.setSize(largeur,hauteur);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(255,255,255));

        hautDroite.add(modifBtn);
        hautDroite.add(supprBtn);
        hautDroite.setBackground(new Color(255, 235, 153));

        hautGauche.add(ajouterBtn);
        hautGauche.setBackground(new Color(255, 235, 153));

        panelHaut.setBackground(new Color(255, 235, 153));
        panelHaut.setPreferredSize(new Dimension(largeur, 63));
        panelHaut.setLayout(new BorderLayout());
        panelHaut.add(hautGauche,BorderLayout.WEST);
        panelHaut.add(hautDroite,BorderLayout.EAST);

        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPanel.getVerticalScrollBar().setUnitIncrement(5);

        rappels.addRappel("Bois un verre d'eau tout suite maintenant", "test", 0, 1);
        rappels.addRappel("Bois un verre d'eau tout suite maintenant", "test", 1, 2);
        rappels.addRappel("Bois un verre d'eau tout suite maintenant", "test", 2, 3);
        rappels.addRappel("Bois un verre d'eau tout suite maintenant", "test", 3, 4);
        rappels.addRappel("Bois un verre d'eau tout suite maintenant", "test", 4, 5);

        this.setLayout(new BorderLayout());
        this.add(panelHaut, BorderLayout.NORTH);
        this.add(scrollPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }
}