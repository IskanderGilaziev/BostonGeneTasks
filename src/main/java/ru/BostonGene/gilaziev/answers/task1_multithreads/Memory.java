package ru.BostonGene.gilaziev.answers.task1_multithreads;

import java.util.*;
import java.util.stream.Collectors;

public class Memory {

    private EnglishTranslator englishTranslator;

    private Map<Integer, String> enteredConsoleNumbers = new HashMap<>();

    public Memory() {

    }

    public Memory(EnglishTranslator et) {
        this.englishTranslator = et;
    }

    public void saveNumber(Integer consoleInteger, String englishTransl) {
        if ((!enteredConsoleNumbers.isEmpty()) && (enteredConsoleNumbers.containsKey(consoleInteger))) {
                enteredConsoleNumbers.put(consoleInteger, englishTransl);
                System.out.println(" Ваша запись перезаписалась.");
            System.out.println();
        }
        else {
            enteredConsoleNumbers.put(consoleInteger, englishTransl);
            System.out.println(" Ваше число сохранено в память.");
            System.out.println();
        }
    }

    public void deleteNumber(Integer minInt) {

        if (enteredConsoleNumbers.isEmpty()) {
            System.out.println( "Память пуста. Нечего удалять");
            System.out.println();
        }

        if (!enteredConsoleNumbers.containsKey(minInt)) {
            System.out.println("Error! This number not found in memory!");
            System.out.println();
        }
        enteredConsoleNumbers.remove(minInt);
        System.out.println(" Минимальное число в памяти: "+ minInt +" удалено");
        System.out.println();
    }

    public  Integer searchMinInteger() {
        Set<Integer> numSet = enteredConsoleNumbers.keySet();
        Integer minVal = numSet.stream().min(Integer::compareTo).get();

        if(minVal==null){
            Thread.interrupted();
        }

        System.out.println(" Найдено минимальное число: "+ minVal);
        System.out.println();
        return minVal;
    }

    public  boolean isMemoryEmpty(){
        if(enteredConsoleNumbers.isEmpty()) {
            return true;
        }
        return false;
    }
}