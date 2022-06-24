package test;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射测试
 * @author szw
 * @date 2022/4/21 11:19
 */
public class ReflectTest {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        User user = new User();
        user.setId("cs03");
        user.setAge(13);
        user.setName("song");
        Class<? extends User> clazz = user.getClass();
        Field id = clazz.getDeclaredField("id");
        id.setAccessible(true);
        Object o = id.get(user);
        System.out.println(o.toString());
    }

    @Test
    public void methodTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class<? extends User> clazz = user.getClass();
        Method test = clazz.getDeclaredMethod("test", int.class, int.class);
        test.setAccessible(true);
        int invoke = (int) test.invoke(user, 13, 3);
        System.out.println(invoke);
    }
}

class User {
    private String id;
    private String name;
    private Integer age;

    public int test(int i, int j) {
        return i + j;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
