/*

 * Copyright (c) 2019 superatomfin.com. All Rights Reserved.

 */
package com.example.marketrobot.util;

import java.math.BigDecimal;
import java.util.Random;

/**
 * @author liudashuang  Date: 2019-08-28 Time: 13:49
 */
public class Util {

    public static String randomPrice(String base){
        return random(base,10);
    }

    public static String random(String base,int round){
        BigDecimal bigDecimal = new BigDecimal(base);
        Random random = new Random();
        int i = random.nextInt(round);
        boolean b = random.nextBoolean();
        if(b){
            bigDecimal = bigDecimal.add(bigDecimal.multiply(new BigDecimal(i)).multiply(new BigDecimal("0.01")));
        }else {
            bigDecimal = bigDecimal.subtract(bigDecimal.multiply(new BigDecimal(i).multiply(new BigDecimal("0.01"))));
        }
        return bigDecimal.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        String str = randomPrice("0.5");
        System.out.println(str);
        int i = 0 ;
        while (true){
            i++ ;;
            System.out.println(randomPriceGrown("0.5",10,"0.9",480,i));
            if(i==900){
                break;
            }
        }
    }

    /**
     *
     * @param base  当前价
     * @param round 波动
     * @param toPrice  目标价
     * @param seconds  多长时间
     * @return
     */
    public static String randomPriceGrown(String base,int round,String toPrice,int seconds,int times){
        BigDecimal to = new BigDecimal(toPrice);
        BigDecimal bigDecimal = new BigDecimal(base);
        BigDecimal increase = to.subtract(bigDecimal);
        BigDecimal preIncrease = increase.divide(new BigDecimal(seconds),8,BigDecimal.ROUND_DOWN);
        Random random = new Random();
        int i = random.nextInt(round);
        boolean b = random.nextBoolean();
        if(b){
            bigDecimal = bigDecimal.add(bigDecimal.multiply(new BigDecimal(i)).multiply(new BigDecimal("0.01")))
                    .add(bigDecimal.multiply(preIncrease).multiply(new BigDecimal(times)));
        }else {
            bigDecimal = bigDecimal.subtract(bigDecimal.multiply(new BigDecimal(i).multiply(new BigDecimal("0.01"))))
                    .add(bigDecimal.multiply(preIncrease).multiply(new BigDecimal(times)));
        }
        return bigDecimal.toString();
    }

}
