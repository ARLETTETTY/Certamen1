package cl.usm.certamen1.controllers;
import cl.usm.certamen1.entities.Libro;
import cl.usm.certamen1.services.LibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibroController {

    @Autowired
    private LibroService libroService;

    // Obtener libros
    @GetMapping("/libros")
    public ResponseEntity<List<Libro>> getLibros(
            @RequestParam(required = false) String search) {
        try {
            if (search != null && !search.isEmpty()) {
                return ResponseEntity.ok(libroService.search(search));
            }
            return ResponseEntity.ok(libroService.getAll());
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Creación de libro
    @PostMapping("/crearLibro")
    public ResponseEntity<?> crearLibro(@RequestBody @Valid Libro libro) {
        try {
            Libro res = libroService.crearLibro(libro);
            return ResponseEntity.ok(res);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Obtener libros por su autor
    @GetMapping("/libros/{autor}")
    public ResponseEntity<?> getByAutor(@PathVariable String autor) {
        try {
            List<Libro> libros = libroService.getByAutor(autor);
            if (libros.isEmpty()) {
                return ResponseEntity.status(404).body("Autor no detectado");
            }
            return ResponseEntity.ok(libros);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
}