import javax.swing.*;
import java.awt.*;

/**
 * Cette classe <code>PanelAjout</code> represente le formulaire qui permet de creer un rappel
 * Elle contient le titre, le contenu, les differents themes et des boutons
 * 
 * @version 1.0
 * @author Emmanuelle Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */
public class PanelAjout {

	/**
	 * Champ de texte qui permet à l'utilisateur d'ecrire le titre du rappel
	 */
	private JTextField champTitre;

	/**
	 * Zone de texte sur plusieurs lignes qui permet a l'utilisateur d'ecrire le contenu du rappel
	 */
	private JTextArea champContenu;

	/**
	 * Bouton venant de la classe <code>Bouton</code> qui permet d'enregistrer et valider la creation du rappel
	 */
	private Bouton btnValider;

	/**
	 * Bouton venant de la classe <code>Bouton</code> qui permet de retourner sur la page principale
	 */
	private Bouton btnRetour;

	/**
	 * Indice qui indique l'index du theme selectione
	 */
	private int indexThemeSelectionne = 0; // Par defaut le premier

	/**
	 * Tableau constant qui contient les differentes couleurs de theme disponible 
	 */
	private final Color[] COULEURS_THEMES = {
        new Color(139, 92, 246), // Violet
        new Color(26, 115, 234), // Bleu
        new Color(0, 168, 107),  // Vert
        new Color(255, 59, 48),  // Rouge
        new Color(255, 127, 0)   // Orange
    };

    /**
     * Constructeur de la classe <code>PanelAjout</code> 
     * Initialise la disposition en GridBagLayout, les couleurs et ajoute tous les composants
     */
    public PanelAjout() {
    	this.setBackground(Color.WHITE);
    	this.setLayout(new GridBagLayout());
    	GridBagConstraints contrainte = new GridBagConstraints();
    	contrainte.insets = new Insets(5, 10, 5, 10);
        contrainte.fill = GridBagConstraints.HORIZONTAL;
        contrainte.gridx = 0;

        // Le titre
        JLabel labelTitre = new JLabel("Titre (Au moins une lettre ou un chiffre)");
        labelTitre.setFont(new Font("Inter", Font.BOLD, 12));
        contrainte.gridy = 0;
        this.add(labelTitre, contrainte);

        this.champTitre = new JTextField();
        this.champTitre.setPreferredSize(new Dimension(300,30));
        contrainte.gridy = 1;
        this.add(this.champTitre, contrainte);

        // Le contenu
        JLabel labelContenu = new JLabel("Contenu (max 4 lignes)");
        labelContenu.setFont(new Font("Inter", Font.BOLD, 12));
        contrainte.gridy = 2;
        contrainte.insets = new Insets(15, 10, 5, 10);
        this.add(labelContenu, contrainte);

        this.champContenu = new JTextArea(4, 30);
        this.champContenu.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        JScrollPane scroll = new JScrollPane(this.champContenu);
        scroll.setPreferredSize(new Dimension(300, 80));
        contrainte.gridy = 3;
        contrainte.insets = new Insets(0, 10, 5, 10);
        this.add(scroll, containte);

        // Le theme
        JLabel labelTheme = new JLabel("Choisissez un thème");
        labelTheme.setFont(new Font("Inter", Font.BOLD, 12));
        contrainte.gridy = 4;
        contrainte.insets = new Insets(15, 10, 5, 10);
        this.add(labelTheme, contrainte);

        /* a partir de la jsp comment representer les differents themes...
				à remplir de code utile 
		*/

		// Bouton Valider
		JPanel panelBtnValider = new JPanel();
		panelBtnValider.setBackground(Color.WHITE);
		this.btnValider = new Bouton(120, 40, "Valider", new Color(255, 184, 0), Color.WHITE);
		panelBtnValider.add(this.btnValider);

		contrainte.gridy = ...;
		contrainte.insets = new Insets(20, 10, 10, 10);
		this.add(panelBtnValider, contrainte);
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
    public Bouton getBtnValider() {
    	return this.btnValider;
    }

    /**
     * getter de type Bouton pour le bouton Retour et obtenir ses parametres
     * 
     * @return le bouton de retour
     */
    public Bouton getBtnRetour() {
    	return this.btnRetour;
    }
}