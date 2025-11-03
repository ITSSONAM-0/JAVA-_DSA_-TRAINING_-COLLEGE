class Node {
    int key;
    Node left, right;

    Node(int i) {
        key = i;
        left = right = null;
    }
}

public class BinaryTree {
    Node root;

    public void TraverseTree(Node node) {
        if (node != null) {
            TraverseTree(node.left);
            System.out.println("" + node.key);
            TraverseTree(node.right);
        }
    }

    // Preorder (Root → Left → Right)
    public void Preorder(Node node) {
        if (node != null) {
            System.out.println(node.key);
            Preorder(node.left);
            Preorder(node.right);
        }
    }

    // Postorder (Left → Right → Root)
    public void Postorder(Node node) {
        if (node != null) {
            Postorder(node.left);
            Postorder(node.right);
            System.out.println(node.key);
        }
    }

    // inorder traversal
    public static void main(String[] args) {
        BinaryTree list = new BinaryTree();
        list.root = new Node(1);
        list.root.left = new Node(2);
        list.root.right = new Node(3);
        list.root.left.left = new Node(4);
        list.root.left.right = new Node(5);
        System.out.println("Binary Tree: ");
        list.TraverseTree(list.root);
        System.out.println("Preorder: ");
        list.Preorder(list.root);

        System.out.println("Postorder: ");
        list.Postorder(list.root);
    }
}