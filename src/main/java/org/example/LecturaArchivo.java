package org.example;
import java.io.*;
public class LecturaArchivo {
    private final File archivo;
    public LecturaArchivo(String rutaArchivo) {
        this.archivo = new File(rutaArchivo);     }
    public String getNombre() {
        return archivo.getName();     }
    public long getTamanio() {
        return (long) Math.ceil(archivo.length() / 1024.0);     }
    public int getNumLineas() throws IOException {
        int lineas = 0;
        try (FileInputStream fstream = new FileInputStream(archivo);
             InputStreamReader is = new InputStreamReader(
                     fstream,
                     java.nio.charset.StandardCharsets.UTF_8              );
             BufferedReader br = new BufferedReader(is)) {
            while (br.readLine() != null) {                 lineas++;
            }         }
        return lineas;     }
    @Override
    public String toString() {
        try {
            return "LecturaArchivo [nombre=" + getNombre()
                    + ", tamanio=" + getTamanio()
                    + ", numLineas=" + getNumLineas() + "]";
        } catch (IOException e) {
            return "No se pudo leer el archivo: " + e.getMessage();         }
    }
}



