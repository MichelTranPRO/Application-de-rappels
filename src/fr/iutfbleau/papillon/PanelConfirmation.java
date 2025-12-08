package fr.iutfbleau.papillon;

import java.awt.*;
import javax.swing.*;

public class PanelConfirmation extends JPanel{

	private FenetreMain fenetreMain;
    private JLabel titre;
    private Bouton btnQuitter;
    private Bouton btnAnnuler;
    private Color fondPanel;
    private GridBagConstraints contraintes;

	public PanelConfirmation(FenetreMain fenetreMain) {
		this.fenetreMain = fenetreMain;
		this.contraintes = new GridBagConstraints();

		this.fondPanel = new Color(255,249,227);
		this.setBackground(fondPanel);
		this.setLayout(new GridBagLayout());

		this.titre = new JLabel("Voulez-vous vraiment quitter l'application ?");
		this.titre.setFont(new Font("Dialog", Font.BOLD, 18));
		this.titre.setHorizontalAlignment(SwingConstants.CENTER);

		this.btnQuitter = new Bouton(180,40,"Oui", new Color(220,53,69), Color.WHITE);
		this.btnQuitter.setName("QUITTER");

		this.btnAnnuler = new Bouton(180,40,"Non", new Color(108,117,125), Color.WHITE);
		this.btnAnnuler.setName("ANNULER");

		ControleurBoutonConfirm ctrlBouton = new ControleurBoutonConfirm(fenetreMain, btnAnnuler, btnQuitter);

		btnQuitter.addMouseListener(ctrlBouton);
		btnAnnuler.addMouseListener(ctrlBouton);

		// Le texte
		contraintes.gridx = 0;
		contraintes.gridy = 0;
		contraintes.gridwidth = 2;
		contraintes.insets = new Insets(0,0,40,0);
		contraintes.anchor = GridBagConstraints.CENTER;
		this.add(titre, contraintes);

		contraintes.gridx = 0;
		contraintes.gridy = 1;
		contraintes.gridwidth = 1;
		contraintes.insets = new Insets(0,10,0,10);
		this.add(btnQuitter,contraintes);

		contraintes.gridx = 1;
		contraintes.gridy = 1;
		contraintes.insets = new Insets(0,10,0,10);
		this.add(btnAnnuler, contraintes);
	}
}