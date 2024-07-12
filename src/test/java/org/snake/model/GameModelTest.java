package org.snake.model;

import javafx.application.Platform;
import javafx.scene.image.Image;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.snake.utility.ImageUtil;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1>GameModelTest</h1>
 * The {@code GameModelTest} class contains JUnit tests for the {@code GameModel} class,
 * which represents the model of the game. It tests specific methods of the GameModel
 * to ensure they behave as expected.
 *
 * @author Ruben Odamo
 * @see GameModel
 */
class GameModelTest {
    private GameModel gameModel;

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
        gameModel = new GameModel();

    }

    /**
     * Tests the {@code getBackground} method of the GameModel class.
     * It verifies that the correct background image of the game is retrieved.
     */
    @Test
    void getBackground() {
        Image actualBackground = gameModel.getBackground();
        Image expectedBackground = ImageUtil.images.get("scene-background3");

        assertEquals(actualBackground, expectedBackground, "FAIL - the background images are not the same");
    }
}