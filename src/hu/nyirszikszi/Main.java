package hu.nyirszikszi;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Hegyek> list = Actions.fileToList("hegyekMo.txt");

        System.out.println("3. feladat: " + Actions.task3(list));

        System.out.println("4. feladat: " + Actions.task4(list));

        System.out.println("5. feladat: " + Actions.task5(list));

        System.out.println("6. feladat: ");
        System.out.println(Actions.task6(list));

        System.out.println("7. feladat: " + Actions.task7(list));

        System.out.println("8. feladat: " + Actions.task8(list));

        System.out.println("8. feladat: " + Actions.task9(list, "bukk-videk.txt"));
    }
}