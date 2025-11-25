import java.awt.*;
import javax.swing.*;

public class Fenetre_ajout extends JFrame{
    private int largeur;
    private int hauteur;
    private PanelAjoutHeader header;
    private PanelAjout ajout;
    private JPanel marges;

    public Fenetre_ajout(){
        header = new PanelAjoutHeader();
        ajout = new PanelAjout();
        marges = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);

        this.setLayout(new BorderLayout());
        this.add(header, BorderLayout.NORTH);
        marges.setBackground(Color.WHITE);
        marges.add(ajout);
        this.add(marges, BorderLayout.CENTER);

        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }
}