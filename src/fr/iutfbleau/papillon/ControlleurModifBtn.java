package fr.iutfbleau.papillon;

import java.awt.*;
import java.awt.event.*;

public class ControlleurModifBtn implements MouseListener {

    private Bouton bouton;
    private PanelRappels panelRappels;
    private PanelRappelsHeader panelRappelsHeader;
    private boolean modifActive = false;

    public ControlleurModifBtn(Bouton bouton, PanelRappelsHeader panelRappelsHeader){
        this.bouton = bouton;
        this.panelRappelsHeader = panelRappelsHeader;
    }

    public void mouseClicked(MouseEvent e) {
        boolean nouveauStatut = !panelRappelsHeader.getStatutModifBtn();
        panelRappelsHeader.setModeModif(nouveauStatut);
    }

    public void mouseEntered(MouseEvent e) {
        // hover uniquement si pas en mode modif
        if (!panelRappelsHeader.getStatutModifBtn()) {
            bouton.setHoverColor(true, new Color(255,184,0), new Color(255,255,255));
        }
    }

    public void mouseExited(MouseEvent e) {
        // hover uniquement si pas en mode modif
        if (!panelRappelsHeader.getStatutModifBtn()) {
            bouton.setHoverColor(false, new Color(255,184,0), new Color(255,255,255));
        }
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
}
