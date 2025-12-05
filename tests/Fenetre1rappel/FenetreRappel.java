import java.awt.*;
import javax.swing.*;

public class FenetreRappel extends JFrame{
    private PanelRappelHeader header;
    private PanelRappel containt;
    public FenetreRappel(){
        header=new PanelRappelHeader();
        containt=new PanelRappel();
        this.setLayout(new BorderLayout());
        this.add(header, BorderLayout.NORTH);
        this.add(containt, BorderLayout.CENTER);

        this.setVisible(true);
    }
}