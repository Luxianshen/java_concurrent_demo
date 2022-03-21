package leetCode;

import java.util.List;

/**
 * @desc：TODO
 * @date：2021/3/23 4:27 下午
 * @author：Lujs
 */
public class letcode24 {

    /**
     * 1->2->3->4->5->NULL
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseList(ListNode head) {

        return head;
    }

    public static void main(String[] args) {

        ListNode cur = new ListNode(1);
        ListNode temp = cur;
        //i 1-5
        int i = 2;
        while (i < 6) {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(i);
            i++;
        }

        //1- 2-3-4-5
        // 断开1 1，null
        //给pre
        // 2-3-4-5 还给listNode
        //5-1
        ListNode pre = null;
        while (cur != null) {
            ListNode rest = cur.next;
            cur.next = pre;
            pre = cur;
            cur = rest;
        }

    }


}
