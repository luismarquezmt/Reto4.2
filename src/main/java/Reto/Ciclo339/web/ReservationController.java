package Reto.Ciclo339.web;

import Reto.Ciclo339.model.Reservation;
import Reto.Ciclo339.model.custom.CountClient;
import Reto.Ciclo339.model.custom.StatusAmount;
import Reto.Ciclo339.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(("api/Reservation"))
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {


    @Autowired
    private ReservationService reservationService;
    private Reservation reservation;

    @RequestMapping("/all")
    public List<Reservation> getReservations(){return reservationService.getAllFromReserv();}
    @RequestMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id")int id){return reservationService.getReservation(id);}
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping("/save")
    public Reservation save(@RequestBody Reservation S){return reservationService.Save(S);}
    @PutMapping("/save")
    public void Update(){reservation.setStatus("CREATED");}

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")int id){
        reservationService.deleteReservation(id);
    }

    //Reto5
    @GetMapping("/report-status")
    public StatusAmount getReservationStatus(){
        return reservationService.getStatusReport();
    }

    @GetMapping("/report-clients")
    public List<CountClient> getCountClient(){
        return reservationService.getTopClients();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getDatesReport(@PathVariable("dateOne")String dateOne,@PathVariable("dateTwo")String dateTwo){
        return reservationService.getReservationPeriod(dateOne,dateTwo);
    }

}


























