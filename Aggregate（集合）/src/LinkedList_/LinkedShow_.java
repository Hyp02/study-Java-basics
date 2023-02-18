package LinkedList_;

public class LinkedShow_ {
    public static void main(String[] args) {
        //创建链表的单个节点
        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node join = new Node("join");
        //将单个节点连接起来，简单的双向链表
        jack.next = tom;
        tom.prev = jack;
        tom.next = join;
        join.prev = tom;
        //确定头结点和尾节点
        Node first = jack;
        Node last = join;
        //循环输出各个节点的元素
        while (true) {
            //从头结点开始输出
            if (first == null) {
                break;
            }
            System.out.println(first);
            first = first.next;//每次将头结点的指向  向后移动
        }
    }
}
class Node {
    Object item;
    Node next;//后继指针
    Node prev;//前驱指针
    public Node(Object item) {
        this.item = item;
    }
    @Override
    public String toString() {
        return "Node name = " + item;
    }
}
