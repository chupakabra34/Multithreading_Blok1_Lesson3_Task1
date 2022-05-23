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
    public static void main(String[] args) {
        GameBox gameBox = new GameBox();
        new Thread(null,gameBox::on,"Игрок").start();
        new Thread(null,gameBox::off,"Обезъяна").start();
    }
}