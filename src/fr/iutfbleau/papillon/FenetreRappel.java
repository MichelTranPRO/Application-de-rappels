package fr.iutfbleau.papillon;

import java.awt.*;
import javax.swing.*;

public class FenetreRappel extends JPanel{
  private FenetreMain fenetreMain;
  private PanelRappelsHeader header;
  private PanelRappels rappels;
  private JScrollPane scrollPanel;

  public FenetreRappel(FenetreMain fenetreMain){
    this.fenetreMain = fenetreMain;
    rappels = new PanelRappels();
    header = new PanelRappelsHeader(this,rappels);
    scrollPanel = new JScrollPane(rappels);

    scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    scrollPanel.getVerticalScrollBar().setUnitIncrement(7);
    scrollPanel.setPreferredSize(new Dimension(400,215));

    for (int i=0; i<=4 ; i++){
      rappels.addRappel(new Rappel("Rappel "+i, "aaa",i,i,i));
    }

    this.setLayout(new BorderLayout());
    this.add(header, BorderLayout.NORTH);
    this.add(scrollPanel, BorderLayout.CENTER);
    this.setVisible(true);
  }

  public void quit(){
    fenetreMain.quit();
  }

  public void setFenetreAjoutVisible(){
    fenetreMain.setFenetre(2);
  }
}
