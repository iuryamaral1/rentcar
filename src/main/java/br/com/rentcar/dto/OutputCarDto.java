package br.com.rentcar.dto;

public class OutputCarDto extends OutputDto {

    private Long idCar;
    private int yearCar;
    private String modelCar;
    private String colorCar;
    private OutputUserDto userCar;
    private String licensePlateCar;

    public OutputCarDto() {
    }

    public OutputCarDto(Long idCar, String licensePlateCar, int yearCar, String modelCar, String colorCar, OutputUserDto userCar) {
        this.idCar = idCar;
        this.userCar = userCar;
        this.yearCar = yearCar;
        this.colorCar = colorCar;
        this.modelCar = modelCar;
        this.licensePlateCar = licensePlateCar;
    }

    public Long getIdCar() {
        return idCar;
    }

    public void setIdCar(Long idCar) {
        this.idCar = idCar;
    }

    public String getLicensePlateCar() {
        return licensePlateCar;
    }

    public void setLicensePlateCar(String licensePlateCar) {
        this.licensePlateCar = licensePlateCar;
    }

    public int getYearCar() {
        return yearCar;
    }

    public void setYearCar(int yearCar) {
        this.yearCar = yearCar;
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

    public OutputUserDto getUserCar() {
        return userCar;
    }

    public void setUserCar(OutputUserDto userCar) {
        this.userCar = userCar;
    }
}
