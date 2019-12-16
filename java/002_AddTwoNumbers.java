class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 大整数相加就有问题了！！！！！！
    // 思路：先将链表转成整数，相加得到整数结果，再将结果还原成链表。
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int v = this.getListValue(l1) + this.getListValue(l2);
        return this.buildList(v);
    }

    private int getListValue(ListNode list) {
        int val = 0;
        int step = 1;
        while (list != null) {
            val += list.val * step;
            step *= 10;
            list = list.next;
        }
        return val;
    }

    private ListNode buildList(int val) {
        ListNode header = null;
        ListNode tail = null;

        if (val == 0) {
            return new ListNode(0);
        }

        while (val != 0) {
            int item = val % 10;
            val = val / 10;

            ListNode node = new ListNode(item);

            if (tail == null) {
                tail = node;
                header = node;
            } else {
                tail.next = node;
            }

            tail = node;

        }
        return header;
    }

    // 走弯路，想到链表反转上去了。。。
    // 其实就是大数相加的问题，不要一开始就钻入数字相加的牛角尖了。先分析题目
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // l1 = this.reverse(l1);
        // l2 = this.reverse(l2);
        boolean overflow = false;
        ListNode header = null;
        ListNode tail = null;
        while (l1 != null || l2 != null || overflow) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int val = v1 + v2;
            if (overflow) {
                val++;
            }
            overflow = val > 9;
            if (overflow) {
                val = val % 10;
            }

            ListNode item = new ListNode(val);

            if (tail == null) {
                header = item;
            } else {
                tail.next = item;
            }
            tail = item;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }

        return header;
    }

    private ListNode reverse(ListNode list) {
        ListNode oldHeader = list;
        ListNode newHeader = null;
        ListNode oldNext = null;
        while (oldHeader != null) {
            oldNext = oldHeader.next;
            oldHeader.next = newHeader;
            newHeader = oldHeader;
            oldHeader = oldNext;
        }

        return newHeader;
    }
}