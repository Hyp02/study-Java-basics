package leetCode.hot100;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class _21_ListNodeAdd {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode(0);//创建存储结果的链表，头结点为 0
        ListNode res = temp;//记录头结点地址，指向头结点
        //循环直到有一条链表指向null
        while (list1 != null && list2 != null) {
            //如果第一条链表指向的元素小于第二条链表指向的元素
            if (list1.val <= list2.val) {
                temp.next = list1;//结果链表指向第一条所指的节点
                list1 = list1.next;//连接了第一条链表节点，像后移动 准备下一轮循环作比较
            } else {//如果如果第一条链表指向的元素大于第二条链表指向的元素
                temp.next = list2;//将list2所指的节点连接
                list2 = list2.next;
            }
            temp = temp.next;//每次连接结果链表都要指向新节点

        }
        //因为链表上得元素是递增的
        //所以当某一条链表节点都被连接完了，直接让 结果链表 指向另一条链表剩余的部分
        if (list1 == null) {
            temp.next = list2;
        }
        if (list2 == null) {
            temp.next = list1;
        }
        return res.next;//然后返回头结点的下一个，因为头结点不能返回（题目要求）
    }
}

