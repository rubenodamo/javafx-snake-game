package org.snake.model;

import javafx.scene.image.Image;
import org.snake.utility.ImageUtil;
import javafx.geometry.Rectangle2D;

import java.util.Random;

/**
 * <h2>FoodModel</h2>
 * The {@code FoodModel} class represents the model of a food item in the game.
 * It encapsulates the properties and behavior of the food item, including appearance and position.
 *
 * @author Ruben Odamo - modified
 * @see org.snake.utility.ImageUtil
 */
public class FoodModel
{
	private final int x, y;
	private final int w, h;
	private boolean alive;
	private final Image i;

	/**
	 * Constructs a new {@code FoodModel} with default properties.
	 * The food item is initially placed randomly within the visible area of the game window.
	 * The appearance of the food item is randomly selected from a set of images.
	 */
	public FoodModel()	{
		this.alive = true;

		this.i = ImageUtil.images.get(String.valueOf(new Random().nextInt(10)));

		this.w = (int) i.getWidth();
		this.h = (int) i.getHeight();

		// Set the X-coordinate and Y-coordinate of the food item randomly within the visible area of the game window
		// Math.random() generates a random value between 0 (inclusive) and 1 (exclusive)
		// Multiply by (600 - w + 10) or (400 - h - 40) to scale the random value to fit the width or height of the visible area
		// The +10 and -40 ensures that the entire width of the food item is visible
		this.x = (int) (Math.random() * (580 - w + 10));
		this.y = (int) (Math.random() * (380 - h - 40));
	}

	/**
	 * Returns the bounding rectangle of the food item for collision detection.
	 *
	 * @return The bounding rectangle of the food item.
	 */
	public Rectangle2D getRectangle()
	{
		return new Rectangle2D(x, y, w, h);
	}

	/**
	 * Returns the X-coordinate of the food item.
	 *
	 * @return The X-coordinate of the food item.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Returns the Y-coordinate of the food item.
	 *
	 * @return The Y-coordinate of the food item.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Checks if the food item is alive.
	 *
	 * @return {@code true} if the food item is alive, {@code false} otherwise.
	 */
	public boolean isAlive() {
		return alive;
	}
	/**
	 * Sets the status of the food item as alive or dead.
	 *
	 * @param alive {@code true} to set the food item as alive, {@code false} to set it as dead.
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	/**
	 * Returns the image of the food item.
	 *
	 * @return The image of the food item.
	 */
	public Image getI() {
		return i;
	}
}
