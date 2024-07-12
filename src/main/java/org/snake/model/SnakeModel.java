package org.snake.model;

import org.snake.utility.ImageUtil;
import org.snake.view.MenuView;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

import java.util.LinkedList;
import java.util.List;

/**
 * <h2>SnakeModel</h2>
 * The {@code SnakeModel} class represents the model of the snake in the game.
 * It encapsulates the properties and behavior related to the snake.
 *
 * @author Ruben Odamo - modified
 * @see org.snake.utility.ImageUtil
 * @see org.snake.view.MenuView
 */
public class SnakeModel
{
    private final int speed_XY;
    private int length;
    private final int num;
    private int score = 0;
    private int x, y;
    private final int w, h;
    private boolean alive;
    private boolean up, down, left, right = true;
    private final Image i;
    private static final Image IMG_SNAKE_HEAD = ImageUtil.images.get("snake-head");
    private static Image newImgSnakeHead;
    private static List<Point2D> bodyPoints = new LinkedList<>();

    /**
     * Constructor for {@code SnakeModel}.
     *
     * @param x Initial x-coordinate.
     * @param y Initial y-coordinate.
     */
    public SnakeModel(int x, int y) {
        this.alive = true;

        this.x = x;
        this.y = y;

        this.i = ImageUtil.images.get("snake-body");

        this.w = (int) i.getWidth();
        this.h = (int) i.getHeight();

        // easy = 2; medium = 3; hard = 4
        this.speed_XY = MenuView.speed;
        this.length = 1;

        this.num = w / speed_XY;
        newImgSnakeHead = IMG_SNAKE_HEAD;

        // resets body points
        setBodyPoints(new LinkedList<>());
    }

    /**
     * Move the snake.
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
     * Get the rectangular bounds of the snake.
     *
     * @return A Rectangle representing the bounds of the snake.
     */
    public Rectangle2D getRectangle() {
        return new Rectangle2D(x, y, w, h);
    }

    /**
     * Get the length of the snake.
     *
     * @return The length of the snake.
     */
    public int getLength() {
        return length;
    }
    /**
     * Change the length of the snake.
     *
     * @param length The new length of the snake.
     */
    public void changeLength(int length) {
        this.length = length;
    }

    /**
     * Get the segment number of the snake.
     *
     * @return The segment number of the snake.
     */
    public int getNum() {
        return num;
    }

    /**
     * Get the score of the snake.
     *
     * @return The score of the snake.
     */
    public int getScore() {
        return score;
    }
    /**
     * Set the score of the snake.
     *
     * @param score The score to set for the snake.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Get the x-coordinate of the snake.
     *
     * @return The x-coordinate of the snake.
     */
    public int getX() {
        return x;
    }

    /**
     * Get the y-coordinate of the snake.
     *
     * @return The y-coordinate of the snake.
     */
    public int getY() {
        return y;
    }

    /**
     * Get the width of the snake.
     *
     * @return The width of the snake.
     */
    public int getW() {
        return w;
    }

    /**
     * Get the height of the snake.
     *
     * @return The height of the snake.
     */
    public int getH() {
        return h;
    }

    /**
     * Check if the snake is alive.
     *
     * @return {@code true} if the snake is alive, {@code false} otherwise.
     */
    public boolean isAlive() {
        return alive;
    }
    /**
     * Set the status of the snake (alive or dead).
     *
     * @param alive The status of the snake.
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * Check if the snake is moving up.
     *
     * @return {@code true} if the snake is moving up, {@code false} otherwise.
     */
    public boolean isUp() {
        return up;
    }
    /**
     * Set the direction of the snake to up.
     *
     * @param up The direction to set for the snake.
     */
    public void setUp(boolean up) {
        this.up = up;
    }

    /**
     * Check if the snake is moving down.
     *
     * @return {@code true} if the snake is moving down, {@code false} otherwise.
     */
    public boolean isDown() {
        return down;
    }
    /**
     * Set the direction of the snake to down.
     *
     * @param down The direction to set for the snake.
     */
    public void setDown(boolean down) {
        this.down = down;
    }

    /**
     * Check if the snake is moving left.
     *
     * @return {@code true} if the snake is moving left, {@code false} otherwise.
     */
    public boolean isLeft() {
        return left;
    }
    /**
     * Set the direction of the snake to left.
     *
     * @param left The direction to set for the snake.
     */
    public void setLeft(boolean left) {
        this.left = left;
    }

    /**
     * Check if the snake is moving right.
     *
     * @return {@code true} if the snake is moving right, {@code false} otherwise.
     */
    public boolean isRight() {
        return right;
    }
    /**
     * Set the direction of the snake to right.
     *
     * @param right The direction to set for the snake.
     */
    public void setRight(boolean right) {
        this.right = right;
    }

    /**
     * Get the image of the snake body.
     *
     * @return The image of the snake body.
     */
    public Image getI() {
        return i;
    }

    /**
     * Get the image of the snake head.
     *
     * @return The image of the snake head.
     */
    public static Image getImgSnakeHead(){
        return IMG_SNAKE_HEAD;
    }

    /**
     * Get the new image of the snake head.
     *
     * @return The new image of the snake head.
     */
    public static Image getNewImgSnakeHead() {
        return newImgSnakeHead;
    }
    /**
     * Set the new image of the snake head.
     *
     * @param newImgSnakeHead The new image of the snake head.
     */
    public static void setNewImgSnakeHead(Image newImgSnakeHead) {
        SnakeModel.newImgSnakeHead = newImgSnakeHead;
    }

    /**
     * Get the list of body points of the snake.
     *
     * @return The list of body points of the snake.
     */
    public static List<Point2D> getBodyPoints() {
        return bodyPoints;
    }
    /**
     * Set the list of body points of the snake.
     *
     * @param bodyPoints The list of body points to set for the snake.
     */
    public static void setBodyPoints(List<Point2D> bodyPoints) {
        SnakeModel.bodyPoints = bodyPoints;
    }
}
