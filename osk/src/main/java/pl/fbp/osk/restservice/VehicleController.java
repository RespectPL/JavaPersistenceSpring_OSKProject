package pl.fbp.osk.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.fbp.osk.entity.Vehicle;
import pl.fbp.osk.service.VehicleService;

import java.util.List;
import java.util.Map;
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

    @PostMapping("/add")
    public Vehicle newVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.createVehicle(vehicle);
    }

    @PutMapping("/replace/{id}")
    public ResponseEntity<Vehicle> replaceVehicle(@RequestBody Vehicle vehicle, @PathVariable Long id) {
        Optional<Vehicle> replacedVehicle = vehicleService.replaceVehicle(vehicle, id);
        return ResponseEntity.of(replacedVehicle);
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody Map<String, Object> updates, @PathVariable Long id) {
        Optional<Vehicle> updatedVehicle = vehicleService.updateVehicle(updates, id);
        return ResponseEntity.of(updatedVehicle);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVehicle(@PathVariable long id) {
        vehicleService.deleteById(id);
    }
}
