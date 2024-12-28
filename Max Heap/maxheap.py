print("Nama : Mufid Bahaudin Nugroho")
print("22106050021")
print("Informatika B")
print("====================================")

class MaxHeap:
    def __init__(self, maxSize):
        self.maxSize = maxSize
        self.arr = [None] * maxSize
        self.heapSize = 0

    def MaxHeapify(self, i):
        l = self.lChild(i)
        r = self.rChild(i)
        largest = i
        if l < self.heapSize and self.arr[l] > self.arr[i]:
            largest = l
        if r < self.heapSize and self.arr[r] > self.arr[largest]:
            largest = r
        if largest != i:
            self.arr[i], self.arr[largest] = self.arr[largest], self.arr[i]
            self.MaxHeapify(largest)

    def parent(self, i):
        return (i - 1) // 2

    def lChild(self, i):
        return (2 * i + 1)

    def rChild(self, i):
        return (2 * i + 2)

    def removeMax(self):
        if self.heapSize <= 0:
            return None
        if self.heapSize == 1:
            self.heapSize -= 1
            return self.arr[0]
        root = self.arr[0]
        self.arr[0] = self.arr[self.heapSize - 1]
        self.heapSize -= 1
        self.MaxHeapify(0)
        return root

    def increaseKey(self, i, newVal):
        self.arr[i] = newVal
        while i != 0 and self.arr[self.parent(i)] < self.arr[i]:
            self.arr[i], self.arr[self.parent(i)] = self.arr[self.parent(i)], self.arr[i]
            i = self.parent(i)

    def getMax(self):
        return self.arr[0]

    def curSize(self):
        return self.heapSize

    def deleteKey(self, i):
        self.increaseKey(i, float("inf"))
        self.removeMax()

    def insertKey(self, x):
        if self.heapSize == self.maxSize:
            print("\nOverflow: Could not insertKey\n")
            return
        self.heapSize += 1
        i = self.heapSize - 1
        self.arr[i] = x
        while i != 0 and self.arr[self.parent(i)] < self.arr[i]:
            self.arr[i], self.arr[self.parent(i)] = self.arr[self.parent(i)], self.arr[i]
            i = self.parent(i)

    def printHeapArray(self):
        print("-".join(str(self.arr[i]) for i in range(self.heapSize)))

    def printHeapTree(self, i=0, depth=0):
        if i < self.heapSize:
            if i == 0:
                print(f"Root: {self.arr[i]}")
            l = self.lChild(i)
            r = self.rChild(i)
            if l < self.heapSize:
                print(f"LChild of {self.arr[i]}: {self.arr[l]}")
            if r < self.heapSize:
                print(f"RChild of {self.arr[i]}: {self.arr[r]}")
            if l < self.heapSize:
                self.printHeapTree(l, depth + 1)
            if r < self.heapSize:
                self.printHeapTree(r, depth + 1)


if __name__ == '__main__':
    h = MaxHeap(15)
    while True:
        print("\nMENU:")
        print("1. Insert Element")
        print("2. Remove Max Element")
        print("3. Delete an Element at Index")
        print("4. Print MaxHeap V.1 (print array)")
        print("5. Print MaxHeap V.2")
        print("6. Quit")
        choice = int(input("Enter your choice: "))

        if choice == 1:
            element = int(input("Inserted Element:? "))
            h.insertKey(element)
        elif choice == 2:
            print("Removed Max Element: " + str(h.removeMax()))
        elif choice == 3:
            index = int(input("Delete Element at Index:? "))
            h.deleteKey(index)
        elif choice == 4:
            print("Heap Array: ", end="")
            h.printHeapArray()
        elif choice == 5:
            print("Heap Tree:")
            h.printHeapTree()
        elif choice == 6:
            print("Exiting...")
            break
        else:
            print("Invalid choice. Please try again.")
