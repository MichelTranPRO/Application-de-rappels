package fr.iutfbleau.papillon;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ControleurWindowConfirm extends WindowAdapter {

    private FenetreMain fenetreMain;

    public ControleurWindowConfirm(FenetreMain fenetreMain) {
        this.fenetreMain = fenetreMain;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        new PanelConfirmation(fenetreMain);
    }
}