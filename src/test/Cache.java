package test;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author szw
 * @date 2022/6/17 15:28
 */
public class Cache {
    /**
     * 键值对集合
     */
    private final static ConcurrentHashMap<String, List<String>> MAP = new ConcurrentHashMap<>();
    /**
     * 添加缓存
     */
    public synchronized static void put(String key, List<String> data) {
        //清除原键值对
        Cache.remove(key);
        //不设置过期时间
        MAP.put(key, data);
    }

    /**
     * 更新缓存
     * @param key
     * @param data
     */
    public synchronized static void update(String key, List<String> data) {
        //清除原键值对
        Cache.remove(key);
        //不设置过期时间
        MAP.put(key, data);
    }
    /**
     * 读取缓存
     */
    public static List<String> get(String key) {
        return MAP.get(key);
    }
    /**
     * 清除缓存
     */
    public synchronized static void remove(String key) {
        MAP.remove(key);
    }
}
