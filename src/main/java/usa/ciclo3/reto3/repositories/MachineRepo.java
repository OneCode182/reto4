/** < - - - - - - - - {  } - - - - - - - - > */

package usa.ciclo3.reto3.repositories;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ciclo3.reto3.models.Machine;
import usa.ciclo3.reto3.repositories.crud.MachineInterface;



@Repository
public class MachineRepo {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    @Autowired
    private MachineInterface crud;
    
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    public List<Machine> getAll() {
        return (List<Machine>) crud.findAll();
    }
    
    public Optional<Machine> getMachine(int id) {
        return crud.findById(id);
    }
    
    public Machine save(Machine machine) {
        return crud.save(machine);
    }
    
    public void delete(Machine machine) {
        crud.delete(machine);
    }

}


