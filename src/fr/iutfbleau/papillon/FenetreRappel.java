package fr.iutfbleau.papillon;

import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.Iterator;

public class FenetreRappel extends JPanel{
  private PanelHeader header;
  private PanelRappels rappels;
  private JScrollPane scrollPanel;
  private List<Rappel> list;

  public FenetreRappel(){
    header = new PanelHeader();
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
}
