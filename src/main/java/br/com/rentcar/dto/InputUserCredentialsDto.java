package br.com.rentcar.dto;

public class InputUserCredentialsDto extends InputDto {

    private String username;
    private String pwd;

    public InputUserCredentialsDto(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    public InputUserCredentialsDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
