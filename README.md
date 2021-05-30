# RickAndMorty

Projet de programmation mobile 3A sous Android Studio (Kotlin)

## Description générale de l'application

L'application RickAndMorty permet d'afficher la liste d'une partie des personnages d'un Sitcom très connu: Rick And Morty.
Lorsque l'on clique sur le nom d'un personnage, un second ecran permet d'afficher les détails du personnages: nom du personnage, son statut et son genre.

## Description technique

Une icone personnalisé a été mis en place sur l'écran d'accueil.
L'application affiche un Splash Screen lors du lancement de l'application.
Une barre de recherche avec pour icone la tete d'un personnage.
L'application affiche la liste des personnages à travers une RecyclerView avec en prime l'image associé au personnage (Glide). 

L'application récupère ces données grâce à une API Rest en utilisant Rétrofit et stocke ces données en cache (via le cache HTTP). L'application 
Voici le lien de l'Api Rick And Morty: https://rickandmortyapi.com

L'application gère les erreurs en affichant un message d'erreur lorsque l'appel API n'est pas reconnue et affiche une progress Bar lorsque le chargement est un peu long.

## Aperçu de l'Application

## Auteur de l'application

Wajdi GUEDIRI UFA-3A

