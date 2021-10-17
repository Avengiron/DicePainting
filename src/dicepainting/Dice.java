package dicepainting;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * Class Dice pour projet DicePainting. ATTENTION : ce de peut prendre la valeur
 * 0
 * @author Xavier
 */
class Dice {
  /** Position du de */
  private PVector pos;
  /** Valeur du de */
  private int value;
  /** Taille du de */
  private float size;

  /** 
   * Constructeur du de
   * @param x Coordonnee x du de
   * @param y Coordonnee y du de
   * @param size Taille du de
   * @param value Valeur du de
   */
  public Dice(int x, int y, float size, int value) {
    this.size = size;
    this.value = value;
    pos = new PVector(x * size, y * size);
  }

  /** 
   * Affichage du de selon sa valeur 
   * @param app PApplet parent
   */
  public void show(PApplet app) {
    app.pushMatrix();
    app.translate(pos.x, pos.y);
    app.stroke(191, 231, 0);
    app.strokeWeight(size / 5f);
    switch (value) {
      case 1 : paintOne(app); break;
      case 2 : paintTwo(app); break;
      case 3 : paintThree(app); break;
      case 4 : paintFour(app); break;
      case 5 : paintFive(app); break;
      case 6 : paintSix(app); break;
      default : break;
    }
    app.popMatrix();
  }

  /** 
   * Affiche un de 1 
   * @param app PApplet parent
   */
  private void paintOne(PApplet app) {
    app.point(size / 2f, size / 2f);
  }

  /** 
   * Affiche un de 2 
   * @param app PApplet parent
   */
  private void paintTwo(PApplet app) {
    app.point(3 * size / 4f, size / 4f);
    app.point(size / 4f, 3 * size / 4f);
  }

  /** 
   * Affiche un de 3 
   * @param app PApplet parent
   */
  private void paintThree(PApplet app) {
    paintOne(app);
    paintTwo(app);
  }

  /** 
   * Affiche un de 4 
   * @param app PApplet parent
   */
  private void paintFour(PApplet app) {
    app.point(3 * size / 4f, size / 4f);
    app.point(size / 4f, 3 * size / 4f);
    app.point(size / 4f, size / 4f);
    app.point(3 * size / 4f, 3 * size / 4f);
  }

  /** 
   * Affiche un de 5 
   * @param app PApplet parent
   */
  private void paintFive(PApplet app) {
    paintOne(app);
    paintFour(app);
  }

  /** 
   * Affiche un de 6 
   * @param app PApplet parent
   */
  private void paintSix(PApplet app) {
    app.point(3 * size / 4f, size / 2f);
    app.point(size / 4f, size / 2f);
    paintFour(app);
  }
}
