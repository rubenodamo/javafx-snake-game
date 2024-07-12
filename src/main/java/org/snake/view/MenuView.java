package org.snake.view;

import javafx.scene.control.Label;
import org.snake.Main;
import org.snake.controller.MusicPlayer;
import org.snake.utility.ImageUtil;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyEvent;
import javafx.scene.image.ImageView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

import java.net.URL;

import java.util.ResourceBundle;

/**
 * MenuView
 * The {@code MenuView} class represents the main menu screen, allowing users to configure game options,
 * select difficulty levels, and navigate to other game sections.
 *
 * The class includes methods for initializing the menu, updating difficulty settings,
 * navigating to the game and leaderboard screens, changing background images and music tracks,
 * and handling key presses for menu interactions.
 *
 * @author Ruben Odamo
 * @see Main
 * @see MusicPlayer
 * @see ImageUtil
 */
public class MenuView implements Initializable {

    public static MusicPlayer musicPlayer;

    public static int speed = 3;
    public static int backgroundOpt = 0;
    public static int musicOpt = 1;
    public static boolean player2 = false;

    @FXML
    private ComboBox<String> difficultyCombo;
    @FXML
    private ImageView preview;
    @FXML
    private Slider volumeSlider;
    @FXML
    private CheckBox playerCheckbox;
    @FXML
    private Label factLabel;

    /**
     * Initializes the MenuView, setting up the difficulty combo box,
     * background image, music player, and other initial settings.
     *
     * @param url The location used to resolve relative paths for the root object, or null if
     *            the location is not known.
     * @param resourceBundle The resource bundle to be used by this controller, or null if
     *                       the root object was not created from an FXML file.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> difficultyList = FXCollections.observableArrayList("EASY","MEDIUM","HARD");
        difficultyCombo.setItems(difficultyList);
        difficultyCombo.setValue("MEDIUM");

        backgroundOpt = 0;
        changeBackground();

        musicOpt = 1;
        String initialMusic = "src/main/resources/clown.mp3";
        musicPlayer = new MusicPlayer(initialMusic);
        musicPlayer.play();
        changeVolume();

        speed = 3;

        playerCheckbox.setIndeterminate(true);

        generateFact();
    }

    /**
     * Updates the game difficulty based on the selected value in the combo box.
     *
     */
    public void updateDifficulty() {
        if(difficultyCombo.getValue().equals("EASY")) {
            speed = 2;
        }
        else if(difficultyCombo.getValue().equals("HARD")) {
            speed = 4;
        }
        else { // "MEDIUM" is default
            speed = 3;
        }
    }

    /**
     * Navigates to the game screen.
     *
     * @throws IOException If an I/O error occurs.
     */
    public void goToGame() throws IOException {
        Main m = new Main();
        m.changeScene("GamePlay.fxml");
    }

    /**
     * Navigates to the leaderboard screen.
     *
     * @throws IOException If an I/O error occurs.
     */
    public void goToLeaderboard() throws IOException {
        Main m = new Main();
        Main.menuFlag = true;
        m.changeScene("Leaderboard.fxml");
    }

    /**
     * Changes the background image preview on the menu screen.
     */
    public void changeBackground() {
        backgroundOpt++;
        if(backgroundOpt > 3) {
            backgroundOpt = 1;
        }

        if(backgroundOpt == 1) {
            preview.setImage(ImageUtil.images.get("scene-background1"));
        }
        else if(backgroundOpt == 2) {
            preview.setImage(ImageUtil.images.get("scene-background2"));
        }
        else {
            preview.setImage(ImageUtil.images.get("scene-background3"));
        }

    }

    /**
     * Changes the background music track.
     *
     */
    public void changeMusic() {
        String filename;
        musicOpt++;
        if(musicOpt > 3) {
            musicOpt = 1;
        }

        if(musicOpt == 1) {
            /*
            Clown by Sakura Girl | https://soundcloud.com/sakuragirl_official
            Music promoted by https://www.chosic.com/free-music/all/
            Creative Commons CC BY 3.0
            https://creativecommons.org/licenses/by/3.0/
             */
            filename ="src/main/resources/clown.mp3";
        }
        else if(musicOpt == 2) {
            /*
             Good Time by Sakura Girl | https://soundcloud.com/sakuragirl_official
             Music promoted by https://www.chosic.com/free-music/all/
             Creative Commons CC BY 3.0
             https://creativecommons.org/licenses/by/3.0/
             */
            filename = "src/main/resources/goodtime.mp3";
        }
        else {
           /*
             Daisy by Sakura Girl | https://soundcloud.com/sakuragirl_official
             Music promoted by https://www.chosic.com/free-music/all/
             Creative Commons CC BY 3.0
             https://creativecommons.org/licenses/by/3.0/
             */
            filename = "src/main/resources/daisy.mp3";
        }

        if (musicPlayer != null) {
            musicPlayer.stop(); // Stop the current music
        }

        musicPlayer = new MusicPlayer(filename);
        musicPlayer.play();
    }

    /**
     * Changes the volume of the background music based on the slider value.
     */
    public void changeVolume(){
        volumeSlider.valueProperty().addListener((observable, oldNumber, newNumber)
                -> musicPlayer.setVolume(volumeSlider.getValue()));
    }

    /**
     * Handles key presses for menu interactions, such as navigating to the game or leaderboard,
     * changing background images, and changing music tracks.
     *
     * @param e The key event triggered by a key press.
     * @throws IOException If an I/O error occurs.
     * @throws InterruptedException If the thread is interrupted during music playback.
     */
    @FXML
    public void onKeyPressed(KeyEvent e) throws IOException, InterruptedException {
        switch (e.getCode()) {
            case G:
                goToGame();
                break;
            case L:
                goToLeaderboard();
                break;
            case C:
                changeBackground();
                break;
            case M:
                changeMusic();
                break;
            default:
                break;
        }
    }

    /**
     * Gets the player number from the checkbox (single or multiplayer).
     */
    public void getPlayerNo() {
        player2 = playerCheckbox.isSelected();
    }

    /**
     * Generates a random number between 1 and 3, and assigns it to a fact.
     * Sets the label to a fact.
     */
    public void generateFact() {
        int factNum = (int) (Math.random() * 3);

        if (factNum == 1) {
            factLabel.setText("Did you know snakes do not have eyelids?");
        }
        else if (factNum == 2) {
            factLabel.setText("Did you know snakes smell with their tongues?");
        }
        else {
            factLabel.setText("Did you know snakes evolved over 142 million years ago?");
        }

    }

}
