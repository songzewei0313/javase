package test;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    @Test
    public void test() {
        Map<String, Object> map = new HashMap(16);
        Map<String, String> data = new HashMap<>(16);
        data.put("uuid", "3");
        data.put("type", "CHA");
        map.put("id", "1");
        map.put("data", data);
        System.out.println(map);
    }
}
