package football;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import  java.util.ArrayList;
import  java.util.Calendar;
import  java.util.Date;
import  java.util.List;
public class Field {
    private int[] field = new int[35];

    public void fielgarrangement() {//场地编号和三名裁判

        for (int i = 0; i <field.length; i++) {
            field[i] = i+1;
            System.out.println("在场地" + field[i] + "进行比赛，裁判为："+field[i]+"号场地的裁判1&2&3");
        }
    }

    public void yellowcard() {//随机发黄牌
        int[] card = new int[11];
        for (int i = 0; i < 11; i++) {
            card[i] = Math.random() >= 0.95 ? 1 : 0;
            if (card[i] == 1) {
                System.out.println("队员：" + players[i] + "被发一张黄牌");//属于哪个队伍？
            }
        }
    }


    public List<Date> findDates(Date dBegin, Date dEnd) {//输出比赛日期
        List lDate = new ArrayList();
        lDate.add(dBegin);
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(dEnd);
        while (dEnd.after(calBegin.getTime())) {
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(calBegin.getTime());
        }
        return lDate;
    }

    public void dateprint1() throws ParseException {//循环赛时间场地和黄牌输出

        Calendar cal = Calendar.getInstance();
        String start = "2017-04-01";
        String end = "2017-04-9";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dBegin = sdf.parse(start);
        Date dEnd = sdf.parse(end);
        List<Date> lDate = findDates(dBegin, dEnd);
        int i = 1;
        for (Date date : lDate) {
            i++;
            System.out.print(sdf.format(date));
            if (i % 2 == 1) {
                System.out.println("上午");
            }
            if (i % 2 == 0) {
                System.out.println("下午");
            }
            fielgarrangement();
            yellowcard();//比赛的两支队伍调用赛程安排
        }

    }
}
