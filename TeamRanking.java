package ranking;
public class TeamRanking {//(int number)
    static int number;//需要外界给出几支队
    static int[] session=new int[number];//场次
    static int[] totalGoal=new int[number];//总进球数
    static int[] loseGoal=new int[number];//总失球数
    static int[] win=new int[number];//胜场数
    static int[] lose=new int[number];//负
    static int[] draw=new int[number];//平
    static int[] compare = new int[number];//用于保存上次的结果
    static int[] Rank = new int[number];//排名顺序（非常重要）
    static int[] teamgrade = new int[number];//队伍积分
  /* 以上都是按队伍顺序储存*/
    public void Initial(int i)

    {               //一个队伍的分数储存在数组里,需与队伍一起调用，按队伍顺序储存
            teamgrade[i] = Team.addGrade();
            session[i]=Team.getSession();
            totalGoal[i]=Team.gettotalGoal();
            loseGoal[i]=Team.getloseGoal();
            win[i]=Team.getWin();
            lose[i]=Team.getLose();
            draw[i]=Team.getDraw();

    }

    public int[] sort()//得到由积分的排序顺序放在数组Rank
    {
        int copy[] = new int[number];
        System.arraycopy(teamgrade, 0, copy, 0, number);//copy用于找到最大数之后置-1
        int max = 0;
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {//找到当前最大积分
                if (copy[j] > copy[max])
                    max = i;
            }
            Rank[i] = max;//排序放入数组
            copy[max] = -1;
        }
        return Rank;
    }

    public String upOrdown(int i)//升降，与上次比较,现在排的第i队
    {          int j=-1;
                    do j++;
                   while(Rank[i] == compare[j]) ;//找到这次排行与上次比较
                    if(session[Rank[i]]<2)
                        return " - ";
                    else
                    { if (i> j)
                        return " DOWN ";
                    else {
                        if (i == j)
                            return " - ";
                        else
                            return " UP ";
                           }
                     }
    }

    public void DisplayTeam()//输出队伍排行
    {  Initial(number);
        System.arraycopy(Rank, 0, compare, 0, number);//用于储存上次排序
        sort();
        String output = "";
        System.out.println(" 排名  升降  球队名  场次  胜  平  负  进球  失球  净胜球  场均胜球  场均积分  积分 ");
        for (int i = 0; i < number; i++) {//每一个队伍
            int pureGoal = totalGoal[Rank[i]] - loseGoal[Rank[i]];
            double aveGoal = totalGoal[Rank[i]] / session[Rank[i]];
            double aveGrade = teamgrade[Rank[i]] / number;
            output = output + " " + i+1 + " " + " " + upOrdown(i) + " " + " " +Rank[i]+1+" "+" "+ session[Rank[i]] + " " + " " + win[Rank[i]] + " " + " " +
                    draw[Rank[i]] + " " + " " + lose[Rank[i]] + " " + " " + totalGoal[Rank[i]] + " " + " " + loseGoal[Rank[i]] + " " + " " + pureGoal +
                    " " + " " + aveGoal + " " + " " + aveGrade + " " + " " + teamgrade[Rank[i]] + "\n";
        }
        System.out.println(output);
    }

        }
/*最后调用的时候
每一天（
number次Innisual 将队伍信息输入
一次display）
*/