package br.com.rentcar.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InputCarDto extends InputDto {

    private int yearCar;
    private String licensePlateCar;
    private String modelCar;
    private String colorCar;
    private InputUserDto userCar;

    public InputCarDto() {
    }

    public InputCarDto(int yearCar, String licensePlateCar, String modelCar, String colorCar, InputUserDto userCar) {
        this.yearCar = yearCar;
        this.licensePlateCar = licensePlateCar;
        this.modelCar = modelCar;
        this.colorCar = colorCar;
        this.userCar = userCar;
    }

    public int getYearCar() {
        return yearCar;
    }

    public void setYearCar(int yearCar) {
        this.yearCar = yearCar;
    }

    public String getLicensePlateCar() {
        return licensePlateCar;
    }

    public void setLicensePlateCar(String licensePlateCar) {
        this.licensePlateCar = licensePlateCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getColorCar() {
        return colorCar;
    }

    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }

    public InputUserDto getUserCar() {
        return userCar;
    }

    public void setUserCar(InputUserDto userCar) {
        this.userCar = userCar;
    }
}
