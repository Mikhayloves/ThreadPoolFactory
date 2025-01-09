# Домашнее задание №12
## За основу модификации использовался проект из домашнего задания № 11.
ссылка задание [https://github.com/Mikhayloves/ThreadPool/blob/main/README.md](https://github.com/Mikhayloves/ThreadPool)
___________________________________________________________
## В задании 11 необходимо было сделать ThreadPool.
Реализация происходила из интерфейса ThreadPool:

Пример:
```java
public interface ThreadPool {
    void start();
    void execute(Runnable task);
    void shutdown();
}
```
## void start() -> запускает потоки. Потоки бездействуют, до тех пор пока не появится новое задание в очереди (см. execute)
## void execute(Runnable runnable) -> складывает это задание в очередь. Освободившийся поток должен выполнить это задание. Каждое задание должны быть выполнено ровно 1 раз
## void shutdown() -> Останавливаем потоки.
