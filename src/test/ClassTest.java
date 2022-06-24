package test;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author 22264
 */
public class ClassTest {
    @Test
    public void test(){
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        Date date = new Date();
        //不推荐使用
        int day = date.getDay();
    }
}
