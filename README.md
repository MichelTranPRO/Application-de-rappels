# Papillon 🦋

Notre projet "**Papillon**", un logiciel de gestion de rappel, qui reste en permanence au premier plan, comme un papillon collé sur le moniteur. Ce projet a été réalisé dans le cadre de la SAÉ 3.1 FA de l'IUT Sénart-Fontainebleau.

## Description du projet

Papillon, un logiciel qui affiche une liste de rappels que l'utilisateur souhaite avoir sous les yeux, qu'il peut personnaliser par thèmes de couleurs, par son ordre, leurs titres et leurs contenus. 
Ce projet a été développé en **Java** en suivant les consignes du professeur de développement *Luc Hernandez*.

## Structure du projet

```
.
|build							//Les fichiers temporaires
|libs/META-INF					//Bibliothèque externe maria DB 
|src/fr/iutfbleau/papillon		//Code source .java
|res 							//Ressources : Diagrammes et rapport du projet
|.gitignore						//Types de fichier que git devrait ignorer
|Makefile						//Fichier Makefile
|TO DO.md 						//Fichier markdown d'objectif que nous nous mettons dans notre équipe
|README.md 						//Fichier markdown de présentation pour ce projet git
```

## Compilation et exécution
### Pré-requis
[!] La bibliothèqe externe MariaDB qui est dans le dossier `libs`

### Compilation
On utilise le fichier `Makefile` pour compiler avec :
```bash
make
```

### Exécution du programme
Pour exécuter le projet on utilise aussi le fichier `Makefile` avec :
```bash
make run
```
ou avec l'archive .jar : 
```bash
java -cp "build:libs/mariadb-java-client-3.5.6.jar" fr.iutfbleau.papillon.Main
```

### Création de l'archive .jar
Grâce au Makefile on génère une archive exécutable avec : 
```bash
make jar
```

### Création de la documentation javadoc
On peut aussi créer une documentation générée via **Javadoc** grâce au `Makefile` : 
```bash
make javadoc
```

### Nettoyage des fichiers compilés
Les fichiers `.class` que vous aviez générer peuvent être effacés grâce au Makefile : 
```bash
make clean
``` 

## Rapport 
Le rapport du projet est disponible dans le dossier `res`, ainsi que les diagrammes de classe

## Auteurs
Ce projet a été réalisé dans le cadre d'une situation d'apprentissage et d'évaluation au sein de la formation de BUT informatique à Fontainebleau dans un but d'apprentissage uniquement. Les auteurs sont : 
* Michel TRAN
* Rayan BISSON
* Emmanuel SRIVASTAVA-TIAMZON