package etiya.SportsClub.service;

import etiya.SportsClub.entity.Arrival;

import java.util.List;

public interface ArrivalService {

    Arrival createArrival(Arrival arrival);
    List<Arrival> getAllArrivals();
    Arrival getArrivalById(Long id);
    Boolean deleteArrival(Long id);
}
