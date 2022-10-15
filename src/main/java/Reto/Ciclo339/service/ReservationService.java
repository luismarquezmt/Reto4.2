package Reto.Ciclo339.service;

import Reto.Ciclo339.model.Reservation;
import Reto.Ciclo339.model.custom.CountClient;
import Reto.Ciclo339.model.custom.StatusAmount;
import Reto.Ciclo339.repository.ReservationRepository;
import Reto.Ciclo339.web.ReservationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    private ReservationController reservationController;
    public List<Reservation> getAllFromReserv(){return reservationRepository.getAllFromCrudRep();}

    public Optional<Reservation> getReservation(int id){return reservationRepository.getReservation(id);}


    public Reservation Save (Reservation S){
        if (S.getIdReservation() == null) {
            return reservationRepository.save(S);
            } else {
                   Optional<Reservation> resAux= reservationRepository.getReservation(S.getIdReservation());
                   if (resAux.isEmpty()) {
                                        return reservationRepository.save(S);
                                         }else {

                                                 return S;
                                                }
                   }


    }



    public boolean deleteReservation (int id ){
        Boolean deleteAux = getReservation(id).map(client -> {
            reservationRepository.delete(client);
            return true;
        }).orElse(false);
        return deleteAux;
    }


    public List<CountClient> getTopClients(){
        return reservationRepository.getTopClients();
    }

    public StatusAmount getStatusReport(){
        List<Reservation> completed=reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled=reservationRepository.getReservationByStatus("cancelled");
        StatusAmount statusAmount = new StatusAmount(completed.size(),cancelled.size());
        return statusAmount;
    }



    public List<Reservation> getReservationPeriod(String dateA, String dateB) {
        // yyyy-mm-dd
        SimpleDateFormat parseSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try {
            a = parseSimpleDateFormat.parse(dateA);
            b = parseSimpleDateFormat.parse(dateB);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (a.before(b)) {
            return reservationRepository.getReservationPeriod(a,b);
        } else {
            return new ArrayList<>();
        }
    }
}






