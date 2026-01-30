package com.weihnachten;

public class Ascii {
    public static void main(String[] args) {
        for (int i = 65; i <=90 ; i++) {
            System.out.print((char)i);
        }
        char cr=13;
        char lf=10;
        System.out.println("\nHallo"+cr+lf+"------------");
        String text = "汉字 中文 漢字";
        System.out.println(text);
    }
}
