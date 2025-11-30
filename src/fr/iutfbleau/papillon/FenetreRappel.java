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
    scrollPanel.setPreferredSize(new Dimension(400,215));

    int rank = 1;
    for(Iterator<Rappel> iter = list.iterator() ; iter.hasNext() ; rank++){
      Rappel rap = iter.next();
      rappels.addRappel(rap.getTitle(), rap.getContent(), rap.getTheme(), rank, rap.getId());
    }

    for (int i=0; i<7 ; i++){
      rappels.addRappel("Rappel "+i, "aaa",i%4,i,i);
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
