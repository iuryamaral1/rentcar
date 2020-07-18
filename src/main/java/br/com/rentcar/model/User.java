package br.com.rentcar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotBlank
    @Size(min = 3, max = 50)
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @NotEmpty
    @NotBlank
    @Size(min = 3, max = 50)
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @NotBlank
    @NotEmpty
    @Email
    @Size(max = 50)
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_day")
    private Date birthDay;

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 50)
    @Column(name = "login", unique = true, nullable = false, length = 50)
    private String login;

    @NotEmpty
    @NotBlank
    @Size(min = 6, max = 150)
    @Column(name = "password", nullable = false, length = 150)
    private String password;

    @Size(min = 11, max = 11)
    @Column(name = "phone", length = 11)
    private String phone;

    @OneToMany(mappedBy = "user")
    private List<Car> carList;

    public User() {  }

    public User(String firstName, String lastName, String email, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
