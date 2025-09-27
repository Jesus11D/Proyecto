import javax.swing.*;
import java.io.*;
import java.util.*;

public class Proyecto {

    public static void main(String[] args) {
        String menu = """
                      Selecciona una opción:
                      1. Ordenación Interna - Burbuja
                      2. Ordenación Interna - Inserción
                      3. Ordenación Interna - QuickSort
                      4. Ordenación Externa (leer archivo .txt)
                      5. Salir
                      6. Uso de Tablas Hash""";

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion) {
                case 1 -> ejecutarBurbuja();
                case 2 -> ejecutarInsercion();
                case 3 -> ejecutarQuickSort();
                case 4 -> ejecutarOrdenacionExterna();
                case 5 -> JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                case 6 -> ejecutarHash();
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
klñjlk
