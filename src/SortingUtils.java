public class SortingUtils {

    // Method untuk Selection Sort harga
    public static void selectionSort(double[] prices, String[] names, boolean ascending) {
        int n = prices.length;
        for (int i = 0; i < n - 1; i++) {
            int targetIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (ascending ? prices[j] < prices[targetIndex] : prices[j] > prices[targetIndex]) {
                    targetIndex = j;
                }
            }
            swap(prices, names, i, targetIndex);
        }
    }

    // Method untuk Bubble Sort harga
    public static void bubbleSort(double[] prices, String[] names, boolean ascending) {
        int n = prices.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (ascending ? prices[j] > prices[j + 1] : prices[j] < prices[j + 1]) {
                    swap(prices, names, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break; // Jika tidak ada swap, berarti sudah terurut
        }
    }

    // Method untuk Selection Sort nama
    public static void sortByName(String[] names, double[] prices, boolean ascending) {
        int n = names.length;
        for (int i = 0; i < n - 1; i++) {
            int targetIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (ascending ? names[j].compareTo(names[targetIndex]) < 0 : names[j].compareTo(names[targetIndex]) > 0) {
                    targetIndex = j;
                }
            }
            swap(prices, names, i, targetIndex);
        }
    }

    // Method untuk Bubble Sort nama
    public static void bubbleSortByName(String[] names, double[] prices, boolean ascending) {
        int n = names.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (ascending ? names[j].compareTo(names[j + 1]) > 0 : names[j].compareTo(names[j + 1]) < 0) {
                    swap(prices, names, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Utility untuk swap harga dan nama
    private static void swap(double[] prices, String[] names, int i, int j) {
        double tempPrice = prices[i];
        prices[i] = prices[j];
        prices[j] = tempPrice;

        String tempName = names[i];
        names[i] = names[j];
        names[j] = tempName;
    }

    // Method untuk menampilkan daftar bunga dan harga
    public static void displayFlowers(String[] names, double[] prices) {
        System.out.printf("| %-15s | %-10s |\n", "Nama Bunga", "Harga");
        System.out.println("|-----------------|------------|");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("| %-15s | Rp%8.2f |\n", names[i], prices[i]);
        }
        System.out.println("|-----------------|------------|");
    }
}
