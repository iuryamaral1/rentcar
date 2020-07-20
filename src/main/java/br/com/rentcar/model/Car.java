package br.com.rentcar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "{br.com.rentcar.Car.year.NotNull}")
    @Column(name = "year", nullable = false)
    private Integer year;

    @NotBlank(message = "{br.com.rentcar.Car.licensePlate.NotBlank}")
    @NotEmpty(message = "{br.com.rentcar.Car.licensePlate.NotEmpty}")
    @Size(min = 7, max = 7, message = "{br.com.rentcar.Car.licensePlate.Size}")
    @Column(name = "license_plate", length = 7, nullable = false, unique = true)
    private String licensePlate;

    @NotBlank(message = "{br.com.rentcar.Car.model.NotBlank}")
    @NotEmpty(message = "{br.com.rentcar.Car.model.NotEmpty}")
    @Size(max = 30, message = "{br.com.rentcar.Car.model.Size}")
    @Column(name = "model", length = 30, nullable = false)
    private String model;

    @NotBlank(message = "{br.com.rentcar.Car.color.NotBlank}")
    @NotEmpty(message = "{br.com.rentcar.Car.color.NotEmpty}")
    @Size(max = 30, message = "{br.com.rentcar.Car.color.Size}")
    @Column(name = "color", length = 30, nullable = false)
    private String color;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Car() {
    }

    public Car(Integer year, String licensePlate, String model, String color) {
        this.year = year;
        this.licensePlate = licensePlate;
        this.model = model;
        this.color = color;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
