package ru.BostonGene.gilaziev.answers.task1_multithreads;

import java.util.Scanner;

public class EnterThread extends  Thread {

    private EnglishTranslator translator;
    private final Memory myMemory;

    public EnterThread(Memory memory) {
        this.myMemory = memory;
    }

    @Override
    public void run() {
        Integer  value;
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Вы можете ввести числа от 0 до 9999.");
        while (!isInterrupted()) {
            synchronized (this) {
                System.out.println(" Для выхода введите '00'. Пожалуйста введите число:");
                value = scanner.nextInt();
                translator = new EnglishTranslator(value);
                System.out.print(" Вы ввели: " + translator.translateNumbers());
                System.out.println();
                myMemory.saveNumber(value, translator.translateNumbers());
                if(myMemory.isMemoryEmpty()){
                    interrupt();
                }
                scanner.nextLine();
                if(value==00){
                    System.out.println(" Вы выходите. До свидания!");
                    System.exit(0);
                }
            }
        }
    }
}
