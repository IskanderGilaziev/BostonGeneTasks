package ru.BostonGene.gilaziev.answers.task1_multithreads;

public class DeleteThread extends  Thread {

    private  Memory memory;

    public DeleteThread(Memory memory) {
        this.memory = memory;
    }

    @Override
    public void run() {
        while (!isInterrupted()){
        synchronized (memory){
            try {
                join(5000);
                System.out.print(" Инициализация поиска и удаления числа");
                System.out.println();

                if(memory.isMemoryEmpty()){
                    System.out.println(" Память пуста.Поток завершает работу.");
                    interrupt();
                    System.out.println();
                }
                memory.deleteNumber(memory.searchMinInteger());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        }
    }
}
