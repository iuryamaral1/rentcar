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

    @NotBlank
    @NotEmpty
    @NotNull
    @Column(name = "year", nullable = false)
    private int year;

    @NotBlank
    @NotEmpty
    @Size(min = 7, max = 7)
    @Column(name = "license_plate", length = 7, nullable = false, unique = true)
    private String licensePlate;

    @NotBlank
    @NotEmpty
    @Size(max = 30)
    @Column(name = "model", length = 30, nullable = false)
    private String model;

    @NotBlank
    @NotEmpty
    @Size(max = 30)
    @Column(name = "color", length = 30, nullable = false)
    private String color;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Car(int year, String licensePlate, String model, String color) {
        this.year = year;
        this.licensePlate = licensePlate;
        this.model = model;
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
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
}
