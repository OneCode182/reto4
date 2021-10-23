/** < - - - - - - - - {  } - - - - - - - - > */

package usa.ciclo3.reto3.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo3.reto3.models.Client;
import usa.ciclo3.reto3.repositories.ClientRepo;


@Service
public class ClientService {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    
    @Autowired
    private ClientRepo metodosCrud;
    
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    public List<Client> getAll() {
        return metodosCrud.getAll();
    }
    
    public Optional<Client> getClient(int clientId) {
        return metodosCrud.getClient(clientId);
    }
    
    public Client save(Client client) {
        if (client.getIdClient()== null) {
            return metodosCrud.save(client);
            
        } else {
            Optional<Client> evt = metodosCrud.getClient(client.getIdClient());
            
            if (evt.isEmpty()) {
                return metodosCrud.save(client);
                
            } else {
                return client;
                
            }
            
        }
        
    }
    
    public Client update(Client client){
        if(client.getIdClient()!= null){
            Optional<Client> e = metodosCrud.getClient(client.getIdClient());
            
            if(!e.isEmpty()){
                if(client.getEmail() != null){
                    e.get().setEmail(client.getEmail());
                }
                
                if(client.getPassword() != null){
                    e.get().setPassword(client.getPassword());
                }
                
                if(client.getName() != null){
                    e.get().setName(client.getName());
                }
                
                if(client.getAge() != null){
                    e.get().setAge(client.getAge());
                }
                
                
                return metodosCrud.save(e.get());
                
            }else{
                return client;
                
            }
            
        }else{
            return client;
            
        }
        
    }
    
    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            
            metodosCrud.delete(client);
            return true;
            
        }).orElse(false);
        
        return aBoolean;
        
    }
    
}


