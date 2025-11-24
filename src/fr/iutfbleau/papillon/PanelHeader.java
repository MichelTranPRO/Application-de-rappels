import javax.swing.*;
import java.awt.*;

public class PanelHeader extends JPanel{
    private JPanel panelDroite = new JPanel();
    private JPanel panelGauche = new JPanel();
    private Bouton ajouterBtn;
    private Bouton modifBtn;
    private Bouton supprBtn;

    public PanelHeader(){
        panelDroite = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelGauche = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        ajouterBtn = new Bouton(124,43, "Ajouter",Color.WHITE, new Color(255, 184, 0));
        modifBtn = new Bouton(43,43, "⇄",Color.WHITE, new Color(255, 184, 0));
        supprBtn = new Bouton(43,43, "✕",Color.WHITE, new Color(255, 184, 0));

        panelDroite.add(modifBtn);
        panelDroite.add(supprBtn);
        panelDroite.setBackground(new Color(255, 235, 153));

        panelGauche.add(ajouterBtn);
        panelGauche.setBackground(new Color(255, 235, 153));

        this.setBackground(new Color(255, 235, 153));
        this.setPreferredSize(new Dimension(461, 63));
        this.setLayout(new BorderLayout());
        this.add(panelGauche,BorderLayout.WEST);
        this.add(panelDroite,BorderLayout.EAST);
    }
}