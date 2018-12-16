
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import redis.clients.jedis.Jedis;

//  Definition for singly-linked list.


public class Solution {

    private Jedis jedis;


    public ListNode reverse1(ListNode node){
        ListNode pre = null;
        ListNode temp = null;
        while (node != null){
            temp = node.next;
            node.next = pre;//第一次这是个最终节点，所以下一个节点是没有数据的.第二次是倒数第二个数据，这个时候，它的next指向第一个数据。也就是pre。
            pre = node;
            node = temp;
        }
        return pre;
    }

    public void sss() {
        ListNode node = new ListNode(1);
        for (int i = 2; i <= 5; i++) {
            node = node.next;
            node.val = i;
        }
        removeNthFromEnd(node,2);
        while (node.next != null)
            System.out.println(node.val);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int add = 0;
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[10];
        Arrays.fill(arr,0);
        while(head.next != null){
            list.add(head.val);
            head = head.next;
            add++;
        }
        if(n>add){
            return head;
        }
        ListNode node = new ListNode(0);
        for(int i=0;i<list.size();i++){
            if(i == list.size()-n+1){
                continue;
            }
            node.val = list.get(i);
            node = node.next;
        }
        return node;

    }

    @Test
    public void reverseTest(){
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(3);
        ListNode three = new ListNode(4);
        head.next = one;
        one.next = two;
        two.next = three;

        ListNode hh = reverse(head);
        while (hh.next != null)
            System.out.println(hh.val);
        System.out.println(hh.val);
    }

    public ListNode reverse(ListNode node){
        if (node == null || node.next == null)
            return node;
        ListNode pre = null;
        ListNode help = null;
        while (node != null){
            help = node.next;
            node.next = pre;
            pre = node;
            node = help;
        }

        return pre;
    }


    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
