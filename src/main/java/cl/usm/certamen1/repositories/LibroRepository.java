package cl.usm.certamen1.repositories;
import cl.usm.certamen1.entities.Libro;
import org.springframework.data.mongodb.repository.MongoRepository;

// Repositorio para buscar y guardar los libros
public interface LibroRepository extends MongoRepository<Libro, String> {
}