import java.awt.*;
import javax.swing.*;

public class PanelAjout extends JPanel{
    private int largeur;
    private int hauteur;
    private JLabel titre;
    private JLabel theme;
    private JLabel contexte; 
    private JTextField champTitre;
    private JThemeArea zoneThemes;
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
        
        this.zoneThemes=new JThemeArea();
        this.champTitre= new JTextField();
        this.champContenu= new JTextArea(4,0);
        champContenu.setLineWrap(true);
        champContenu.setWrapStyleWord(true);

        this.validerBtn= new Bouton(380,43,"Valider", new Color(0, 200, 83), Color.WHITE);
        validerBtn.addMouseListener(new ControlleurValiderBtn(validerBtn));
        this.grisFond= new Color(255, 249, 227);

        this.setLayout(new GridBagLayout());
        this.setBackground(grisFond);

        //Titre
        contraintes.gridx=0;
        contraintes.gridy=0;
        contraintes.weightx=1.0;
        contraintes.anchor = GridBagConstraints.WEST;
        contraintes.insets = new Insets(10, 10, 0, 10); 
        this.add(titre,contraintes);
        
        //Theme
        contraintes.gridx=1;
        contraintes.insets = new Insets(10, 10, 0, 10); 
        this.add(theme,contraintes);
        
        //Champs titre
        contraintes.gridx=0;
        contraintes.gridy=1;
        contraintes.insets = new Insets(0, 10, 5, 10); 
        contraintes.fill = GridBagConstraints.BOTH;

        this.add(champTitre,contraintes);

        //Champs theme
        contraintes.gridx=1;
        contraintes.fill = GridBagConstraints.BOTH;
        contraintes.insets = new Insets(0, 10, 5, 10); 
        this.add(zoneThemes,contraintes);
        
        //Contexte
        contraintes.gridx=0;
        contraintes.gridy=2;
        contraintes.gridwidth=2;
        contraintes.insets = new Insets(0, 10, 5, 10); 
        this.add(contexte,contraintes);

        //Champs contexte
        contraintes.gridy=3;
        contraintes.fill = GridBagConstraints.BOTH;
        this.add(champContenu,contraintes);

        //Valider
        contraintes.gridy=4;
        contraintes.fill = GridBagConstraints.NONE;
        contraintes.anchor = GridBagConstraints.CENTER;
        contraintes.insets = new Insets(10, 0, 15, 0); 
        this.add(validerBtn,contraintes);
        
    }

    /**
     * getter de type String pour le titre
     * 
     * @return le titre du rappel sous forme de chaine de characteres
     */
    public String getTitre() {
    	return champTitre.getText();
    }

    /**
     * getter de type String pour le contenu
     * 
     * @return le contenu du rappel sous forme de chaine de caracteres
     */
    public String getContenu() {
    	return champContenu.getText();
    }

    /**
     * getter de type Bouton pour le bouton Valider et obtenir ses parametres
     * 
     * @return le bouton de validation
     */
    public Bouton getvaliderBtn() {
    	return this.validerBtn;
    }
}