# Cibles
.PHONY: all run clean jar javadoc

# Cible principale 
all: build/Main.class 
	@echo "Compilation terminée."

# Compilation manuelle des fichiers
build/Requete.class: src/fr/iutfbleau/papillon/Requete.java
	javac -d build -cp build:res/lib/mariadb-java-client-3.5.4.jar $<

build/PanelHeader.class: src/fr/iutfbleau/papillon/PanelHeader.java build/Bouton.class build/Controlleur_ajouterBtn.class build/Controlleur_modifBtn.class build/Controlleur_supprBtn.class
	javac -d build -cp build $<

build/PanelRappels.class: src/fr/iutfbleau/papillon/PanelRappels.java build/Rappel.class
	javac -d build -cp build $<
	
build/Rappel.class: src/fr/iutfbleau/papillon/Rappel.java
	javac -d build -cp build $<

build/Bouton.class : src/fr/iutfbleau/papillon/Bouton.java
	javac -d build -cp build $<

build/Controlleur_ajouterBtn.class : src/fr/iutfbleau/papillon/Controlleur_ajouterBtn.java build/Bouton.class
	javac -d build -cp build $<

build/Controlleur_modifBtn.class : src/fr/iutfbleau/papillon/Controlleur_modifBtn.java build/Bouton.class
	javac -d build -cp build $<

build/Controlleur_supprBtn.class : src/fr/iutfbleau/papillon/Controlleur_supprBtn.java build/Bouton.class
	javac -d build -cp build $<

build/Fenetre.class: src/fr/iutfbleau/papillon/Fenetre.java build/PanelHeader.class build/PanelRappels.class
	javac -d build -cp build $<

build/Main.class: src/fr/iutfbleau/papillon/Main.java build/Fenetre.class 
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

