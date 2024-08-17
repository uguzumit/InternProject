package etiya.SportsClub.controller;

import etiya.SportsClub.entity.Arrival;
import etiya.SportsClub.service.ArrivalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arrivals")
public class ArrivalController {

    private final ArrivalService arrivalService;

    public ArrivalController(ArrivalService arrivalService) {
        this.arrivalService = arrivalService;
    }

    @PostMapping("/create")
    public ResponseEntity<Arrival> createArrival(@RequestBody Arrival arrival) {
        return ResponseEntity.ok(arrivalService.createArrival(arrival));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Arrival>> getAllArrivals() {
        return ResponseEntity.ok(arrivalService.getAllArrivals());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Arrival> getArrivalById(@PathVariable Long id) {
        return ResponseEntity.ok(arrivalService.getArrivalById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteArrival(@PathVariable Long id) {
        arrivalService.deleteArrival(id);
        return ResponseEntity.ok().build();
    }

}
