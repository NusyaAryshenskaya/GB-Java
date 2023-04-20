import java.util.Arrays;
import java.util.Random;

// 1. Написать метод принимающий строку, ищущий в ней основание и степень После этого расчитывающий результат и выводящий в консоль в консоль строку параметра + ответ. 
//Пример строки: "Основание -12б степень 7, результат". Попробовать с разными входящими строками.
//Сравнить скорость работы реплейса классов String и StringBuilder.

public class Homework2 {
    public static void main(String[] args) {


//        Задача 1. Дописать результат ко следующим строкам:
//        Основание -5, степень 3, результат равен
//        Основание 127, степень 2, результат равен
//        Основание 33, степень 15, результат равен
//        Основание 4, степень 7, результат равен

        System.out.println(parse_string("Основание -5, степень 3, результат равен"));
        System.out.println(parse_string("Основание 127, степень 2, результат равен"));
        System.out.println(parse_string("Основание 33, степень 15, результат равен"));
        System.out.println(parse_string("Основание 4, степень 7, результат равен"));
        System.out.println(parse_string("Основание 0, степень 0, результат равен"));

//        Задача 2. Заменить слово, встречающееся несколько раз, на другое.
//        Самолёт построим сами,
//                Понесёмся над лесами.
//        Понесёмся над лесами,
//                А потом вернёмся к маме.

        String my_string = """
                Самолёт построим сами,
                Понесёмся над лесами.
                Понесёмся над лесами,
                А потом вернёмся к маме.""";
        String query = "лесами";
        String replace = "полями";

        double begin;
        double end;

        begin = time_stamp();
        print_modified_string(my_string, query, replace);
        end = time_stamp();
        System.out.println("Время выполнения: " + Math.round(end - begin) + " нс");

        begin = time_stamp();
        print_modified_string_builder(my_string, query, replace);
        end = time_stamp();
        System.out.println("Время выполнения: " + Math.round(end - begin) + " нс");
    }

    public static double time_stamp() {
        return System.nanoTime();
    }

    public static void print_modified_string(String in_string, String in_query, String in_replace) {
        System.out.println(in_string.replace(in_query, in_replace));
    }

    public static void print_modified_string_builder(String in_string, String in_query, String in_replace) {
        StringBuilder sb = new StringBuilder(in_string);
        while (sb.indexOf(in_query) > 0) {
            sb.replace(sb.indexOf(in_query), sb.indexOf(in_query) + in_query.length(), in_replace);
        }
        System.out.println(sb);
    }

    public static String parse_string(String in_string) {
        String[] strings = in_string.split(" ");
        int base = 0;
        int power = 0;
        double product = 0;
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].replace(",", "");
            try {
                Integer.parseInt(strings[i]);
                if (base == 0) {
                    base = Integer.parseInt(strings[i]);
                } else {
                    power = Integer.parseInt(strings[i]);
                }

            } catch (NumberFormatException e) {
                continue;
            }
        }
        product = Math.pow(base, power);
        return in_string + " " + String.valueOf(product);
    }
}