package JavaCollections.OptionalTask;

import java.util.ArrayList;

//7. Задана строка, состоящая из символов «(», «)», «[», «]», «{», «}».
//    Проверить правильность расстановки скобок.
//    Не используя стек.

public class Task7WithoutStack {
    static boolean checkBracketsOrder(String line){
        boolean checkResult=false;
        if(line!="") {
            if ((!line.contains("[")) & (!line.contains("]")) & (!line.contains("(")) & (!line.contains(")")) &
                    (!line.contains("{")) & (!line.contains("}"))) checkResult = true;
            else {
                ArrayList<Integer> indexOFBrackets = new ArrayList<>();
                //Определяем первую закрывающуюся скобку
                indexOFBrackets.add(line.indexOf("]"));
                indexOFBrackets.add(line.indexOf(")"));
                indexOFBrackets.add(line.indexOf("}"));
                indexOFBrackets.removeIf(integer -> integer < 0);
                //Если закрывающая скобка есть то продолжаем
                if (indexOFBrackets.size() > 0) {
                    indexOFBrackets.sort((o1, o2) -> o1 - o2);
                    char bracket = line.charAt(indexOFBrackets.get(0));

                    //Находим соответствующую  скобку
                    switch (bracket) {
                        case ']':
                            bracket = '[';
                            break;
                        case ')':
                            bracket = '(';
                            break;
                        case '}':
                            bracket = '{';
                            break;
                    }
                    //Разделяем строку на две части - до и после найденой скобки
                    String linePart3 = "";
                    if (indexOFBrackets.get(0) + 1 <= line.length()) {
                        linePart3 = line.substring(indexOFBrackets.get(0) + 1);
                    }
                    String linePart2 = line.substring(0, indexOFBrackets.get(0));

                    //Находим последнюю с конца нужную открывающуюся скобку
                    if ((linePart2 != "") & (linePart2.indexOf(bracket) != -1)) {
                        int i;
                        for (i = linePart2.length() - 1; i >= 0; i--) {
                            if (linePart2.charAt(i) == bracket) break;
                        }
                        //Разбиваем строку на три части - начало(часть1)+середина(часть между найдеными скобками - часть 2)+конец(часть 3)
                        String linePart1 = linePart2.substring(0, i);
                        if (i + 1 < linePart2.length()) {
                            linePart2 = linePart2.substring(i + 1);
                        } else linePart2 = "";
                        //Выполняем проверку для середины строки и крайних ее частей
                        checkResult = checkBracketsOrder(linePart2) & checkBracketsOrder(linePart1 + linePart3);
                    }
                }
            }
        }else checkResult=true;
        return checkResult;
    }

    public static void main(String[] args) {

        String testLineNew="{(a(a[s]d))}";
        System.out.println(testLineNew);
        System.out.println(checkBracketsOrder(testLineNew));
        
    }
}
