package fr.iutfbleau.papillon;

/**
 * La classe <code>VerifRappel</code> est utilisee en tant que Modele.
 * Cette classe verifie les conditions lors de creation d'un rappel pour un titre et pour le contenu.
 */
public class VerifRappel {

	/**
	 * On verifie le titre du rappel
	 * - Le titre ne doit pas etre vide
	 * - Le titre ne doit pas depasser 50 characteres
	 * - Le titre doit contenir au moins une lettre ou un chiffre
	 * - Le titre ne doit pas contenir de saut de ligne
	 * @param titre
	 * @return boolean	
	 */
	public static boolean isTitleOk(String titre) {
		if(titre == null || titre.isEmpty()) {
			return false;
		}

		if (titre.length() > 50) {
			return false;
		}

		boolean aLettre = false;
		boolean aChiffre = false;

		for(int i = 0; i < titre.length(); i++) {
			char c = titre.charAt(i); 
			if(c == '\n') {
				return false;
			}
			if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
				aLettre = true;
			}

			if(c >= '0' && c <= '9') {
				aChiffre = true;
			}
		}

		return aLettre || aChiffre; // Soit une lettre ou un chiffre est acceptable dans le titre
	}

	/**
	 * On verifie le contenu du rappel
	 * - Le contenu peut etre vide
	 * - Le contenu ne doit pas depasser 4 lignes
	 * - Chaque ligne ne doit pas depasser 50 characteres
	 * @param contenu
	 * @return boolean
	 */
	public static boolean isTextOk(String contenu) {
		if(contenu == null || contenu.isEmpty()) {
			return true;
		}

		int nombreLignes = 1;
		int nbCharLignes = 0;

		for(int i = 0; i < contenu.length(); i++) {
			char c = contenu.charAt(i);

			if(c == '\n') {
				nombreLignes++;
				nbCharLignes = 0; // On remet à 0 le nombre de charactere a cette ligne
			} else {
				nbCharLignes++; 
			}

			if(nombreLignes > 4) {
				return false; // Pas plus de 4 lignes
			}

			if(nbCharLignes > 50) {
				return false; // Pas plus de 50 characteres par lignes
			}
		}

		return true; // On return true si tout est bon et que le contenu respecte toutes les conditions
	}
}
