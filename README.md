# Snake Game

Welcome to the Snake Game repository! This simple Snake Game is developed in Java and JavaFX.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Getting Started](#getting-started)
- [How to Play](#how-to-play)
- [Credits](#credits)
- [Test Plan](#test-plan)
- [Documentation](#documentation)
  - [UML Diagrams](#uml-diagrams)
  - [MVC Architecture Plan](#mvc-architecture-plan)


## Overview

This Snake Game is a classic implementation where players control a snake to eat food and grow longer. The game features a user-friendly interface, scoring, and basic functionalities.

## Features

- Snake movement control with arrow keys.
- Food items appear randomly for the snake to consume.
- Score tracking and length increase for each consumed food.
- Basic graphics and background music.
- Leaderboard to track the highest scores.

## Getting Started

To run the game locally, follow these steps:

### IDE Installation
1. Clone the repository:

   ```bash
   git clone [https://github.com/rubenodamo/javafx-snake-game.git]
2. Open the project into your preferred IDE (e.g., IntelliJ, Eclipse). 
3. Run the `Main.java` class to start the game.

### Maven Instructions
1. Clone the repository:

   ```bash
   git clone [https://github.com/rubenodamo/javafx-snake-game.git]
   
2. Navigate to the folder in your directory.

3. Compile and run the game
    ```bash
       mvn clean compile javafx:run

### JAR Instructions
1. Clone the repository:

   ```bash
   git clone [https://github.com/rubenodamo/javafx-snake-game.git]
   
2. Compile and run the game

   ```bash
   cd javafx-snake-game
   java -jar Snake-1.0-SNAPSHOT.jar

**Disclaimer:** Please note that running the game using the Maven or JAR method may encounter issues due to system dependencies, configurations, or compatibility. For a more reliable experience, consider using an IDE to run the game.

## How to Play
- Use the arrow keys to navigate the snake (Up, Down, Left, Right). 
- Grow the snake by eating food (displayed as apples). 
- Avoid collisions with the snake's own body and the game borders. 
- Enhance the game speed for an added challenge and aim for leaderboard supremacy!
- Engage in multiplayer mode with a friend and steer clear of the venomous mushroom enemy (controlled by A, W, S, D).

![ReadmeImage.PNG](assets%2FReadmeImage.PNG)

## Credits
Background music courtesy of:
   1. **Clown by Sakura Girl**
      [Listen on SoundCloud](https://soundcloud.com/sakuragirl_official)
      Music promoted by [Chosic](https://www.chosic.com/free-music/all/)
      Creative Commons CC BY 3.0
      [License](https://creativecommons.org/licenses/by/3.0/)

   2. **Good Time by Sakura Girl**
      [Listen on SoundCloud](https://soundcloud.com/sakuragirl_official)
      Music promoted by [Chosic](https://www.chosic.com/free-music/all/)
      Creative Commons CC BY 3.0
      [License](https://creativecommons.org/licenses/by/3.0/)

   3. **Daisy by Sakura Girl**
      [Listen on SoundCloud](https://soundcloud.com/sakuragirl_official)
      Music promoted by [Chosic](https://www.chosic.com/free-music/all/)
      Creative Commons CC BY 3.0
      [License](https://creativecommons.org/licenses/by/3.0/)

## Test Plan
For details on the Test Plan with various testing tables, refer to the [Test Plan document](/documentation/TestPlan.md).

## Documentation
### UML Diagrams
For details and descriptions on the UML diagrams for this game , refer to the [UML Diagrams document](/documentation/UMLDiagrams.md).

### MVC Architecture Plan
For details on the Model-View-Controller (MVC) architecture plan, refer to the [MVC Architecture Plan document](/documentation/MVCPlan.md).



