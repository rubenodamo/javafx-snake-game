package org.snake.view;

import org.snake.Main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import java.io.*;

import java.net.URL;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * <h2>LeaderboardView</h2>
 * The {@code LeaderboardView} class represents the view for displaying the leaderboard.
 * It includes methods for initializing the leaderboard, retrieving the top ten scores for different difficulty levels,
 * and handling key events to navigate and update the leaderboard.
 *
 * This class utilizes JavaFX components such as {@code TableView}, {@code CheckBox}, and {@code TableColumn} for displaying the leaderboard data.
 * It interacts with the {@code LeaderboardItem} class to represent individual leaderboard items.
 *
 * @author Ruben Odamo
 */
public class LeaderboardView implements Initializable {

    public static boolean leaderboardInitialized = false;
    private boolean player2 = false;

    @FXML
    private TableView<LeaderboardItem> leaderboardTable;
    @FXML
    private TableColumn<LeaderboardItem, String> nameCol, scoreCol, posCol;
    @FXML
    private CheckBox playerCheckbox;

    /**
     * Initializes the LeaderboardView, setting up the columns for the leaderboard table
     * and loading the top ten scores for the MEDIUM difficulty level.
     *
     * @param url The location used to resolve relative paths for the root object, or null if
     *            the location is not known.
     * @param resourceBundle The resource bundle to be used by this controller, or null if
     *                       the root object was not created from an FXML file.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        posCol.setCellValueFactory(new PropertyValueFactory<>("pos"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));

        ObservableList<LeaderboardItem> listMax;
        try {
            listMax = getTopTen("MEDIUM");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        leaderboardTable.setItems(listMax);

        playerCheckbox.setIndeterminate(true);
    }

    /**
     * Retrieves the top ten scores for the specified difficulty level.
     *
     * @param level The difficulty level (EASY, MEDIUM, HARD).
     * @return An ObservableList of LeaderboardItem representing the top ten scores.
     * @throws IOException If an I/O error occurs.
     */
    public ObservableList<LeaderboardItem> getTopTen(String level) throws IOException {
        ObservableList<LeaderboardItem> listMax = FXCollections.observableArrayList();
        List<String[]> leaderboardList = new ArrayList<>();
        int counter = 0;

        FileReader fr;
        if (player2) {
           fr = new FileReader("src/main/resources/org/snake/leaderboard-multiplayer.csv");
        }
        else {
           fr = new FileReader("src/main/resources/org/snake/leaderboard.csv");
        }

        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while(line!=null) {
            if ((line.split(",")[2]).equals(level)) {
                String[] data = line.split(",");
                leaderboardList.add(data);
            }
            line = br.readLine();
        }
        fr.close();

        while(!leaderboardList.isEmpty() && counter < 10) {
            int max = 0;
            int maxIndex = 0;
            counter++;
            for(int i = 0; i < leaderboardList.size(); i++) {
                if(Integer.parseInt(leaderboardList.get(i)[1]) > max) {
                    max = Integer.parseInt(leaderboardList.get(i)[1]);
                    maxIndex = i;
                }
            }

            listMax.add(new LeaderboardItem(""+counter, leaderboardList.get(maxIndex)[0],
                    leaderboardList.get(maxIndex)[1]));
            leaderboardList.remove(maxIndex);
        }

        return listMax;
    }

    /**
     * Navigates back to the menu or game over screen based on the flag {@code Main.menuFlag}.
     *
     * @throws IOException If an I/O error occurs.
     */
    public void goBack() throws IOException{
        Main m = new Main();
        if(Main.menuFlag) {
            MenuView.musicPlayer.stop();
            m.changeScene("Menu.fxml");
        }
        else {
            leaderboardInitialized = true;
            m.changeScene("GameOver.fxml");
        }
    }

    /**
     * Handles key events for navigation and updating the leaderboard.
     *
     * @param e The KeyEvent object.
     * @throws IOException If an I/O error occurs.
     */
    @FXML
    public void onKeyPressed(KeyEvent e) throws IOException {
        switch (e.getCode()) {
            case B:
                goBack();
                break;
            case E:
                setEasyTable();
                break;
            case M:
                setMediumTable();
                break;
            case H:
                setHardTable();
                break;
            default:
                break;
        }
    }

    /**
     * Sets the leaderboard table to display the top ten scores for the EASY difficulty level.
     *
     * @throws IOException If an I/O error occurs.
     */
    public void setEasyTable() throws IOException {
        leaderboardTable.setItems(getTopTen("EASY"));
    }

    /**
     * Sets the leaderboard table to display the top ten scores for the MEDIUM difficulty level.
     *
     * @throws IOException If an I/O error occurs.
     */
    public void setMediumTable() throws IOException {
        leaderboardTable.setItems(getTopTen("MEDIUM"));
    }

    /**
     * Sets the leaderboard table to display the top ten scores for the HARD difficulty level.
     *
     * @throws IOException If an I/O error occurs.
     */
    public void setHardTable() throws IOException {
        leaderboardTable.setItems(getTopTen("HARD"));
    }

    /**
     * Updates the player number based on the checkbox selection and refreshes the leaderboard.
     */
    public void getPlayerNo() {
        player2 = playerCheckbox.isSelected();

        ObservableList<LeaderboardItem> listMax;
        try {
            listMax = getTopTen("MEDIUM");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        leaderboardTable.setItems(listMax);
    }

}
