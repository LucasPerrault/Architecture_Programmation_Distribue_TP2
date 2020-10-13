# Architecture_Programmation_Distribue_TP2

## Partie 1
Cette partie consiste à découvrir le fonctionnement d'un fonctionnement RMI très 
basique en JAVA. Nous avons deux classes (Client - Server) et l'interface commune aux deux.
Nous initialisons le serveur RMI et nous connectons le client dessus. On appelle avec celui-ci la méthode
commune disponible dans l'interface.

Le serveur nous répond. Nous affichons le message final côté client.


## Partie 2
 
Ici nous devions créer un calculateur de moyenne pour une promotion d'étudiants en utilisant
le fonctionnement d'un serveur RMI.

Nous avons donc implémenté :
- 2 classes MODEL (Exam et Student)
- 2 interfaces (PromotionInterface, StudentInterface)
- 1 client
- 1 serveur

#### Le serveur

Celui-ci va se charger d'implémenter les fonctions des interfaces PromotionInterface et 
StudentInterface. Il va également initialiser notre serveur RMI.

Lorsque le serveur démarre on initialise la promotion d'étudiant.

#### Le client

Il va être le pilote de ce projet.

Etape de pilotage :

1) Demandé au serveur d'ajouter des étudiants (plusieurs),

2) Demandé au serveur d'ajouter des examens (un score, un coefficient, un nom),

3) Demandé au serveur de nous retourner les examens d'un étudiant,

4) Demandé au serveur de calculer la moyenne d'un étudiant,

5) Demandé au serveur de calculer la moyenne de la promotion

Comme on le voit, le client pilote et le serveur exécute.


## Partie 3

Nous devions calculer des matrices avec le fonctionnement du RMI.
Le client envoie deux matrices, le serveur retourne la nouvelle matrice.