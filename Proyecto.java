import javax.swing.*;
import java.io.*;
import java.util.*;

public class Proyecto {

    public static void main(String[] args) {
        String menu = """
                      Selecciona una opci\u00f3n:
                      1. Ordenaci\u00f3n Interna - Burbuja
                      2. Ordenaci\u00f3n Interna - Inserci\u00f3n
                      3. Ordenaci\u00f3n Interna - QuickSort
                      4. Ordenaci\u00f3n Externa (leer archivo .txt)
                      5. Salir""";

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion) {
                case 1 -> ejecutarBurbuja();
                case 2 -> ejecutarInsercion();
                case 3 -> ejecutarQuickSort();
                case 4 -> ejecutarOrdenacionExterna();
                case 5 -> JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                default -> JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        } while (opcion != 5);
    }

    public static void ejecutarBurbuja() {
        int[] arr = {5, 3, 8, 4, 2};
        JOptionPane.showMessageDialog(null, "Arreglo original: " + Arrays.toString(arr));
        long start = System.nanoTime();
        burbuja(arr);
        long end = System.nanoTime();
        JOptionPane.showMessageDialog(null, "Arreglo ordenado: " + Arrays.toString(arr)
                + "\nComplejidad: O(n^2)"
                + "\nTiempo: " + (end - start) + " ns");
    }

    public static void burbuja(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                JOptionPane.showMessageDialog(null, Arrays.toString(arr));
            }
        }
    }

    public static void ejecutarInsercion() {
        int[] arr = {9, 1, 5, 3, 7};
        JOptionPane.showMessageDialog(null, "Arreglo original: " + Arrays.toString(arr));
        long start = System.nanoTime();
        insercion(arr);
        long end = System.nanoTime();
        JOptionPane.showMessageDialog(null, "Arreglo ordenado: " + Arrays.toString(arr)
                + "\nComplejidad: O(n^2)"
                + "\nTiempo: " + (end - start) + " ns");
    }

    public static void insercion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
                JOptionPane.showMessageDialog(null, Arrays.toString(arr));
            }
            arr[j + 1] = key;
        }
    }

    public static void ejecutarQuickSort() {
        int[] arr = {10, 7, 8, 9, 1, 5};
        JOptionPane.showMessageDialog(null, "Arreglo original: " + Arrays.toString(arr));
        long start = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);
        long end = System.nanoTime();
        JOptionPane.showMessageDialog(null, "Arreglo ordenado: " + Arrays.toString(arr)
                + "\nComplejidad promedio: O(n log n)"
                + "\nTiempo: " + (end - start) + " ns");
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            JOptionPane.showMessageDialog(null, Arrays.toString(arr));
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void ejecutarOrdenacionExterna() {
        String ruta = JOptionPane.showInputDialog("Ingrese la ruta del archivo .txt con números separados por espacios:");
        try {
            List<Integer> numeros = new ArrayList<>();
            Scanner sc = new Scanner(new File(ruta));
            while (sc.hasNextInt()) {
                numeros.add(sc.nextInt());
            }
            sc.close();

            int[] arr = numeros.stream().mapToInt(i -> i).toArray();
            JOptionPane.showMessageDialog(null, "Arreglo leído: " + Arrays.toString(arr));

            long start = System.nanoTime();
            mergeSort(arr, 0, arr.length - 1);
            long end = System.nanoTime();

            JOptionPane.showMessageDialog(null, "Arreglo ordenado (externo): " + Arrays.toString(arr)
                    + "\nComplejidad: O(n log n)"
                    + "\nTiempo: " + (end - start) + " ns");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error leyendo el archivo: " + e.getMessage());
        }
    }

    public static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
            JOptionPane.showMessageDialog(null, Arrays.toString(arr));
        }
    }

    public static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
i
