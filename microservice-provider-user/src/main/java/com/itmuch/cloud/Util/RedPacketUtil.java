package com.itmuch.cloud.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 微信随机分配红包算法
 *
 * @author leo-zeng
 *
 */
public class RedPacketUtil {
    //最小红包额度
    private static final int MINMONEY = 1;
    //最大红包额度
    private static final int MAXMONEY = 66;
    //每个红包最大是平均值的倍数
    private static final double TIMES = 2.1;

    /**
     * @param money
     * @param count
     * @return
     * @Author:lulei
     * @Description: 拆分红包
     */
    public List<Integer> splitRedPackets(int money, int count) {
        if (!isRight(money, count)) {
            return null;
        }
        List<Integer> list = new ArrayList<Integer>();
        //红包最大金额为平均金额的TIMES倍
        int max = (int) (money * TIMES / count);
        max = max > MAXMONEY ? MAXMONEY : max;
        for (int i = 0; i < count; i++) {
            int one = random(money, MINMONEY, max, count - i);
            list.add(one);
            money -= one;
        }
        Collections.reverse(list);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)>MAXMONEY){
               int s = list.get(i)-MAXMONEY;
               list.set(i,MAXMONEY);
               list.set(i+1,list.get(i +1)+s);
            }
        }
        return list;
    }

    /**
     * @param money
     * @param minS
     * @param maxS
     * @param count
     * @return
     * @Author:lulei
     * @Description: 随机红包额度
     */
    private int random(int money, int minS, int maxS, int count) {
        //红包数量为1，直接返回金额
        if (count == 1) {
            return money;
        }
        //如果最大金额和最小金额相等，直接返回金额
        if (minS == maxS) {
            return minS;
        }
        int max = maxS > money ? money : maxS;
        //随机产生一个红包
        double f = Math.random();
        int one = ((int)Math.rint(f * (max - minS) + minS)) % max + 1;
        int a = max - minS;
        double b = f*a+ minS;
        int c = (int) Math.rint(b);
        int d = c%max;
        int e = d +1;
        int money1 = money - one;
        //判断该种分配方案是否正确
        if (isRight(money1, count -1)) {
            return one;
        } else {
            double avg = money1 / (count - 1);
            if (avg < MINMONEY) {
                //递归调用，修改红包最大金额
                return random(money, minS, one, count);
            }else if (avg > MAXMONEY) {
                //递归调用，修改红包最小金额
                return random(money, one, maxS, count);
            }
        }
        return one;
    }

    /**
     * @param money
     * @param count
     * @return
     * @Author:lulei
     * @Description: 此种红包是否合法
     */
    private boolean isRight(int money, int count) {
        double avg = money / count;
        if (avg < MINMONEY) {
            return false;
        }
        if (avg > MAXMONEY) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RedPacketUtil util = new RedPacketUtil();
        System.out.println(util.splitRedPackets(6600, 100));

        int s = 23%66;

        System.out.println(s);
    }
}