import java.io.*;
import java.util.*;
import javax.swing.*;

public class BusquedaInvertida {

    static Map<String, Set<String>> indiceInvertido = new HashMap<>();
    static List<String> listaDocumentos = new ArrayList<>();

    public static void main(String[] args) {
        try {
            inicializarDocumentos();
            indexarDocumentos();

            String palabra = JOptionPane.showInputDialog("Ingrese palabra a buscar:");
            Set<String> resultados = buscarPalabra(palabra.toLowerCase());

            StringBuilder sb = new StringBuilder();
            sb.append("Diccionario de términos:\n");
            for (String termino : indiceInvertido.keySet()) {
                sb.append(termino).append(" -> ").append(indiceInvertido.get(termino)).append("\n");
            }
            sb.append("\nLista de documentos:\n");
            for (String doc : listaDocumentos) sb.append(doc).append("\n");

            sb.append("\nResultados de búsqueda para '").append(palabra).append("':\n");
            if (resultados.isEmpty()) sb.append("No se encontró en ningún documento");
            else for (String doc : resultados) sb.append("- ").append(doc).append("\n");

            JOptionPane.showMessageDialog(null, sb.toString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    static void inicializarDocumentos() throws IOException {
        for (int i = 1; i <= 3; i++) {
            File f = new File("doc" + i + ".txt");
            if (!f.exists()) {
                try (PrintWriter pw = new PrintWriter(f)) {
                    if (i == 1) pw.println("El zorro veloz corre por el bosque");
                    if (i == 2) pw.println("El perro duerme bajo el arbol");
                    if (i == 3) pw.println("El gato salta sobre el muro veloz");
                }
            }
            listaDocumentos.add(f.getName());
        }
    }

    static void indexarDocumentos() throws IOException {
        for (String nombreDoc : listaDocumentos) {
            try (BufferedReader br = new BufferedReader(new FileReader(nombreDoc))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] palabras = linea.toLowerCase().replaceAll("[^a-záéíóúñ ]", "").split("\\s+");
                    for (String p : palabras) {
                        if (!indiceInvertido.containsKey(p)) indiceInvertido.put(p, new HashSet<>());
                        indiceInvertido.get(p).add(nombreDoc);
                    }
                }
            }
        }
    }

    static Set<String> buscarPalabra(String palabra) {
        return indiceInvertido.getOrDefault(palabra.toLowerCase(), new HashSet<>());
    }
}d
asdada
