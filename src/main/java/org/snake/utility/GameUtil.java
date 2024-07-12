package org.snake.utility;

import java.net.URL;

import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.image.WritableImage;

/**
 * <h2> GameUtil </h2>
 * The {@code GameUtil} class provides utility methods for loading and manipulating images in the Snake game.
 * It includes methods to retrieve images from file paths and rotate images.
 *
 * Example usage:
 * <pre>
 * {@code
 * URL imageResource = GameUtil.class.getClassLoader().getResource("path/to/image.png");
 * BufferedImage image = ImageIO.read(imageResource);
 * Image rotatedImage = GameUtil.rotateImage(image, 90);
 * }
 * </pre>
 *
 * @author Ruben Odamo - modified
 * @see Image
 */
public class GameUtil
{
	/**
	 * Retrieves an Image object from the specified image path using the class loader.
	 *
	 * @param imagePath The path to the image file.
	 * @return The Image object corresponding to the specified image path.
	 */
	public static Image getImage(String imagePath) {
		URL imageResource = GameUtil.class.getClassLoader().getResource(imagePath);
		Image image = null;
		try
		{
            assert imageResource != null;
            image = new Image(imageResource.toExternalForm());
		} catch (Exception e)
		{
			System.err.println("ERROR: SPECIFIC IMAGE NOT FOUND!\n");
		}

		return image;
	}

	/**
	 * Rotates the given Image object by the specified degree.
	 *
	 * @param image The Image object to rotate.
	 * @param degree The degree by which to rotate the image.
	 * @return The rotated WritableImage.
	 */
	public static WritableImage rotateImage(final Image image, final int degree) {
		ImageView imageView = new ImageView(image);
		imageView.setRotate(degree);

		SnapshotParameters params = new SnapshotParameters();
		params.setFill(Color.TRANSPARENT);

		int w = (int) image.getWidth();
		int h = (int) image.getHeight();

		WritableImage writableImage = new WritableImage(w, h);

		return imageView.snapshot(params, writableImage);
	}
}
