/**
 * \* Created with IntelliJ IDEA.
 * \* Author: Prekrasnov Sergei
 * \* Date: 16.05.2022
 * \* ----- group JAVA-27 -----
 * \*
 * \* Description: Домашнее задание к занятию 1.3 Переменные многопоточной программы.
 * \*
 * \* Задача: Задача 1. Самая бесполезная коробка
 * \
 */
public class Main {
    public static volatile boolean boxStatus;

    public static void main(String[] args) {
        Toy toy = new Toy();
        Gamer gamer = new Gamer();
        Thread threadGamer = new Thread(gamer, "Игрок");
        Thread threadToy = new Thread(toy, "Мартышка");
        threadGamer.start();
        threadToy.start();
        try {
            threadGamer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadToy.interrupt();
    }
}