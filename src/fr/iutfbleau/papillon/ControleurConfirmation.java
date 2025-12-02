package fr.iutfbleau.papillon;

import java.awt.event.*;
import java.awt.*;

public class ControleurConfirmation extends MouseAdapter {
    
    private FenetreMain fenetreMain;
    private boolean quitter;

    public ControleurConfirmation(FenetreMain fenetreMain, boolean quitter) {
        this.fenetreMain = fenetreMain;
        this.quitter = quitter;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        if(quitter) {
            System.exit(0);
        } else {
            fenetreMain.setFenetre(1);
        }
    }
}