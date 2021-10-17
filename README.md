# DicePainting
Transforme une image source en une image composée de dés à jouer (dés 6)

(version java d'un projet Processing, nécessite la bibliothèque processing core.jar)

![Dices](https://github.com/Avengiron/HostReadMeImages/blob/main/DicePainting/Dices.png)

On vient lire les pixels de l'image source selon un certain espace de division (ici, 7 pixels). Selon la valeur
de brightness du pixel, on attribue une valeur entre 0 et 6 et on crée un dé correspondant. Les pixels totalement 
transparents sont considérés comme des dés 0. On affiche ensuite les dés pour faire apparaitre l'image en dés.

Exemple :

![Exemple](https://github.com/Avengiron/HostReadMeImages/blob/main/DicePainting/CloneHelmetDice.png)

### Stats
Le programme compte le nombre de dés 6 et de dés neutres nécessaires à la réalisation de l'image.
Il indique aussi la taille que prendrait l'image si elle était réalisée avec des dés de 0.5cm.
