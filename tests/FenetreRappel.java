import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.Iterator;

public class FenetreRappel extends JPanel{
  private PanelHeader header;
  private PanelRappels rappels;
  private JScrollPane scrollPanel;

  public FenetreRappel(){
    header = new PanelHeader();
    rappels = new PanelRappels();
    scrollPanel = new JScrollPane(rappels);
    list = requete.getAllRappels();

    scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    scrollPanel.getVerticalScrollBar().setUnitIncrement(5);

    for(Iterator<Rappel> iter = list.iterator() ; iter.hasNext() ; ){
      Rappel rap = iter.next();
      rappels.addRappel(rap.titre, rap.contexte, rap.theme, rap.rang, rap.id);
    }


    this.setLayout(new BorderLayout());
    this.add(header, BorderLayout.NORTH);
    this.add(scrollPanel, BorderLayout.CENTER);
    this.setVisible(true);
  }
}
