package pl.fbp.osk.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fbp.osk.entity.Vehicle;
import pl.fbp.osk.service.VehicleService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/osk/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.findAll());
    }
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        Optional<Vehicle> vehicle = vehicleService.findById(id);
        return ResponseEntity.ok(vehicle.get());
    }
}
