package com.solvd;


import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class RandomGeneration {

    public static String getRandomString(int len){
        String res = "";
        for (int i=0;i<len;i++)
            res+=(char)RandomUtils.nextInt('a',1+'z');
        return res;
    }
    public static String getRandomString(){
        int len = RandomUtils.nextInt(3,6);
        return getRandomString(len);
    }
    public static String getRandomSurnameOrName(){
        String s = getRandomString();
        s  = Character.toString(s.charAt(0)).toUpperCase()+StringUtils.substring(s,1);
        return s;

    }
    public static String getNameOfSubDivision(){
        return getRandomString().toUpperCase();
    }
    public static String getNameOfSubDivision(int len){
        return getRandomString(len).toUpperCase();
    }
    public static<T> T getRandomElementFromList(List<T> list){
        return list.get(RandomUtils.nextInt(0,list.size()));
    }
    public static<T> T getRandomElementFromArray(T array[]){
        return array[(RandomUtils.nextInt(0,array.length))];
    }
}
