public class teams {
    String name;
    String[] player;
    int position;
    int played;
    int wins;
    int draws;
    int losses;
    int goalsFor;
    int goalsAgainst;
    int goalDifference;
    int points;

    public int getPosition() {
        return position;
    }

    public int getPoints() {
        return points;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
    }
}
