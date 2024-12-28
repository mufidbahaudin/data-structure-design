// Nama : Mufid Bahaudin Nugroho
// NIM : 22106050021

import java.util.*;

class HashTableExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hashtable<Integer, List<String>> ht = new Hashtable<>();
        boolean running = true;

        while (running) {
            System.out.println("MENU:");
            System.out.println("1. Masukkan string yang akan dikelompokkan");
            System.out.println("2. Hasil pengelompokkan");
            System.out.println("3. Tutup");
            System.out.print("Pilihan Anda: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan string: ");
                    String input = scanner.nextLine();
                    int hash = input.hashCode();
                    if (!ht.containsKey(hash)) {
                        ht.put(hash, new ArrayList<>());
                    }
                    ht.get(hash).add(input);
                    break;

                case 2:
                    System.out.println("Hasil pengelompokkan:");
                    for (Map.Entry<Integer, List<String>> entry : ht.entrySet()) {
                        System.out.println("Hash " + entry.getKey() + ": " + entry.getValue());
                    }
                    break;

                case 3:
                    running = false;
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }

        scanner.close();
    }
}
