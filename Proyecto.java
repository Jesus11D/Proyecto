import javax.swing.*;

public class Burbuja {
    public static void main(String[] args) {
        int[] numeros = {5, 3, 8, 4, 2};

        JOptionPane.showMessageDialog(null, "Arreglo original: " + arrayToString(numeros));

        burbuja(numeros);

        JOptionPane.showMessageDialog(null, "Arreglo final ordenado: " + arrayToString(numeros));
    }

    public static void burbuja(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                JOptionPane.showMessageDialog(
                        null,
                        "Intercambio entre posiciones " + j + " y " + (j + 1) + ":\n" + arrayToString(arr)
                    );
                }
            }
        }
    }

    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int n : arr) {
            sb.append(n).append(" ");
        }
        return sb.toString();
    }
}
