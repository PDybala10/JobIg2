# JobIg

Jobig est une application android qui permettra aux étudiants de l'Esiea de trouver un stage ou une alternance lors de leurs formations.
Cette application affiche les offres d'emplois en utilisant une API de github disponible via le lien suivant :

```
https://jobs.github.com/
```

## Membres de l'équipe (4A-41)

* Nde Signe Igor berenger

## Prérequis

* Installation d'android Studio

```
https://developer.android.com/studio/
```

* Récupération de la branche master

```
https://github.com/PDybala10/JobIg2.git
```

## Installation

Il suffit de faire un pull sur la branche master de notre github ci-dessus et après lancer l'application.

## Consignes respectées:

* Language Kotlin / Swift si iOS
* Architecture MVVM
* Clean Architecture
* Utilisation d’une réelle BDD
* Utilisation Api REST
* Affichage d’une liste
* Design


## Les plus:

* Design
* Nettoyage des données brute récupéré via l'api Rest pour une meilleure présentation.
* Récupération des logos d'entreprise pour chaque offre via un lien donnée par l'API.
* Test Unitaire

## Fonctionnalités :

#### Premier écran Connexion
* Affiche deux champs email et mot de passe pour se connecter si le compte n'exite pas on envoie un message d'erreur sinon on connecte l'utilisateur eil donne aussi une possibilité à l'utilisateur de créer un compte

<p align="start">

  <img src="https://github.com/PDybala10/JobIg2/blob/develop/images/connec.png" width="250" height="500" title="connec">
  <img src="https://github.com/PDybala10/JobIg2/blob/develop/images/connec1.png" width="250" height="500" title="connec1">
</p>

#### Ecran Inscription
* Après avoir cliqué sur Register now affiche deux champs un email et mot de passe et permet de créer un nouvel utilisateur si tous les champs ne sont pas remplis erreur sinon l'utilisateur est créé

<p align="start">
   <img src="https://github.com/PDybala10/JobIg2/blob/develop/images/ins.png" width="250" height="500" title="ins">
   <img src="https://github.com/PDybala10/JobIg2/blob/develop/images/ins1.png" width="250" height="500" title="ins1">
   <img src="https://github.com/PDybala10/JobIg2/blob/develop/images/ins2.png" width="250" height="500" title="ins2">
</p>

#### Ecran Home
* Affiche la liste d'offres d'emploi récupérer sur internet via une API possibilité de faire un scroll vertical donne la posibilité à l'utilisateur de revenir sur la page de connexion et aussi de voir le détail d'une offre. Si le click est effectué sur une offre l'image de l'item change

<p align="start">
  <img src="https://github.com/PDybala10/JobIg2/blob/develop/images/off.png" width="250" height="500" title="off">
   <img src="https://github.com/PDybala10/JobIg2/blob/develop/images/off1.png" width="250" height="500" title="off1">

</p>

#### Ecran Offre
* Affiche le détail sur une offre et donne la possibilité à l'utilisateur de la partagée de visiter le site web de l'entreprise ou encore de postuler directement.

#### Détail sur une Offre

<p align="start">
    <img src="https://github.com/PDybala10/JobIg2/blob/develop/images/det.png" width="250" height="500" title="det">
</p>

#### Lorqu'on appui sur le bouton Web

<p align="start">
    <img src="https://github.com/PDybala10/JobIg2/blob/develop/images/det1.png" width="250" height="500" title="det1">
</p>

#### Lorsqu'on appui sur le bouton Share

<p align="start">
    <img src="https://github.com/PDybala10/JobIg2/blob/develop/images/det2.png" width="250" height="500" title="det2">
</p>

#### Lorqu'on appui sur le bouton valid ici l'offfre ne nou permet pas de postuler directement

<p align="start">
    <img src="https://github.com/PDybala10/JobIg2/blob/develop/images/det3.png" width="250" height="500" title="det3">
</p>

## Auteur

* **Nde Signe Igor berenger** - *Initial work* - [Igor Nde](https://github.com/PDybala10)


## Remerciements

* Je me suis inspiré de ma situation de recherche de stage et d'alternance pour cette application qui permettra peut-être d'aider d'autres personnes.

* Merci Mr Vincent Étienne pour votre accompagnement tout le long de ce projet.
