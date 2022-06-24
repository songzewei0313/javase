package dsa.binarysorttree;

/**
 * 二叉排序树
 * @author szw
 * @date 2022/3/30 9:39
 */
public class BinarySortTree1 {
    /**
     * 根节点
     */
    private Node1 root;

    public void add(Node1 node){
        if (root == null){
            root = node;
        }else {
            root.add(node);
        }
    }

    public void inorderTraversal(){
        if (root != null){
            root.inorderTraversal();
        }else {
            System.out.println("空树，无法进行中序遍历...");
        }
    }

    /**
     * 二叉排序树查找值为value的节点
     */
    public Node1 search(int value){
        if (root == null){
            return null;
        } else {
            return root.search(value);
        }
    }

    /**
     * 二叉排序树查找值为value的父节点
     */
    public Node1 searchParent(int value){
        if (root == null){
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     * 二叉排序树删除值为value的节点
     * @param value
     */
    public void del(int value){
        if (root == null){
            return;
        } else {
            Node1 targetNode = search(value);
            if (targetNode == null){
                return;
            }
        }
    }
}
