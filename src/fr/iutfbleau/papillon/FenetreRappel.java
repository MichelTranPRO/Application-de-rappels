package fr.iutfbleau.papillon;

import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.Iterator;

public class FenetreRappel extends JPanel{
  private FenetreMain fenetreMain;
  private PanelRappelsHeader header;
  private PanelRappels rappels;
  private JScrollPane scrollPanel;
  private List<Rappel> list;

  public FenetreRappel(FenetreMain fenetreMain){
    this.fenetreMain = fenetreMain;
    header = new PanelRappelsHeader(this);
    rappels = new PanelRappels();
    scrollPanel = new JScrollPane(rappels);
    list = Requete.getAllRappels();

    scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    scrollPanel.getVerticalScrollBar().setUnitIncrement(5);

    int rank = 1;
    for(Iterator<Rappel> iter = list.iterator() ; iter.hasNext() ; rank++){
      Rappel rap = iter.next();
      rappels.addRappel(rap.getTitle(), rap.getContent(), rap.getTheme(), rank, rap.getId());
    }


    this.setLayout(new BorderLayout());
    this.add(header, BorderLayout.NORTH);
    this.add(scrollPanel, BorderLayout.CENTER);
    this.setVisible(true);
  }

  public void setFenetreAjoutVisible(){
    fenetreMain.setFenetre(2);
  }
}
