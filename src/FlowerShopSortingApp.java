import java.util.Scanner;

public class FlowerShopSortingApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=======================================");
        System.out.println("|      Aplikasi Pengurutan Bunga      |");
        System.out.println("=======================================");

        // Input jumlah bunga
        System.out.println("|-------------------------------------|");
        System.out.print("| Masukkan jumlah bunga: ");
        int n = scanner.nextInt();

        String[] flowerNames = new String[n];
        double[] flowerPrices = new double[n];

        // Input nama dan harga bunga
        System.out.println("| Masukkan nama dan harga bunga:      |");
        System.out.println("|-------------------------------------|");
        for (int i = 0; i < n; i++) {
            System.out.printf("| Nama Bunga ke-%d: ", i + 1);
            flowerNames[i] = scanner.next();
            System.out.printf("| Harga Bunga ke-%d: ", i + 1);
            flowerPrices[i] = scanner.nextDouble();
            System.out.println("|-------------------------------------|");
        }

        // Loop untuk mengulang pilihan sorting
        boolean exit = false;
        while (!exit) {
            // Pilihan sorting berdasarkan atribut
            System.out.println("\n=======================================");
            System.out.println("|        Pilih Atribut Sorting        |");
            System.out.println("|-------------------------------------|");
            System.out.println("| 1. Sorting Berdasarkan Harga        |");
            System.out.println("| 2. Sorting Berdasarkan Nama         |");
            System.out.println("| 3. Keluar                           |");
            System.out.println("=======================================");
            System.out.print("| Pilihan Anda (1/2/3): ");
            int attributeChoice = scanner.nextInt();

            if (attributeChoice == 3) {
                exit = true;
                System.out.println("=======================================");
                System.out.println("|   Terima Kasih Telah Menggunakan    |");
                System.out.println("|        Aplikasi Pengurutan          |");
                System.out.println("=======================================");
                break;
            }

            if (attributeChoice < 1 || attributeChoice > 3) {
                System.out.println("| Pilihan tidak valid! Silakan coba lagi. |");
                continue;
            }

            // Pilihan metode sorting
            System.out.println("\n=======================================");
            System.out.println("|         Pilih Metode Sorting        |");
            System.out.println("|-------------------------------------|");
            System.out.println("| 1. Selection Sort                   |");
            System.out.println("| 2. Bubble Sort                      |");
            System.out.println("=======================================");
            System.out.print("| Pilihan Anda (1/2): ");
            int methodChoice = scanner.nextInt();

            if (methodChoice < 1 || methodChoice > 2) {
                System.out.println("| Pilihan tidak valid! Silakan coba lagi. |");
                continue;
            }

            boolean ascending = true;

            // Pilihan arah pengurutan
            if (attributeChoice == 1) {
                System.out.println("\n=======================================");
                System.out.println("|        Pilih Arah Pengurutan        |");
                System.out.println("|-------------------------------------|");
                System.out.println("| 1. Termurah ke Termahal (Ascending) |");
                System.out.println("| 2. Termahal ke Termurah (Descending)|");
                System.out.println("=======================================");
                System.out.print("| Pilihan Anda (1/2): ");
                int orderChoice = scanner.nextInt();

                if (orderChoice == 2) ascending = false;
                if (orderChoice < 1 || orderChoice > 2) {
                    System.out.println("| Pilihan tidak valid! Silakan coba lagi. |");
                    continue;
                }
            } else if (attributeChoice == 2) {
                System.out.println("\n=======================================");
                System.out.println("|        Pilih Arah Pengurutan        |");
                System.out.println("|-------------------------------------|");
                System.out.println("| 1. A-Z                              |");
                System.out.println("| 2. Z-A                              |");
                System.out.println("=======================================");
                System.out.print("| Pilihan Anda (1/2): ");
                int orderChoice = scanner.nextInt();

                if (orderChoice == 2) ascending = false;
                if (orderChoice < 1 || orderChoice > 2) {
                    System.out.println("| Pilihan tidak valid! Silakan coba lagi. |");
                    continue;
                }
            }

            // Tampilkan data sebelum sorting
            System.out.println("\n=======================================");
            System.out.println("|     Data Bunga Sebelum Sorting      |");
            System.out.println("=======================================");
            SortingUtils.displayFlowers(flowerNames, flowerPrices);

            // Sorting berdasarkan pilihan metode dan arah
            if (attributeChoice == 1) { // Sorting harga
                if (methodChoice == 1) {
                    SortingUtils.selectionSort(flowerPrices, flowerNames, ascending);
                } else if (methodChoice == 2) {
                    SortingUtils.bubbleSort(flowerPrices, flowerNames, ascending);
                }
            } else if (attributeChoice == 2) { // Sorting nama
                if (methodChoice == 1) {
                    SortingUtils.sortByName(flowerNames, flowerPrices, ascending);
                } else if (methodChoice == 2) {
                    SortingUtils.bubbleSortByName(flowerNames, flowerPrices, ascending);
                }
            }

            // Tampilkan data setelah sorting
            System.out.println("\n=======================================");
            System.out.println("|      Data Bunga Setelah Sorting     |");
            System.out.println("=======================================");
            SortingUtils.displayFlowers(flowerNames, flowerPrices);
        }

        scanner.close();
    }
}
