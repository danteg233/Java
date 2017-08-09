package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    String [] string = {"Alex", "Nothing", "Something", "Whatever", "Cheeeeeeck!!!"};
	    Arrays.sort(string, new ByCountOfVowels());
        System.out.println("\nSort by Count of vowels: \n");
        for (String str: string
             ) {
            System.out.println(str);
        }
        System.out.println("\nSort by string length: \n");
        Arrays.sort(string, new byStringLength());

        for (String str: string
                ) {
            System.out.println(str);
        }
    }
}
