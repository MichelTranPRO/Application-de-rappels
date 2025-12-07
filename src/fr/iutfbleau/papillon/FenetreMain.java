package fr.iutfbleau.papillon;

import java.awt.*;
import javax.swing.*;

public class FenetreMain extends JFrame{
	private CardLayout cardLayout;
	private JPanel contenu;
	private FenetreAccueil fenetreAccueil;
	private FenetreAjout fenetreAjout;
	private FenetreRappel fenetreRappel;

	public FenetreMain(){
		cardLayout = new CardLayout();
		contenu = new JPanel(cardLayout);

		fenetreAccueil = new FenetreAccueil(this);
		fenetreAjout = new FenetreAjout(this);

		contenu.add(fenetreAccueil,"FENETRE_ACCUEIL");
		contenu.add(fenetreAjout,"FENETRE_AJOUT");

		cardLayout.show(contenu, "FENETRE_ACCUEIL");
		this.setLayout(new BorderLayout());
		this.add(contenu, BorderLayout.CENTER);
		this.pack();
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		contenu.remove(fenetreRappel);
		cardLayout.show(contenu, "FENETRE_ACCUEIL");
		contenu.revalidate();
		contenu.repaint();
	}
}
