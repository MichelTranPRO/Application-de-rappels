package fr.iutfbleau.papillon;
import java.awt.*;
import javax.swing.*;

public class FenetreAccueil extends JPanel{
	private FenetreMain fenetreMain;
	private PanelAccueilHeader header;
	private PanelAccueil rappels;
	private JScrollPane scrollPanel;

	public FenetreAccueil(FenetreMain fenetreMain){
		this.fenetreMain = fenetreMain;
		rappels = new PanelAccueil(this);
		header = new PanelAccueilHeader(this,rappels);
		scrollPanel = new JScrollPane(rappels);

		scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.getVerticalScrollBar().setUnitIncrement(7);
		scrollPanel.setPreferredSize(new Dimension(400,100));

		this.setLayout(new BorderLayout());
		this.add(header, BorderLayout.NORTH);
		this.add(scrollPanel, BorderLayout.CENTER);
		this.setVisible(true);
	}

	public void setFenetreAjoutVisible(){
		fenetreMain.setFenetre(2);
	}
	public void setFenetreRappel(Rappel rappel){
		fenetreMain.setFenetreRappel(rappel);
	}
	public void returnFenetreAccueil(){
		rappels.refreshAllRappels();
		fenetreMain.returnFenetreAccueil();
	}
}
