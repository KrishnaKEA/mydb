package ongoing.carrus.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "car_table")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;
    @Column(length = 40, nullable = false)
    private String name;
    @Column(length = 20, nullable = false)
    private String model;
    @Column(length = 20, nullable = false)
    private String brand;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime dateUpdated;
    @Column(nullable = false)
    private boolean isVaccant;
    @Column(nullable = false)
    private boolean isRserved;
    @Column(length = 40, nullable = false)
    private double pricePrDay;

    public Car() {
    }

    public Car(String name, String model, String brand, LocalDateTime dateCreated, LocalDateTime dateUpdated, boolean isVaccant, boolean isRserved, double pricePrDay) {
        this.name = name;
        this.model = model;
        this.brand = brand;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.isVaccant = isVaccant;
        this.isRserved = isRserved;
        this.pricePrDay = pricePrDay;
    }

    public Car(String name, String model, String brand, boolean isVaccant, boolean isRserved, double pricePrDay) {
        this.name = name;
        this.model = model;
        this.brand = brand;
        this.isVaccant = isVaccant;
        this.isRserved = isRserved;
        this.pricePrDay = pricePrDay;
    }

    public int getCarId() {
        return carId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public boolean isVaccant() {
        return isVaccant;
    }

    public void setVaccant(boolean vaccant) {
        isVaccant = vaccant;
    }

    public boolean isRserved() {
        return isRserved;
    }

    public void setRserved(boolean rserved) {
        isRserved = rserved;
    }

    public double getPricePrDay() {
        return pricePrDay;
    }

    public void setPricePrDay(double pricePrDay) {
        this.pricePrDay = pricePrDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getCarId() == car.getCarId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarId());
    }
}
