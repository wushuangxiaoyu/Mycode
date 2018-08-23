package 其他.morris;

/**
 * ${DESCRIPTION}
 *
 * @author Yu
 * @create 2018-07-28 19:06
 **/
class TravelTree {

    //后
    private static void morrisTravel3(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                if (mostRight.right == cur) {
                    mostRight.right = null;
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(head);
    }

    private static void printEdge(TreeNode head) {
        TreeNode tail = reverse(head);
        TreeNode cur = tail;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.right;
        }
        reverse(tail);
    }

    private static TreeNode reverse(TreeNode head) {
        if (head == null || head.right == null) {
            return head;
        }
        TreeNode next = head.right;
        TreeNode res = reverse(next);
        next.right = head;
        head.right = null;
        return res;
    }


    //中
    private static void morrisTravel(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                if (mostRight.right == cur) {
                    mostRight.right = null;
                }
            }
            System.out.println(cur.val + " ");
            cur = cur.right;
        }

    }

    //先
    private static void morrisTrave2(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    System.out.println(cur.val + " ");
                    cur = cur.left;
                    continue;
                }
                if (mostRight.right == cur) {
                    mostRight.right = null;
                }
            } else {
                System.out.println(cur.val + " ");
            }
            cur = cur.right;
        }
    }

    public static void main(String[] args) {
        TreeNode[] treeNodes = new TreeNode[7];
        for (int i = 0; i < 7; i++) {
            treeNodes[i] = new TreeNode(i + 1);
        }
        treeNodes[0].left = treeNodes[1];
        treeNodes[0].right = treeNodes[2];
        treeNodes[1].left = treeNodes[3];
        treeNodes[1].right = treeNodes[4];
        treeNodes[3].left = treeNodes[5];
        treeNodes[2].right = treeNodes[6];

        morrisTravel3(treeNodes[0]);
        System.out.println("---");
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
