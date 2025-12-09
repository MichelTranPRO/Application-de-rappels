package fr.iutfbleau.papillon;
import java.awt.*;
import javax.swing.*;

public class FenetreRappel extends JPanel{
    private Rappel rappel;
    private FenetreAccueil fenetreAccueil;
    private PanelRappelHeader header;
    private PanelRappel content;
    private JPanel marges;
    public FenetreRappel(Rappel rappel, FenetreAccueil fenetreAccueil){
        this.rappel=rappel;
        this.fenetreAccueil=fenetreAccueil;
        header=new PanelRappelHeader(this);
        content=new PanelRappel(rappel,this);
        marges = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        this.setLayout(new BorderLayout());
        this.add(header, BorderLayout.NORTH);
        marges.setBackground(Color.WHITE);
        marges.add(content);
        this.add(marges, BorderLayout.CENTER);
    }
    public void returnFenetreAccueil(){
        fenetreAccueil.returnFenetreAccueil();
    }

    public void updateRappel(int id, int theme, String title, String context){
        Requete.update(id, title, context, theme);
        this.returnFenetreAccueil();
    }
}
