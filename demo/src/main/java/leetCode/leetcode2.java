package leetCode;

/**
 * @author Lujs
 * @desc 解决
 * @date 2021/11/29 3:41 下午
 */
public class leetcode2 {

    public static void main(String[] args) {

        //342 + 465 = 807.
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));

        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode tail = result;
        int carry = 0;
        int sum;
        while (l1 != null || l2 != null) {

            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;

            sum = n1 + n2 + carry;

            carry = sum / 10;
            tail.next = new ListNode(sum % 10);

            tail = tail.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            tail.next = new ListNode(carry);
        }
        return result.next;
    }


}
