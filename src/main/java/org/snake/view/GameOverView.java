package org.snake.view;

import javafx.scene.paint.Color;
import org.snake.Main;
import org.snake.controller.GameController;
import org.snake.model.SnakeModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Alert.AlertType;

import java.io.*;

import java.net.URL;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import java.util.List;
import java.util.ResourceBundle;

/**
 * <h2>GameOverView</h2>
 * The {@code GameOverView} class represents the controller for the Game Over screen.
 * It handles user input, displays the final score, and provides options to restart the game,
 * go to the main menu, or view the leaderboard.
 *
 * @author Ruben Odamo
 * @see Initializable
 * @see org.snake.Main
 * @see org.snake.controller.GameController
 * @see org.snake.model.SnakeModel
 */
public class GameOverView implements Initializable {
    public static String restartName;

    @FXML
    private Label score, highscoreLabel;
    @FXML
    private TextField name;

    /**
     * Initializes the Game Over screen, displaying the final score and checking if it's a new high score.
     *
     * @param url The URL used to resolve relative paths for the root object, or null if the root object was not created from an FXML file.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not created from an FXML file.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String finalScore = GameController.finalScore + "";
        String level;
        if (MenuView.speed == 2) {
            level = "EASY";
        }
        else if (MenuView.speed == 3) {
            level = "MEDIUM";
        }
        else {
            level = "HARD";
        }

        score.setText(finalScore);
        try {
            if (isHighscore()) {
                highscoreLabel.setText("NEW HIGHSCORE!!!");
                score.setTextFill(Color.GOLD);
            }
            else {
                highscoreLabel.setText("SCORE:");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        if (!LeaderboardView.leaderboardInitialized) {

            String username = "Guest" + ((int) (Math.random() * 5000));
            name.setText(restartName);

            FileWriter fw;
            try {
                if(MenuView.player2) {
                    fw = new FileWriter("src/main/resources/org/snake/leaderboard-multiplayer.csv", true);
                }
                else {
                    fw = new FileWriter("src/main/resources/org/snake/leaderboard.csv", true);
                }
                if (restartName == null) {
                    fw.append(username).append(",").append(finalScore).append(",").append(level).append("\n");
                    restartName = username;
                } else {
                    fw.append(restartName).append(",").append(finalScore).append(",").append(level).append("\n");
                }
                fw.flush();
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            LeaderboardView.leaderboardInitialized = true;
        }
    }

    /**
     * Confirms the player's name for the leaderboard and displays a confirmation message.
     *
     * @throws IOException If an I/O error occurs.
     */
    public void confirmName() throws IOException {
        String username = name.getText();
        String finalScore = GameController.finalScore +"";
        String level;

        if (MenuView.speed == 2) {
            level = "EASY";
        }
        else if (MenuView.speed == 3) {
            level = "MEDIUM";
        }
        else {
            level = "HARD";
        }

        String newLine = username+","+finalScore+","+level;
        Path path;
        if(MenuView.player2) {
             path = Paths.get("src/main/resources/org/snake/leaderboard-multiplayer.csv");
        }
        else {
            path = Paths.get("src/main/resources/org/snake/leaderboard.csv");
        }
        List<String> lines  =  Files.readAllLines(path);
        if(!lines.isEmpty()) {
            lines.set(lines.size() - 1, newLine);
            Files.write(path, lines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        }
        else{
            Files.write(path, newLine.getBytes(), StandardOpenOption.WRITE, StandardOpenOption.APPEND);
        }

        restartName = username;

        Alert alert = new Alert(AlertType.INFORMATION, "Name Confirmed!",
                ButtonType.OK);
        alert.showAndWait();
    }

    /**
     * Navigates to the main menu.
     *
     * @throws IOException If an I/O error occurs.
     */
    public void goToMenu() throws IOException {
        MenuView.musicPlayer.stop();
        LeaderboardView.leaderboardInitialized = false;
        restartName = null;
        Main m = new Main();
        m.changeScene("Menu.fxml");
    }

    /**
     * Restarts the game.
     *
     * @throws IOException If an I/O error occurs.
     */
    public void restartGame() throws IOException {
        LeaderboardView.leaderboardInitialized = false;
        //confirmName();
        Main m = new Main();
        //m.restart(new Stage());
        new SnakeModel(100,100);
        m.changeScene("GamePlay.fxml");

    }

    /**
     * Navigates to the leaderboard.
     *
     * @throws IOException If an I/O error occurs.
     */
    public void goToLeaderboard() throws IOException {
        Main m = new Main();
        Main.menuFlag = false;
        m.changeScene("Leaderboard.fxml");
    }

    /**
     * Handles key pressed events, triggering actions based on the pressed key.
     *
     * @param e The {@code KeyEvent} object representing the key event.
     * @throws IOException If an I/O error occurs.
     * @throws InterruptedException If the thread is interrupted while sleeping.
     */
    @FXML
    public void onKeyPressed(KeyEvent e) throws IOException, InterruptedException {
        switch (e.getCode()) {
            case R:
                restartGame();
                break;
            case L:
                goToLeaderboard();
                break;
            case M:
                goToMenu();
                break;
            case C:
                confirmName();
                break;
            default:
                break;
        }
    }

    /**
     * Checks if the final score is a new high score for the current level.
     *
     * @return {@code true} if it's a new high score, {@code false} otherwise.
     * @throws IOException If an I/O error occurs.
     */
    public boolean isHighscore() throws IOException {
        String level;
        if (MenuView.speed == 2) {
            level = "EASY";
        }
        else if (MenuView.speed == 3) {
            level = "MEDIUM";
        }
        else {
            level = "HARD";
        }

        FileReader fr;
        if(MenuView.player2) {
            fr = new FileReader("src/main/resources/org/snake/leaderboard-multiplayer.csv");
        }
        else {
            fr = new FileReader("src/main/resources/org/snake/leaderboard.csv");
        }

        BufferedReader br=new BufferedReader(fr);
        String line=br.readLine();
        while(line!=null) {
            if ((line.split(",")[2]).equals(level)) {
                if (Integer.parseInt(line.split(",")[1]) > GameController.finalScore) {
                    return false;
                }
            }
            line=br.readLine();
        }
        fr.close(); //Closes FileReader

        return true;
    }
}
