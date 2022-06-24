package dsa.linkedlist;

/**
 * @author songzw
 */
public class BookNode {
    public int id;
    public String name;
    public double price;

    public BookNode next;

    public BookNode() {
    }

    public BookNode(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
