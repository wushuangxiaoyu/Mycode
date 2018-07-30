package 其他.morris;

/**
 * ${DESCRIPTION}
 *
 * @author Yu
 * @create 2018-07-28 19:06
 **/
class TravelTree {
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
            cur =cur.right;
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

        morrisTrave2(treeNodes[0]);
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
