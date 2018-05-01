package ranking;

public class PlayerRanking {
    //排名 球员 球队 进球
    static int number;//需要告诉我几个队伍
    private int[][] player = new int[number][11];
    static int[][] copy = new int[number][11];//复制的数组，用于比较过后置-1
    static int[] rank1 = new int[number * 11];//队员排序的队伍部分,按照顺序放队员的队伍，Rank1[n]即第n名队员的队伍部分
    static int[] rank2 = new int[number * 11];//队员排序的队员部分，按照顺序放队员的队内，Rank2[n]即第n名队员的队内部分

    public void Initial()//把球员进的球放入数组以便比较
    {
        for (int i = 0; i < number; i++)
            for (int j = 0; j < 11; j++) {
                player[i][j] = Player.getGoal;
                copy[i][j] = Player.getGoal;
            }

    }

    public void sort()//比较后用两个数组储存队伍和球员
    {
        int max1 = 0, max2 = 0;
        for (int counter = 0; counter < number * 11; counter++) {//第counter名排行
            for (int i = 0; i < number; i++)
                for (int j = 0; j < 11; i++)
                    if (copy[i][j] > copy[max1][max2]) {
                        max1 = i;
                        max2 = j;
                    }
            copy[max1][max2] = -1;
            rank1[counter++] = max1;
            rank2[counter++] = max2;
        }
    }

    public void displayPlayer() {
        Initial();
        sort();
        String output = "";
        System.out.println(" " + "排名" + " " + " " + "球员" + " " + " " + "球队" + " " + " " + "进球");
        for (int counter = 0; counter < number * 11; counter++) {
            output = output + " " + counter + 1 + " " + " " + rank2[counter] + 1 + " " + " " + rank1[counter] + 1 + " " + " "
                    + player[rank1[counter]][rank2[counter]] + '\n';
        }
        System.out.println(output);
    }
}

