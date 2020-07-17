package br.com.rentcar.dto;

public class InputUserDto extends InputDto {

    private String firstNameUser;
    private String lastNameUser;
    private String usermail;
    private String birthDateUser;
    private String loginUser;
    private String passUser;
    private String phoneContactUser;

    public InputUserDto() { }

    public InputUserDto(String firstNameUser, String lastNameUser,
                        String usermail, String birthDateUser,
                        String loginUser, String passUser,
                        String phoneContactUser) {
        this.firstNameUser = firstNameUser;
        this.lastNameUser = lastNameUser;
        this.usermail = usermail;
        this.birthDateUser = birthDateUser;
        this.loginUser = loginUser;
        this.passUser = passUser;
        this.phoneContactUser = phoneContactUser;
    }

    public String getFirstNameUser() {
        return firstNameUser;
    }

    public void setFirstNameUser(String firstNameUser) {
        this.firstNameUser = firstNameUser;
    }

    public String getLastNameUser() {
        return lastNameUser;
    }

    public void setLastNameUser(String lastNameUser) {
        this.lastNameUser = lastNameUser;
    }

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail;
    }

    public String getBirthDateUser() {
        return birthDateUser;
    }

    public void setBirthDateUser(String birthDateUser) {
        this.birthDateUser = birthDateUser;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getPassUser() {
        return passUser;
    }

    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }

    public String getPhoneContactUser() {
        return phoneContactUser;
    }

    public void setPhoneContactUser(String phoneContactUser) {
        this.phoneContactUser = phoneContactUser;
    }
}
