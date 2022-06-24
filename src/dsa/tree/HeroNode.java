package dsa.tree;

/**
 * @author szw
 */
public class HeroNode {
    private int id;
    private String name;
    private HeroNode leftChild;
    private HeroNode rightChild;

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(HeroNode leftChild) {
        this.leftChild = leftChild;
    }

    public HeroNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(HeroNode rightChild) {
        this.rightChild = rightChild;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        if (this.leftChild != null){
            this.leftChild.preOrder();
        }
        if (this.rightChild != null){
            this.rightChild.preOrder();
        }
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
