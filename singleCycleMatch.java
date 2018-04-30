package soccerGame;
import java.util.Random;
/**
 * All rights reserved,designed By Echo
 *
 * @author: Echo
 * @createtime:2018/4/29
 * @description:${DETAILS}
 **/
public class singleCycleMatch {
    private Team A=new Team(0);
    private Team B=new Team(0);//初始化队伍编号为0
    private int goalOne;
    private int goalTwo;
    singleCycleMatch(int numA,int numB){
        A.setTeamNumber(numA);
        B.setTeamNumber(numB);//在Team中是否可以考虑根据TeamNumber的变化而变化Player的队伍编号
        this.goalOne=0;
        this.goalTwo=0;
    }
    void play() {
        Random rand = new Random();
        while (goalTwo < 10 && goalTwo < 10) {//假设每场比赛每队进球数都不超过10
            int i = rand.nextInt(2);//随机分配球队i进球
            int j = rand.nextInt(12);//随机分配球员j进球
            if (i == 0) {
                System.out.print(A.getTeamNumber()+"队进球\n");
                System.out.print(j+"队员进球\n");//只是为了方便检查
                //A.getPlayerNumber(j).setGoal(goalOne++); 报错Team.50行
                goalOne++;
            }
             else {
                System.out.print(B.getTeamNumber()+"队进球\n");
                System.out.print(j+"队员进球\n");
                //B.getPlayerNumber(j).setGoal(goalTwo++);
                goalTwo++;
            }
        }
    }
    void showResult(){
        if(goalOne<goalTwo) {
            A.addWin();
            B.addLose();
            System.out.print("A is win\n");
        }
        else if(goalOne==goalTwo) {
            A.addDraw();
            B.addDraw();
            System.out.print("与"+"is draw\n");
        }
        else {
            B.addWin();
            A.addWin();
            System.out.print("B is win\n");
        }
        A.setLoseGoal(goalTwo);
        B.setLoseGoal(goalOne);
    }
    void imitatePlay(){
       play();
       showResult();
       System.out.print(A.getTeamNumber()+"进球数为"+goalOne+"失球数为"+goalTwo+"\n");
       System.out.print(B.getTeamNumber()+"进球数为"+goalTwo+"失球数为"+goalOne+"\n");
    }//比赛模拟
}
