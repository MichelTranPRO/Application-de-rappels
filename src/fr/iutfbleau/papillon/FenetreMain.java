package fr.iutfbleau.papillon;

import java.awt.*;
import javax.swing.*;

public class FenetreMain extends JFrame{
    private CardLayout cardLayout;
    private JPanel contenu;
    private FenetreRappel fenetreRappel;
    private FenetreAjout fenetreAjout;
    private FenetreConfirmation fenetreConfirmation;

    public FenetreMain(){
        cardLayout = new CardLayout();
        contenu = new JPanel(cardLayout);

        fenetreRappel = new FenetreRappel(this);
        fenetreAjout = new FenetreAjout(this);
        fenetreConfirmation = new FenetreConfirmation(this);

        contenu.add(fenetreRappel,"FENETRE_RAPPELS");
        contenu.add(fenetreAjout,"FENETRE_AJOUT");
        contenu.add(fenetreConfirmation, "FENETRE_CONFIRMATION");

        cardLayout.show(contenu, "FENETRE_RAPPELS");
        this.setLayout(new BorderLayout());
        this.add(contenu, BorderLayout.CENTER);
        this.pack();
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
/* 
        WindowAdapter adapter = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                setFenetre(3);
            }
        };
        this.addWindowListener(adapter);

        Faudrait le changer là
*/
        this.setVisible(true);
    }

    public void setFenetre(int indexFenetre){
        if(indexFenetre == 1){
            cardLayout.show(contenu, "FENETRE_RAPPELS");
        } else if (indexFenetre == 2) {
            cardLayout.show(contenu, "FENETRE_AJOUT");
        } else if (indexFenetre == 3) {
            cardLayout.show(contenu, "FENETRE_CONFIRMATION");
        }
    }
}
