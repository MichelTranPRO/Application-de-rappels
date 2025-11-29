package fr.iutfbleau.papillon;

import java.awt.*;
import javax.swing.*;

public class FenetreMain extends JFrame{
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private FenetreAjout fenetreAjout;
    public FenetreMain(){
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.cardLayout = new CardLayout();
        this.mainPanel = new JPanel(cardLayout);
        this.fenetreAjout = new FenetreAjout();
        this.add(mainPanel);

        mainPanel.add(fenetreAjout,"fenetreAjout");
        cardLayout.show(mainPanel, "card2");

        
        this.pack();
        this.setVisible(true);

    }
    
}
