/** < - - - - - - - - {  } - - - - - - - - > */


package usa.ciclo3.reto3.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;



@Entity
@Table(name = "machine")
public class Machine implements Serializable {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    
    // Atributos base
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;
    
    
    
    /** < - - - - - - - - { Relaciones } - - - - - - - - > */
    
    // Categorias
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("machines")
    private Category category;
    
    
    // Messages
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "machine")
    @JsonIgnoreProperties({"machine", "client"})
    private List<Message> messages;
    
    
    // Reservations
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "machine")
    @JsonIgnoreProperties({"machine", "client"})
    private List<Reservation> reservations;

    
    
    
    /** < - - - - - - - - { Getter & Setter } - - - - - - - - > */
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
}


