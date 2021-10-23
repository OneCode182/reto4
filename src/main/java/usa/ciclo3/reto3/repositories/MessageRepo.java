/** < - - - - - - - - {  } - - - - - - - - > */

package usa.ciclo3.reto3.repositories;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ciclo3.reto3.models.Message;
import usa.ciclo3.reto3.repositories.crud.MessageInterface;



@Repository
public class MessageRepo {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    
    @Autowired
    private MessageInterface crud;
    
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    public List<Message> getAll() {
        return (List<Message>) crud.findAll();
    }
    
    public Optional<Message> getMessage(int id) {
        return crud.findById(id);
    }
    
    public Message save(Message message) {
        return crud.save(message);
    }
    
    public void delete(Message message) {
        crud.delete(message);
    }

}


