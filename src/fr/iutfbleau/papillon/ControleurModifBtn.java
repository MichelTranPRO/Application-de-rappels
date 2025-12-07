package fr.iutfbleau.papillon;

import java.awt.*;
import java.awt.event.*;

public class ControleurModifBtn implements MouseListener {

    private Bouton bouton;
    private PanelAccueil PanelAccueil;
    private PanelAccueilHeader panelAccueilHeader;
    private boolean modifActive = false;

    public ControleurModifBtn(Bouton bouton, PanelAccueilHeader panelAccueilHeader){
        this.bouton = bouton;
        this.panelAccueilHeader = panelAccueilHeader;
    }

    public void mouseClicked(MouseEvent e) {
        boolean nouveauStatut = !panelAccueilHeader.getStatutModifBtn();
        panelAccueilHeader.setModeModif(nouveauStatut);
    }

    public void mouseEntered(MouseEvent e) {
        // hover uniquement si pas en mode modif
        if (!panelAccueilHeader.getStatutModifBtn()) {
            bouton.setHoverColor(true, new Color(255,184,0), new Color(255,255,255));
        }
    }

    public void mouseExited(MouseEvent e) {
        // hover uniquement si pas en mode modif
        if (!panelAccueilHeader.getStatutModifBtn()) {
            bouton.setHoverColor(false, new Color(255,184,0), new Color(255,255,255));
        }
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
}
