package org.example;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertTrue;
class LecturaArchivoTest {
    private static LecturaArchivo lecturaArchivo;

    @BeforeAll
    static void setUp() {
        Path ruta = Paths.get(
                "src",
                "main",
                "resources",
                "hola.txt"
        ).toAbsolutePath();
        assertTrue(
                Files.exists(ruta),
                "No se encontró el archivo en src/main/resources/hola.txt"
        );
        lecturaArchivo = new LecturaArchivo(ruta.toString());
    }

    @Test
    void testGetNombre() {
        assertEquals(
                "hola.txt",
                lecturaArchivo.getNombre(),
                "El nombre del archivo debe ser hola.txt"
        );
    }

    @Test
    void testGetTamanio() {
        assertEquals(
                1,
                lecturaArchivo.getTamanio(),
                "El tamaño del archivo debe ser 1 KB"
        );
    }

    @Test
    void testGetNumLineas() throws IOException {
        assertEquals(
                3,
                lecturaArchivo.getNumLineas(),
                "El archivo hola.txt debe tener 3 líneas"
        );
    }

    @Test
    void testToString() {
        String esperado =
                "LecturaArchivo [nombre=hola.txt, tamanio=1, numLineas=3]";
        String obtenido = lecturaArchivo.toString();
        assertEquals(
                esperado,
                obtenido,
                "No se ha superado el test.\n"
                        + "Esperado: " + esperado + "\n"
                        + "Obtenido: " + obtenido
        );
    }
}