package dsa.hashtab;

import java.util.Scanner;

/**
 * 哈希表测试类
 * @author szw
 */
public class HashTabTest {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        String key;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("del: 删除雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("请输入id：");
                    int id = scanner.nextInt();
                    System.out.println("请输入名字：");
                    String name = scanner.next();
                    Emp emp = new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入id：");
                    id = scanner.nextInt();
                    hashTab.findById(id);
                    break;
                case "del":
                    System.out.println("请输入id：");
                    id = scanner.nextInt();
                    hashTab.delete(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("输入有误，请重新输入：");
                    break;
            }
        }
    }
}
