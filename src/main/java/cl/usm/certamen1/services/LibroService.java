package cl.usm.certamen1.services;
import cl.usm.certamen1.entities.Libro;
import cl.usm.certamen1.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {

    // variable de repositorio
    @Autowired
    private LibroRepository libroRepository;

    // crea el libro
    public Libro crearLibro(Libro libro) {
        return this.libroRepository.insert(libro);
    }

    // obtiene todos los libros
    public List<Libro> getAll() {
        return this.libroRepository.findAll();
    }

    // busca todos los libros
    public List<Libro> search(String query) {
        return this.getAll().stream()
                .filter(l -> l.getTitulo().toLowerCase().contains(query.toLowerCase())
                        || l.getAutor().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
    // obtiene los autores
    public List<Libro> getByAutor(String autor) {
        return this.getAll().stream()
                .filter(l -> l.getAutor().equalsIgnoreCase(autor))
                .collect(Collectors.toList());
    }
}