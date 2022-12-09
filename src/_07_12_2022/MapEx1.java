package _07_12_2022;

import java.util.*;

public class MapEx1 {
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>(200_000_000);
        map.put(89654, "Natalia");
        map.put(12365, "Natalia");
        map.put(645, "Alexander");
        map.put(9874, "Sergey");
        map.put(8123, "User");
        map.put(23658, "Uliana");
        map.put(null, "Ivan");
        map.put(null, "Ivan1");
        map.put(9996, null);
        map.putIfAbsent(6456, "******");
        map.putIfAbsent(645611, "------------------");

      //  System.out.println(map.get(8123));
        Integer a = 4;
        System.out.println(a.hashCode());

        //System.out.println(map.values());

        List<Integer> list = new ArrayList<>();
        list.add(51);
        list.add(152);
        list.add(253);
        list.add(354);
        list.add(455);

//        for (Integer i: list) {
//            System.out.println(i);
//        }

//        for (Map.Entry<Integer, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }

       // System.out.println(5 + 5 + "5"); //==105
    }
}
