package org.snake.model;

import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.snake.utility.ImageUtil;
import org.snake.view.MenuView;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1>SnakeModelTest</h1>
 * The {@code SnakeModelTest} class contains JUnit tests for the {@code SnakeModel} class,
 * which represents the model of the snake in the game. It tests various methods of the
 * SnakeModel to ensure they behave as expected.
 *
 * @author Ruben Odamo
 * @see SnakeModel
 */
class SnakeModelTest {
    private SnakeModel snakeModel;

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
        snakeModel = new SnakeModel(100,100);
    }

    /**
     * Tests the {@code move} method of the SnakeModel class.
     * It checks if the snake moves correctly based on its current direction.
     */
    @Test
    void move() {
        snakeModel.setUp(true);
        int initialY = snakeModel.getY();

        snakeModel.move();
        assertEquals(initialY - 5, snakeModel.getY(), "FAIL - snake does not move correctly");
    }

    /**
     * Tests the {@code getRectangle} method of the SnakeModel class.
     * It verifies if the returned Rectangle2D matches the expected values.
     */
    @Test
    void getRectangle() {
        Rectangle2D expectedRectangle = new Rectangle2D(snakeModel.getX(), snakeModel.getY(),
                                                            snakeModel.getW(), snakeModel.getH());
        Rectangle2D actualRectangle = snakeModel.getRectangle();

        assertEquals(expectedRectangle, actualRectangle, "FAIL - rectangles are not equal");
    }

    /**
     * Tests the {@code getLength} method of the SnakeModel class.
     * It ensures that the correct length of the snake is retrieved.
     */
    @Test
    void getLength() {
        int expectedLength = 1;
        int actualLength = snakeModel.getLength();

        assertEquals(expectedLength, actualLength, "FAIL - lengths are not equal");
    }

    /**
     * Tests the {@code changeLength} method of the SnakeModel class.
     * It checks if the length of the snake is updated correctly.
     */
    @Test
    void changeLength() {
        snakeModel.changeLength(2);

        int expectedLength = 2;
        int actualLength = snakeModel.getLength();

        assertEquals(expectedLength, actualLength, "FAIL - lengths are not equal");
    }

    /**
     * Tests the {@code getNum} method of the SnakeModel class.
     * It verifies that the correct segment number of the snake is retrieved.
     */
    @Test
    void getNum() {
        int expectedNum = 5;
        int actualNum = snakeModel.getNum();

        assertEquals(expectedNum, actualNum, "FAIL - nums are not equal");
    }

    /**
     * Tests the {@code getScore} method of the SnakeModel class.
     * It ensures that the correct score of the snake is retrieved.
     */
    @Test
    void getScore() {
        int expectedScore = 0;
        int actualScore = snakeModel.getScore();

        assertEquals(expectedScore, actualScore, "FAIL - scores are not equal");
    }

    /**
     * Tests the {@code setScore} method of the SnakeModel class.
     * It checks if the score of the snake is updated correctly.
     */
    @Test
    void setScore() {
        snakeModel.setScore(2);

        int expectedScore = 2;
        int actualScore = snakeModel.getScore();

        assertEquals(expectedScore, actualScore, "FAIL - scores are not equal");
    }

    /**
     * Tests the {@code getX} method of the SnakeModel class.
     * It verifies that the correct x-coordinate of the snake is retrieved.
     */
    @Test
    void getX() {
        int expectedX = 100;
        int actualX = snakeModel.getX();

        assertEquals(expectedX, actualX, "FAIL - X's are not equal");
    }

    /**
     * Tests the {@code getY} method of the SnakeModel class.
     * It ensures that the correct y-coordinate of the snake is retrieved.
     */
    @Test
    void getY() {
        int expectedY = 100;
        int actualY = snakeModel.getY();

        assertEquals(expectedY, actualY, "FAIL - Y's are not equal");
    }

    /**
     * Tests the {@code getW} method of the SnakeModel class.
     * It checks if the correct width of the snake is retrieved.
     */
    @Test
    void getW() {
        int expectedW = 25;
        int actualW = snakeModel.getW();

        assertEquals(expectedW, actualW, "FAIL - W's are not equal");
    }

    /**
     * Tests the {@code getH} method of the SnakeModel class.
     * It verifies that the correct height of the snake is retrieved.
     */
    @Test
    void getH() {
        int expectedH = 25;
        int actualH = snakeModel.getH();

        assertEquals(expectedH, actualH, "FAIL - H's are not equal");
    }

    /**
     * Tests the {@code isAlive} method of the SnakeModel class.
     * It ensures that the correct alive status of the snake is retrieved.
     */
    @Test
    void isAlive() {
        boolean expectedAlive = true;
        boolean actualAlive = snakeModel.isAlive();

        assertEquals(expectedAlive, actualAlive, "FAIL - booleans are not equal");
    }

    /**
     * Tests the {@code setAlive} method of the SnakeModel class.
     * It checks if the alive status of the snake is updated correctly.
     */
    @Test
    void setAlive() {
        snakeModel.setAlive(false);

        boolean expectedAlive = false;
        boolean actualAlive = snakeModel.isAlive();

        assertEquals(expectedAlive, actualAlive, "FAIL - booleans are not equal");
    }

    /**
     * Tests the {@code isUp} method of the SnakeModel class.
     * It verifies if the correct upward direction of the snake is retrieved.
     */
    @Test
    void isUp() {
        boolean expectedUp = false;
        boolean actualUp = snakeModel.isUp();

        assertEquals(expectedUp, actualUp, "FAIL - booleans are not equal");
    }

    /**
     * Tests the {@code setUp} method of the SnakeModel class.
     * It ensures that the correct upward direction of the snake is updated correctly.
     */
    @Test
    void setUp() {
        snakeModel.setUp(true);

        boolean expectedUp = true;
        boolean actualUp = snakeModel.isUp();

        assertEquals(expectedUp, actualUp, "FAIL - booleans are not equal");
    }

    /**
     * Tests the {@code isDown} method of the SnakeModel class.
     * It ensures that the correct downward direction of the snake is retrieved.
     */
    @Test
    void isDown() {
        boolean expectedDown = false;
        boolean actualDown = snakeModel.isDown();

        assertEquals(expectedDown, actualDown, "FAIL - booleans are not equal");
    }

    /**
     * Tests the {@code setDown} method of the SnakeModel class.
     * It checks if the downward direction of the snake is set correctly.
     */
    @Test
    void setDown() {
        snakeModel.setDown(true);

        boolean expectedDown = true;
        boolean actualDown = snakeModel.isDown();

        assertEquals(expectedDown, actualDown, "FAIL - booleans are not equal");
    }

    /**
     * Tests the {@code isLeft} method of the SnakeModel class.
     * It verifies if the correct left direction of the snake is retrieved.
     */
    @Test
    void isLeft() {
        boolean expectedLeft = false;
        boolean actualLeft = snakeModel.isLeft();

        assertEquals(expectedLeft, actualLeft, "FAIL - booleans are not equal");
    }

    /**
     * Tests the {@code setLeft} method of the SnakeModel class.
     * It checks if the left direction of the snake is set correctly.
     */
    @Test
    void setLeft() {
        snakeModel.setLeft(true);

        boolean expectedLeft = true;
        boolean actualLeft = snakeModel.isLeft();

        assertEquals(expectedLeft, actualLeft, "FAIL - booleans are not equal");
    }

    /**
     * Tests the {@code isRight} method of the SnakeModel class.
     * It ensures that the correct right direction of the snake is retrieved.
     */
    @Test
    void isRight() {
        boolean expectedRight = true;
        boolean actualRight = snakeModel.isRight();

        assertEquals(expectedRight, actualRight, "FAIL - booleans are not equal");
    }

    /**
     * Tests the {@code setRight} method of the SnakeModel class.
     * It checks if the right direction of the snake is set correctly.
     */
    @Test
    void setRight() {
        snakeModel.setRight(false);

        boolean expectedRight = false;
        boolean actualRight = snakeModel.isRight();

        assertEquals(expectedRight, actualRight, "FAIL - booleans are not equal");
    }

    /**
     * Tests the {@code getI} method of the SnakeModel class.
     * It verifies that the correct image of the snake body is retrieved.
     */
    @Test
    void getI() {
        Image actualI = snakeModel.getI();
        Image expectedI = ImageUtil.images.get("snake-body");

        assertEquals(expectedI, actualI, "FAIL - the images are not the same");

    }

    /**
     * Tests the {@code getImgSnakeHead} method of the SnakeModel class.
     * It ensures that the correct image of the snake head is retrieved.
     */
    @Test
    void getImgSnakeHead() {
        Image actualImgSnakeHead = SnakeModel.getImgSnakeHead();
        Image expectedImgSnakeHead = ImageUtil.images.get("snake-head");

        assertEquals(expectedImgSnakeHead, actualImgSnakeHead, "FAIL - the images are not the same");
    }

    /**
     * Tests the {@code getNewImgSnakeHead} method of the SnakeModel class.
     * It checks if the correct new image of the snake head is retrieved.
     */
    @Test
    void getNewImgSnakeHead() {
        Image actualNewImgSnakeHead = SnakeModel.getNewImgSnakeHead();
        Image expectedNewImgSnakeHead = ImageUtil.images.get("snake-head");

        assertEquals(expectedNewImgSnakeHead, actualNewImgSnakeHead, "FAIL - the images are not the same");
    }

    /**
     * Tests the {@code setNewImgSnakeHead} method of the SnakeModel class.
     * It ensures that the new image of the snake head is set correctly.
     */
    @Test
    void setNewImgSnakeHead() {
        SnakeModel.setNewImgSnakeHead(ImageUtil.images.get("food-apple"));

        Image actualNewImgSnakeHead = SnakeModel.getNewImgSnakeHead();
        Image expectedNewImgSnakeHead = ImageUtil.images.get("food-apple");

        assertEquals(expectedNewImgSnakeHead, actualNewImgSnakeHead, "FAIL - the images are not the same");
    }

    /**
     * Tests the {@code getBodyPoints} method of the SnakeModel class.
     * It verifies that the correct list of body points of the snake is retrieved.
     */
    @Test
    void getBodyPoints() {
        List<Point2D> expectedBodyPoints = new LinkedList<>();
        List<Point2D> actualBodyPoints = SnakeModel.getBodyPoints();
        assertEquals(expectedBodyPoints, actualBodyPoints, "FAIL - the lists are not equal");
    }

    /**
     * Tests the {@code setBodyPoints} method of the SnakeModel class.
     * It checks if the list of body points of the snake is set correctly.
     */
    @Test
    void setBodyPoints() {
        List<Point2D> expectedBodyPoints = new LinkedList<>();
        expectedBodyPoints.add(new Point2D(6.0,3.0));
        expectedBodyPoints.add(new Point2D(4.0,5.0));

        SnakeModel.setBodyPoints(expectedBodyPoints);
        List<Point2D> actualBodyPoints = SnakeModel.getBodyPoints();

        assertEquals(expectedBodyPoints, actualBodyPoints, "FAIL - the lists are not equal");
    }

}