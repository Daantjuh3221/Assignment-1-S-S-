package nl.hva.ict.ss;

/**
 * Player keeps track of the name and the highscore for a player.
 * Once created the name can't be changed. The best score for this player
 * can be changed during the lifetime of an instance.
 */
public class Player implements Comparable<Player> {
    private String firstName;
    private String lastName;
    private long highScore;

    public Player(String firstName, String lastName, long highScore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.highScore = highScore;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getHighScore() {
        return highScore;
    }

    public void setHighScore(long highScore) {
        this.highScore = highScore;
    }

    @Override
    public int compareTo(Player other) {
        if (this.highScore != other.highScore) {
            return (int)(this.highScore - other.highScore);
        }
        if (!this.lastName.equalsIgnoreCase(other.lastName)) {
            return this.lastName.compareToIgnoreCase(other.lastName);
        }
        return this.firstName.compareToIgnoreCase(other.firstName);
    }
}
