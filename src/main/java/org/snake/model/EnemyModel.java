package org.snake.model;

import org.snake.utility.ImageUtil;
import org.snake.view.MenuView;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

/**
 * <h2>EnemyModel</h2>
 * The {@code EnemyModel} class represents the model of the enemy in the game.
 * It encapsulates the properties and behavior of the enemy, including movement and appearance.
 *
 * @author Ruben Odamo
 * @see org.snake.utility.ImageUtil
 * @see org.snake.view.MenuView
 */
public class EnemyModel {
    private final int speed_XY;
    private int x, y;
    private final int w, h;
    private boolean alive;
    private boolean up, down, left, right;
    private static final Image IMG_ENEMY = ImageUtil.images.get("enemy");
    private static Image newImgEnemy;

    /**
     * Constructs a new {@code EnemyModel} with default properties.
     * The enemy is initially placed randomly within the visible area of the game window.
     * The speed and appearance of the enemy depend on the game settings.
     */
    public EnemyModel()	{
        if (MenuView.player2) {
            this.alive = true;
        }

        this.w = (int) IMG_ENEMY.getWidth();
        this.h = (int) IMG_ENEMY.getHeight();

        // easy = 2; medium = 3; hard = 4
        this.speed_XY = MenuView.speed;

        // Set the X-coordinate and Y-coordinate of the enemy randomly within the visible area of the game window
        // Math.random() generates a random value between 0 (inclusive) and 1 (exclusive)
        // Multiply by (600 - w + 10) or (400 - h - 40) to scale the random value to fit the width or height of the visible area
        // The +10 and -40 ensures that the entire width of the food item is visible
        this.x = (int) (Math.random() * (580 - w + 10));
        this.y = (int) (Math.random() * (380 - h - 40));

        newImgEnemy = IMG_ENEMY;
    }

    /**
     * Returns the bounding rectangle of the enemy for collision detection.
     *
     * @return The bounding rectangle of the enemy.
     */
    public Rectangle2D getRectangle() {
        return new Rectangle2D(x, y, w, h);
    }

    /**
     * Moves the enemy based on its current direction.
     */
    public void move() {
        if (up)
        {
            y -= speed_XY;
        } else if (down)
        {
            y += speed_XY;
        } else if (left)
        {
            x -= speed_XY;
        } else if (right)
        {
            x += speed_XY;
        }
    }

    /**
     * Returns the X-coordinate of the enemy.
     *
     * @return The X-coordinate of the enemy.
     */
    public int getX() {
        return x;
    }
    /**
     * Sets the X-coordinate of the enemy.
     *
     * @param x The new X-coordinate of the enemy.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Returns the Y-coordinate of the enemy.
     *
     * @return The Y-coordinate of the enemy.
     */
    public int getY() {
        return y;
    }
    /**
     * Sets the Y-coordinate of the enemy.
     *
     * @param y The new Y-coordinate of the enemy.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Checks if the enemy is alive.
     *
     * @return {@code true} if the enemy is alive, {@code false} otherwise.
     */
    public boolean isAlive() {
        return alive;
    }


    /**
     * Checks if the enemy is moving up.
     *
     * @return {@code true} if the enemy is moving up, {@code false} otherwise.
     */
    public boolean isUp() {
        return up;
    }
    /**
     * Sets the direction of the enemy to up.
     *
     * @param up {@code true} to set the direction up, {@code false} otherwise.
     */
    public void setUp(boolean up) {
        this.up = up;
    }

    /**
     * Checks if the enemy is moving down.
     *
     * @return {@code true} if the enemy is moving down, {@code false} otherwise.
     */
    public boolean isDown() {
        return down;
    }
    /**
     * Sets the direction of the enemy to down.
     *
     * @param down {@code true} to set the direction down, {@code false} otherwise.
     */
    public void setDown(boolean down) {
        this.down = down;
    }

    /**
     * Checks if the enemy is moving left.
     *
     * @return {@code true} if the enemy is moving left, {@code false} otherwise.
     */
    public boolean isLeft() {
        return left;
    }
    /**
     * Sets the direction of the enemy to left.
     *
     * @param left {@code true} to set the direction left, {@code false} otherwise.
     */
    public void setLeft(boolean left) {
        this.left = left;
    }

    /**
     * Checks if the enemy is moving right.
     *
     * @return {@code true} if the enemy is moving right, {@code false} otherwise.
     */
    public boolean isRight() {
        return right;
    }
    /**
     * Sets the direction of the enemy to right.
     *
     * @param right {@code true} to set the direction right, {@code false} otherwise.
     */
    public void setRight(boolean right) {
        this.right = right;
    }

    /**
     * Returns the original image of the enemy.
     *
     * @return The original image of the enemy.
     */
    public static Image getImgEnemy(){
        return IMG_ENEMY;
    }

    /**
     * Returns the current image of the enemy.
     *
     * @return The current image of the enemy.
     */
    public static Image getNewImgEnemy() {
        return newImgEnemy;
    }
    /**
     * Sets the current image of the enemy.
     *
     * @param newImgEnemy The new image of the enemy.
     */
    public static void setNewImgEnemy(Image newImgEnemy) {
        EnemyModel.newImgEnemy = newImgEnemy;
    }
}
