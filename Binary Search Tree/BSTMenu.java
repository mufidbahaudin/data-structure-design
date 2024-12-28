import java.util.Scanner;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // Insert a new node with given key in BST
    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        // Return the (unchanged) node pointer
        return root;
    }

    // Utility function to search a key in a BST
    Node search(int key) {
        return searchRec(root, key);
    }

    Node searchRec(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.key == key)
            return root;

        // Key is greater than root's key
        if (root.key < key)
            return searchRec(root.right, key);

        // Key is smaller than root's key
        return searchRec(root.left, key);
    }

    // Delete a node
    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        // Base case: if the tree is empty
        if (root == null)
            return root;

        // Otherwise, recur down the tree
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);

        // If key is same as root's key, then this is the node to be deleted
        else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    // In-order traversal
    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Menu driven program
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Mufid Bahaudin Nugroho");
        System.out.println("22106050021 / Informatika B");

        while (true) {
            System.out.println("\nMENU:");
            System.out.println("1. Insert an Element");
            System.out.println("2. Delete an Element");
            System.out.println("3. In-Order Traversal");
            System.out.println("4. Mencari data");
            System.out.println("5. Quit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Inserted Element: ");
                    int insertValue = scanner.nextInt();
                    tree.insert(insertValue);
                    break;
                case 2:
                    System.out.print("Element/data yang akan dihapus: ");
                    int deleteValue = scanner.nextInt();
                    tree.deleteKey(deleteValue);
                    break;
                case 3:
                    System.out.print("In-order traversal: ");
                    tree.inorder();
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Data yang dicari: ");
                    int searchValue = scanner.nextInt();
                    Node result = tree.search(searchValue);
                    if (result != null) {
                        System.out.println(searchValue + " ditemukan di BST.");
                    } else {
                        System.out.println(searchValue + " tidak ditemukan di BST.");
                    }
                    break;
                case 5:
                    System.out.println("Quitting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Pemilihan Invalid, silakan coba lagi!.");
            }
        }
    }
}
