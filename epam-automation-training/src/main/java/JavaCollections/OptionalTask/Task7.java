package JavaCollections.OptionalTask;

import java.util.*;

//7. Задана строка, состоящая из символов «(», «)», «[», «]», «{», «}».
//    Проверить правильность расстановки скобок. Использовать стек.

public class Task7 {
    static boolean checkBracketsOrder(String line){
        boolean checkResult=false;
        //Преобразуем строку в очередь
        if(line!="") {
            Deque<Character> symbolsFromLine = new ArrayDeque<>();
            for (int i = 0; i < line.length(); i++) symbolsFromLine.offer(line.charAt(i));
            checkResult=checkBracketsOrder(symbolsFromLine);
        }else checkResult=true;
        return checkResult;
    }

    static boolean checkBracketsOrder(Deque<Character> symbolsFromLine){
        boolean checkResult=false;
        Deque<Character> symbolsFromBegining=new ArrayDeque<>();
        char symbol=symbolsFromLine.poll();

        //Считываем все символы из исходной строки до закрывающей скобки и записываем в новую очередь
        while (!symbolsFromLine.isEmpty()){
            if((symbol==']')|(symbol==')')|(symbol=='}'))break;
            symbolsFromBegining.offer(symbol);
            symbol=symbolsFromLine.poll();
        }

        //Находим соответствующую  открывающуюю скобку
        char bracket='[';
        char bracketNotMatch1='(';
        char bracketNotMatch2='{';
        switch (symbol) {
            case ']':
                bracket = '[';
                bracketNotMatch1='(';
                bracketNotMatch2='{';
                break;
            case ')':
                bracket = '(';
                bracketNotMatch1='[';
                bracketNotMatch2='{';
                break;
            case '}':
                bracket = '{';
                bracketNotMatch1='(';
                bracketNotMatch2='[';
                break;
        }

        boolean checkBracket=false;
        //Если есть символы до найденой открывающейся скобки то перебераем элементы
        if(symbolsFromBegining!=null){

            while (!symbolsFromBegining.isEmpty()){
                symbol=symbolsFromBegining.pollLast();

                //Если встретилась открывающаяся скобка не соответствующего типа то возвращаем false
                if((symbol==bracketNotMatch1)|(symbol==bracketNotMatch2))break;

                //ищем нужную открывающуюся скобку
                if(symbol==bracket){
                    checkBracket=true;
                    break;
                }
            }
            //Если нужная скобка найдена, тогда проверяем оставшиеся части
            if(checkBracket){
                symbolsFromBegining.addAll(symbolsFromLine);
                if(symbolsFromBegining.isEmpty())checkResult=true;
                else checkResult=checkBracketsOrder(symbolsFromBegining);
            }
        }
        return checkResult;
    }

    public static void main(String[] args) {
        String testLineNew="[{{(a{a[s]d})}[]((()))}]";
        System.out.println(testLineNew);
        System.out.println(checkBracketsOrder(testLineNew));
    }
}
