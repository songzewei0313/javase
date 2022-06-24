package dsa.tree;

/**
 * author szw
 * date 2022/3/25 15:38
 */
public class BinaryTree1 {
    private HeroNode root;

    public void setRoot(HeroNode root){
        this.root = root;
    }

    public void add(HeroNode node) {
        if (root == null) {
            root = node;
            return;
        }
        HeroNode temp = root;
        while (true) {
            if (temp.getId()>node.getId()){
                if (temp.getLeftChild() == null){
                    temp.setLeftChild(node);
                    break;
                }else {

                }
            }
        }
    }
}
