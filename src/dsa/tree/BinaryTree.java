package dsa.tree;


/**
 * author szw
 * date 2022/3/28 9:58
 */
public class BinaryTree<K extends Comparable<K>, V> {
    private Node root;
    /**
     * 元素个数
     */
    private int n;

    private class Node<K, V> {
        private K k;
        private V v;
        private Node leftChild;
        private Node rightChild;

        public Node(K k, V v, Node leftChild, Node rightChild) {
            this.k = k;
            this.v = v;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    public int size() {
        return n;
    }

    public void put(K k, V v) {

    }
}
