package org.snake.view;

/**
 * <h2>LeaderboardItem</h2>
 * The {@code LeaderboardItem} class represents an item in the leaderboard,
 * encapsulating position, name, and score.
 *
 * Example usage:
 * <pre>
 * {@code
 * LeaderboardItem item = new LeaderboardItem("1", "John Doe", "500");
 * }
 * </pre>
 *
 * @author Ruben Odamo
 */
public class LeaderboardItem {
    private final String pos, name, score;

    /**
     * Constructs a {@code LeaderboardItem} with the specified position, name, and score.
     *
     * @param pos   The position of the item.
     * @param name  The name associated with the item.
     * @param score The score associated with the item.
     */
    public LeaderboardItem(String pos, String name, String score) {
        this.pos = pos;
        this.name = name;
        this.score = score;
    }

    /**
     * Gets the position of the player on the leaderboard.
     *
     * @return The position as a String.
     */
    public String getPos() {
        return pos;
    }

    /**
     * Gets the name of the player.
     *
     * @return The name as a String.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the score achieved by the player.
     *
     * @return The score as a String.
     */
    public String getScore() {
        return score;
    }
}
