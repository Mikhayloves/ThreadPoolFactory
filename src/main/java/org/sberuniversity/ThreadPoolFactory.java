package org.sberuniversity;

public class ThreadPoolFactory {
    public static ThreadPool createThreadPool(String type, int... params) {
        switch (type) {
            case "Fixed":
                if (params.length < 1) {
                    throw new IllegalArgumentException("Для FixedThreadPool требуется 1 параметр: количество потоков");
                }
                return new FixedThreadPool(params[0]);

            case "Scalable":
                if (params.length < 2) {
                    throw new IllegalArgumentException("\n" +
                            "Для масштабируемого пула потоков требуются 2 параметра: MinThreads и maxThreads");
                }
                return new ScalableThreadPool(params[0], params[1]);

            default:
                throw new IllegalArgumentException("Неизвестный тип пула потоков: " + type);
        }
    }
}

