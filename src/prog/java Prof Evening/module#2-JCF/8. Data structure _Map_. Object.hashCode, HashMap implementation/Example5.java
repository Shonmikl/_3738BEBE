/*
Сгруппируйте слова с одинаковым набором символов

Дан список слов со строчными буквами. Реализуйте функцию поиска всех слов с одинаковым уникальным набором символов.
вход: String words[] = {"student", "students", "dog", "god", "cat", "act", "flow", "wolf"};

выход:
student, students,
cat, act,
dog, god,
flow, wolf

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Example5 {
    static final int MAX_CHAR = 26;
    public static void main(String[] args) {
        String[] words = {"student", "students", "dog", "god", "cat", "act", "flow", "wolf"};

        wordsWithSameCharSet(words);
    }

    public static void wordsWithSameCharSet(String[] words) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String key = getKey(words[i]);

            if (map.containsKey(key)) {
                ArrayList<Integer> checkList = map.get(key);
                checkList.add(i);
                map.put(key, checkList);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(key, list);
            }
        }

        for (Map.Entry<String, ArrayList<Integer>> it : map.entrySet()) {
            ArrayList<Integer> get = it.getValue();

            for (Integer v : get)
                System.out.print(words[v] + ", ");

            System.out.println();
        }

    }

    public static String getKey(String str) {
        boolean[] visited = new boolean[MAX_CHAR];
        Arrays.fill(visited, false);

        for (int i = 0; i < str.length(); i++)
            visited[str.charAt(i) - 'a'] = true;


        StringBuilder key = new StringBuilder();

        for (int i = 0; i < MAX_CHAR; i++) {
            if (visited[i])
                key.append((char)('a' + i));
        }

        return key.toString();
    }
}
