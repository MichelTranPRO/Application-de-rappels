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

build/Requete.class: ${SRC}/Requete.java
	${JC} ${JCFLAGS} -cp build:res/lib/mariadb-java-client-3.5.4.jar $<



build/PanelHeader.class: ${SRC}/PanelHeader.java build/Bouton.class build/ControlleurAjouterBtn.class build/ControlleurModifBtn.class build/ControlleurSupprBtn.class
	${JC} ${JCFLAGS} $<

build/PanelRappels.class: ${SRC}/PanelRappels.java build/Rappel.class
	${JC} ${JCFLAGS} $<

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

build/JThemeArea.class: ${SRC}/JThemeArea.java ${SRC}/ControlleurThemes.java build/Theme.class
	${JC} ${JCFLAGS} ${SRC}/JThemeArea.java ${SRC}/ControlleurThemes.java


# === Controlleurs === #

build/ControlleurAjouterBtn.class : ${SRC}/ControlleurAjouterBtn.java build/Bouton.class
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

# ==================== #

# ===== Fenetres ====== #

build/FenetreAjout.class: ${SRC}/FenetreAjout.java build/PanelAjoutHeader.class build/PanelAjout.class
	${JC} ${JCFLAGS} $<

build/FenetreRappel.class: ${SRC}/FenetreRappel.java build/PanelHeader.class build/PanelRappels.class
	${JC} ${JCFLAGS} $<

build/FenetreMain.class: ${SRC}/FenetreMain.java build/FenetreRappel.class build/FenetreAjout.class
	${JC} ${JCFLAGS} $<

# ===================== #

build/Main.class: ${SRC}/Main.java build/FenetreMain.class 
	${JC} ${JCFLAGS} $<

# Exécution du programme
run: 
	${JVM} -cp build:res/lib/mariadb-java-client-3.5.4.jar Main

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

