package org.snake.model;

import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1>FoodModelTest</h1>
 * The {@code FoodModelTest} class contains JUnit tests for the {@code FoodModel} class,
 * which represents the model of the food item in the game. It tests specific methods
 * of the FoodModel to ensure they behave as expected.
 *
 * @author Ruben Odamo
 * @see FoodModel
 */
class FoodModelTest {
    private FoodModel foodModel;
    Image foodI;
    int x,y;

    /**
     * Initialises JavaFX before running any tests to facilitate GUI-related testing.
     */
    @BeforeAll
    public static void initJavaFX() {
        Platform.startup(() -> {});
    }

    /**
     * Cleans up JavaFX after all tests have been executed.
     */
    @AfterAll
    public static void cleanUpJavaFX() {
        Platform.exit();
    }

    /**
     * Sets up the test environment before each test by initialising necessary objects.
     */
    @BeforeEach
    void setUpTests() {
        foodModel = new FoodModel();
        foodI = foodModel.getI();
        x = foodModel.getX();
        y = foodModel.getY();
    }

    /**
     * Tests the {@code getRectangle} method of the FoodModel class.
     * It verifies if the returned Rectangle2D matches the expected values.
     */
    @Test
    void getRectangle() {
        Rectangle2D expectedRectangle = new Rectangle2D(foodModel.getX(), foodModel.getY(),
                foodI.getWidth(), foodI.getHeight());
        Rectangle2D actualRectangle = foodModel.getRectangle();

        assertEquals(expectedRectangle, actualRectangle, "FAIL - rectangles are not equal");
    }

    /**
     * Tests the {@code getX} method of the FoodModel class.
     * It ensures that the correct x-coordinate of the food item is retrieved.
     */
    @Test
    void getX() {
        int expectedX = x;
        int actualX = foodModel.getX();

        assertEquals(expectedX, actualX, "FAIL - X's are not equal");
    }

    /**
     * Tests the {@code getY} method of the FoodModel class.
     * It verifies that the correct y-coordinate of the food item is retrieved.
     */
    @Test
    void getY() {
        int expectedY = y;
        int actualY = foodModel.getY();

        assertEquals(expectedY, actualY, "FAIL - Y's are not equal");
    }

    /**
     * Tests the {@code isAlive} method of the FoodModel class.
     * It ensures that the correct alive status of the food item is retrieved.
     */
    @Test
    void isAlive() {
        boolean expectedAlive = true;
        boolean actualAlive = foodModel.isAlive();

        assertEquals(expectedAlive, actualAlive, "FAIL - booleans are not equal");
    }

    /**
     * Tests the {@code setAlive} method of the FoodModel class.
     * It checks if the alive status of the food item is updated correctly.
     */
    @Test
    void setAlive() {
        foodModel.setAlive(false);

        boolean expectedAlive = false;
        boolean actualAlive = foodModel.isAlive();

        assertEquals(expectedAlive, actualAlive, "FAIL - booleans are not equal");
    }

    /**
     * Tests the {@code getI} method of the FoodModel class.
     * It verifies that the correct image of the food item is retrieved.
     */
    @Test
    void getI() {
        Image actualI = foodModel.getI();
        Image expectedI = foodI;

        assertEquals(expectedI, actualI, "FAIL - the images are not the same");
    }
}