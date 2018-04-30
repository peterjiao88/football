package team;

public class Team {
    private int teamNumber;//队伍编号
    private Player[] players;//队员编号
    static int session;//场次
    static int grade;//总积分
    static int totalGoal;//总进球数
    static int loseGoal;//总失球数
    static int win;//胜场数
    static int lose;//负
    static int draw;//平

    public Team(int teamNumber) {//初始化整个类的属性
        players=new Player[11];
        for(int i=0;i<players.length;i++){
            players[i]=new Player(teamNumber,i+1,0);//设定第0个编号为1，一开始的进球数为0
        }
        this.session=0;
        this.grade=0;
        this.totalGoal=0;
        this.loseGoal=0;
        this.win=0;
        this.lose=0;
        this.draw=0;
    }

    public int getTeamNumber() {
        return teamNumber;
    }
    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }
    public int getSession() {
        return session;
    }
    public void addSession() {
        this.session = session+1;
    }
    public Player getPlayerNumber(int i) {
        return players[i];
    }
    public int getGrade() {
        return grade;
    }
    public void addGrade(int grade) {
        this.grade = win*3+draw*1;
    }
    public int gettotalGoal() {
        for(int i=0;i<players.length;i++){
            totalGoal+=players[i].getGoal();
        }
        return totalGoal;
    }
    public int getLoseGoal() {//如何得到？？调用比赛中b队伍的进球数
        return loseGoal;
    }
    public void setLoseGoal(int loseGoal) {
        this.loseGoal = loseGoal;
    }
    public int getWin() {
        return win;
    }
    public void addWin() {
        this.win = win+1;
    }
    public int getLose() {
        return lose;
    }
    public void addLose() {
        this.lose = lose+1;
    }
    public int getDraw() {
        return draw;
    }
    public void addDraw() {
        this.draw = draw+1;
    }
}
