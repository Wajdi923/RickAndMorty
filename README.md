
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
![icone](https://user-images.githubusercontent.com/61593396/120121229-8d096d00-c1a2-11eb-89ed-1d0a303767ba.png)
img[alt=icone] { width: 200px; }
![splashscreen](https://user-images.githubusercontent.com/61593396/120121234-97c40200-c1a2-11eb-80c5-36e03e0f0e07.png)
![searchbar](https://user-images.githubusercontent.com/61593396/120121240-9c88b600-c1a2-11eb-8935-bbb6040a6b16.png)
![recyclerview](https://user-images.githubusercontent.com/61593396/120121244-a01c3d00-c1a2-11eb-8624-b2f4a0c52e0f.png)
![detail_list](https://user-images.githubusercontent.com/61593396/120121258-ad392c00-c1a2-11eb-8df3-ef9106e54e91.png)
![cache](https://user-images.githubusercontent.com/61593396/120121260-af9b8600-c1a2-11eb-90f6-8913598d9651.png)
![erreur](https://user-images.githubusercontent.com/61593396/120121262-b32f0d00-c1a2-11eb-8946-54d25d50934d.png)

## Auteur de l'application

Wajdi GUEDIRI UFA-3A

