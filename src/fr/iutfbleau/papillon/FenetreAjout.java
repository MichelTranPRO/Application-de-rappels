package fr.iutfbleau.papillon;

import java.awt.*;
import javax.swing.*;

public class FenetreAjout extends JPanel{
    private int largeur;
    private int hauteur;
    private PanelAjoutHeader header;
    private PanelAjout ajout;
    private JPanel marges;

    public FenetreAjout(){
        header = new PanelAjoutHeader();
        ajout = new PanelAjout();
        marges = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        this.setLayout(new BorderLayout());
        this.add(header, BorderLayout.NORTH);
        marges.setBackground(Color.WHITE);
        marges.add(ajout);
        this.add(marges, BorderLayout.CENTER);
    }
}
