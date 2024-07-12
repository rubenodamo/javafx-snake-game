package org.snake.model;

import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.snake.view.MenuView;
import org.snake.utility.ImageUtil;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1>EnemyModelTest</h1>
 * The {@code EnemyModelTest} class contains JUnit tests for the {@code EnemyModel} class,
 * which represents the model of the enemy in the game. It tests specific methods
 * of the EnemyModel to ensure they behave as expected.
 *
 * @author Ruben Odamo
 * @see EnemyModel
 */
class EnemyModelTest {
    private EnemyModel enemyModel;

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
        MenuView.speed = 5;
        enemyModel = new EnemyModel();
    }

    /**
     * Tests the {@code getRectangle} method of the EnemyModel class.
     * It verifies if the returned Rectangle2D matches the expected values.
     */
    @Test
    void getRectangle() {
        Rectangle2D expectedRectangle = new Rectangle2D(enemyModel.getX(), enemyModel.getY(),
                ImageUtil.images.get("enemy").getWidth(), ImageUtil.images.get("enemy").getHeight());
        Rectangle2D actualRectangle = enemyModel.getRectangle();

        assertEquals(expectedRectangle, actualRectangle, "FAIL - rectangles are not equal");
    }

    /**
     * Tests the {@code move} method of the EnemyModel class.
     * It checks if the enemy moves correctly when the 'up' direction is set.
     */
    @Test
    void move() {
        enemyModel.setUp(true);
        int initialY = enemyModel.getY();

        enemyModel.move();
        assertEquals(initialY - 5, enemyModel.getY(), "FAIL - enemy does not move correctly");
    }

    /**
     * Tests the {@code getSetX} methods of the EnemyModel class.
     * It verifies if the getX and setX methods work as expected.
     */
    @Test
    void getSetX() {
        int expectedX = 35;
        enemyModel.setX(35);
        int actualX = enemyModel.getX();

        assertEquals(expectedX, actualX, "FAIL - X's are not equal");
    }

    /**
     * Tests the {@code getSetY} methods of the EnemyModel class.
     * It verifies if the getY and setY methods work as expected.
     */
    @Test
    void getSetY() {
        int expectedY = 40;
        enemyModel.setY(40);
        int actualY = enemyModel.getY();

        assertEquals(expectedY, actualY, "FAIL - Y's are not equal");
    }

    /**
     * Tests the {@code isAlive} method of the EnemyModel class.
     * It ensures that the correct alive status of the enemy is retrieved.
     */
    @Test
    void isAlive() {
        boolean expectedAlive = false;
        boolean actualAlive = enemyModel.isAlive();

        assertEquals(expectedAlive, actualAlive, "FAIL - booleans are not equal");
    }

    /**
     * Tests the {@code isUp} method of the EnemyModel class.
     * It ensures that the correct 'up' direction status of the enemy is retrieved.
     * The test checks if the initial 'up' direction is false.
     */
    @Test
    void isUp() {
        boolean expectedUp = false;
        boolean actualUp = enemyModel.isUp();

        assertEquals(expectedUp, actualUp, "FAIL - booleans are not equal");
    }

    /**
     * Tests the {@code setUp} method of the EnemyModel class.
     * It checks if the 'up' direction is set correctly.
     * The test sets 'up' direction to true and then checks if isUp returns true.
     */
    @Test
    void setUp() {
        enemyModel.setUp(true);

        boolean expectedUp = true;
        boolean actualUp = enemyModel.isUp();

        assertEquals(expectedUp, actualUp, "FAIL - booleans are not equal");
    }

    /**
     * Tests the {@code isDown} method of the EnemyModel class.
     * It ensures that the correct 'down' direction status of the enemy is retrieved.
     * The test checks if the initial 'down' direction is false.
     */
    @Test
    void isDown() {
        boolean expectedDown = false;
        boolean actualDown = enemyModel.isDown();

        assertEquals(expectedDown, actualDown, "FAIL - booleans are not equal");
    }

    /**
     * Tests the {@code setDown} method of the EnemyModel class.
     * It checks if the 'down' direction is set correctly.
     * The test sets 'down' direction to true and then checks if isDown returns true.
     */
    @Test
    void setDown() {
        enemyModel.setDown(true);

        boolean expectedDown = true;
        boolean actualDown = enemyModel.isDown();

        assertEquals(expectedDown, actualDown, "FAIL - booleans are not equal");
    }

    /**
     * Tests the {@code isLeft} method of the EnemyModel class.
     * It ensures that the correct 'left' direction status of the enemy is retrieved.
     * The test checks if the initial 'left' direction is false.
     */
    @Test
    void isLeft() {
        boolean expectedLeft = false;
        boolean actualLeft = enemyModel.isLeft();

        assertEquals(expectedLeft, actualLeft, "FAIL - booleans are not equal");
    }

    /**
     * Tests the {@code setLeft} method of the EnemyModel class.
     * It checks if the 'left' direction is set correctly.
     * The test sets 'left' direction to true and then checks if isLeft returns true.
     */
    @Test
    void setLeft() {
        enemyModel.setLeft(true);

        boolean expectedLeft = true;
        boolean actualLeft = enemyModel.isLeft();

        assertEquals(expectedLeft, actualLeft, "FAIL - booleans are not equal");
    }

    /**
     * Tests the {@code isRight} method of the EnemyModel class.
     * It ensures that the correct 'right' direction status of the enemy is retrieved.
     * The test checks if the initial 'right' direction is false.
     */
    @Test
    void isRight() {
        boolean expectedRight = false;
        boolean actualRight = enemyModel.isRight();

        assertEquals(expectedRight, actualRight, "FAIL - booleans are not equal");
    }

    /**
     * Tests the {@code setRight} method of the EnemyModel class.
     * It checks if the 'right' direction is set correctly.
     * The test sets 'right' direction to false and then checks if isRight returns false.
     */
    @Test
    void setRight() {
        enemyModel.setRight(false);

        boolean expectedRight = false;
        boolean actualRight = enemyModel.isRight();

        assertEquals(expectedRight, actualRight, "FAIL - booleans are not equal");
    }

    /**
     * Tests the {@code getImgEnemy} method of the EnemyModel class.
     * It ensures that the correct image of the enemy is retrieved.
     * The test compares the actual image with the expected image retrieved from ImageUtil.
     */
    @Test
    void getImgEnemy() {
        Image actualImgEnemy = EnemyModel.getImgEnemy();
        Image expectedImgEnemy = ImageUtil.images.get("enemy");

        assertEquals(actualImgEnemy, expectedImgEnemy, "FAIL - the images are not the same");
    }

    /**
     * Tests the {@code getNewImgEnemy} method of the EnemyModel class.
     * It ensures that the correct new image of the enemy is retrieved.
     * The test compares the actual new image with the expected image retrieved from ImageUtil.
     */
    @Test
    void getNewImgEnemy() {
        Image actualNewImgEnemy = EnemyModel.getNewImgEnemy();
        Image expectedNewImgEnemy = ImageUtil.images.get("enemy");

        assertEquals(expectedNewImgEnemy, actualNewImgEnemy, "FAIL - the images are not the same");
    }

    /**
     * Tests the {@code setNewImgEnemy} method of the EnemyModel class.
     * It checks if the new image of the enemy is set correctly.
     * The test sets a new image using setNewImgEnemy and then checks if getNewImgEnemy returns the same image.
     */
    @Test
    void setNewImgEnemy() {
        EnemyModel.setNewImgEnemy(ImageUtil.images.get("food-apple"));

        Image actualNewImgEnemy = SnakeModel.getNewImgSnakeHead();
        Image expectedNewImgEnemy = ImageUtil.images.get("food-apple");

        assertEquals(expectedNewImgEnemy, actualNewImgEnemy, "FAIL - the images are not the same");
    }
}