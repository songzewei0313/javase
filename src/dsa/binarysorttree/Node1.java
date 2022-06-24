package dsa.binarysorttree;

/**
 * @author szw
 * @date 2022/3/30 9:21
 */
public class Node1 {
    int value;
    Node1 left;
    Node1 right;

    public Node1(int value) {
        this.value = value;
    }

    /**
     * 递归添加节点并且按照二插排序树的顺序
     * 为什么要在节点类里面写添加节点的方法?
     *
     * @param node
     */
    public void add(Node1 node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            //如果当前节点左子节点为空的话，直接让其成为当前节点左子节点
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void inorderTraversal() {
        if (this.left != null) {
            this.left.inorderTraversal();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.inorderTraversal();
        }
    }

    /**
     * 查找值为value的节点
     *
     * @param value
     * @return
     */
    public Node1 search(int value) {
        //如果value和当前节点value相等，说明已经找到，返回当前节点
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     * 查找值
     * @param value
     * @return
     */
    public Node1 searchParent(int value) {
        if (this.left != null && this.left.value == value) {
            return this;
        }
        if (this.right != null && this.right.value == value) {
            return this;
        }
        if (value < this.value && this.left != null) {
            return this.left.searchParent(value);
        } else if (value >= this.value && this.right != null) {
            return this.right.searchParent(value);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Node1{" +
                "value=" + value +
                '}';
    }
}
