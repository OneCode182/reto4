/** < - - - - - - - - {  } - - - - - - - - > */

package usa.ciclo3.reto3.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "message")
public class Message implements Serializable {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    
    // Atributos base
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;
    
    
    
    
    /** < - - - - - - - - { Relaciones } - - - - - - - - > */
    
    // Maquinas
    @ManyToOne 
    @JoinColumn(name = "id")
    @JsonIgnoreProperties({"messages", "client", "reservations"})
    private Machine machine;
    
    // Clientes
    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"messages", "reservations", "client"})
    private Client client;

    
    
    
    /** < - - - - - - - - { Getter & Setter } - - - - - - - - > */
    
    
    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
}


