# Variables utiliées 
JC = javac
JVM = java
SRC = src/fr/iutfbleau/papillon
JCFLAGS = -d build -sourcepath src -cp build


# Cibles
.PHONY: all run clean jar javadoc

# Cible principale 
all: build build/Main.class 
	@echo "Compilation terminée."

# Création du dossier build si il existe pas déjà

build : 
	mkdir -p build

# Compilation manuelle des fichiers

build/Requete.class: ${SRC}/Requete.java build/Rappel.class
	${JC} ${JCFLAGS} -cp build:libs/mariadb-java-client-3.5.4.jar $<

build/PanelRappels.class: ${SRC}/PanelRappels.java build/Rappel.class build/Requete.class build/ControleurRappel.class
	${JC} ${JCFLAGS} $<

build/PanelRappelsHeader.class: ${SRC}/PanelRappelsHeader.java build/PanelRappels.class build/Bouton.class build/BoutonAjouterValider.class build/ControlleurAjouterValiderBtn.class build/ControleurQuitterBtn.class build/ControlleurModifBtn.class build/ControlleurSupprBtn.class
	${JC} ${JCFLAGS} ${SRC}/PanelRappelsHeader.java

build/PanelAjoutHeader.class: ${SRC}/PanelAjoutHeader.java build/Bouton.class build/ControlleurRetourBtn.class
	${JC} ${JCFLAGS} $<

build/PanelAjout.class: ${SRC}/PanelAjout.java build/Bouton.class build/JThemeArea.class build/ControlleurValiderBtn.class
	${JC} ${JCFLAGS} $<

build/Rappel.class: ${SRC}/Rappel.java 
	${JC} ${JCFLAGS} $<

build/Theme.class: ${SRC}/Theme.java
	${JC} ${JCFLAGS} $<

build/Bouton.class : ${SRC}/Bouton.java
	${JC} ${JCFLAGS} $<

build/BoutonAjouterValider.class : ${SRC}/BoutonAjouterValider.java
	${JC} ${JCFLAGS} $<

build/JThemeArea.class: ${SRC}/JThemeArea.java ${SRC}/ControlleurThemes.java build/Theme.class
	${JC} ${JCFLAGS} ${SRC}/JThemeArea.java ${SRC}/ControlleurThemes.java


# === Controlleurs === #

build/ControlleurAjouterValiderBtn.class : ${SRC}/ControlleurAjouterValiderBtn.java build/BoutonAjouterValider.class
	${JC} ${JCFLAGS} $<

build/ControleurQuitterBtn.class : ${SRC}/ControleurQuitterBtn.java build/Bouton.class
	${JC} ${JCFLAGS} $<

build/ControlleurModifBtn.class : ${SRC}/ControlleurModifBtn.java build/Bouton.class
	${JC} ${JCFLAGS} $<

build/ControlleurThemes.class: ${SRC}/ControlleurThemes.java ${SRC}/JThemeArea.java build/Theme.class
	${JC} ${JCFLAGS} ${SRC}/JThemeArea.java ${SRC}/ControlleurThemes.java

build/ControlleurSupprBtn.class : ${SRC}/ControlleurSupprBtn.java build/Bouton.class
	${JC} ${JCFLAGS} $<

build/ControlleurValiderBtn.class : ${SRC}/ControlleurValiderBtn.java build/Bouton.class
	${JC} ${JCFLAGS} $<

build/ControlleurRetourBtn.class : ${SRC}/ControlleurRetourBtn.java build/Bouton.class
	${JC} ${JCFLAGS} $<

build/ControleurRappel.class : ${SRC}/ControleurRappel.java build/Rappel.class
	${JC} ${JCFLAGS} $<

# ==================== #

# ===== Fenetres ====== #

build/FenetreAjout.class: ${SRC}/FenetreAjout.java ${SRC}/FenetreMain.java build/PanelAjoutHeader.class build/PanelAjout.class
	${JC} ${JCFLAGS} ${SRC}/FenetreAjout.java ${SRC}/FenetreMain.java

build/FenetreRappel.class: ${SRC}/FenetreRappel.java ${SRC}/FenetreMain.java build/PanelRappelsHeader.class build/PanelRappels.class 
	${JC} ${JCFLAGS} ${SRC}/FenetreRappel.java ${SRC}/FenetreMain.java

build/FenetreMain.class: ${SRC}/FenetreMain.java build/FenetreRappel.class build/FenetreAjout.class
	${JC} ${JCFLAGS} ${SRC}/FenetreMain.java

# ===================== #

build/Main.class: ${SRC}/Main.java build/FenetreMain.class 
	${JC} ${JCFLAGS} $<

# Exécution du programme
run:
	${JVM} -cp "build:libs/mariadb-java-client-3.5.6.jar" fr.iutfbleau.papillon.Main

#Création de la javadoc
javadoc: 
	javadoc -d doc/ -sourcepath src fr iutfbleau papillon \
		-encoding UTF-8 -charset UTF-8 -windowtitle "Documentation SAE DEV 3.1"

# Création de l'archive jar
jar: all
	jar cfe papillon.jar papillon.Main -C build .

# Nettoyage des fichiers compilés
clean:
	rm -r build
	@echo "Dossier build nettoyé."

