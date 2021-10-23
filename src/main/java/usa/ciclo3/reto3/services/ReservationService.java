/** < - - - - - - - - {  } - - - - - - - - > */

package usa.ciclo3.reto3.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo3.reto3.models.Reservation;
import usa.ciclo3.reto3.repositories.ReservationRepo;


@Service
public class ReservationService {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    
    @Autowired
    private ReservationRepo metodosCrud;
    
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    public List<Reservation> getAll() {
        return metodosCrud.getAll();
    }
    
    public Optional<Reservation> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }
    
    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation()== null) {
            return metodosCrud.save(reservation);
            
        } else {
            Optional<Reservation> evt = metodosCrud.getReservation(reservation.getIdReservation());
            
            if (evt.isEmpty()) {
                return metodosCrud.save(reservation);
                
            } else {
                return reservation;
                
            }
            
        }
        
    }
    
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation() != null){
            Optional<Reservation> e = metodosCrud.getReservation(reservation.getIdReservation());
            
            if(!e.isEmpty()){
                if(reservation.getStartDate() != null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                
                if(reservation.getDevolutionDate() != null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                
                if(reservation.getStatus() != null){
                    e.get().setStatus(reservation.getStatus());
                }
                
                if(reservation.getScore() != null){
                    e.get().setScore(reservation.getScore());
                }
                
                
                return metodosCrud.save(e.get());
                
            }else{
                return reservation;
                
            }
            
        }else{
            return reservation;
            
        }
        
    }
    
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            
            metodosCrud.delete(reservation);
            return true;
            
        }).orElse(false);
        
        return aBoolean;
        
    }
    
}


