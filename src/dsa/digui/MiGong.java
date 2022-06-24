package dsa.digui;

/**
 * @author szw
 */
public class MiGong {
    public static void main(String[] args) {
        //建立一个8行7列二维数组充当地图
        int[][] map = new int[8][7];

        for (int j = 0; j < 7; j++) {
            map[0][j] = 1;
            map[7][j] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("小球走过迷宫之后的地图:");
        find(map, 1, 1);

        //小球走过迷宫之后的地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 迷宫找路
     * 说明：0为未走过，1为墙体，2为走过，3为此点不能成为通路上的点
     * @param map 地图
     * @param i   i,j为其实位置
     * @param j
     * @return
     */
    public static boolean find(int[][] map, int i, int j) {
        //如果要找的位置，即map[6][5] 为2，说明路已找到，直接返回true
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                //如果map[i][j] == 0，说明初始位置没有走过，可以走，标记为2，然后开始下一步（开始递归调用）
                // 按照 下->右->上->左 的顺序找路
                if (find(map, i + 1, j)) {
                    return true;
                } else if (find(map, i, j + 1)) {
                    return true;
                } else if (find(map, i - 1, j)) {
                    return true;
                } else if (find(map, i, j - 1)) {
                    return true;
                } else {
                    //说明此点走不通，标记为3，此时将结果返回到上一个调用栈，并开始回溯到上一个点，继续按照策略走
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //说明map[i][j] ！= 0，那么就为1，2或3，即都走不通，直接返回false
                return false;
            }
        }
    }
}
