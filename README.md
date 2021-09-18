# Phasmophobia Evidence Journal

Le Phasmophobia Evidence Journal est une application qui a pour but d'aider un joueur lors d'une partie du jeu [Phasmophobia](https://store.steampowered.com/app/739630/Phasmophobia/).

## But du jeu

Le but d'une partie de Phasmophobia est d'investiguer un lieu et d'y trouver trois indices permettant de déterminer quel type de fantôme y réside.

Cette application permet au joueur de d'éliminer des choix de fantômes qui sont impossible en fonction des indices trouvés.

## Utilisation
Au lancement de l'application, le joueur se trouve devant une fenêtre séparée en plusieurs sections:
1. À gauche, sept boutons représentants chacun l'un des indices possibles;
2. À droite, la liste des types de fantômes actuellement possibles;
3. Dans la partie inférieure, deux boutons sont présents, un pour tenter de deviner, l'autre pour remettre l'application à zéro;;
4. Dans la partie supérieure, un menu permettant d'avoir accès aux statistiques accumulées depuis la première utilisation de l'application.


![Fenêtre principale de l'application.](https://raw.githubusercontent.com/Flerxc/PhasmophobiaEvidenceJournal/main/img/img1.PNG "Fenêtre principale")

Un simple clic de souris permet de choisir les indices actuellement trouvés dans le jeu. La liste de fantômes possibles se met à jour automatiquement. Si le joueur fait une erreur et choisi le mauvais indice, il peut recliquer sur le bouton pour désélectionner l'indice.

![L'indice 'EMF Level 5' est sélectionné.](https://raw.githubusercontent.com/Flerxc/PhasmophobiaEvidenceJournal/main/img/img2.PNG "Fenêtre principale avec un indice sélectionné")

Si le joueur choisi plus de trois indices, une fenêtre d'erreur apparait.

![Trop d'indices sont sélectionnés, la fenêtre d'erreur apparait.](https://raw.githubusercontent.com/Flerxc/PhasmophobiaEvidenceJournal/main/img/img3.PNG "Fenêtre d'erreur")

Il est parfois possible de déterminer que certains indices sont impossibles à trouver. Dans ce cas, le joueur peut les retirer en appuyant sur la touche ***MAJ***, puis en cliquant sur le bouton de l'indice à enlever.

![Deux indices sont confirmés, les boutons sont verts, et un indice est supprimé, le bouton est rouge.](https://raw.githubusercontent.com/Flerxc/PhasmophobiaEvidenceJournal/main/img/img4.PNG "Fenêtre principale avec deux indices confirmés et un indice supprimé")

Le joueur peut remettre l'indice en jeu en recliquant sur le bouton, avec ou sans la touche ***MAJ*** enfoncée.

## Fin de la partie

Lorsque le joueur pense avoir trouver le bon type de fantôme, il doit appuyer sur le bouton ***GUESS***. Il est important de noter qu'un message d'erreur apparaîtra si plus d'un type fantôme est disponible dans la liste.

![Plus d'un phantôme est possible, un message d'erreur est apparu.](https://raw.githubusercontent.com/Flerxc/PhasmophobiaEvidenceJournal/main/img/img5.PNG "Fenêtre d'erreur")

1. Si le joueur confirme après la partie dans le jeu qu'il a bien deviné, il n'a qu'a appuyer sur ***Yes*** et le fantôme sera enregistré sur une base de données locale;

![L'application demande au joueur si le bon fantôme a été trouvé.](https://raw.githubusercontent.com/Flerxc/PhasmophobiaEvidenceJournal/main/img/img6.png "Fenêtre de confirmation du fantôme")

2. Si le joueur s'est trompé et qu'il clique sur ***No***, une nouvelle fenêtre s'ouvrira afin qu'il puisse selectionner le bon fantôme afin qu'il soit enregistré dans la base de données.

![L'application demande au joueur quel est le bon fantôme.](https://raw.githubusercontent.com/Flerxc/PhasmophobiaEvidenceJournal/main/img/img7.PNG "Fenêtre de confirmation du bon fantôme")

Après avoir enregistré une partie dans la base de données, le menu ***Statistics*** sera disponible. Les deux options possibles sont :
-   *General Statistics* : Une fenêtre affichera le pourcentage de victoires, le nombre total de parties jouées, ainsi que la fréquence à laquelle chaque fantôme à été rencontré.

![Une fenêtre montrant des statistiques prises dans la base de données.](https://raw.githubusercontent.com/Flerxc/PhasmophobiaEvidenceJournal/main/img/img8.PNG "Fenêtre de statistiques")

-   *History* : Une fenêtre affichera chaque entrée de la base de données.

![Une fenêtre montrant un tableau des différentes parties enregistrées dans la base de données.](https://raw.githubusercontent.com/Flerxc/PhasmophobiaEvidenceJournal/main/img/img9.PNG "Fenêtre de de statistiques")

## License
[MIT](LICENSE.txt)