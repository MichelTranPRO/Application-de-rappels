import java.awt.event.*;

// JAVADOC A FAIRE

/**
 * La classe <code>Controlleur_themes</code> est utilisée 
 * pour gérer les interractions entre la souris et l'objet "ajouterBtn" de la classe <code>Bouton</code>." 
 * 
 * @version 1.0
 * @author Emmanuelle Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */

public class Controlleur_themes implements MouseListener{
	
    /**
     * Bouton ajouter de la classe <code>Panelheader</code>
     */
    private Theme theme;
    private int numTheme;
    private JThemeArea panelThemes;
    private int statutClique;

    /**
     * Le constructeur de la classe <code>Controlleur_themes</code> 
     * permet de faire le lien avec un objet de la classe <code>Bouton</code>.
     * @param bouton variable nécessaire à la référence de la classe <code>Bouton</code>.
     */
	public Controlleur_themes(Theme t, JThemeArea panel){
        this.theme=t;
        this.numTheme=theme.getNumTheme();
        this.panelThemes=panel;
        this.statutClique=0;
	}

	public void mouseClicked(MouseEvent e) {
        statutClique++;
        if (statutClique >1){
            statutClique=0;
        }
        panelThemes.setClick(statutClique,numTheme);
	}
	public void mouseExited(MouseEvent e) { // pas hover
        if (statutClique == 0){
            panelThemes.setHover(false,numTheme);
        }
        if (statutClique == 1){
            panelThemes.setHover(true, numTheme);
        }
    }
	public void mouseEntered(MouseEvent e) { // hover
        if (statutClique == 0){
            panelThemes.setHover(true,numTheme);
        }
        if (statutClique == 1){
            panelThemes.setHover(false,numTheme);
        }
    }
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
}