package JavaCollections.OptionalTask;

import java.util.ArrayList;

//5. Не используя вспомогательных объектов, переставить отрицательные элементы данного списка в конец,
//   а положительные — в начало списка.

public class Task5 {
    public static void main(String[] args) {
        ArrayList<Integer> listOfRandomNumbers=new ArrayList<>();
        //Создадим список случайных чисел из 20 элементов
        for(int i=0;i<20;i++){
            listOfRandomNumbers.add((int)( Math.random()*2*10-10));
        }
        //Перенесем все отрицательные элементы в конец
        listOfRandomNumbers.sort((o1, o2) -> o2-o1);
        System.out.println(listOfRandomNumbers);

    }
}
