import java.awt.*;
import javax.swing.*;

public class PanelRappels extends JPanel{
    private GridBagConstraints contraintes;

    public PanelRappels(){
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);
    }

    public void addRappel(String titre, String contexte, int theme, int rang, int id){
        contraintes = new GridBagConstraints();
        contraintes.gridx = 0;
        contraintes.gridy = rang;
        contraintes.weightx = 1.0;
        contraintes.insets = new Insets(10, 10, 0, 10); 
        this.add(new Rappel(titre,contexte,theme,rang,id),contraintes);
    }

    public void deleteRappel(){
    }

    public void updateRappel(){

    }
}
