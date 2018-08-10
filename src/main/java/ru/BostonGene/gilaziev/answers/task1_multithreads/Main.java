package ru.BostonGene.gilaziev.answers.task1_multithreads;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Memory memory = new Memory();
        EnterThread thread1 = new EnterThread(memory);
        DeleteThread thread2  = new DeleteThread(memory);
        thread1.start();
        thread2.start();

    }
}
