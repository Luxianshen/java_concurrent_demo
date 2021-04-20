package leetCode;

/**
 * @desc：反转链表
 * @date：2021/4/19 4:20 下午
 * @author：Lujs
 */
public class letcode206 {

    public static void main(String[] args) {

        ListNode node = new ListNode(1, null);
        int i = 2;
        while (i < 6) {
            ListNode temp = node;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(i, null);
            ++i;
        }
        reverseList(node);
    }


    public static class ListNode {
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


    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;

        //头部处理
        ListNode reverse;
        ListNode temp = null;
        while (head.next != null) {
            reverse = new ListNode(head.val, temp);
            head = head.next;
            temp = reverse;
        }
        //尾节点
        reverse = new ListNode(head.val, temp);

        return reverse;
    }

}
