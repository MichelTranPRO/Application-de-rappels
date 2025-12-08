package fr.iutfbleau.papillon;

import java.awt.*;
import java.awt.event.*;

public class ControleurBoutonConfirm extends MouseAdapter {
	
	private FenetreMain fenetreMain;
    private Bouton btnAnnuler;
    private Bouton btnQuitter;

	public ControleurBoutonConfirm(FenetreMain fenetreMain, Bouton btnAnnuler, Bouton btnQuitter) {
		this.fenetreMain = fenetreMain;
        this.btnAnnuler = btnAnnuler;
        this.btnQuitter = btnQuitter;
	}

	@Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == btnQuitter) {
            this.quitterApplication();
        } else if (e.getSource() == btnAnnuler) {
            this.annulerFermeture();
        }
    }
/*Le hover
    @Override
    public void mouseEntered(MouseEvent e) {
    	Bouton b = (Bouton) e.getSource();
    	if(b.getName().equals("QUITTER"))
    }
*/
    public void quitterApplication() {
        System.exit(0);
    }
    
    public void annulerFermeture() {
        this.fenetreMain.returnFenetreAccueil();
    }
}