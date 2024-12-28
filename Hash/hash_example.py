# Nama : Mufid Bahaudin Nugroho
# NIM : 22106050021

hashTable = [[] for _ in range(10)]

def checkPrime(n):
    if n <= 1:
        return False

    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False

    return True

def getPrime(n):
    if n % 2 == 0:
        n += 1

    while not checkPrime(n):
        n += 2

    return n

def hashFunction(key):
    # Capacity should be the same as the length of the hashTable
    capacity = len(hashTable)
    return key % capacity

def insertData(key, data):
    index = hashFunction(key)
    hashTable[index].append((key, data))

def removeData(key):
    index = hashFunction(key)
    for i, (k, v) in enumerate(hashTable[index]):
        if k == key:
            del hashTable[index][i]
            break

def main():
    import hashlib
    def getStringHash(s):
        return int(hashlib.md5(s.encode()).hexdigest(), 16)

    running = True
    while running:
        print("MENU:")
        print("1. Masukkan string yang akan dikelompokkan")
        print("2. Hasil pengelompokkan")
        print("3. Tutup")
        choice = int(input("Pilihan Anda: "))

        if choice == 1:
            string = input("Masukkan string: ")
            key = getStringHash(string)
            insertData(key, string)
        elif choice == 2:
            print("Hasil pengelompokkan:")
            for i, entries in enumerate(hashTable):
                if entries:
                    print(f"Hash {i}: {entries}")
        elif choice == 3:
            running = False
            print("Program selesai.")
        else:
            print("Pilihan tidak valid, coba lagi.")

if __name__ == "__main__":
    main()
