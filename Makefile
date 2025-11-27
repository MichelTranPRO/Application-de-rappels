# Cibles
.PHONY: all run clean jar javadoc

# Cible principale 
all: build/Main.class 
	@echo "Compilation terminée."

# Compilation manuelle des fichiers
build/Requete.class: src/fr/iutfbleau/papillon/Requete.java
	javac -d build -cp build:res/lib/mariadb-java-client-3.5.4.jar $<



build/PanelHeader.class: src/fr/iutfbleau/papillon/PanelHeader.java build/Bouton.class build/ControlleurAjouterBtn.class build/ControlleurModifBtn.class build/ControlleurSupprBtn.class
	javac -d build -cp build $<

build/PanelRappels.class: src/fr/iutfbleau/papillon/PanelRappels.java build/Rappel.class
	javac -d build -cp build $<

build/PanelAjoutHeader.class: src/fr/iutfbleau/papillon/PanelAjoutHeader.java build/Bouton.class build/ControlleurRetourBtn.class
	javac -d build -cp build $<

build/PanelAjout.class: src/fr/iutfbleau/papillon/PanelAjout.java build/Bouton.class build/JThemeArea.class build/ControlleurValiderBtn.class
	javac -d build -cp build $<
	
build/Rappel.class: src/fr/iutfbleau/papillon/Rappel.java
	javac -d build -cp build $<

build/Theme.class: src/fr/iutfbleau/papillon/Theme.java
	javac -d build -cp build $<

build/Bouton.class : src/fr/iutfbleau/papillon/Bouton.java
	javac -d build -cp build $<

build/JThemeArea.class: src/fr/iutfbleau/papillon/JThemeArea.java src/fr/iutfbleau/papillon/ControlleurThemes.java build/Theme.class
	javac -d build -cp build src/fr/iutfbleau/papillon/JThemeArea.java src/fr/iutfbleau/papillon/ControlleurThemes.java


# === Controlleurs === #

build/ControlleurAjouterBtn.class : src/fr/iutfbleau/papillon/ControlleurAjouterBtn.java build/Bouton.class
	javac -d build -cp build $<

build/ControlleurModifBtn.class : src/fr/iutfbleau/papillon/ControlleurModifBtn.java build/Bouton.class
	javac -d build -cp build $<

build/ControlleurThemes.class: src/fr/iutfbleau/papillon/ControlleurThemes.java src/fr/iutfbleau/papillon/JThemeArea.java build/Theme.class
	javac -d build -cp build src/fr/iutfbleau/papillon/JThemeArea.java src/fr/iutfbleau/papillon/ControlleurThemes.java

build/ControlleurSupprBtn.class : src/fr/iutfbleau/papillon/ControlleurSupprBtn.java build/Bouton.class
	javac -d build -cp build $<

build/ControlleurValiderBtn.class : src/fr/iutfbleau/papillon/ControlleurValiderBtn.java build/Bouton.class
	javac -d build -cp build $<
	
build/ControlleurRetourBtn.class : src/fr/iutfbleau/papillon/ControlleurRetourBtn.java build/Bouton.class
	javac -d build -cp build $<

# ==================== #

# ===== Fenetres ====== #

build/FenetreAjout.class: src/fr/iutfbleau/papillon/FenetreAjout.java build/PanelAjoutHeader.class build/PanelAjout.class
	javac -d build -cp build $<	

build/FenetreRappel.class: src/fr/iutfbleau/papillon/FenetreRappel.java build/PanelHeader.class build/PanelRappels.class
	javac -d build -cp build $<
	
build/FenetreMain.class: src/fr/iutfbleau/papillon/FenetreMain.java build/FenetreRappel.class build/FenetreAjout.class
	javac -d build -cp build $<

# ===================== #

build/Main.class: src/fr/iutfbleau/papillon/Main.java build/FenetreMain.class 
	javac -d build -cp build $<

# Exécution du programme
run: 
	java -cp build:res/lib/mariadb-java-client-3.5.4.jar Main

#Création de la javadoc
javadoc: 
	javadoc -d doc/ -sourcepath src fr iutfbleau papillon \
		-encoding UTF-8 -charset UTF-8 -windowtitle "Documentation SAE DEV 3.1"

# Création de l'archive jar
jar: all
	jar cfe papillon.jar papillon.Main -C build .

# Nettoyage des fichiers compilés
clean:
	rm -rf build/*
	@echo "Dossier build nettoyé."

