package fr.iutfbleau.papillon;

import java.awt.*;
import javax.swing.*;

public class FenetreMain extends JFrame{
	private CardLayout cardLayout;
	private JPanel contenu;
	private FenetreAccueil fenetreAccueil;
	private FenetreAjout fenetreAjout;
	private FenetreRappel fenetreRappel;
	private PanelConfirmation panelConfirmation;

	public FenetreMain(){
		cardLayout = new CardLayout();
		contenu = new JPanel(cardLayout);

		fenetreAccueil = new FenetreAccueil(this);
		fenetreAjout = new FenetreAjout(this);
		panelConfirmation = new PanelConfirmation(this);

		contenu.add(fenetreAccueil,"FENETRE_ACCUEIL");
		contenu.add(fenetreAjout,"FENETRE_AJOUT");
		contenu.add(panelConfirmation,"FENETRE_CONFIRMATION");

		cardLayout.show(contenu, "FENETRE_ACCUEIL");
		this.setLayout(new BorderLayout());
		this.add(contenu, BorderLayout.CENTER);
		this.pack();
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new ControleurWindowConfirm(this));

		this.setVisible(true);
	}

	public void setFenetre(int indexFenetre){
		if(indexFenetre == 1){
			cardLayout.show(contenu, "FENETRE_ACCUEIL");
		} else if (indexFenetre == 2) {
			cardLayout.show(contenu, "FENETRE_AJOUT");
		} 
	}
	public void setFenetreRappel(Rappel rappel){
		fenetreRappel = new FenetreRappel(rappel,fenetreAccueil);
		contenu.add(fenetreRappel,"FENETRE_RAPPEL");
		cardLayout.show(contenu, "FENETRE_RAPPEL");
	}
	public void returnFenetreAccueil(){
		if(fenetreRappel != null) {
			contenu.remove(fenetreRappel);
		}
		cardLayout.show(contenu, "FENETRE_ACCUEIL");
		contenu.revalidate();
		contenu.repaint();
	}

	public void afficherEcranConfirmation() {
		cardLayout.show(contenu, "FENETRE_CONFIRMATION");
	}
}
