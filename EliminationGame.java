import java.util.Random;

public class EliminationGame {
    private int[] team=new int[8];
   public EliminationGame(int[] team){
       this.team=team;
   }
   //淘汰赛主赛程
public int[] mainGame(int[] team){
    int[] ranking=new int[8];
    int count=0;
    Random random=new Random();
    for(int i=0;i<8;i++){  //八个队伍分组
        int num=0;
        while(true){
       count=random.nextInt(8);
       if(count!=i&&judge(team[i],team[count],ranking,i)){
           ranking[2*i]=team[i];
           ranking[2*i+1]=team[count];break;}
           num++;
       if(num>=7)
           break;
        } }

        int n=0;//八个队伍两两进行比赛
       for(int k=0;k<7;k=k+2){
         ranking[n]=Game(ranking[k],ranking[k+1]);
          n++;}

        int c;//剩余的四个队进行比赛
       for(int j=0;j<2;j++){
           c=Game(ranking[j],ranking[j+2]);
       if(ranking[j+2]==c){ranking[j+2]=ranking[j];ranking[j]=c;}
      }
    for(int j=0;j<4;j=j+2){//得出冠亚季军
        c=Game(ranking[j],ranking[j+2]);
        if(ranking[j+2]==c){ranking[j+2]=ranking[j];ranking[j]=c;}
        c=0;
    }

     return ranking;
   }
     //判断随机的两个队伍是否已被分配
   public boolean judge(int a,int b,int[] ranking,int c){
       for( int j=0;j<2*c; j++)
           if(a==ranking[j]||b==ranking[j])
               return false;
    return true;
   }
   //两两队比赛过程
    public int Game(int a,int b){
        int result=0;
        Random rand=new Random();
        int randnum=rand.nextInt(3);
        if(randnum==0)
            result=a;
        else if(randnum==1) result=b;
        else result=extraTime(a,b);//如果平局，进入加时赛
        return result;
    }

   //淘汰赛加时赛
public int extraTime(int a,int b){
       int result=0;
       Random rand=new Random();
       int randnum=rand.nextInt(3);
       if(randnum==0)
           result=a;
         else if(randnum==1) result=b;
              else result=penaltySpot(a,b);
       return result;
}

//淘汰赛罚点球
public int penaltySpot(int a,int b){
       int result;
       Random rand=new Random();
       int randnum1,randnum2;
       while (true){
           randnum1=rand.nextInt(2);
           if(randnum1==1){
               result=a;
               break;}
           else{     //如果a队球没有踢进去，则轮到b队
               randnum2=rand.nextInt(2);
               if(randnum2==1){
                   result=b;
                   break;
                  }
                }
       }
       return result;
}

}
