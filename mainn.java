class Node {
    int data;
    Node left, right;

    public Node(int value) {
        data = value;
        left = right = null;
    }
}

class mainn {
    Node root;

    
    Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }
        return root; 
    }

    
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

   
    boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (key < root.data) {
            return search(root.left, key);
        }
        return search(root.right, key);
    }
}

public class mainn {
    public static void main(String[] args) {
        BST tree = new BST();

        
        int values[] = { 50, 30, 20, 40, 70, 60, 80 };
        for (int val : values) {
            tree.root = tree.insert(tree.root, val);
        }

        
        System.out.print("Inorder Traversal: ");
        tree.inorder(tree.root); // Output: 20 30 40 50 60 70 80
        System.out.println();

       
        int key = 60;
        if (tree.search(tree.root, key)) {
            System.out.println(key + " found in BST");
        } else {
            System.out.println(key + " not found in BST");
        }
    }
}
