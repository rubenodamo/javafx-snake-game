package org.snake.view;

import org.snake.controller.GameController;
import org.snake.model.EnemyModel;
import org.snake.model.FoodModel;
import org.snake.model.GameModel;
import org.snake.model.SnakeModel;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;

import java.net.URL;

import java.util.ResourceBundle;

/**
 * <h2>GameView</h2>
 * The {@code GameView} class represents the game view screen.
 * It includes the game logic for controlling a snake ({@code SnakeController}) and managing food items.
 * The class handles user input, painting the game elements, and displaying the player's score.
 * The game view features a background image and a fail image displayed upon losing the game.
 *
 * The class includes methods for handling key presses, painting graphics, drawing the player's score,
 * and initiating the game frame. The game flow involves updating the snake and food elements,
 * checking for collisions, and updating the score accordingly.
 *
 * @author Ruben Odamo - modified
 * @see org.snake.controller.GameController
 * @see org.snake.model.EnemyModel
 * @see org.snake.model.FoodModel
 * @see org.snake.model.GameModel
 * @see org.snake.model.SnakeModel
 */
public class GameView implements Initializable
{
	private GameModel gameModel;
	private SnakeModel snakeModel;
	private GameController gameController;
	private FoodModel foodModel;
	private EnemyModel enemyModel;

	private final long NANOS_PER_SECOND = 1_000_000_000;
	private final double UPDATE_RATE = 5.0;
	private long lastUpdateTime = 0;
	public static boolean paused = false;

	@FXML
	private Canvas canvas;
	@FXML
	private Pane canvasPane;
	@FXML
	private AnimationTimer at;
	@FXML
	private Pane pausePane;

	/**
	 * Initializes the Game View screen, creating instances of game elements and setting up key event handling.
	 *
	 * @param location The location used to resolve relative paths for the root object, or null if the root object was not created from an FXML file.
	 * @param resources The resources used to localize the root object, or null if the root object was not created from an FXML file.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		if (gameController == null) {
			gameController = new GameController();
		}

		if (snakeModel == null) {
			snakeModel = new SnakeModel(100, 100);
		}

		if (foodModel == null) {
			foodModel = new FoodModel();
		}

		if (gameModel == null) {
			gameModel = new GameModel();
		}

		if (enemyModel == null) {
			enemyModel = new EnemyModel();
		}

		if(canvasPane != null && canvas != null) {

			canvasPane.setFocusTraversable(true);
			canvasPane.setOnKeyPressed(this::onKeyPressed);
			at = new AnimationTimer()
			{
				@Override
				public void handle(long l)
				{
					if (l - lastUpdateTime >= NANOS_PER_SECOND / UPDATE_RATE)
					{
						lastUpdateTime = l;
					}
					if(!paused) {
						try {
							pausePane.setVisible(false);
							draw();
						} catch (IOException e) {
							throw new RuntimeException(e);
						}
					}
					else {
						pausePane.setVisible(true);
					}
				}
			};
			gameController.initialise(this, snakeModel, foodModel, enemyModel);
			at.start();
		}
	}

	/**
	 * Stops the animation loop.
	 */
	public void stopLoop() {
		at.stop();
	}

	/**
	 * Handles key pressed events, triggering actions based on the pressed key.
	 *
	 * @param event The {@code KeyEvent} object representing the key event.
	 */
	@FXML
	public void onKeyPressed(KeyEvent event) {
		gameController.keyPressed(event);
	}

	/**
	 * Draws the game elements on the canvas, including the snake, food, and enemy.
	 *
	 * @throws IOException If an I/O error occurs.
	 */
	public void draw() throws IOException {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.drawImage(gameModel.getBackground(), 0, 0);
		gc.drawImage(SnakeModel.getNewImgSnakeHead(), snakeModel.getX(), snakeModel.getY());

		// Determine the state of the game
		if (snakeModel.isAlive())
		{
			drawSnake(gc);
			if (foodModel.isAlive())
			{
				drawFood(gc);
				gameController.eaten(snakeModel, foodModel);
			} else
			{
				foodModel = new FoodModel();
			}
			if (enemyModel.isAlive()) {
				drawEnemy(gc);
				gameController.killSnake(snakeModel, enemyModel);
			}
		}
		drawScore(gc);
	}

	/**
	 * Displays the player's score on the screen.
	 *
	 * @param gc The Graphics object for drawing.
	 */
	public void drawScore(GraphicsContext gc) {
		if(MenuView.backgroundOpt == 1) {
			gc.setFill(Color.rgb(186,211,228));
		}
		else if(MenuView.backgroundOpt == 2) {
			gc.setFill(Color.rgb(16,86,79));
		}
		else {
			gc.setFill(Color.CYAN);
		}
		gc.setFont(Font.font("Avenir Next Condensed",30));
		gc.fillText("SCORE : " + snakeModel.getScore()	, 20, 40);
	}

	/**
	 * Draws the food on the screen.
	 *
	 * @param gc The Graphics object for drawing.
	 */
	public void drawFood(GraphicsContext gc) {

		gc.drawImage(foodModel.getI(), foodModel.getX(), foodModel.getY());
	}

	/**
	 * Draw the snake on the screen.
	 *
	 * @param gc The {@code Graphics} object for drawing.
	 * @throws IOException If an I/O error occurs.
	 */
	public void drawSnake(GraphicsContext gc) throws IOException {
		gameController.outOfBounds();
		gameController.eatBody();

		gc.drawImage(SnakeModel.getNewImgSnakeHead(), snakeModel.getX(), snakeModel.getY());

		SnakeModel.getBodyPoints().add(new Point2D(snakeModel.getX(), snakeModel.getY()));

		if (SnakeModel.getBodyPoints().size() == (snakeModel.getLength() + 1) * snakeModel.getNum())
		{
			SnakeModel.getBodyPoints().remove(0);
		}

		drawBody(gc);

		snakeModel.move();
	}

	/**
	 * Draw the snake's body on the screen.
	 *
	 * @param gc The {@code Graphics} object for drawing.
	 */
	public void drawBody(GraphicsContext gc) {
		int length = SnakeModel.getBodyPoints().size() - 1 - snakeModel.getNum();

		for (int i = length; i >= snakeModel.getNum(); i -= snakeModel.getNum())
		{
			Point2D point = SnakeModel.getBodyPoints().get(i);
			gc.drawImage(snakeModel.getI(), point.getX(), point.getY());
		}
	}

	/**
	 * Draws the enemy on the screen.
	 *
	 * @param gc The {@code Graphics} object for drawing.
	 * @throws IOException If an I/O error occurs.
	 */
	public void drawEnemy(GraphicsContext gc) throws IOException {
		gameController.killSnake(snakeModel, enemyModel);
		gc.drawImage(EnemyModel.getNewImgEnemy(), enemyModel.getX(), enemyModel.getY());
		enemyModel.move();
	}

}
