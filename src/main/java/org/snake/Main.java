package org.snake;

import javafx.application.Platform;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * <h2>Main</h2>
 * The {@code Main} class serves as the entry point for the Snake Game application.
 * It extends the JavaFX {@code Application} class and initializes the game components,
 * including the models, views, and controllers.
 *
 * The class includes a method to change the scene, start the application,
 * and handle the closing of the application window.
 *
 * @author Ruben Odamo - modified
 * @see Application
 * @see Stage
 * @see Parent
 * @see Scene
 */
public class Main extends Application {
    public static boolean menuFlag;

    private static Stage stg;

    /**
     * The main entry point for the application.
     * It launches the JavaFX application and sets up the initial scene (Menu.fxml).
     *
     * @param stage The primary stage for the application.
     * @throws IOException If an error occurs while loading the FXML file.
     */
    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Menu.fxml")));
        Scene scene = new Scene(root);
        stage.setTitle("Snake Game");
        stage.setResizable(false);

        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(t -> {
            Platform.exit();
            System.exit(0);
        });
    }

    /**
     * Changes the scene in the primary stage to the specified FXML file.
     *
     * @param fxml The name of the FXML file for the new scene.
     * @throws IOException If an error occurs while loading the FXML file.
     */
    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        stg.setResizable(false);
        stg.getScene().setRoot(pane);
        stg.sizeToScene();
    }

    /**
     * The main method that launches the JavaFX application.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
