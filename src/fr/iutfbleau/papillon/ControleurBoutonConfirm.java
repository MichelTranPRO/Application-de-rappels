package fr.iutfbleau.papillon;

import java.awt.*;
import java.awt.event.*;

/**
 * La classe <code>ControleurBoutonConfirm</code> est utilisée 
 * pour gérer les interractions entre la souris et les boutons de la classe <code>PanelConfirmation</code>."
 * 
 * @version 1.0
 * @author Emmanuelle Srivastava-Tiamzon, Rayan Bisson et Michel Tran
 */

public class ControleurBoutonConfirm extends MouseAdapter {
	
    /**
     * 
     */
	private FenetreMain fenetreMain;
    private PanelConfirmation panelConfirmation;
    private Bouton btnAnnuler;
    private Bouton btnQuitter;

	public ControleurBoutonConfirm(FenetreMain fenetreMain, Bouton btnAnnuler, Bouton btnQuitter, PanelConfirmation panelConfirmation) {
		this.fenetreMain = fenetreMain;
        this.panelConfirmation=panelConfirmation;
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
        panelConfirmation.dispose();
    }
}