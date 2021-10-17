package dicepainting;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Class DicePainting pour projet DicePainting. Prends une image source et la
 * decompose en des.
 * @author Xavier
 */
public class DicePainting extends PApplet {

  /** Point d'entree de l'application */
  public static void main(String[] args) {
    PApplet.main(DicePainting.class.getName());
  }

  /** Setup du PApplet */
  @Override
  public void settings() {
    // Window width = image width / size * size
    // Window height = image height / size * size
    size(497, 637);
  }

  /** Setup de la fenetre */
  @Override
  public void setup() {
    // Chargement de l'image et setup des variables
    PImage img = loadImage("CloneHelmet.png");
    final int size = 7;
    int nbCols = img.width / size;
    int nbRows = img.height / size;
    Dice[][] dices = new Dice[nbCols][nbRows];
    // Statistiques sur les des
    int[] diceCount = new int[7];

    // Lecture de l'image source : on lit les pixels selon
    // l'espace de division.
    // Si le pixel est transparent, on cree un de 0. Sinon
    // on cree un de selon la brightness du pixel
    for (int i = 0; i < nbCols; i++) {
      for (int j = 0; j < nbRows; j++) {
        int x = i * size;
        int y = j * size;

        // Si pixel transparent, de 0 (de neutre)
        if (alpha(img.get(x, y)) == 0) {
          dices[i][j] = new Dice(i, j, size, 0);
          diceCount[0]++;
        } 
        // Sinon, on s'adapte a la brightness (de 0 inclus)
        else {
          float bright = brightness(img.get(x, y));
          int val = round(map(bright, 0, 255, 0, 6));
          dices[i][j] = new Dice(i, j, size, val);
          diceCount[val]++;
        }
      }
    }

    // Affichage du tableau de des
    background(39, 39, 34);
    for (int i = 0; i < nbCols; i++) {
      for (int j = 0; j < nbRows; j++) {
        dices[i][j].show(this);
      }
    }
    
    // Affichage des statistiques
    float diceSize = 0.5f; // cm
    System.out.printf("%.2f x %.2fcm (dés de %.2fcm)\n", nbCols * diceSize, nbRows * diceSize, diceSize);
    System.out.println("Nombre de dés neutres : " + diceCount[0]);
    int sum = 0;
    for (int i = 1; i < diceCount.length; i++) {
      sum += diceCount[i];
      //System.out.println("Nombre dé " + i + " : " + diceCount[i]);
    }
    System.out.println("Nombre de dés 6 : " + sum);
  }

}
