package org.snake.utility;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;

/**
 * <h2> ImageUtil</h2>
 * The {@code ImageUtil} class serves as a utility class for managing and storing images used in the Snake game.
 * It includes a static map ({@code images}) that associates image names with their corresponding Image objects.
 * Images are loaded using the {@code GameUtil} class, which provides a method to retrieve images based on file paths.
 *
 * The class features a static initialiser block to populate the image map
 * with various elements used in the game, such as different parts of the snake, obstacles (food items),
 * background images, and scene images.
 *
 * Example usage:
 * <pre>
 * {@code
 * ImageUtil.images.put("snake-head", GameUtil.getImage("snake-head.png"));
 * ImageUtil.images.put("food-kiwi", GameUtil.getImage("food-kiwi.png"));
 * // ... (add more image mappings)
 * }
 * </pre>
 *
 * @author Ruben Odamo - modified
 * @see GameUtil
 * @see Image
 * @see HashMap
 */
public class ImageUtil
{
	/**
	 * A map that associates image names with their corresponding Image objects.
	 */
	public static Map<String, Image> images = new HashMap<>();

	//Initialises the image map by populating it with various elements used in the Snake game.
	static
	{
		// snake
		images.put("snake-head", GameUtil.getImage("snake-head.png"));
		images.put("snake-body", GameUtil.getImage("snake-body.png"));
		// obstacles
		images.put("0", GameUtil.getImage("food-kiwi.png"));
		images.put("1", GameUtil.getImage("food-lemon.png"));
		images.put("2", GameUtil.getImage("food-litchi.png"));
		images.put("3", GameUtil.getImage("food-mango.png"));
		images.put("4", GameUtil.getImage("food-apple.png"));
		images.put("5", GameUtil.getImage("food-banana.png"));
		images.put("6", GameUtil.getImage("food-blueberry.png"));
		images.put("7", GameUtil.getImage("food-cherry.png"));
		images.put("8", GameUtil.getImage("food-durian.png"));
		images.put("9", GameUtil.getImage("food-grape.png"));
		images.put("10", GameUtil.getImage("food-grapefruit.png"));
		images.put("11", GameUtil.getImage("food-peach.png"));
		images.put("12", GameUtil.getImage("food-pear.png"));
		images.put("13", GameUtil.getImage("food-orange.png"));
		images.put("14", GameUtil.getImage("food-pineapple.png"));
		images.put("15", GameUtil.getImage("food-strawberry.png"));
		images.put("16", GameUtil.getImage("food-watermelon.png"));
		images.put("scene-background1", GameUtil.getImage("scene-background1.png"));
		images.put("scene-background2", GameUtil.getImage("scene-background2.png"));
		images.put("scene-background3", GameUtil.getImage("scene-background3.png"));
		images.put("enemy", GameUtil.getImage("enemy.png"));
	}
}
