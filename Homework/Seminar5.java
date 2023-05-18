package org.example;

import java.util.*;

public class S5 {

    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();
        map.put("РџСЏС‚СЊ", "Five");
        map.put("Р”РІР°", "Two");
        map.put("РћРґРёРЅ", "One");

        String str = map.get("РџСЏС‚СЊ");
        System.out.println(str);

        map.remove("РџСЏС‚СЊ");
        map.remove("РџСЏС‚СЊ", "Five");

        map.put("РџСЏС‚СЊ", "Five");

//        for (String key: map.keySet()) {
//            System.out.println(map.get(key));
//        }
//
//        Iterator<String> iterator = map.keySet().iterator();
//        while (iterator.hasNext()){
//            String key = iterator.next();
//            System.out.println(map.get(key));
//        }
//
//        Set keys = map.keySet();
//        for (int i=0; i< keys.size();i++){
//            System.out.println(map.get(keys.toArray()[i]));
//        }

        map.replace("РџСЏС‚СЊ", "5");
        map.replace("РџСЏС‚СЊ", "Five", "5");

        map.getOrDefault("РЁРµСЃС‚СЊ", "0");
        map.containsKey("РЁРµСЃС‚СЊ");
        map.containsValue("5");
        map.putIfAbsent("РЁРµСЃС‚СЊ", "6");
        map.forEach((k, v) -> System.out.println(k+" "+v));

        map.compute("РЁРµСЃС‚СЊ", (k, v) -> v+="!");

        map.computeIfPresent("РЁРµСЃС‚СЊ", (k, v) -> v+"!?");
        map.computeIfAbsent("РЁРµСЃС‚СЊ", v -> v+"!?!");

        for (String key: map.keySet()) {
//            map.compute(key, (k, v) -> v+"!");
            map.merge(key, "!", String::concat);
        }

        System.out.println(map);

        map.merge("РћРґРёРЅ", "7", String::concat);

        System.out.println(map);

        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
        hashMap.put("РџСЏС‚СЊ", "Five");
        hashMap.put("Р”РІР°", "Two");
        hashMap.put("РћРґРёРЅ", "One");
        hashMap.putIfAbsent("РЁРµСЃС‚СЊ", "6");
        System.out.println(hashMap);

        TreeMap<Integer, String> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        treeMap.put(5, "Five");
        treeMap.put(2, "Two");
        treeMap.put(1, "One");
        treeMap.putIfAbsent(6, "6");
        System.out.println(treeMap.headMap(2, true));
        System.out.println(treeMap.tailMap(2, false));

        int[] ints;
        ArrayList<Integer> integers;
        HashMap<Integer, Integer> map1;


    }
}