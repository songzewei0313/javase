package dsa.digui;

/**
 * 八皇后问题->用递归算法解决
 * 1、注意定义一维数组的含义
 * 2、注意变量 n、i的含义以及arr[n]和arr[i]的含义
 * 3、注意check()和judge()两个方法要连在一起理解，不然可能会不理解（比如如果单独看judge方法，可能会觉得有问题）
 *
 * @author szw
 */
public class Queen8 {
    /**
     * 表示一共有八个皇后
     */
    int max = 8;

    /**
     * 定义一个一维数组接收放置各个皇后的一个解法
     * 数组下标+1为第几个皇后，即第几行的皇后
     * 数组下标对应的value+1为在第几列
     * 所以一维数组就可以搞定
     */
    int[] arr = new int[max];

    /**
     * 多少种解法
     */
    static int count = 0;

    /**
     * 判断冲突的次数
     */
    static int judgeCnt = 0;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        //从第一个皇后开始摆
        queen8.check(0);
        System.out.printf("八皇后一共%d种解法", count);
        System.out.println();
        System.out.print("打印一下判断冲突的次数：" + judgeCnt);
    }

    /**
     * 注：参数n为数组下标，所以应为第n+1个皇后，也就是第n+1行的皇后
     * i则为第i+1列
     *
     * @param n
     */
    public void check(int n) {
        //如果n=8,说明8个皇后已经放好
        if (n == max) {
            print();
            return;
        }
        //
        for (int i = 0; i < max; i++) {
            //每个皇后（即第n+1个皇后）都先让她在第一列（因为i最初是0），然后判断冲突
            arr[n] = i;
            //如果不冲突的话
            if (judge(n)) {
                //则放置下一个皇后（即n+1），开始递归
                check(n + 1);
            }
        }
    }

    /**
     * 注：参数n为数组下标，所以应为第n+1个皇后，也就是第n+1行的皇后
     * i则为第i+1列
     *
     * @param n
     * @return
     */
    public boolean judge(int n) {
        judgeCnt++;
        //n为0的话，i<n不成立，不会走循环，即放置第一个皇后根本不会出现冲突的情况
        for (int i = 0; i < n; i++) {
            //arr[i] == arr[n] 判断是否有皇后在同一列，因为我们规定的一维数组的值就是在第几列
            //Math.abs(n - i) == Math.abs(arr[n] - arr[i]) 判断
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        //进入到print，说明已有一种解法，则count++；count代表多少种解法
        count++;
        //吧一维数组打印出来（即产生的解法->皇后的摆法）
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
