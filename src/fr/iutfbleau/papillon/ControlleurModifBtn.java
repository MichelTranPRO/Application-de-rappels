package fr.iutfbleau.papillon;

import java.awt.*;
import java.awt.event.*;

public class ControlleurModifBtn implements MouseListener {

    private Bouton bouton;
    private PanelRappels panelRappels;
    private PanelRappelsHeader panelRappelsHeader;
    private boolean modifActive = false;

    public ControlleurModifBtn(Bouton bouton, PanelRappels panelRappels, PanelRappelsHeader panelRappelsHeader){
        this.bouton = bouton;
        this.panelRappels = panelRappels;
        this.panelRappelsHeader = panelRappelsHeader;
    }

    public void mouseClicked(MouseEvent e) {
        modifActive = !modifActive;

        if (modifActive) {
            // MODE MODIF
            bouton.setHoverColor(true, new Color(255,184,0), new Color(255,255,255));
            panelRappels.setModeModif(true);
            panelRappelsHeader.setStatutModifBtn(true);  // Ajouter => Valider

        } else {
            // MODE PAS MODIF
            bouton.setHoverColor(false, new Color(255,184,0), new Color(255,255,255));
            panelRappels.setModeModif(false);
            panelRappelsHeader.setStatutModifBtn(false); // Valider => Ajouter
        }
    }

    public void mouseEntered(MouseEvent e) {
        // hover uniquement si pas en mode modif
        if (!modifActive) {
            bouton.setHoverColor(true, new Color(255,184,0), new Color(255,255,255));
        }
    }

    public void mouseExited(MouseEvent e) {
        // hover uniquement si pas en mode modif
        if (!modifActive) {
            bouton.setHoverColor(false, new Color(255,184,0), new Color(255,255,255));
        }
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
}
