/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long denominator = 1, firstValue = 0, secondValue = 0, finalValue = 0;
        ListNode node = new ListNode(0);
        String value;
        while(true){
            if(l1 != null){
                firstValue = (l1.val * denominator) + firstValue;
                denominator = (denominator * 10);
                l1 = l1.next;
            } else {
                break;
            }
        }
        denominator = 1;
        while(true){
            if(l2 != null){
                secondValue = (l2.val * denominator) + secondValue;
                denominator = (denominator * 10);
                l2 = l2.next;
            } else {
                break;
            }
        }
        finalValue = firstValue+secondValue;
        value = Long.toString(finalValue);
        node.val = Character.getNumericValue(value.charAt(0));
        for(int i = 1; i <= value.length()-1; i++){
            ListNode next = new ListNode(Character.getNumericValue(value.charAt(i)));
            next.next = node;
            node = next;
        }
        return node;
    }
}
