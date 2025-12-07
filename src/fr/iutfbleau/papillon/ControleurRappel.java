package fr.iutfbleau.papillon;

import java.awt.event.*;

public class ControleurRappel implements MouseListener {

    private Rappel rappel;
    private PanelAccueil panelAccueil;

    public ControleurRappel(Rappel rappel, PanelAccueil panelAccueil){
        this.rappel = rappel;
        this.panelAccueil = panelAccueil;
    }

    public void mouseClicked(MouseEvent e) {

        if (rappel.getModeModif()) {

            // on inverse l'état de sélection
            boolean nouveauStatut = !rappel.isSelectedModif();
            rappel.setSelectedModif(nouveauStatut);

            if (nouveauStatut) {
                rappel.setColorModifHover(true);
                panelAccueil.addTabRappelModif(rappel);
            } else {
                rappel.setColorModifHover(false);
                //PanelAccueil.deleteTabRappelModif(rappel);
            }

        } else {
            panelAccueil.setFenetreRappel(rappel);
        }
    }

    public void mouseEntered(MouseEvent e) {
        if (!rappel.getModeModif()) {
            rappel.setHoverColor(true);
        } else if (!rappel.isSelectedModif()) {
            rappel.setColorModifHover(true);
        }
    }

    public void mouseExited(MouseEvent e) {
        if (!rappel.getModeModif()) {
            rappel.setHoverColor(false);
        } else if (!rappel.isSelectedModif()) {
            rappel.setColorModifHover(false);
        }
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
}
