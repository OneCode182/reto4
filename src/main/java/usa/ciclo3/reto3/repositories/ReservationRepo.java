/** < - - - - - - - - {  } - - - - - - - - > */

package usa.ciclo3.reto3.repositories;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ciclo3.reto3.models.Reservation;
import usa.ciclo3.reto3.repositories.crud.ReservationInterface;



@Repository
public class ReservationRepo {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    
    @Autowired
    private ReservationInterface crud;
    
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    public List<Reservation> getAll() {
        return (List<Reservation>) crud.findAll();
    }
    
    public Optional<Reservation> getReservation(int id) {
        return crud.findById(id);
    }
    
    public Reservation save(Reservation reservation) {
        return crud.save(reservation);
    }
    
    public void delete(Reservation reservation) {
        crud.delete(reservation);
    }

}


