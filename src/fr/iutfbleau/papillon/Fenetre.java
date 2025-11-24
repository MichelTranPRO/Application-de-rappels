import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame{
    private int largeur;
    private int hauteur;
    private PanelHeader header;
    private PanelRappels rappels;
    private JScrollPane scrollPanel;
    
    public Fenetre(){
        largeur = 461;
        hauteur = 367;
        header = new PanelHeader();
        rappels = new PanelRappels();
        scrollPanel = new JScrollPane(rappels);

        this.setSize(largeur,hauteur);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(255,255,255));

        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPanel.getVerticalScrollBar().setUnitIncrement(5);

        rappels.addRappel("Bois un verre d'eau tout suite maintenant", "test", 0, 1);
        rappels.addRappel("Bois un verre d'eau tout suite maintenant", "test", 1, 2);
        rappels.addRappel("Bois un verre d'eau tout suite maintenant", "test", 2, 3);
        rappels.addRappel("Bois un verre d'eau tout suite maintenant", "test", 3, 4);
        rappels.addRappel("Bois un verre d'eau tout suite maintenant", "test", 4, 5);
        rappels.addRappel("Bois un verre d'eau tout suite maintenant", "test", 4, 6);
        rappels.addRappel("Bois un verre d'eau tout suite maintenant", "test", 4, 7);
        rappels.addRappel("Bois un verre d'eau tout suite maintenant", "test", 4, 8);

        this.setLayout(new BorderLayout());
        this.add(header, BorderLayout.NORTH);
        this.add(scrollPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }
}