package etiya.SportsClub.service.impl;

import etiya.SportsClub.entity.Arrival;
import etiya.SportsClub.repository.ArrivalRepository;
import etiya.SportsClub.service.ArrivalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArrivalServiceImpl implements ArrivalService {

    private final ArrivalRepository arrivalRepository;

    public ArrivalServiceImpl(ArrivalRepository arrivalRepository) {
        this.arrivalRepository = arrivalRepository;
    }

    @Override
    public Arrival createArrival(Arrival arrival) {
        return arrivalRepository.save(arrival);
    }

    @Override
    public List<Arrival> getAllArrivals() {
        return arrivalRepository.findAll();
    }

    @Override
    public Arrival getArrivalById(Long id) {
        return arrivalRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteArrival(Long id) {
        Arrival existingArrival = arrivalRepository.findById(id).orElse(null);
        if (existingArrival == null) {
            return false;
        }
        arrivalRepository.delete(existingArrival);
        return true;
    }
}
