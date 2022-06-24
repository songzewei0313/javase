package obj;

import org.junit.jupiter.api.Test;

/**
 * @author 22264
 */
public class ConstructTest {
//    private String name = "ss";
    private String name;

    public ConstructTest() {
//        name = "zhangsan";
    }

    public ConstructTest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Test
    public void test(){
        ConstructTest constructTest = new ConstructTest();
        System.out.println(constructTest.getName());
    }

    public static void main(String[] args) {
        ConstructTest constructTest = new ConstructTest();
        System.out.println(constructTest.getName());
    }

}
