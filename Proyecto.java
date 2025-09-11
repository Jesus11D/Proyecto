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
