import java.awt.*;
import javax.swing.*;

public class FenetreRappel extends JPanel{
    private PanelRappelHeader header;
    private PanelRappel content;
    public FenetreRappel(){
        header=new PanelRappelHeader();
        content=new PanelRappel();
        this.setLayout(new BorderLayout());
        this.add(header, BorderLayout.NORTH);
        this.add(content, BorderLayout.CENTER);
        this.setSize(390,300);
        this.setVisible(true);
    }
}