import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Crear un nuevo árbol binario
        BinaryTree<Association<String, String>> dictionary = new BinaryTree<>(new Association<>("", ""));

        // Leer el archivo diccionario.txt e insertar las asociaciones en el árbol
        try (BufferedReader reader = new BufferedReader(new FileReader("diccionario.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.substring(1, line.length() - 1).split(", ");
                dictionary.insert(new Association<>(parts[0].toLowerCase(), parts[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Procesar el archivo de texto y traducir cada palabra
        try (BufferedReader reader = new BufferedReader(new FileReader("texto.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\W+");
                StringBuilder translatedLine = new StringBuilder();
                for (int i = 0; i < words.length; i++) {
                    String word = words[i];
                    Association<String, String> translation = dictionary.search(new Association<>(word.toLowerCase(), null));
                    if (translation != null) {
                        translatedLine.append(translation.value);
                    } else {
                        translatedLine.append("*").append(word).append("*");
                    }
                    if (i < words.length - 1) {
                        translatedLine.append(" ");
                    }
                }
                if (line.endsWith(".")) {
                    translatedLine.append(".");
                }
                System.out.println(translatedLine.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}