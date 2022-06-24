package dsa.binarysorttree;

/**
 * @author szw
 * @date 2022/3/30 9:48
 */
public class BinarySortTreeTest {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree1 binarySortTree1 = new BinarySortTree1();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree1.add(new Node1(arr[i]));
        }
        System.out.println("中序遍历结果：");
        binarySortTree1.inorderTraversal();
    }
}
