package io.datajek.springdatajdbc.tennis_player;

public class Practice {
    public void printWord(String... words){
        System.out.println("Total argumetns "+words.length);
        for(String s:words) System.out.println(s);
    }
    public void printClassInfo(Class<?> clazz){
        System.out.println(clazz.getName());
    }

}
