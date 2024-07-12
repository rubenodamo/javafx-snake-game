/**
 * The module declaration for the Snake Game module.
 * Specifies module-related information, opens packages for reflective access,
 * exports packages to other modules, and declares required dependencies.
 *
 * This module includes packages for the Snake game implementation,
 * consisting of the model, view, controller, and utility components.
 */
module SnakeGame {
    opens org.snake;

    opens org.snake.model;
    opens org.snake.view;
    opens org.snake.controller;
    opens org.snake.utility;

    exports org.snake;
    exports org.snake.model;
    exports org.snake.view to javafx.fxml;
    exports org.snake.controller;
    exports org.snake.utility;

    requires java.desktop;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.media;
}