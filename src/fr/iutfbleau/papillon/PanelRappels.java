import javax.swing.*;
import java.awt.*;

public class PanelRappels extends JPanel{
    private GridBagConstraints contraintes;

    public PanelRappels(){
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);
    }

    public void addRappel(String titre, String contexte, int theme, int rang){
        contraintes = new GridBagConstraints();
        contraintes.gridx = 0;
        contraintes.gridy = rang;
        contraintes.weightx = 1.0;
        contraintes.insets = new Insets(10, 0, 0, 0); 
        this.add(new Rappel(titre,contexte,theme,rang),contraintes);
    }

    public void deleteRappel(){
    }

    public void updateRappel(){

    }
}
