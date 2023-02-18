package niuke;

import java.util.HashMap;

public class ListOverturn {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode l = l1;
        overturnList(l);
    }

    public static ListNode overturnList(ListNode head) {
        if (head == null || head.next == null)//注意这里是head.next==null
            //也就意味着head一直指向的是尾结点的前一个
            return head;
        //先递归到尾结点，在回溯，将每一个节点依次往res后面连接，直到回溯到最前面
        ListNode res = overturnList(head.next);
        // res是不变的，head.next的值一直指向的是链表末尾
        head.next.next = head;
        head.next = null;

        return res;
    }
    //第二种方法，使用hashmap将节点正向存储后，反向取出连接到tmp后面
    //记录头指针，返回头指针的next
    public ListNode ReverseList2(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode tmp = new ListNode(0);
        ListNode res = tmp;
        for (int i = 0; head != null; i++) {
            map.put(i, head.val);
            head = head.next;
        }
        for (int i = map.size() - 1; i >= 0; i--) {
            int val = map.get(i);
            tmp.next = new ListNode(val);
            tmp = tmp.next;
        }
        return res.next;

    }

}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val + "}";
    }
}
