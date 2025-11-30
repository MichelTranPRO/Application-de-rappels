package fr.iutfbleau.papillon;

import java.awt.*;
import javax.swing.*;

public class FenetreMain extends JFrame{
    private CardLayout cardLayout;
    private JPanel contenu;
    private FenetreRappel fenetreRappel;
    private FenetreAjout fenetreAjout;
    public FenetreMain(){
        cardLayout = new CardLayout();
        contenu = new JPanel(cardLayout);
        fenetreRappel = new FenetreRappel(this);
        fenetreAjout = new FenetreAjout(this);

        contenu.add(fenetreRappel,"FENETRE_RAPPELS");
        contenu.add(fenetreAjout,"FENETRE_AJOUT");

        cardLayout.show(contenu, "FENETRE_RAPPELS");
        this.setLayout(new BorderLayout());
        this.add(contenu, BorderLayout.CENTER);
        this.pack();
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void quit(){
        this.dispose();
    }

    public void setFenetre(int indexFenetre){
        if(indexFenetre == 1){
            cardLayout.show(contenu, "FENETRE_RAPPELS");
        } else if (indexFenetre == 2) {
            cardLayout.show(contenu, "FENETRE_AJOUT");
        }
    }
}
