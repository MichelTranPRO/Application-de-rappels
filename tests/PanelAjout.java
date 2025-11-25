import java.awt.*;
import javax.swing.*;

public class PanelAjout extends JPanel{
    private int largeur;
    private int hauteur;
    private JLabel titre;
    private JLabel theme;
    private JLabel contexte; 
    private JTextField champTitre;
    private JTextField testTheme; // a remplacer
    private JTextArea champContenu;
    private Bouton validerBtn;
    private Color grisFond;
    private GridBagConstraints contraintes;

    public PanelAjout(){
        this.contraintes = new GridBagConstraints();

        this.titre=new JLabel("Titre (50 caractères maximum) :");
        titre.setFont(new Font("Dialog", Font.BOLD, 15));
        this.theme=new JLabel("Thème :");
        theme.setFont(new Font("Dialog", Font.BOLD, 15));
        this.contexte=new JLabel("Contenu (200 caractères maximum) :");
        contexte.setFont(new Font("Dialog", Font.BOLD, 15));
        
        this.testTheme=new JTextField();
        this.champTitre= new JTextField();
        this.champContenu= new JTextArea();

        this.validerBtn= new Bouton(380,43,"Valider", new Color(0, 200, 83), Color.WHITE);
        validerBtn.addMouseListener(new Controlleur_validerBtn(validerBtn));
        this.grisFond= new Color(255, 249, 227);

        this.setLayout(new GridBagLayout());
        this.setBackground(grisFond);

        //Titre
        contraintes.gridx=0;
        contraintes.gridy=0;
        contraintes.weightx=1.0;
        contraintes.anchor = GridBagConstraints.WEST;
        contraintes.insets = new Insets(10, 20, 0, 20); 
        this.add(titre,contraintes);
        
        //Theme
        contraintes.gridx=1;
        this.add(theme,contraintes);
        
        //Champs titre
        contraintes.gridx=0;
        contraintes.gridy=1;
        contraintes.insets = new Insets(0, 20, 5, 20); 
        champTitre.setPreferredSize(new Dimension(245,25));
        this.add(champTitre,contraintes);

        //Champs theme
        contraintes.gridx=1;
        testTheme.setPreferredSize(new Dimension(96,25));
        this.add(testTheme,contraintes);
        
        //Contexte
        contraintes.gridx=0;
        contraintes.gridy=2;
        contraintes.gridwidth=2;
        this.add(contexte,contraintes);

        //Champs contexte
        contraintes.gridy=3;
        champContenu.setPreferredSize(new Dimension(400,105));
        this.add(champContenu,contraintes);

        //Valider
        contraintes.gridy=4;
        contraintes.insets = new Insets(10, 30, 10, 0); 
        this.add(validerBtn,contraintes);
        
    }
}