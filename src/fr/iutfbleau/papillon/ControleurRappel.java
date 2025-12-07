package fr.iutfbleau.papillon;

import java.awt.event.*;

public class ControleurRappel implements MouseListener {

    private Rappel rappel;
    private PanelAccueil panelAccueil;
    private boolean nouveauStatutModif;
    private boolean nouveauStatutSuppr;

    public ControleurRappel(Rappel rappel, PanelAccueil panelAccueil){
        this.rappel = rappel;
        this.panelAccueil = panelAccueil;
    }

    public void mouseClicked(MouseEvent e) {

        if (rappel.getModeModif()) { // mode modif

            // on inverse l'état de sélection
            nouveauStatutModif = !rappel.isSelectedModif();
            rappel.setSelectedModif(nouveauStatutModif);

            if (nouveauStatutModif) {
                rappel.setColorModifHover(true);
                panelAccueil.addTabRappelModif(rappel);
            } else {
                rappel.setColorModifHover(false);
                panelAccueil.deleteTabRappelModif(rappel);
            }

        } else if(rappel.getModeSuppr()) { // mode suppr
            nouveauStatutSuppr = !rappel.isSelectedSuppr();
            rappel.setSelectedSuppr(nouveauStatutSuppr);

            if (nouveauStatutSuppr) {
                rappel.setColorSupprHover(true);
                panelAccueil.addTabRappelSuppr(rappel);
            } else {
                rappel.setColorSupprHover(false);
                panelAccueil.deleteTabRappelSuppr(rappel);
            }
        } 
        else {
            panelAccueil.setFenetreRappel(rappel);
        }
    }

    public void mouseEntered(MouseEvent e) {
        if (rappel.getModeModif()) {
            if (!rappel.isSelectedModif()) {
                rappel.setColorModifHover(true);
            }
            return; 
        }

        if (rappel.getModeSuppr()) {
            if (!rappel.isSelectedSuppr()) {
                rappel.setColorSupprHover(true);
            }
            return;
        }
        rappel.setHoverColor(true);
    }

    
    public void mouseExited(MouseEvent e) {
        if (rappel.getModeModif()) {
            if (!rappel.isSelectedModif()) {
                rappel.setColorModifHover(false);
            }
            return;
        }
        if (rappel.getModeSuppr()) {
            if (!rappel.isSelectedSuppr()) {
                rappel.setColorSupprHover(false);
            }
            return;
        }
        rappel.setHoverColor(false);
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
}
