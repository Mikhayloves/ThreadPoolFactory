package org.sberuniversity;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ThreadWork {
    Scanner scanner = new Scanner(System.in);

    public void launch() {
        while (true) {
            menu();
            ThreadPool threadPool = null;
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // Создаем FixedThreadPool через фабрику
                    threadPool = ThreadPoolFactory.createThreadPool("Fixed", 3);
                case 2:
                    threadPool = ThreadPoolFactory.createThreadPool("Scalable", 2, 5);
            }
            executeTasks(threadPool);
        }
    }

    public static void menu() {
        System.out.println("Выберите пункт меню:\n1 - FixedThreadPool\n2 - ScalableThreadPool");
    }

    private void executeTasks(ThreadPool threadPool) {
        threadPool.start();

        // Добавляем 10 задач для выполнения
        for (int i = 0; i < 10; i++) {
            int taskId = i;
            threadPool.execute(() -> {
                System.out.println("Задача " + taskId + " запущена в потоке" + Thread.currentThread().getName());
                try {
                    // Симулируем работу задачи с задержкой
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Задача " + taskId + " завершена");
            });
        }
        // Ждем выполнения всех задач
        try {
            TimeUnit.SECONDS.sleep(threadPool instanceof ScalableThreadPool ? 25 : 15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadPool.shutdown();
        System.out.println("Пул потоков был завершен.");
    }
}
