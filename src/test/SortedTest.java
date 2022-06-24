package test;

import java.util.*;

/**
 * @author szw
 * @date 2022/4/21 9:28
 */
public class SortedTest {
    public static void main(String[] args) {
        List<Map<String, Integer>> list = new ArrayList<>(10);
        Map map = new HashMap<>(16);
        Map map1 = new HashMap<>(16);
        Map map2 = new HashMap<>(16);
        Map map3 = new HashMap<>(16);
        Map map4 = new HashMap<>(16);
        map.put("s",13);
        map1.put("s",6);
        map2.put("s",9);
        map3.put("s",3);
        map4.put("s",33);
        list.add(map);
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        list.sort(Comparator.comparing(m->m.get("s")));
        Collections.reverse(list);
        System.out.println(list);
    }
}
