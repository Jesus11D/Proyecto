import java.awt.HeadlessException;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Ordenaciones {
    
    public static void main(String[] args) throws FileNotFoundException {
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
asd
