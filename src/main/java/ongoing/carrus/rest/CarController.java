package ongoing.carrus.rest;

import ongoing.carrus.entity.Car;
import ongoing.carrus.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/cars",produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController {
    @Autowired
    private CarRepository carRepository;
    @GetMapping
    Iterable<Car> getAllCars(){
        return carRepository.findAll();
    }
    @GetMapping("/{id}")
    Car getCar(@PathVariable int id){
        Car car = carRepository.findById(id).orElseThrow();
        return car;
    }
    @PutMapping("/{id}")
    Car editCar (@RequestBody Car car,@PathVariable int id){
        Car originalCar = carRepository.findById(id).orElseThrow();
        car.setDateCreated(originalCar.getDateCreated());
        return carRepository.save(car);
    }

    @PutMapping("/c1/{id}")
    ResponseEntity<Car> editOrAddCar(@RequestBody Car car, @PathVariable int id){
        Optional<Car> optionalCar = carRepository.findById(id);
        HttpStatus status = HttpStatus.CREATED;
        if(optionalCar.isPresent()){
            Car originalCar =  optionalCar.get();
            car.setDateCreated(originalCar.getDateCreated());
            status = HttpStatus.OK;
        }
        return ResponseEntity.status(status).body(car);

    }






    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable int id){
        carRepository.deleteById(id);

    }
}
