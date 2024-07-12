package org.snake.model;

import org.snake.utility.ImageUtil;
import org.snake.view.MenuView;

import javafx.scene.image.Image;

/**
 * <h2>GameModel</h2>
 * The {@code GameModel} class represents the model of the game environment.
 * It encapsulates the properties and behavior related to the game background.
 *
 * @author Ruben Odamo
 * @see org.snake.utility.ImageUtil
 * @see org.snake.view.MenuView
 */
public class GameModel {
    private final Image background;

    /**
     * Constructs a new {@code GameModel} with the specified background option.
     * The background option determines the appearance of the game background.
     *
     * @see MenuView#backgroundOpt
     */
    public GameModel() {
        if(MenuView.backgroundOpt == 1) {
            this.background = ImageUtil.images.get("scene-background1");
        }
        else if(MenuView.backgroundOpt == 2) {
            this.background = ImageUtil.images.get("scene-background2");
        }
        else {
            this.background = ImageUtil.images.get("scene-background3");
        }
    }

    /**
     * Returns the background image of the game environment.
     *
     * @return The background image of the game environment.
     */
    public Image getBackground() {

        return background;
    }
}
