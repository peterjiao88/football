package team;

public class Player {
    private int teamNumber;//队伍编号
    private int playerNumber;//队员编号
    static int goal;//个人进球数

    public Player(int teamNumber,int playerNumber,int goal) {
        this.teamNumber = teamNumber;
        this.playerNumber=playerNumber;
        this.goal=goal;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal += goal;
    }
}
