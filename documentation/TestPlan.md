# Test Plan

## Contents

| Section                | Class                  |
|------------------------|------------------------|
| [model](#model)        |                        |
|                        | [1 - Class: FoodModel](#class-foodmodel) |
|                        | [2 - Class: GameModel](#class-gamemodel) |
|                        | [3 - Class: SnakeModel](#class-snakemodel) |
|                        | [4 - Class: EnemyModel](#class-enemymodel) |
| [view](#view)          |                        |
|                        | [1 - Class: GameView](#class-gameview) |
|                        | [2 - Class: MenuView](#class-menuview) |
|                        | [3 - Class: LeaderboardItem](#class-leaderboarditem) |
|                        | [4 - Class: LeaderboardView](#class-leaderboardview) |
|                        | [5 - Class: GameOverView](#class-gameoverview) |
| [controller](#controller)|                       |
|                        | [1 - Class: GameController](#class-gamecontroller) |
|                        | [2 - Class: MenuView](#class-musicplayer) |
| [utility](#utility)    |                        |
|                        | [1 - Class: GameUtil](#class-gameutil) |
|                        | [2 - Class: ImageUtil](#class-imageutil) |
| [main](#main)          |                        |
|                        | [1 - Class: Main](#class-main) |


## Test Tables

### model

### Class: FoodModel

### 1. Constructor `FoodModel()`

| TestID | Reason | Inputs | Expected Outputs                                  | Pass/Fail       | Notes |
|--------|--------|--------|---------------------------------------------------|-----------------|-------|
| 1.1.1  | Default construction | None | Initialises the food item with default properties | Pass [15/12/23] | - |

### 2. `getRectangle()` 

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 1.2.1  | Valid properties | None | Returns a Rectangle2D representing the bounding rectangle | Pass [15/12/23]| - |

### 3. `getX()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 1.3.1  | Valid X-coordinate | None | Returns the X-coordinate of the food item | Pass [15/12/23]| - |

### 4. `getY()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 1.4.1  | Valid Y-coordinate | None | Returns the Y-coordinate of the food item | Pass [15/12/23]| - |

### 5. `isAlive()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 1.5.1  | Alive food item | None | Returns true | Pass [15/12/23]| - |
| 1.5.2  | Dead food item | Set alive to false | Returns false | Pass [15/12/23]| - |

### 6. `setAlive()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 1.6.1  | Set to alive | true | Sets the status of the food item to alive | Pass [15/12/23]| - |
| 1.6.2  | Set to dead | false | Sets the status of the food item to dead | Pass [15/12/23]| - |

### 7. `getI()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 1.7.1  | None | None | Returns the image of the food item | Pass [15/12/23]| - |

### Class: GameModel

### 1. Constructor `GameModel()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 2.1.1  | Background option 1 | Set `MenuView.backgroundOpt` to 1 | Initializes the background with "scene-background1" image | Pass [15/12/23]| - |
| 2.1.2  | Background option 2 | Set `MenuView.backgroundOpt` to 2 | Initializes the background with "scene-background2" image | Pass [15/12/23]| - |
| 2.1.3  | Background option 3 | Set `MenuView.backgroundOpt` to 3 | Initializes the background with "scene-background3" image | Pass [15/12/23]| - |

### 2. `getBackground()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 2.2.1  | Option 1 background | Set `MenuView.backgroundOpt` to 1 | Returns the "scene-background1" image | Pass [15/12/23]| - |
| 2.2.2  | Option 2 background | Set `MenuView.backgroundOpt` to 2 | Returns the "scene-background2" image | Pass [15/12/23]| - |
| 2.2.3  | Option 3 background | Set `MenuView.backgroundOpt` to 3 | Returns the "scene-background3" image | Pass [15/12/23]| - |

### Class: SnakeModel

### 1. Constructor `SnakeModel()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail       | Notes |
|--------|--------|--------|------------------|-----------------|-------|
| 3.1.1  | Initialize with (0, 0) | Initial coordinates (0, 0) | Initializes the snake with alive status, length 1, and other properties | Pass [15/12/23] | - |
| 3.1.2  | Initialize with (100, 200) | Initial coordinates (100, 200) | Initializes the snake with alive status, length 1, and other properties | Pass [15/12/23] | - |

### 2. `move()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 3.2.1  | Move up | Set `up` to `true` | Updates y-coordinate to y - `speed_XY` | Pass [15/12/23]| - |
| 3.2.2      | Move down | Set `down` to `true` | Updates y-coordinate to y + `speed_XY` | Pass [15/12/23]| - |
| 3.2.3      | Move left | Set `left` to `true` | Updates x-coordinate to x - `speed_XY` | Pass [15/12/23]| - |
| 3.2.4      | Move right | Set `right` to `true` | Updates x-coordinate to x + `speed_XY` | Pass [15/12/23]| - |

### 3. `getRectangle()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 3.3.1  | Check rectangle bounds | - | Returns a Rectangle2D with coordinates and dimensions | Pass [15/12/23]| - |

### 4. `getLength()` and `changeLength()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 3.4.1  | Default length | - | Returns the initial length of 1 | Pass [15/12/23]| - |
| 3.4.2  | Change length to 5 | `changeLength(5)` | Returns the updated length of 5 | Pass [15/12/23]| - |

### 5. `getNum()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 3.5.1  | Default num | - | Returns the default num value | Pass [15/12/23]| - |

### 6. `getScore()`, `setScore()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 3.6.1  | Default score | - | Returns the initial score of 0 | Pass [15/12/23]| - |
| 3.6.2  | Set score to 100 | `setScore(100)` | Returns the updated score of 100 | Pass [15/12/23]| - |

### 7. `getX()`, `getY()`, `getW()`, `getH()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 3.7.1  | Default coordinates | - | Returns the initial x and y coordinates | Pass [15/12/23]| - |
| 3.7.2  | Default width and height | - | Returns the initial width and height | Pass [15/12/23]| - |

### 8. `isAlive()`, `setAlive()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 3.8.1  | Default alive status | - | Returns `true` initially | Pass [15/12/23]| - |
| 3.8.2  | Set alive to `false` | `setAlive(false)` | Returns `false` | Pass [15/12/23]| - |

### 9. `isUp()`, `setUp()`, `isDown()`, `setDown()`, `isLeft()`, `setLeft()`, `isRight()`, `setRight()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 3.9.1  | Default direction | - | Returns `true` for `right` initially | Pass [15/12/23]| - |
| 3.9.2      | Set direction to `up` | `setUp(true)` | Returns `true` for `up` | Pass [15/12/23]| - |
| 3.9.3      | Set direction to `down` | `setDown(true)` | Returns `true` for `down` | Pass [15/12/23]| - |
| 3.9.4      | Set direction to `left` | `setLeft(true)` | Returns `true` for `left` | Pass [15/12/23]| - |
| 3.9.5      | Set direction to `right` | `setRight(true)` | Returns `true` for `right` | Pass [15/12/23]| - |

### 10. `getI()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 3.10.1 | Default image | - | Returns the default snake body image | Pass [15/12/23]| - |

### 11. `getImgSnakeHead()`, `getNewImgSnakeHead()`, `setNewImgSnakeHead()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 3.11.1 | Default head image | - | Returns the default snake head image | Pass [15/12/23]| - |
| 3.11.2 | Set new head image | `setNewImgSnakeHead(newImage)` | Returns the updated snake head image | Pass [15/12/23]| - |

### 12. `getBodyPoints()`, `setBodyPoints()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 3.12.1 | Default body points | - | Returns an empty list initially | Pass [15/12/23]| - |
| 3.12.2 | Set body points | `setBodyPoints(newBodyPoints)` | Returns the updated body points | Pass [15/12/23]| - |

### Class: EnemyModel
### 1. Constructor `EnemyModel()`

| TestID | Reason | Inputs | Expected Outputs                              | Pass/Fail | Notes |
|--------|--------|--------|-----------------------------------------------|-----------|-------|
| 4.1.1  | Default construction | None | Initialises the enemy with default properties | Pass [15/12/23]| - |

### 2. `getRectangle()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 4.2.1  | Valid properties | None | Returns a Rectangle2D representing the bounding rectangle | Pass [15/12/23]| - |

### 3. `move()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 4.3.1  | Move up | Set direction to up | Updates the Y-coordinate correctly | Pass [15/12/23]| - |
| 4.3.2  | Move down | Set direction to down | Updates the Y-coordinate correctly | Pass [15/12/23]| - |
| 4.3.3  | Move left | Set direction to left | Updates the X-coordinate correctly | Pass [15/12/23]| - |
| 4.3.4  | Move right | Set direction to right | Updates the X-coordinate correctly | Pass [15/12/23]| - |

### 4. `getX()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 4.4.1  | Valid X-coordinate | None | Returns the X-coordinate of the enemy | Pass [15/12/23]| - |

### 5. `setX()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 4.5.1  | Valid X-coordinate | New X-coordinate | Sets the X-coordinate of the enemy | Pass [15/12/23]| - |

### 6. `getY()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 4.6.1  | Valid Y-coordinate | None | Returns the Y-coordinate of the enemy | Pass [15/12/23]| - |

### 7. `setY()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 4.7.1  | Valid Y-coordinate | New Y-coordinate | Sets the Y-coordinate of the enemy | Pass [15/12/23]| - |

### 8. `isAlive()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 4.8.1  | Alive enemy | None | Returns true | Pass [15/12/23]| - |
| 4.8.2  | Dead enemy | Set alive to false | Returns false | Pass [15/12/23]| - |

### 9. `isUp()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 4.9.1  | Moving up | Set direction to up | Returns true | Pass [15/12/23]| - |
| 4.9.2  | Not moving up | Set direction to down | Returns false | Pass [15/12/23]| - |

### 10. `setUp()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail      | Notes |
|--------|--------|--------|------------------|----------------|-------|
| 4.10.1 | Set to up | true | Sets the direction to up | Pass [15/12/23] | - |
| 4.10.2 | Set to down | false | Does not change the direction | Pass [15/12/23]          | - |

### 11. `isDown()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 4.11.1 | Moving down | Set direction to down | Returns true | Pass [15/12/23]| - |
| 4.11.2 | Not moving down | Set direction to up | Returns false | Pass [15/12/23]| - |

### 12. `setDown()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 4.12.1 | Set to down | true | Sets the direction to down | Pass [15/12/23]| - |
| 4.12.2 | Set to up | false | Does not change the direction | Pass [15/12/23]| - |

### 13. `isLeft()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|----------|-------|
| 4.13.1 | Moving left | Set direction to left | Returns true | Pass [15/12/23]    | - |
| 4.13.2 | Not moving left | Set direction to right | Returns false | Pass    [15/12/23] | - |

### 14. `setLeft()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 4.14.1 | Set to left | true | Sets the direction to left | Pass [15/12/23]| - |
| 4.14.2 | Set to right | false | Does not change the direction | Pass [15/12/23]| - |

### 15. `isRight()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 4.15.1 | Moving right | Set direction to right | Returns true | Pass [15/12/23]| - |
| 4.15.2 | Not moving right | Set direction to left | Returns false | Pass [15/12/23]| - |

### 16. `setRight()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 4.16.1 | Set to right | true | Sets the direction to right | Pass [15/12/23]| - |
| 4.16.2 | Set to left | false | Does not change the direction | Pass [15/12/23]| - |

### 17. `getImgEnemy()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 4.17.1 | None | None | Returns the original image of the enemy | Pass [15/12/23]| - |

### 18. `getNewImgEnemy()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 4.18.1 | None | None | Returns the current image of the enemy | Pass [15/12/23]| - |

### 19. `setNewImgEnemy()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 4.19.1 | Set new image | New image | Sets the current image of the enemy | Pass [15/12/23]| - |


## view
### Class: `GameView`

### 1. `initialize()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail       | Notes                           |
|-------|--------|--------|------------------|-----------------|---------------------------------|
| 1.1.1 | Initial setup | URL location = null, ResourceBundle resources = null | Game elements (gameController, snakeModel, foodModel, gameModel, enemyModel) should be initialized | Pass [03/12/23] | -                               |
| 1.1.2 | Canvas setup | canvasPane = not null, canvas = not null | Canvas should be set up with key event handling and AnimationTimer | Pass            [03/12/23]| Ensure all elements are visible |

### 2. `stopLoop()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail                       | Notes                          |
|--------|--------|--------|------------------|---------------------------------|--------------------------------|
| 1.2.1  | Normal case | - | AnimationTimer should be stopped | Pass [03/12/23] | |

### 3. `onKeyPressed()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail        | Notes |
|--------|--------|--------|------------------|------------------|-------|
| 1.3.1  | Key pressed | KeyEvent event with a valid key | Corresponding action in the game controller should be triggered | Pass [03/12/23]  | - |
| 1.3.2  | Invalid key | KeyEvent event with an invalid key | No action should be triggered | Pass [03/12/23]  | - |

### 4. `draw()`

| TestID | Reason          | Inputs                       | Expected Outputs                                                                        | Pass/Fail         | Notes                                   |
|--------|-----------------|------------------------------|-----------------------------------------------------------------------------------------|-------------------|-----------------------------------------|
| 1.4.1  | Normal case     | -                            | Game elements (snake, food, enemy) should be drawn on the canvas                        | Pass [03/12/23]   | -                                       |
| 1.4.2  | Food not alive  | FoodModel.isAlive() = false  | New food model should be created, and only background, score, and snake should be drawn | Pass [03/12/23]   | Only one food should be drawn at a time |
| 1.4.3  | Enemy not alive | EnemyModel.isAlive() = false | Only the background, score, and snake should be drawn                                   | Pass  [15/12/23]  | -                                       |
| 1.4.4  | Enemy is alive  | EnemyModel.isAlive() = true  | The background, score, snake and enemy should be drawn                                  | Pass   [15/12/23] | -                                       |

### 5. `drawScore()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail                                | Notes                                |
|--------|--------|--------|------------------|------------------------------------------|--------------------------------------|
| 1.5.1  | Normal case | GraphicsContext gc | Score should be drawn on the canvas | Partial Pass [03/12/23], Pass [12/12/23] | Different colour for each background |

### 6. `drawFood()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 1.6.1  | Normal case | GraphicsContext gc | Food should be drawn on the canvas | Pass [03/12/23]     | - |

### 7. `drawSnake()`

| TestID | Reason | Inputs | Expected Outputs                                 | Pass/Fail                        | Notes                       |
|--------|--------|--------|--------------------------------------------------|----------------------------------|-----------------------------|
| 1.7.1  | Normal case | GraphicsContext gc | Snake and its body should be drawn on the canvas | Fail [01/12/23], Pass [03/12/23] | Reset the snake body points |
| 1.7.2  | Snake out of bounds | SnakeModel.isOutOfBounds() = true | GameOverView is called and the scene is chnaged  | Fail [02/12/23], Pass [03/12/23] | Fixed method border values  |
| 1.7.3  | Snake eats itself | SnakeModel.eatBody() = true |GameOverView is called and the scene is chnaged   | Pass [03/12/23]                  | -                           |

### 8. `drawBody()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes                                            |
|--------|--------|--------|------------------|-----------|--------------------------------------------------|
| 1.8.1  | Normal case | GraphicsContext gc | Snake's body should be drawn on the canvas | Pass [03/12/23]     | More body points added when the snake eats fruit |

### 9. `drawEnemy()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail       | Notes |
|--------|--------|--------|------------------|-----------------|-------|
| 1.9.1  | Normal case | GraphicsContext gc | Enemy should be drawn on the canvas | Pass [12/12/23] | - |
| 1.9.2  | Snake killed by enemy | gameController.killSnake(snakeModel, enemyModel) = true | GameOverView is called and the scene is chnaged  | Pass [12/12/23] | - |

### Class: MenuView

### 1. `initialize()`

| TestID | Reason                | Inputs | Expected Outputs                                                                           | Pass/Fail                        | Notes                                                                    |
|--------|-----------------------|--------|--------------------------------------------------------------------------------------------|----------------------------------|--------------------------------------------------------------------------|
| 2.1.1  | Initial setup         | URL url = null, ResourceBundle resourceBundle = null | Difficulty combo box, background image, music player, and initial settings should be set up | Pass [10/12/23]                            | -                                                                        |
| 2.1.2  | Set Background change | backgroundOpt = 0 | Background should be set on the first option                                               | Fail [10/12/23], Pass [10/12/23] | Resize actual image                                                      |
| 2.1.3  | Set Music change      | musicOpt = 1 | Music track should be set on the first option                                              | Fail [11/12/23] ,Pass [11/12/23] | Music plays over previous song, so stopped song before starting a new one |

### 2. `updateDifficulty()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 2.2.1  | Easy difficulty | difficultyCombo.setValue("EASY") | Speed should be set to 2 | Pass [10/12/23]     | - |
| 2.2.2  | Medium difficulty | difficultyCombo.setValue("MEDIUM") | Speed should be set to 3 | Pass [10/12/23]     | - |
| 2.2.3  | Hard difficulty | difficultyCombo.setValue("HARD") | Speed should be set to 4 | Pass  [10/12/23]    | - |

### 3. `goToGame()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail       | Notes |
|--------|--------|--------|------------------|-----------------|-------|
| 2.3.1  | Normal case | - | Should navigate to the game screen | Pass [08/12/23] | - |

### 4. `goToLeaderboard()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail       | Notes |
|--------|--------|--------|------------------|-----------------|-------|
| 2.4.1  | Normal case | - | Should navigate to the leaderboard screen | Pass [08/12/23] | - |

### 5. `changeBackground()`

| TestID | Reason | Inputs                                                                   | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------------------------------------------------------------------------|------------------|-----------|-------|
| 2.5.1  | Background change | Button click (backgroundOpt = 1, backgroundOpt = 2 or backgroundOpt = 3) | Background should be changed to the next option | Pass [10/12/23]| - |

### 6. `changeMusic()`

| TestID | Reason | Inputs                                                    | Expected Outputs | Pass/Fail       | Notes |
|--------|--------|-----------------------------------------------------------|------------------|-----------------|-------|
| 2.6.1  | Music change | Button click (musicOpt = 1, musicOpt = 2 or musicOpt = 3) | Music track should be changed to the next option | Fail [11/12/23] ,Pass [11/12/23] | Music plays over previous song, so stopped song before starting a new one |

### 7. `changeVolume()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail       | Notes |
|--------|--------|--------|------------------|-----------------|-------|
| 2.7.1  | Volume change | volumeSlider value changes | Music player volume should be updated | Pass [11/12/23] | - |

### 8. `onKeyPressed()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|-------|--------|--------|------------------|-----------|-------|
| 2.8.1 | Key press G | KeyCode.G | Should navigate to the game screen | Pass [11/12/23]| - |
| 2.8.2 | Key press L | KeyCode.L | Should navigate to the leaderboard screen | Pass [11/12/23]| - |
| 2.8.3 | Key press C | KeyCode.C | Background should be changed to the next option | Pass [11/12/23]| - |
| 2.8.4     | Key press M | KeyCode.M | Music track should be changed to the next option | Pass [11/12/23]| - |
| 2.8.5     | Key press other | KeyCode.A | No action should be triggered | Pass [11/12/23]| - |

### 9. `getPlayerNo()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail       | Notes |
|--------|--------|--------|------------------|-----------------|-------|
| 2.9.1  | Checkbox selected | playerCheckbox.isSelected() = true | player2 should be true | Pass [15/12/23] | - |
| 2.9.2      | Checkbox not selected | playerCheckbox.isSelected() = false | player2 should be false | Pass [15/12/23]           | - |

### 10. `generateFact()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail       | Notes |
|--------|--------|--------|------------------|-----------------|-------|
| 2.10.1 | Random fact generation | Random factNum | Label should be set to a corresponding fact | Pass [13/12/23] | - |

### Class: LeaderboardItem

### 1. Constructor `LeaderboardItem()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail       | Notes |
|--------|--------|--------|------------------|-----------------|-------|
| 3.1.1  | Normal case | pos = "1", name = "John Doe", score = "500" | LeaderboardItem should be created with specified position, name, and score | Pass [09/12/23] | - |
| 3.1.2      | Empty values | pos = "", name = "", score = "" | LeaderboardItem should be created with empty values | Pass    [09/12/23]        | - |

### 2. `getPos()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 3.2.1  | Normal case | LeaderboardItem with pos = "1" | getPos() should return "1" | Pass [09/12/23]| - |
| 3.2.2  | Empty position | LeaderboardItem with pos = "" | getPos() should return "" | Pass [09/12/23]| - |

### 3. `getName()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 3.3.1  | Normal case | LeaderboardItem with name = "John Doe" | getName() should return "John Doe" | Pass [09/12/23]| - |
| 3.3.2  | Empty name | LeaderboardItem with name = "" | getName() should return "" | Pass [09/12/23]| - |

### 4. `getScore()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 3.4.1  | Normal case | LeaderboardItem with score = "500" | getScore() should return "500" | Pass [09/12/23]| - |
| 3.4.2  | Empty score | LeaderboardItem with score = "" | getScore() should return "" | Pass [09/12/23]| - |

### Class: LeaderboardView

### 1. `initialize()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 4.1.1  | Initial setup | URL url = null, ResourceBundle resourceBundle = null | Leaderboard columns should be set up, and top ten scores for MEDIUM difficulty should be loaded | Pass [09/12/23]| - |

### 2. `getTopTen()`

| TestID | Reason      | Inputs           | Expected Outputs                                             | Pass/Fail       | Notes |
|--------|-------------|------------------|--------------------------------------------------------------|-----------------|-------|
| 4.2.1  | Normal case | level = "MEDIUM" | ObservableList with the top ten scores for MEDIUM difficulty | Pass [12/12/23] | - |
| 4.2.2  | Hard level  | level = "HARD"   | ObservableList with the top ten scores for HARD difficulty   | Pass [12/12/23]           | - |
| 4.2.3  | Hard level  | level = "EASY"   | ObservableList with the top ten scores for EASY difficulty   | Pass [12/12/23]           | - |
| 4.2.4  | Empty level | level = ""       | ObservableList with no scores                                | Pass [12/12/23]           | - |
| 4.2.5  | 2 players selected | level = "MEDIUM", player2 = true | ObservableList with the top ten scores for MEDIUM difficulty in multiplayer mode | Pass  [12/12/23]          | - |
| 4.2.6  | 1 player selected | level = "MEDIUM", player2 = false | ObservableList with the top ten scores for MEDIUM difficulty in single-player mode | Pass  [12/12/23]          | - |


### 3. `goBack()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 4.3.1  | Back to menu | Main.menuFlag = true | Should navigate back to the menu screen | Pass [09/12/23]| - |
| 4.3.2  | Back to game over | Main.menuFlag = false | Should navigate back to the game over screen | Pass [09/12/23]| - |

### 4. `onKeyPressed()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail       | Notes |
|--------|--------|--------|------------------|-----------------|-------|
| 4.4.1  | Key press B | KeyCode.B | Should call goBack() | Pass [11/12/23] | - |
| 4.4.2  | Key press E | KeyCode.E | Should call setEasyTable() | Pass [12/12/23] | - |
| 4.4.3  | Key press M | KeyCode.M | Should call setMediumTable() | Pass [12/12/23] | - |
| 4.4.4  | Key press H | KeyCode.H | Should call setHardTable() | Pass [12/12/23] | - |
| 4.4.5  | Key press other | KeyCode.A | No action should be triggered | Pass [12/12/23] | - |

### 5. `setEasyTable()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 4.5.1  | Normal case | - | Should set the leaderboard table to display the top ten scores for EASY difficulty | Pass [12/12/23]| - |

### 6. `setMediumTable()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 4.6.1  | Normal case | - | Should set the leaderboard table to display the top ten scores for MEDIUM difficulty | Pass [12/12/23]| - |

### 7. `setHardTable()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 4.7.1  | Normal case | - | Should set the leaderboard table to display the top ten scores for HARD difficulty | Pass [12/12/23]| - |

### 8. `getPlayerNo()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 4.8.1  | Checkbox selected | playerCheckbox.isSelected() = true | Should update player2 to true and refresh the leaderboard | Pass [12/12/23]| - |
| 4.8.2  | Checkbox not selected | playerCheckbox.isSelected() = false | Should update player2 to false and refresh the leaderboard | Pass [12/12/23]| - |

### Class: GameOverView

### 1. `initialize()`

| TestID | Reason                      | Inputs | Expected Outputs | Pass/Fail       | Notes                                                    |
|--------|-----------------------------|--------|------------------|-----------------|----------------------------------------------------------|
| 5.1.1  | Initial setup               | URL url = null, ResourceBundle resourceBundle = null | Displays the final score and checks if it's a new high score | Pass [09/12/23] | If new highscore display score in yellow and notify user |



### 2. `confirmName()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail                        | Notes                                  |
|--------|--------|--------|------------------|----------------------------------|----------------------------------------|
| 5.2.1  | Normal case | Username = "JohnDoe" | Name confirmed message should be displayed | Fail [11/12/23], Pass [11/12/23] | Incorrect AlertType used (`INFORMATION`) |

### 3. `goToMenu()`

| TestID | Reason | Inputs                          | Expected Outputs | Pass/Fail       | Notes |
|--------|--------|---------------------------------|------------------|-----------------|-------|
| 5.3.1  | Normal case | Click the "Back to Menu" button | Navigates to the main menu | Pass [09/12/23] | - |

### 4. `restartGame()`

| TestID | Reason | Inputs                     | Expected Outputs | Pass/Fail       | Notes |
|--------|--------|----------------------------|------------------|-----------------|-------|
| 5.4.1  | Normal case | Click the "Restart" button | Restarts the game | Pass [09/12/23] | - |

### 5. `goToLeaderboard()`

| TestID | Reason | Inputs                              | Expected Outputs | Pass/Fail       | Notes |
|--------|--------|-------------------------------------|------------------|-----------------|-------|
| 5.5.1  | Normal case | Click the "View Leaderbaord" button | Navigates to the leaderboard | Pass [09/12/23] | - |

### 6. `onKeyPressed()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail        | Notes |
|--------|--------|--------|------------------|------------------|-------|
| 5.6.1  | Key press R | KeyCode.R | Should call restartGame() | Pass [11/12/23]  | - |
| 5.6.2      | Key press L | KeyCode.L | Should call goToLeaderboard() | Pass  [11/12/23] | - |
| 5.6.3      | Key press M | KeyCode.M | Should call goToMenu() | Pass [11/12/23]  | - |
| 5.6.4      | Key press C | KeyCode.C | Should call confirmName() | Pass  [11/12/23] | - |
| 5.6.5      | Key press other | KeyCode.A | No action should be triggered | Pass [11/12/23]  | - |

### 7. `isHighscore()`

| TestID | Reason | Inputs                                            | Expected Outputs | Pass/Fail       | Notes |
|--------|--------|---------------------------------------------------|------------------|-----------------|-------|
| 5.7.1  | Highscore | GameController.finalScore = 100, level = "MEDIUM" | Returns true | Pass [11/12/23] | - |
| 5.7.2  | Not highscore | GameController.finalScore = 2, level = "MEDIUM"   | Returns false | Pass [11/12/23] | - |


### controller
### Class: GameController

### 1. `initialize()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 1.1.1  | Initialize with valid components | Valid instances of GameView, SnakeModel, FoodModel, EnemyModel | Components are correctly initialized | Pass [02/12/23]| - |

### 2. `keyPressed()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail                        | Notes                                              |
|--------|--------|--------|------------------|----------------------------------|----------------------------------------------------|
| 1.2.1  | Press 'UP' key | KeyEvent with KeyCode.UP | SnakeModel's direction is set to 'up' | Pass [02/12/23]                  | -                                                  |
| 1.2.2      | Press 'DOWN' key | KeyEvent with KeyCode.DOWN | SnakeModel's direction is set to 'down' | Pass [02/12/23]                  | -                                                  |
| 1.2.3      | Press 'LEFT' key | KeyEvent with KeyCode.LEFT | SnakeModel's direction is set to 'left' | Pass  [02/12/23]                 | -                                                  |
| 1.2.4      | Press 'RIGHT' key | KeyEvent with KeyCode.RIGHT | SnakeModel's direction is set to 'right' | Pass [02/12/23]                  | -                                                  |
| 1.2.5      | Press 'W' key | KeyEvent with KeyCode.W | EnemyModel's direction is set to 'up' | Pass [15/12/23]                  | -                                                  |
| 1.2.6      | Press 'S' key | KeyEvent with KeyCode.S | EnemyModel's direction is set to 'down' | Pass  [15/12/23]                 | -                                                  |
| 1.2.7      | Press 'A' key | KeyEvent with KeyCode.A | EnemyModel's direction is set to 'left' | Pass   [15/12/23]                | -                                                  |
| 1.2.8      | Press 'D' key | KeyEvent with KeyCode.D | EnemyModel's direction is set to 'right' | Pass [15/12/23]                  | -                                                  |
| 1.2.9      | Press 'P' key | KeyEvent with KeyCode.P | Game is paused or resumed | Fail [10/12/23], Pass [10/12/23] | Incorrect loop stopped, needs to be main game loop |
| 1.2.10     | Press other key | KeyEvent with other KeyCode | No change in directions or game state | Pass  [02/12/23]                          | -                                                  |

### 3. `eaten()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 1.3.1  | Snake eats food | Overlapping rectangles of SnakeModel and FoodModel | FoodModel is set to not alive, SnakeModel's length and score are increased | Pass [02/12/23]     | - |
| 1.3.2  | No overlap | Non-overlapping rectangles of SnakeModel and FoodModel | No change in SnakeModel or FoodModel | Pass  [02/12/23]    | - |

### 4. `outOfBounds()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail                          | Notes                      |
|--------|--------|--------|------------------|------------------------------------|----------------------------|
| 1.4.1  | Snake is out of bounds | SnakeModel's x or y coordinates are out of bounds | GameOver is triggered | Fail [02/12/23], Pass [02/12/23]   | Incorrect width and height |
| 1.4.2      | Enemy is out of bounds (right) | EnemyModel's x coordinate is out of bounds (right) | EnemyModel's x coordinate is set to 0 | Pass   [15/12/23]                  | -                          |
| 1.4.3      | Enemy is out of bounds (left) | EnemyModel's x coordinate is out of bounds (left) | EnemyModel's x coordinate is set to (600 - width) | Fail [15/12/23], Pass   [15/12/23] | changed to (600-width)     |
| 1.4.4      | Enemy is out of bounds (top) | EnemyModel's y coordinate is out of bounds (top) | EnemyModel's y coordinate is set to 0 | Pass  [15/12/23]                   | -                          |
| 1.4.5      | Enemy is out of bounds (down) | EnemyModel's y coordinate is out of bounds (down) | EnemyModel's y coordinate is set to (400 - height) | Fail [15/12/23], Pass [15/12/23]   | changed to (400-height)    |

### 5. `eatBody()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail       | Notes |
|--------|--------|--------|------------------|-----------------|-------|
| 1.5.1  | Snake collides with own body | Body points in SnakeModel overlap | GameOver is triggered | Pass [03/12/23] | - |
| 1.5.2  | No collision | No overlapping body points in SnakeModel | No change in game state | Pass [03/12/23] | - |

### 6. `killSnake()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 1.6.1  | Snake collides with enemy | Overlapping rectangles of SnakeModel and EnemyModel | GameOver is triggered | Pass [15/12/23]| - |
| 1.6.2  | No collision | Non-overlapping rectangles of SnakeModel and EnemyModel | No change in game state | Pass [15/12/23]| - |

### 7. `gameOver()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail       | Notes             |
|--------|--------|--------|------------------|-----------------|-------------------|
| 1.7.1  | Game over scenario | SnakeModel's alive status is set to false | Game is stopped and score is recorded | Pass [15/12/23] | both player modes |

### Class: MusicPlayer

### 1. Constructor `MusicPlayer()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail        | Notes |
|--------|--------|--------|------------------|------------------|-------|
| 2.1.1  | Initialize with valid filename | Valid path to an existing MP3 file | MusicPlayer is correctly initialized | Pass [11/12/23]  | - |
| 2.1.2  | Initialize with invalid filename | Invalid or non-existing path | Initialization fails with an exception | Pass  [11/12/23] | Ensure the exception is handled appropriately |

### 2. `initializeMediaPlayer()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail       | Notes |
|--------|--------|--------|------------------|-----------------|-------|
| 2.2.1  | Initialize media player | Valid path to an existing MP3 file | MediaPlayer is correctly initialized | Pass [11/12/23] | - |

### 3. `play()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail                        | Notes                                                |
|--------|--------|--------|------------------|----------------------------------|------------------------------------------------------|
| 2.3.1  | Play music | MediaPlayer is in a valid state | Music is played | Fail [07/12/23], Pass [11/12/23] | Class changed to JavaFX using the `MediaPlayer` import |

### 4. `pause()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 2.4.1  | Pause music | MediaPlayer is in a valid state and playing | Music is paused | Pass | - |
| 2.4.2  | Pause when already paused | MediaPlayer is in a valid state and paused | No change in music state | Fail [07/12/23], Pass [11/12/23] | Class changed to JavaFX using the `MediaPlayer` import |

### 5. `stop()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 2.5.1  | Stop music | MediaPlayer is in a valid state | Music is stopped | Fail [07/12/23], Pass [11/12/23] | Class changed to JavaFX using the `MediaPlayer` import |

### 6. `setVolume()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes                                                  |
|--------|--------|--------|------------------|-----------|--------------------------------------------------------|
| 2.6.1  | Set volume | Valid volume level (0.0 to 1.0) | Volume is set accordingly | Pass [11/12/23]| -                                                      |
| 2.6.2  | Set invalid volume (below 0.0) | Negative volume level | Volume is not set, or exception is thrown | Pass [11/12/23]| Implemented slider functionality so this is impossible |
| 2.6.3  | Set invalid volume (above 1.0) | Volume level greater than 1.0 | Volume is not set, or exception is thrown | Pass [11/12/23]| Implemented slider functionality so this is impossible         |

### utility
### Class: GameUtil

### 1. `getImage()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail       | Notes |
|--------|--------|--------|------------------|-----------------|-------|
| 7.1.1  | Valid image path | "path/to/image.png" | Returns a non-null Image object | Pass [15/12/23] | - |
| 7.1.2  | Invalid image path | "invalid/path/image.png" | Returns null | Pass            [15/12/23]| - |
| 7.1.3  | Null image path | null | Returns null | Pass           [15/12/23] | - |

### 2. `rotateImage()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail       | Notes |
|--------|--------|--------|------------------|-----------------|-------|
| 7.2.1  | Valid inputs | Image, 90 degrees | Returns a non-null rotated WritableImage | Pass [15/12/23] | - |
| 7.2.2      | Null image | null, 90 degrees | Returns null | Pass            [15/12/23]| - |
| 7.2.3      | Zero degree rotation | Image, 0 degrees | Returns the original image | Pass        [15/12/23]    | - |
| 7.2.4      | Negative degree rotation | Image, -45 degrees | Returns a non-null rotated WritableImage | Pass          [15/12/23]  | - |

### Class: ImageUtil

### 1. Initialization `static{}`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 8.1.1  | Valid images | - | Map is populated with non-null Image objects | Pass [15/12/23]| - |
| 8.1.2  | Invalid image path | Image with an invalid path | Map is not modified | Pass [15/12/23]| - |

### 2. `getImage()` from images Map

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail | Notes |
|--------|--------|--------|------------------|-----------|-------|
| 8.2.1  | Existing image name | "snake-head" | Returns the corresponding Image object | Pass [15/12/23]| - |
| 8.2.2  | Non-existing image name | "non-existing-image" | Returns null | Pass [15/12/23]| - |
| 8.2.3  | Null image name | null | Returns null | Pass [15/12/23]| - |

### main
### Class: Main

### 1. `start()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail                        | Notes                                        |
|--------|--------|--------|------------------|----------------------------------|----------------------------------------------|
| 1.1.1  | Valid inputs | Valid Stage | Initializes the game window with the Menu scene | Pass [09/12/23]                  | -                                            |
| 1.1.2  | Stage close request handling        | Window close request  | Platform and System exit called | Fail [07/12/23], Pass [09/12/23] | Application fully closed when 'x' is pressed |
| 1.1.3  | Null Stage | null | Throws an exception | Pass         [09/12/23]          | -                                            |

### 2. `changeScene()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail                        | Notes                                           |
|--------|--------|--------|------------------|----------------------------------|-------------------------------------------------|
| 2.1.1  | Valid inputs | "GamePlay.fxml" | Changes the scene to GamePlay.fxml | Fail [09/12/23], Pass [09/12/23] | `LoadException` error, incorrect file location  |
| 2.2.1  | Invalid FXML | "Invalid.fxml" | Throws an exception | Pass [09/12/23]                  | -                                               |

### 3. `main()`

| TestID | Reason | Inputs | Expected Outputs | Pass/Fail       | Notes |
|--------|--------|---|------------------|-----------------|-------|
| 3.1.1  | Valid inputs | - | Launches the JavaFX application | Pass [09/12/23] | - |
| 3.1.2  | Null arguments | null | Launches the JavaFX application | Pass [09/12/23] | - |
