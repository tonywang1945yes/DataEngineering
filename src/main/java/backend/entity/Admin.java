package backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Wen Sun
 * @date 2019-3-19
 */

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @Column(name = "aid")
    String aid;
    @Column(name = "username")
    String username;
    @Column(name = "password")
    String password;
    @Column(name = "name")
    String name;
    @Column(name = "email_address")
    String emailAddress;
    @Column(name = "email_admission")
    String emailAdmission;

    public Admin() {
    }

    public Admin(String username, String password, String name, String emailAddress, String emailAdmission) {
        int id = 100000 + (int) (Math.random() * 900000);
        this.aid = "a" + Integer.toString(id);
        this.username = username;
        this.password = password;
        this.name = name;
        this.emailAddress = emailAddress;
        this.emailAdmission = emailAdmission;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAdmission() {
        return emailAdmission;
    }

    public void setEmailAdmission(String emailAdmission) {
        this.emailAdmission = emailAdmission;
    }
}
