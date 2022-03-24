package leetCode;

/**
 * @author Lujs
 * @desc done
 * @date 2022/3/24 9:25 PM
 */
public class letcode27 {


    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return true;

        //指针
        int i = 1;
        int j = 1;
        ListNode fast = head;
        ListNode temp;
        ListNode last = null;
        while (fast != null) {

            if (j / i == 2) {
                temp = head.next;
                head.next = last;
                last = head;
                head = temp;
                i++;
            }
            fast = fast.next;
            j++;
        }

        while (head != null && last != null){
            if(head.val == last.val){
                head = head.next;
                last = last.next;
            }else if(head.next != null && head.next.val == last.val){
                head = head.next.next;
                last = last.next;
            }else {
                break;
            }
        }

        return head == null && last == null;

    }

}
