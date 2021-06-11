class BinaryTree {
    // root of binary tree
    TreeNode root;

    public void order() {
        inOrder(root);
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.printf("%s ", node.data.name);
        inOrder(node.right);
    }
}