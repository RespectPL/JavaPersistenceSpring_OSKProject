package pl.fbp.osk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.fbp.osk.entity.Vehicle;
import pl.fbp.osk.repository.VehicleRepository;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;


    public List<Vehicle> findAll() {
        return (List<Vehicle>) vehicleRepository.findAll();
    }
    public Optional<Vehicle> findById(Long id) {
        return vehicleRepository.findById(id);
    }
}
