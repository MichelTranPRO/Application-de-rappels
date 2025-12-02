package fr.iutfbleau.papillon;

import javax.swing.*;
import java.awt.*;

public class FenetreConfirmation extends JPanel {

    private GridBagConstraints contraintes;
    private Bouton btnOui;
    private Bouton btnNon;
    private FenetreMain fenetreMain;

    public FenetreConfirmation(FenetreMain fenetreMain) {
        this.fenetreMain = fenetreMain;
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);

        this.contraintes = new GridBagConstraints();
        this.contraintes.insets = new Insets(20,20,20,20);
        this.contraintes.gridx = 0;
        this.contraintes.gridy = 0;
        this.contraintes.gridwidth = 2;

        // Question de si on veut vrmt quitter
        JLabel label = new JLabel("Voulez-vous vraiment quitter ?");
        label.setFont(new Font("Dialog", Font.BOLD, 18));
        this.add(label, this.contraintes);

        // Le bouton Oui
        this.contraintes.gridy = 1;
        this.contraintes.gridwidth = 1;
        this.contraintes.anchor = GridBagConstraints.EAST;
        this.btnOui = new Bouton(100, 40, "Oui", Color.WHITE, new Color(0,255,0));
        this.btnOui.addMouseListener(new ControleurConfirmation(fenetreMain, true)); 
        this.add(this.btnOui, this.contraintes);

        // Le bouton Non
        this.contraintes.gridx = 1;
        this.contraintes.anchor = GridBagConstraints.WEST;
        this.btnNon= new Bouton(100, 40, "Non", Color.WHITE, new Color(255,0,0));
        this.btnNon.addMouseListener(new ControleurConfirmation(fenetreMain, false));
        this.add(this.btnNon, this.contraintes); 
    }

    public Bouton getBtnOui() {
        return this.btnOui;
    }

    public Bouton getBtnNon() {
        return this.btnNon;
    }
}