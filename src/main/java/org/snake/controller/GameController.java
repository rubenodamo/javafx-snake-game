package org.snake.controller;

import org.snake.Main;
import org.snake.model.EnemyModel;
import org.snake.model.FoodModel;
import org.snake.utility.GameUtil;
import org.snake.model.SnakeModel;
import org.snake.view.GameView;
import org.snake.view.MenuView;

import javafx.scene.input.KeyEvent;
import javafx.geometry.Point2D;

import java.io.IOException;

/**
 * <h2>Game Controller</h2>
 * The {@code GameController} class is responsible for managing the game logic,
 * including handling user input, updating the game state, and detecting
 * game-over conditions.
 *
 * @author Ruben Odamo
 * @see org.snake.view.GameView
 * @see org.snake.model.SnakeModel
 * @see org.snake.model.FoodModel
 * @see org.snake.model.EnemyModel
 * @see org.snake.view.MenuView
 * @see org.snake.Main
 */
public class GameController {

    public GameView gameView;
    public SnakeModel snakeModel;
    public FoodModel foodModel;
    public EnemyModel enemyModel;
    public static int finalScore;
    private boolean boundFlag;

    /**
     * Initializes the GameController with references to the game components.
     *
     * @param gameView   The GameView instance responsible for rendering the game.
     * @param snakeModel The SnakeModel instance representing the game's snake.
     * @param foodModel  The FoodModel instance representing the game's food.
     * @param enemyModel The EnemyModel instance representing the game's enemy.
     */
    public void initialise(GameView gameView, SnakeModel snakeModel, FoodModel foodModel, EnemyModel enemyModel) {
        this.gameView = gameView;
        this.snakeModel = snakeModel;
        this.foodModel = foodModel;
        this.enemyModel = enemyModel;
    }

    /**
     * Handles key events when a key is pressed.
     *
     * @param e The KeyEvent object representing the key event.
     */
    public void keyPressed(KeyEvent e)
    {
        // Check the pressed key
        switch (e.getCode())
        {

            case UP:
                if (!snakeModel.isDown())
                {
                    snakeModel.setUp(true);
                    snakeModel.setDown(false);
                    snakeModel.setLeft(false);
                    snakeModel.setRight(false);

                    SnakeModel.setNewImgSnakeHead(
                         GameUtil.rotateImage(SnakeModel.getImgSnakeHead(), -90));
                }
                break;

            case DOWN:
                if (!snakeModel.isUp())
                {
                    snakeModel.setUp(false);
                    snakeModel.setDown(true);
                    snakeModel.setLeft(false);
                    snakeModel.setRight(false);

                    SnakeModel.setNewImgSnakeHead(
                            GameUtil.rotateImage(SnakeModel.getImgSnakeHead(), 90));
                }
                break;

            case LEFT:
                if (!snakeModel.isRight())
                {
                    snakeModel.setUp(false);
                    snakeModel.setDown(false);
                    snakeModel.setLeft(true);
                    snakeModel.setRight(false);

                    SnakeModel.setNewImgSnakeHead(
                            GameUtil.rotateImage(SnakeModel.getImgSnakeHead(), -180));

                }
                break;

            case RIGHT:
                if (!snakeModel.isLeft())
                {
                    snakeModel.setUp(false);
                    snakeModel.setDown(false);
                    snakeModel.setLeft(false);
                    snakeModel.setRight(true);

                    SnakeModel.setNewImgSnakeHead(SnakeModel.getImgSnakeHead());
                }
                break;

            case W:
                if (!enemyModel.isDown() || boundFlag)
                {
                    boundFlag = false;
                    enemyModel.setUp(true);
                    enemyModel.setDown(false);
                    enemyModel.setLeft(false);
                    enemyModel.setRight(false);

                    EnemyModel.setNewImgEnemy(EnemyModel.getImgEnemy());
                }
                break;

            case S:
                if (!enemyModel.isUp() || boundFlag)
                {
                    boundFlag = false;
                    enemyModel.setUp(false);
                    enemyModel.setDown(true);
                    enemyModel.setLeft(false);
                    enemyModel.setRight(false);

                    EnemyModel.setNewImgEnemy(
                            GameUtil.rotateImage(EnemyModel.getImgEnemy(), -180));
                }
                break;

            case A:
                if (!enemyModel.isRight() || boundFlag)
                {
                    boundFlag = false;
                    enemyModel.setUp(false);
                    enemyModel.setDown(false);
                    enemyModel.setLeft(true);
                    enemyModel.setRight(false);

                    EnemyModel.setNewImgEnemy(
                            GameUtil.rotateImage(EnemyModel.getImgEnemy(), -90));

                }
                break;

            case D:
                if (!enemyModel.isLeft() || boundFlag)
                {
                    boundFlag = false;
                    enemyModel.setUp(false);
                    enemyModel.setDown(false);
                    enemyModel.setLeft(false);
                    enemyModel.setRight(true);

                    EnemyModel.setNewImgEnemy(
                            GameUtil.rotateImage(EnemyModel.getImgEnemy(), 90));
                }
                break;

            case P: // press 'P' to pause
                GameView.paused = !GameView.paused;
                if(!GameView.paused){
                    MenuView.musicPlayer.play();
                }
                else{
                    MenuView.musicPlayer.pause();
                }

                break;

            default:
                break;
        }
    }

    /**
     * Handles the scenario when the snake eats the food.
     *
     * @param snakeModel The SnakeModel instance representing the game's snake.
     * @param foodModel  The FoodModel instance representing the game's food.
     */
    public void eaten(SnakeModel snakeModel, FoodModel foodModel)	{

        if (snakeModel.getRectangle().intersects(foodModel.getRectangle()) && foodModel.isAlive() && snakeModel.isAlive())		{
            foodModel.setAlive(false);
            snakeModel.changeLength(snakeModel.getLength() + 1);
            snakeModel.setScore(snakeModel.getScore()+1);
        }
    }

    /**
     * Check if the snake is out of bounds.
     *
     * @throws IOException If an I/O error occurs.
     */
    public void outOfBounds() throws IOException {
        boolean xOutS = (snakeModel.getX() <= 0 || snakeModel.getX() >= (600 - snakeModel.getW()));
        boolean yOutS = (snakeModel.getY() <= 0 || snakeModel.getY() >= (400 - snakeModel.getH()));
        if (xOutS || yOutS)
        {
            gameOver();
        }

        boolean xOutE_right = enemyModel.getX() >= (600 - enemyModel.getRectangle().getWidth());
        boolean xOutE_left = enemyModel.getX() <= 0;
        boolean yOutE_top = enemyModel.getY() >= (400 - enemyModel.getRectangle().getHeight());
        boolean yOutE_down = enemyModel.getY() <= 0;

        if (xOutE_right) {
            enemyModel.setX(0);
        }
        if(xOutE_left) {
            enemyModel.setX((int) (600 - enemyModel.getRectangle().getWidth()));
        }
        if (yOutE_top) {
            enemyModel.setY(0);
        }
        if(yOutE_down) {
            enemyModel.setY((int) (400 - enemyModel.getRectangle().getHeight()));
        }
    }

    /**
     * Check if the snake has collided with its own body.
     */
    public void eatBody()
    {
        try {
            if (snakeModel != null) {
                for (Point2D point : SnakeModel.getBodyPoints()) {
                    for (Point2D point2 : SnakeModel.getBodyPoints()) {
                        if (point.equals(point2) && point != point2) {
                            gameOver();
                        }
                    }
                }
            }
        } catch (Exception ignored) {

        }
    }

    /**
     * Checks if the snake has collided with the enemy and handles the scenario.
     *
     * @param snakeModel The SnakeModel instance representing the game's snake.
     * @param enemyModel The EnemyModel instance representing the game's enemy.
     * @throws IOException If an I/O error occurs.
     */
    public void killSnake(SnakeModel snakeModel, EnemyModel enemyModel) throws IOException {

        if (snakeModel.getRectangle().intersects(enemyModel.getRectangle()) && enemyModel.isAlive() && snakeModel.isAlive()) {
            gameOver();
        }
    }

    /**
     * Initiates the game-over scenario.
     *
     * @throws IOException If an I/O error occurs.
     */
    public void gameOver() throws IOException {
        snakeModel.setAlive(false);
        gameView.stopLoop();
        finalScore = snakeModel.getScore();
        Main m = new Main();
        m.changeScene("GameOver.fxml");

    }

}
