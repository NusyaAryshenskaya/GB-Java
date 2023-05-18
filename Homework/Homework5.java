import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.text.html.HTMLDocument.Iterator;

public class Homework5 {
    public static void main(String[] args){

// Создать множество, ключь и значение строки. Добавить шесть элементов. Вывести в консоль значения. 
        HashMap<String, String> map = new HashMap<>();
        map.put("один","one");
        map.put("два","two");
        map.put("три","three");
        map.put("четыре","four");
        map.put("пять","five");
        map.put("шесть","six");
        System.out.println("\n" + "Первое множество: "  + map + "\n");

//Добавить ко всем значениям символ "!".
    for(String key: map.keySet()){ 
        map.compute(key, (k,v) -> v + "!"); 
    }    
    System.out.println("Добавление символа '!' ко всем значениям: " + map + "\n");

//Создать второе множество с таким же обобщением. Ключи второго множества частично совпадают с ключеми первого.
    HashMap<String, String> map2 = new HashMap<>(); 
    map2.put("пять","five");
    map2.put("шесть","six");
    map2.put("семь","seven");
    map2.put("восемь","eight");
    map2.put("девять","nine");
    map2.put("десять","ten");    
    System.out.println("Второе множество: " + map2 + "\n");

// Объеденить значания во втором множестве и первом если ключи совподают. Вывести результат в консоль.
// непоняла до конца задание толи вывести все одинаковые значения толи одинаковые обьядинить и вывести все вместе
// Вывела общие значения 
    HashMap<String, String> map_map2 = new HashMap<>();
   
    for(String key: map.keySet()){
        if (map2.containsKey(key)){
            map_map2.put(key,map.get(key));
            map_map2.merge(key, "(" + map2.get(key) +")", String::concat);
        }
    }
    System.out.println("Одинаковые ключи и их значеиня: " + map_map2 + "\n");
    }
}