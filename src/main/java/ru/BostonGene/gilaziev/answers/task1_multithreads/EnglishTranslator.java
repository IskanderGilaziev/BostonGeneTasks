package ru.BostonGene.gilaziev.answers.task1_multithreads;

import java.util.HashMap;
import java.util.Map;

public class EnglishTranslator {

    private  Integer inputValue = null;
    private Map<Integer, String> numbers = new HashMap<>();


    public EnglishTranslator(Integer value) {
        this.inputValue = value;
        numbers.put(0,"null");
        numbers.put(1,"one");
        numbers.put(2,"two");
        numbers.put(3,"three");
        numbers.put(4,"four");
        numbers.put(5,"five");
        numbers.put(6,"six");
        numbers.put(7,"seven");
        numbers.put(8,"eight");
        numbers.put(9,"nine");
        numbers.put(10,"ten");
        numbers.put(11,"eleven");
        numbers.put(12,"twelve");
        numbers.put(13,"thirteen");
        numbers.put(14,"fourteen");
        numbers.put(15,"fifteen");
        numbers.put(16,"sixteen");
        numbers.put(17,"seventeen");
        numbers.put(18,"eighteen");
        numbers.put(19,"nineteen");
        numbers.put(20,"twenty");
        numbers.put(30,"thirty");
        numbers.put(40,"forty");
        numbers.put(50,"fifty");
        numbers.put(60,"sixty");
        numbers.put(70,"seventy");
        numbers.put(80,"eighty");
        numbers.put(90,"ninety");
        numbers.put(100,"hundred");
        numbers.put(1000,"thousand");
    }

    public String translateNumbers(){
        String translateNumberInString="";
        String str = "";
        if(numbers.containsKey(inputValue)){
            translateNumberInString = numbers.get(inputValue) ;
        }
        else {
            str = inputValue.toString();
            switch (str.length()){
                case 2:
                    Integer xTeen2 = Integer.parseInt(String.valueOf(str.charAt(0))) * 10;
                    Integer lastIndex2 = Integer.parseInt(String.valueOf(str.charAt(1)));
                    translateNumberInString = numbers.get(xTeen2) + " " + numbers.get(lastIndex2);
                    break;
                case 3:
                    Integer xHundred = Integer.parseInt(String.valueOf(str.charAt(0)));
                    Integer xTeen3 = Integer.parseInt(String.valueOf(str.charAt(1))) * 10;
                    Integer lastIndex3 = Integer.parseInt(String.valueOf(str.charAt(2)));
                    translateNumberInString = numbers.get(xHundred) + " "
                                                + numbers.get(100) + " "
                                                + numbers.get(xTeen3) + " "
                                                + numbers.get(lastIndex3);
                    break;
                case 4:
                    Integer xThousand = Integer.parseInt(String.valueOf(str.charAt(0)));
                    Integer xHundred4 = Integer.parseInt(String.valueOf(str.charAt(1)));
                    Integer xTeen4 = Integer.parseInt(String.valueOf(str.charAt(2))) * 10;
                    Integer lastIndex4 = Integer.parseInt(String.valueOf(str.charAt(3)));
                    translateNumberInString = numbers.get(xThousand)+ " " + numbers.get(1000)+ " "+
                                                 numbers.get(xHundred4)+ " " + numbers.get(100)+ " "+
                                                    numbers.get(xTeen4) + " " + numbers.get(lastIndex4);
                    break;
            }
        }
        return translateNumberInString;
    }


}
