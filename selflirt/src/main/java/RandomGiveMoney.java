import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhouxuan on 2017/7/24.
 */
public class RandomGiveMoney {
    public static final int TIMES = 10000000;
    public static final int LENGTH = 100;


    public List<Integer> random(List<Integer> list, int times) {
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < list.size(); j++) {
                Integer index1 = (int) (list.size() * Math.random());
                while (index1 == j) {
                    index1 = (int) (list.size() * Math.random());
                }
                list.set(j, list.get(j) - 1);
                list.set(index1, list.get(index1) + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        RandomGiveMoney randomGiveMoney = new RandomGiveMoney();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < LENGTH; i++) {
            list.add(100);
        }
        randomGiveMoney.random(list, TIMES);
        Collections.sort(list);
        for (int i = 0; i < LENGTH; i++) {
            System.out.println(list.get(i));
        }
    }
}
