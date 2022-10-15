package Reto.Ciclo339.repository;

import Reto.Ciclo339.model.Client;
import Reto.Ciclo339.model.Reservation;
import Reto.Ciclo339.model.custom.CountClient;
import Reto.Ciclo339.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAllFromCrudRep(){return (List<Reservation>) reservationCrudRepository.findAll();}
    public Optional<Reservation> getReservation(int id){return reservationCrudRepository.findById(id);}
    public Reservation save (Reservation c){return reservationCrudRepository.save(c);}
    public void delete(Reservation c){reservationCrudRepository.delete(c);}
    public List<Reservation> getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<Reservation> getReservationPeriod(Date dateOne, Date dateTwo){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne,dateTwo);
    }

    public List<CountClient> getTopClients(){
        List<CountClient> countClients= new ArrayList<>();

        List<Object[]> report =reservationCrudRepository.countReservationByClient();
        for (int i=0;i<report.size();i++){
            /*
            Client client=(Client) report.get(i)[1];
            Long quantity=(Long) report.get(i)[0];
            CountClient countClient= new CountClient(client,quantity);
            countClients.add(countClient);*/
            countClients.add(new CountClient((Long) report.get(i)[1],(Client) report.get(i)[0]));
        }
        return countClients;
    }
}
