
import java.awt.*;
import javax.swing.*;

public class JThemeArea extends JPanel{
    private Color[][] tabColors; // Color[numero du theme][statut] numero de theme : 0 à 4, statut : 0=defaut 1=hover 
    private Color couleurActuelle;
    private Theme[] tabThemes;
    private boolean[] tabStatutCliqueThemes;
    private ControlleurThemes ctrl_theme;
    private GridBagConstraints contraintes;

    public JThemeArea(){
        this.tabThemes=new Theme[5];
        this.tabStatutCliqueThemes=new boolean[5];
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);
        contraintes = new GridBagConstraints();
        contraintes.gridy=0;
        contraintes.insets = new Insets(0,2,0,2);
        contraintes.fill = GridBagConstraints.NONE;
        contraintes.anchor = GridBagConstraints.CENTER;

        
        tabColors = new Color[][]{
            {new Color(227, 212, 255),new Color(139, 92, 246)}, // violet
            {new Color(207, 225, 255),new Color(26, 115, 234)}, // bleu
            {new Color(191, 255, 208),new Color(0, 168, 107)}, // vert
            {new Color(255, 207, 203),new Color(255, 59, 48)}, // rouge
            {new Color(255, 209, 164),new Color(255, 127, 0)} // orange
        };

        for (int i=0 ; i<5 ;i++){
            tabThemes[i]=new Theme(tabColors[i][0],i);
            tabThemes[i].addMouseListener(new ControlleurThemes(tabThemes[i],this));
            contraintes.gridx=i;
            this.add(tabThemes[i],contraintes);
        }
    }

    public void setHover(boolean statut, int numTheme) {
        if (statut){
            tabThemes[numTheme].setColorTheme(tabColors[numTheme][1]);
        } else {
            tabThemes[numTheme].setColorTheme(tabColors[numTheme][0]);
        }
        repaint();
    }

    public void setClick(int statutClique, int numTheme) {
        if (statutClique== 0){
            tabStatutCliqueThemes[numTheme] = false;
            tabThemes[numTheme].setColorTheme(tabColors[numTheme][0]);
        }
        if(statutClique== 1){
            for (int i=0 ; i<5 ;i++){
                tabStatutCliqueThemes[i]= false;
                tabThemes[i].setColorTheme(tabColors[i][0]);
                repaint();
            }
            tabStatutCliqueThemes[numTheme] = true;
            tabThemes[numTheme].setColorTheme(tabColors[numTheme][1]);
        }
        repaint();
    }
    
    public boolean getStatut(int numTheme) {
        return tabStatutCliqueThemes[numTheme];
    }


}
