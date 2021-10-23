/** < - - - - - - - - {  } - - - - - - - - > */

package usa.ciclo3.reto3.repositories;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ciclo3.reto3.models.Client;
import usa.ciclo3.reto3.repositories.crud.ClientInterface;



@Repository
public class ClientRepo {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    
    @Autowired
    private ClientInterface crud;
    
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    public List<Client> getAll() {
        return (List<Client>) crud.findAll();
    }
    
    public Optional<Client> getClient(int id) {
        return crud.findById(id);
    }
    
    public Client save(Client client) {
        return crud.save(client);
    }
    
    public void delete(Client client) {
        crud.delete(client);
    }
    
    

}


