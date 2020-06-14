package pl.fbp.osk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.fbp.osk.entity.Vehicle;
import pl.fbp.osk.repository.VehicleRepository;

import java.util.List;
import java.util.Map;
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
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
    public void deleteById(Long vehicleId) {
        vehicleRepository.deleteById(vehicleId);
    }
    public Optional<Vehicle> replaceVehicle(Vehicle newVehicle, Long vehicleId) {
        return vehicleRepository.findById(vehicleId).map(vehicle -> {
           vehicle.setNazwa(newVehicle.getNazwa());
           vehicle.setTyp(newVehicle.getTyp());
           vehicle.setNrRejestracyjny(newVehicle.getNrRejestracyjny());
           return vehicleRepository.save(vehicle);
        });
    }
    public Optional<Vehicle> updateVehicle(Map<String, Object> updates, Long vehicleId) {
        Optional<Vehicle> vehicleById = vehicleRepository.findById(vehicleId);
        if(vehicleById.isPresent()) {
            Vehicle vehicle = vehicleById.get();
            if(updates.containsKey("nazwa")) {
                vehicle.setNazwa((String) updates.get("nazwa"));
            }
            if(updates.containsKey("typ")) {
                vehicle.setTyp((String) updates.get("typ"));
            }
            if(updates.containsKey("nrRejestracyjny")) {
                vehicle.setNrRejestracyjny((String) updates.get("nrRejestracyjny"));
            }
            vehicleRepository.save(vehicle);
        }
        return vehicleById;
    }
}
