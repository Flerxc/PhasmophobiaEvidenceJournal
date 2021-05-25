# Phasmophobia Evidence Journal

Le Phasmophobia Evidence Journal est une application qui a pour but d'aider un joueur lors d'une partie du jeu [Phasmophobia](https://store.steampowered.com/app/739630/Phasmophobia/).

## But du jeu

Le but d'une partie de Phasmophobia est d'investiguer un lieu et d'y trouver trois indices permettant de déterminer quel type de fantôme y réside.

Cette application permet au joueur de d'éliminer des choix de fantômes qui sont impossible en fonction des indices trouvés.

## Installation

1. Assurez vous d'avoir la version de [java](https://www.java.com/en/download/) la plus à jour.
2. Exécutez le fichier *Phasmophobia Evidence Journal.jar* du repertoire **dist**.

## Utilisation
Au lancement de l'application, le joueur se trouve devant une fenêtre séparée en deux:
1. À gauche, six boutons représentants chacun l'un des indices possibles
2. À droite, la liste des types de fantômes actuellement possibles


![Fenêtre principale de l'application](https://raw.githubusercontent.com/FrancisLerxc/PhasmophobiaEvidenceJournal/main/img/img1.PNG "Fenêtre principale")

Un simple clic de souris permet de choisir les indices actuellement trouvés dans le jeu. La liste de fantômes possibles se met à jour automatiquement. Si le joueur fait une erreur et choisi le mauvais indice, il peut recliquer sur le bouton pour désélectionner  l'indice.

![L'indice 'EMF Level 5' est sélectionné](https://raw.githubusercontent.com/FrancisLerxc/PhasmophobiaEvidenceJournal/main/img/img2.PNG "Fenêtre principale avec un indice sélectionné")

Si le joueur choisi plus de trois indices, une fenêtre d'erreur apparait.

![Trop d'indices sont sélectionnés, la fenêtre d'erreur apparait](https://raw.githubusercontent.com/FrancisLerxc/PhasmophobiaEvidenceJournal/main/img/img3.PNG "Fenêtre d'erreur")

Il est parfois possible de déterminer que certains indices sont impossibles à trouver. Dans ce cas, le joueur peut les retirer en appuyant sur la touche ***MAJ***, puis en cliquant sur le bouton de l'indice à enlever.

![Deux indices sont confirmés, les boutons sont verts, et un indice est supprimé, le bouton est rouge.](https://raw.githubusercontent.com/FrancisLerxc/PhasmophobiaEvidenceJournal/main/img/img4.PNG "Fenêtre principale avec deux indices confirmés et un indice supprimé")

Encore une fois, le joueur peut remettre l'indice en jeu en recliquant sur le bouton, avec ou sans la touche ***MAJ*** enfoncée.


## License
[MIT](LICENSE.txt)