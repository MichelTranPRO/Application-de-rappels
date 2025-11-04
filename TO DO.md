# A SUPPRIMER AVANT DE RENDRE LE RAPPORT

C'est pour marquer les points importants que j'ai remarqué dans la SAE, un peu comme un cahier des charges, y'a des choses évidentes mais j'ai mis quand meme pour qu'on soit sur :

## IMPORTANT : 

Surtout pas négliger l'ergonomie des interfaces :

>"Une partie importante de la note portera sur l'ergonomie de vos interfaces." 
### Programme : 

- [ ] Classes originales 
- [ ] Classes vues en cours uniquement
- [ ] PAS DE FONCTION AVEC ->{}, 
	exemple : 
```Java
 button.addActionListener(e -> {
                count[0]++;
                label.setText("Clics : " + count[0]);
            });
```
faire des beaux controlleurs comme vu en cours, le premier qui fait ça je vais chier devant chez lui 
- [ ] Suivre les consignes pour que le soit bien organiser pour luc : https://iut-fbleau.fr/sitebp/doc_consignes
### Fenetre : 

- [ ] Premier plan
- [ ] Le plus petit possible, donc je pense qu'on devra faire une seule fenetre avec un contenu a l'interieur que change et s'actualise, pas plusieurs fenetre. 
- [ ] Pas gener l'accès aux autres fenetres, donc je pense que ça serait bien de placer la fenetre dans un endroit stratégique, genre pas en haut a droite parce que souvent les boutons pour fermer les fenetres se trouvent en haut a droite, donc ça pourrait gener les autres fenetres. Au milieu peut-etre mais apres ça oblige l'utilisateur a bouger la fenetre. A voir ensemble
- [ ] Affiche les rappels, SANS LEUR CONTENU

### Rappels : 

- [ ] Trois éléments : 
	- [ ] Titre : 
		- [ ] 50 caractères max (pas des octets ou même des char mais des points de code Unicode).
		- [ ] Peut pas etre vide.
		- [ ] Peut pas contenir de saut de ligne.
		- [ ] Doit contenir au moins une lettre ou un chiffre.
	- [ ] Contenu, texte :
		- [ ] 4 lignes max, une ligne fait 50 caractères max, peut-etre essayer de faire un retour a la ligne tout les 50 carac pour que ça soit plus esthetique, comme ça ça s'affiche pas sur une seule ligne, notifier a l'utilisateur que c'est 200 caracteres max.
	- [ ] Thème, élément visuel distinctif : 
		- [ ] Proposer au moins 5, donc on doit avoir la fonctionnalité d'en rajouter
		- [ ] pas de nom, afin que les utilisateurs puissent librement choisir leur signification
		- [ ] pas forcement une couleur
- [ ] Opération *CRUD* sur chaque rappel, *Create, Read; Update, Delete*

### BD, Base de donnée :

- [ ] Les rappels et leur ordre doit etre conservé d'une session à une autre, donc utiliser un BD
- [ ] Les problèmes liés a la BD doivent etre envoyé vers une sortie d'erreur MAIS AUSSI graphiquement a l'utilisateur, on peut les afficher sur la fenetre

### Sources : 
Choses à vérifier, avant de rendre le projet :  
- [ ] pas de fichier **``.class``**
- [ ] depot privé, j'ai vu un mec qui l'avait mit en publique sur le grond, FAUT PAS
- [ ] Luc en collabo (collaborateur bien sur pas de mauvaise blague ^^)
- [ ] Javadoc
- [ ] Respecter l'organisation du code vue au début de l'année
- [ ] Toutes les classess appartiennent a un package
- [ ]  Un fichier **`Makefile`** devra permettre la compilation de votre projet et la création d'une archive jar, et un but factice nommé `run` devra en permettre l'exécution
- [ ] Transcrivez bien toutes les dépendances entre vos fichiers dans les règles
- [ ] Vérifiez également que l'archive soit exécutable sans aucune autre dépendance que la présence d'une JVM (version 11 et plus).
- [ ] Rapport présent sur le depot, bonne orthographe, page de garde, table des matières, les en-tête et pieds de page.
- [ ] Tous les diagrammes soient lisibles avec un facteur d'affichage de 100%
### Pas compris faut demander au prof : 

L'ordre des rappels dans la liste est sous le contrôle de l'utilisateur. L'utilisateur peut lui attribuer la signification qui l'arrange : les plus vieux, les plus urgents ou les plus importants rappels en premier, par exemple (ou un mélange des trois). Il n'a pas besoin d'expliquer sa logique au programme.

