package Reto.Ciclo339.repository.crud;

import Reto.Ciclo339.model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {

     //JPQL
     @Query("SELECT c.client,COUNT(c.client) FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")
     public List<Object[]> countReservationByClient();
     public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne,Date dateTwo);
     public List<Reservation> findAllByStatus(String status);
}
