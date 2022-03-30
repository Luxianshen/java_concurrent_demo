package leetCode;

/**
 * @author Lujs
 * @desc solution
 * @date 2022/3/28 10:25 PM
 */
public class letcode19 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        int i = 2;
        while (i < 6) {
            temp.next = new ListNode(i);
            temp = temp.next;
            i++;
        }

        //ListNode result = removeNthFromEnd(head, 0);
        ListNode result1 = removeNthFromEnd(head, 1);
        ListNode result2 = removeNthFromEnd(head, 2);
        ListNode result3 = removeNthFromEnd(head, 3);
        ListNode result4 = removeNthFromEnd(head, 4);
        ListNode result5 = removeNthFromEnd(head, 5);

        System.out.println("123");
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) return head;
        if (head.next == null && n == 1) return null;
        //双指针
        int f = 0;
        int l = 0;
        ListNode fast = head;
        ListNode last = head;
        while (fast.next != null) {
            fast = fast.next;
            f++;
            if (f - l > n) {
                l++;
                last = last.next;
            }
        }

        //刚好最后一个
        if (l==0 && f + 1 == n) {
            head = head.next;
        }
        //正常移动
        if (l > 0) {
            last.next = last.next.next;
        }
        //长度不够
        if (l == 0) return head;
        return head;
    }

}
