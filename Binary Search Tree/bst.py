print("Nama : Mufid Bahaudin Nugroho")
print("22106050021")
print("Informatika B")
print("====================================")

class Node:
    # Constructor to create a new node
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None

# A utility function to insert a new node with the given key in BST
def insert(node, key):
    # If the tree is empty, return a new node
    if node is None:
        return Node(key)

    # Otherwise, recur down the tree
    if key < node.key:
        node.left = insert(node.left, key)
    elif key > node.key:
        node.right = insert(node.right, key)

    # Return the (unchanged) node pointer
    return node

# Utility function to search a key in a BST
def search(root, key):
    # Base Cases: root is null or key is present at root
    if root is None or root.key == key:
        return root

    # Key is greater than root's key
    if root.key < key:
        return search(root.right, key)

    # Key is smaller than root's key
    return search(root.left, key)

# Utility function to perform in-order traversal of the BST
def inorder(root):
    if root:
        inorder(root.left)
        print(root.key, end=' ')
        inorder(root.right)

# Utility function to delete a node with the given key from BST
def delete_node(root, key):
    # Base case: If the tree is empty
    if root is None:
        return root

    # Recur down the tree
    if key < root.key:
        root.left = delete_node(root.left, key)
    elif key > root.key:
        root.right = delete_node(root.right, key)
    else:
        # Node with only one child or no child
        if root.left is None:
            return root.right
        elif root.right is None:
            return root.left

        # Node with two children: Get the inorder successor (smallest in the right subtree)
        min_val_node = min_value_node(root.right)
        root.key = min_val_node.key
        root.right = delete_node(root.right, min_val_node.key)

    return root

# Utility function to find the node with the smallest key
def min_value_node(node):
    current = node
    while current.left is not None:
        current = current.left
    return current

# Menu-driven program
def main():
    root = None

    while True:
        print("\nMENU:")
        print("1. Insert an Element")
        print("2. Delete an Element")
        print("3. In-Order Traversal")
        print("4. Mencari data")
        print("5. Quit")

        choice = int(input("Enter your choice: "))
        if choice == 1:
            key = int(input("Inserted Element: "))
            root = insert(root, key)
        elif choice == 2:
            key = int(input("Element/data yang akan dihapus: "))
            root = delete_node(root, key)
        elif choice == 3:
            print("In-order traversal: ", end='')
            inorder(root)
            print()
        elif choice == 4:
            key = int(input("Data yang dicari: "))
            result = search(root, key)
            if result is not None:
                print(f"{key} ditemukan di BST.")
            else:
                print(f"{key} tidak ditemukan di BST.")
        elif choice == 5:
            print("Quitting...")
            break
        else:
            print("Pilihan invalid, silakan coba lagi!")

if __name__ == "__main__":
    main()
