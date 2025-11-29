import java.awt.event.*;

// JAVADOC A FAIRE

/**
 * La classe <code>ControlleurThemes</code> est utilisée 
 * pour gérer les interractions entre la souris et l'objet "ajouterBtn" de la classe <code>Bouton</code>." 
 * 
 * @version 1.0
 * @author Emmanuelle Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */

public class ControlleurThemes implements MouseListener{
	
    /**
     * Bouton ajouter de la classe <code>Panelheader</code>
     */
    private Theme theme;
    private int numTheme;
    private JThemeArea panelThemes;

    /**
     * Le constructeur de la classe <code>ControlleurThemes</code> 
     * permet de faire le lien avec un objet de la classe <code>Bouton</code>.
     * @param bouton variable nécessaire à la référence de la classe <code>Bouton</code>.
     */
	public ControlleurThemes(Theme t, JThemeArea panel){
        this.theme=t;
        this.numTheme=theme.getNumTheme();
        this.panelThemes=panel;
	}

	public void mouseClicked(MouseEvent e) {
        panelThemes.setClick(1, numTheme);
	}
	public void mouseExited(MouseEvent e) { // pas hover
        if (!panelThemes.getStatut(numTheme)) {
            panelThemes.setHover(false, numTheme);
        }
    }
	public void mouseEntered(MouseEvent e) { // hover
        if (!panelThemes.getStatut(numTheme)) {
            panelThemes.setHover(true, numTheme);
        }
    }
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
}