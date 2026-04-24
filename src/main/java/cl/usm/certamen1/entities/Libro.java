package cl.usm.certamen1.entities;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;

// Datos de los libros

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "libros")


public class Libro implements Serializable {

    @Id
    @NotBlank(message = "ISBN es obligatorio")
    @Size(min = 13, max = 13, message = "El ISBN debe tener 13 caracteres")
    private String isbn;

    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @NotBlank(message = "El autor es obligatorio")
    private String autor;

    @Min(value = 11, message = "La cantidad de páginas deben ser más de 10")
    private int paginas;

    @NotBlank(message = "La categoría es obligatoria")
    private String categoria;
}