package org.example;
import java.net.URL;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {
        URL resource = Main.class
                .getClassLoader()
                .getResource("hola.txt");
        if (resource == null) {
            throw new IllegalArgumentException(
                    "No se encontró hola.txt en src/main/resources"
            );
        }
        String ruta = Paths.get(resource.toURI()).toString();
        LecturaArchivo lectura = new LecturaArchivo(ruta);
        System.out.println("Nombre: " + lectura.getNombre());
        System.out.println("Tamaño: " + lectura.getTamanio() + " KB");
        System.out.println("Número de líneas: " + lectura.getNumLineas());
        System.out.println("Resumen: " + lectura);     }
}
