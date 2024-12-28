import java.util.Arrays;
import java.util.Scanner;

public class MaxHeap {
    int[] arr;
    int maxSize;
    int heapSize;

    MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        heapSize = 0;
    }

    void MaxHeapify(int i) {
        int l = lChild(i);
        int r = rChild(i);
        int largest = i;
        if (l < heapSize && arr[l] > arr[i])
            largest = l;
        if (r < heapSize && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            MaxHeapify(largest);
        }
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int lChild(int i) {
        return (2 * i + 1);
    }

    int rChild(int i) {
        return (2 * i + 2);
    }

    int removeMax() {
        if (heapSize <= 0)
            return Integer.MIN_VALUE;
        if (heapSize == 1) {
            heapSize--;
            return arr[0];
        }
        int root = arr[0];
        arr[0] = arr[heapSize - 1];
        heapSize--;
        MaxHeapify(0);
        return root;
    }

    void increaseKey(int i, int newVal) {
        arr[i] = newVal;
        while (i != 0 && arr[parent(i)] < arr[i]) {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }
    }

    int getMax() {
        return arr[0];
    }

    int curSize() {
        return heapSize;
    }

    void deleteKey(int i) {
        increaseKey(i, Integer.MAX_VALUE);
        removeMax();
    }

    void insertKey(int x) {
        if (heapSize == maxSize) {
            System.out.println("\nOverflow: Could not insertKey\n");
            return;
        }
        heapSize++;
        int i = heapSize - 1;
        arr[i] = x;
        while (i != 0 && arr[parent(i)] < arr[i]) {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }
    }

    void printHeapArray() {
        for (int i = 0; i < heapSize; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void printHeapTree() {
        if (heapSize > 0) {
            System.out.println("Root: " + arr[0]);
            printHeapChildren(0);
        }
    }

    void printHeapChildren(int i) {
        int l = lChild(i);
        int r = rChild(i);
        if (l < heapSize) {
            System.out.println("LChild of " + arr[i] + ": " + arr[l]);
            printHeapChildren(l);
        }
        if (r < heapSize) {
            System.out.println("RChild of " + arr[i] + ": " + arr[r]);
            printHeapChildren(r);
        }
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(15);
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Mufid Bahaudin Nugroho");
        System.out.println("22106050021 / Informatika B");

        do {
            System.out.println("\nMENU:");
            System.out.println("1. Insert Element");
            System.out.println("2. Remove Max Element");
            System.out.println("3. Delete an Element at Index");
            System.out.println("4. Print MaxHeap V.1 (print array)");
            System.out.println("5. Print MaxHeap V.2 (print tree)");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Inserted Element:? ");
                    int element = scanner.nextInt();
                    heap.insertKey(element);
                    break;
                case 2:
                    System.out.println("Removed Max Element: " + heap.removeMax());
                    break;
                case 3:
                    System.out.print("Delete Element at Index:? ");
                    int index = scanner.nextInt();
                    heap.deleteKey(index);
                    break;
                case 4:
                    System.out.print("Heap Array: ");
                    heap.printHeapArray();
                    break;
                case 5:
                    System.out.println("Heap Tree:");
                    heap.printHeapTree();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Pemilihan Invalid, silakan coba lagi!.");
                    break;
            }
        } while (choice != 6);

        scanner.close();
    }
}
